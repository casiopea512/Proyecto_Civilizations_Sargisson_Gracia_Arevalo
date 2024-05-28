from lxml import etree
import os


# Leer el archivo XML
def read_xml(path):
    file = open(path, 'r', encoding='utf-8')  # "r" es lectura
    string = file.read()
    file.close()
    return bytes(bytearray(string, encoding='utf-8'))


# Escribir el archivo HTML
def write_html(path,html):
    file = open(path, 'w', encoding='utf-8')  # escribir borrando el contenido, si el fichero no existe lo crea
    file.write(html)
    file.close()



# Crear un árbol XML combinado de los tres grupos
def combine_xml_files(xml_files):

    # elemento raíz
    root = etree.Element("root")

    # para cada archivo xml en la lista
    for xml_file in xml_files:

        # leer el archivo
        xml_data = read_xml(xml_file)
        # parsear los bytes a xml
        xml_tree = etree.XML(xml_data)
        # agregar el xml al elemento root
        root.append(xml_tree)

    # devuelve el arbol combinado
    #return etree.ElementTree(root)

    # devielve el elemento raíz, para así poder iterar sobre él
    return root


# Transformar una uniadad de XML a HTML
def transform_group(xmlTree, nombre):

    # crear el arbol xsl para una unidad
    xslUnidad = read_xml('./xml/template-unidad.xsl')
    xslTree = etree.XML(xslUnidad)

    # transformar el xml combinado según el archivo template-unidad.xsl y guardarlo en un .html
    transform = etree.XSLT(xslTree)
    htmlDom = transform(xmlTree, paramId=etree.XSLT.strparam(nombre)) #al contener espacios un nombre lo escapamos
    htmlResult = etree.tostring(htmlDom, pretty_print=True).decode('utf-8')
    write_html("./html/" + nombre + ".html", htmlResult)


# crear un índice con todos los grupos
def transfrom_index_group(xmlTree):

    # crar el arbol xsl para el índice de todos los grupos
    xslGrupos = read_xml('./xml/template-principal.xsl')
    xslTreeGrupos = etree.XML(xslGrupos)

    # transformar el archivo de cada grupo según el archivo template-principal.xsl y guardarlo en wikiCivilization.html
    transform = etree.XSLT(xslTreeGrupos)
    htmlDom = transform(xmlTree)
    htmlResult = etree.tostring(htmlDom, pretty_print=True).decode('utf-8')
    write_html("./html/wikiCivilization.html", htmlResult)







# crear el arbol XML de todos juntos
gruposXML = ['attack_units','buildings','defences','special_units']
xml_files = [f'./xml/{grupo}.xml' for grupo in gruposXML]

xmlTree = combine_xml_files(xml_files)

''''
for element in xmlTree:
    print(etree.tostring(element, pretty_print=True).decode('utf-8'))
   print(element)
'''


# borrar los archivos .html creados anteriormente
for file in os.listdir("./html"):
   if file.endswith(".html"):
      os.remove("./html/"+file)


# generar cada uno de las unidades en archivos .html
for grupo in xmlTree:
    #print("el grupo es: " + etree.tostring(grupo, pretty_print=True).decode('utf-8'))

    for unidad in grupo:
        #print("la unidad es: " + etree.tostring(unidad, pretty_print=True).decode('utf-8'))
        #transform_group(xmlTree,unidad.get('name'))
        unidad_name = unidad.xpath('name/text()')[0]
        #print(unidad_name)
        transform_group(xmlTree, unidad_name)
        #print(etree.tostring(unidad,pretty_print=True).decode('utf-8'))


# Crear el índice de los grupos
transfrom_index_group(xmlTree)