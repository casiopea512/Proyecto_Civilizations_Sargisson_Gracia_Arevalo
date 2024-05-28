<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match ="/">

        <html>
            <head>
                <meta charset="UTF-8"/>
                <title>Wiki Civilization</title>
                <link rel="stylesheet" href="indice.css"/>
            </head>

            <body>

                <div class = "cabecera">
                    <h1 class="titulo">Civilization</h1>
                </div>

                <div class ="contenedorIndex">

                    <xsl:apply-templates select="root/buildings"/>
                    <xsl:apply-templates select="root/attack_units"/>
                    <xsl:apply-templates select="root/defences"/>
                    <xsl:apply-templates select="root/special_units"/>

                </div>

                

            </body>


            <footer>
                
                <div class="footer-container">

                    <div class="footer-row">


                        <div class="footer-links">

                            <h4>Componentes del grupo</h4>
                            <ul>
                                <li>Pau García</li>
                                <li>William Sargisson</li>
                                <li>Marta Arévalo</li>
                            </ul>

                        </div>

                        <div class="footer-links">

                            <h4>Aplicaciones</h4>
                            <ul>
                                <li><a href="https://github.com/casiopea512/Proyecto_Civilizations_Sargisson_Gracia_Arevalo.git">GitHub</a></li>
                            </ul>

                        </div>

                    </div>

                </div>

            </footer>

        </html>

    </xsl:template>


    <!-- Plantilla para edificos -->
    <xsl:template match="buildings">
        <div class="grupo">
            <h1 class="tituloGrupo">Buildings</h1>

            <div class="carousel-group">

                <xsl:for-each select="building">
                    
                    <div class="carousel-unit">

                        <a class = "vinculoUnidad" href="{name}.html" target="_self">
                            <img class ="imgUnit" src="./imatges/{imagen}" alt="Imagen {imagen}"/>
                        </a>

                        <h3><xsl:value-of select="name"></xsl:value-of></h3>

                    </div>
        
                </xsl:for-each>

            </div>

        </div>
    </xsl:template>


    <!-- Plantilla unidades ataque -->
    <xsl:template match="attack_units">
        <div class="grupo">
            <h1 class="tituloGrupo">Attack Units</h1>

            <div class="carousel-group">

                <xsl:for-each select="unit">
                    
                    <div class="carousel-unit">

                        <a class = "vinculoUnidad" href="{name}.html" target="_self">
                            <img class ="imgUnit" src="./imatges/{imagen}" alt="Imagen {imagen}"/>
                        </a>
                        <h3><xsl:value-of select="name"></xsl:value-of></h3>

                    </div>
        
                </xsl:for-each>

            </div>

        </div>
    </xsl:template>


    <!-- Plantilla para unidades defensoras -->
    <xsl:template match="defences">
        <div class="grupo">
            <h1 class="tituloGrupo">Defence Units</h1>

            <div class="carousel-group">

                <xsl:for-each select="unit">
                    
                    <div class="carousel-unit">

                        <a class = "vinculoUnidad" href="{name}.html" target="_self">
                            <img class ="imgUnit" src="./imatges/{imagen}" alt="Imagen {imagen}"/>
                        </a>
                        <h3><xsl:value-of select="name"></xsl:value-of></h3>

                    </div>
        
                </xsl:for-each>

            </div>

        </div>
    </xsl:template>


    <!-- Plantilla para unidades especiales -->
    <xsl:template match="special_units">
        <div class="grupo">
            <h1 class="tituloGrupo">Special Units</h1>

            <div class="carousel-group">

                <xsl:for-each select="unit">
                    
                    <div class="carousel-unit">

                        <a class = "vinculoUnidad" href="{name}.html" target="_self">
                            <img class ="imgUnit" src="./imatges/{imagen}" alt="Imagen {imagen}"/>
                        </a>
                        <h3><xsl:value-of select="name"></xsl:value-of></h3>

                    </div>
        
                </xsl:for-each>

            </div>

        </div>
    </xsl:template>
    

</xsl:stylesheet>