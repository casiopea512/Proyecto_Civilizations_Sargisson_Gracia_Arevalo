<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:param name="paramId"/>
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="UTF-8"/>
                    <title>Wiki Civilization </title>
                    <link rel="stylesheet" href="unidad.css"/>
            </head>
    
            <body>
                
                <div class="contenedorInforme">
                    
                        
                    <!--para cada edificio-->
                    <xsl:for-each select="root/buildings/building[name=$paramId]">                       
                        <xsl:call-template name="building"></xsl:call-template>
                    </xsl:for-each>

                    <!--para cada unidad atacante-->
                    <xsl:for-each select="root/attack_units/unit[name=$paramId]">                       
                        <xsl:call-template name="attack-defence"></xsl:call-template>
                    </xsl:for-each>

                    <!--para cada unidad defensiva-->
                    <xsl:for-each select="root/defences/unit[name=$paramId]">                       
                        <xsl:call-template name="attack-defence"></xsl:call-template>
                    </xsl:for-each>
                    
                    <!--para cada unidad especial-->
                    <xsl:for-each select="root/special_units/unit[name=$paramId]">                       
                        <xsl:call-template name="special"></xsl:call-template>
                    </xsl:for-each>

                </div>
    
            </body>
        </html>

    </xsl:template>


    <!-- template para los edificios-->
    <xsl:template name="building">

        <div class="contenedor-informacion">
            <h1 class="titulo"><xsl:value-of select="name"></xsl:value-of></h1>

            <p class="descripcion"> <xsl:value-of select="description"></xsl:value-of> </p>

            <p>Cost of the building:</p>
            <ul>
                <li>Food: <xsl:value-of select="costs/food_cost"></xsl:value-of></li>
                <li>Iron: <xsl:value-of select="costs/iron_cost"></xsl:value-of></li>
                <li>Wood: <xsl:value-of select="costs/wood_cost"></xsl:value-of></li>
            </ul>


        </div>

        <div class="contenedor-imagen">
            <img class="imagen" src="./imatges/{imagen}"/>
        </div>

    </xsl:template>



    <!-- template para las unidades de ataque y defensa-->
    <xsl:template name="attack-defence">

        <div class="contenedor-informacion">
            <h1 class="titulo"><xsl:value-of select="name"></xsl:value-of></h1>

            <p class="descripcion"> <xsl:value-of select="description"></xsl:value-of> </p>

            <p>Stats:</p>
            <ul>
                <li>Base damage: <xsl:value-of select="base_damage"></xsl:value-of></li>
                <li>Armor: <xsl:value-of select="armour"></xsl:value-of></li>
                <li>Change of attack again: <xsl:value-of select="attack_again_chance"></xsl:value-of></li>
                <li>Change of generating waste: <xsl:value-of select="waste_chance"></xsl:value-of></li>
            </ul>

            <p>Plus stats:</p>
            <ul>
                <li>Armor technology: <xsl:value-of select="plus_stats/armour_technology"></xsl:value-of></li>
                <li>Attack technology: <xsl:value-of select="plus_stats/attack_technology"></xsl:value-of></li>
                <li>Armor experience: <xsl:value-of select="plus_stats/armour_experience"></xsl:value-of></li>
                <li>Attack experience: <xsl:value-of select="plus_stats/attack_experience"></xsl:value-of></li>
                <li>Armor sanctified: <xsl:value-of select="plus_stats/armour_sanctified"></xsl:value-of></li>
                <li>Attack sanctified: <xsl:value-of select="plus_stats/attack_sanctified"></xsl:value-of></li>
            </ul>


            <p>Cost of the unit:</p>
            <ul>
                <li>Food: <xsl:value-of select="costs/food_cost"></xsl:value-of></li>
                <li>Wood: <xsl:value-of select="costs/wood_cost"></xsl:value-of></li>
                <li>Iron: <xsl:value-of select="costs/iron_cost"></xsl:value-of></li>
                <li>Mana: <xsl:value-of select="costs/mana_cost"></xsl:value-of></li>
                
            </ul>


        </div>

        <div class="contenedor-imagen">
            <img class="imagen" src="./imatges/{imagen}"/>
        </div>

    </xsl:template>



    <!-- template para las unidades especiales-->
    <xsl:template name="special">

        <div class="contenedor-informacion">
            <h1 class="titulo"><xsl:value-of select="name"></xsl:value-of></h1>

            <p class="descripcion"> <xsl:value-of select="description"></xsl:value-of> </p>

            <p>Stats:</p>
            <ul>
                <li>Base damage: <xsl:value-of select="base_damage"></xsl:value-of></li>
                <li>Change of attack again: <xsl:value-of select="attack_again_chance"></xsl:value-of></li>
                <li>Change of generating waste: <xsl:value-of select="waste_chance"></xsl:value-of></li>
            </ul>

            <p>Plus stats:</p>
            <ul>
                <li>Armor technology: <xsl:value-of select="plus_stats/armour_technology"></xsl:value-of></li>
                <li>Attack technology: <xsl:value-of select="plus_stats/attack_technology"></xsl:value-of></li>
                <li>Armor experience: <xsl:value-of select="plus_stats/armour_experience"></xsl:value-of></li>
                <li>Attack experience: <xsl:value-of select="plus_stats/attack_experience"></xsl:value-of></li>
                <li>Armor sanctified: <xsl:value-of select="plus_stats/armour_sanctified"></xsl:value-of></li>
                <li>Attack sanctified: <xsl:value-of select="plus_stats/attack_sanctified"></xsl:value-of></li>
            </ul>


            <p>Cost of the special unit:</p>
            <ul>
                <li>Food: <xsl:value-of select="costs/food_cost"></xsl:value-of></li>
                <li>Wood: <xsl:value-of select="costs/wood_cost"></xsl:value-of></li>
                <li>Iron: <xsl:value-of select="costs/iron_cost"></xsl:value-of></li>
                <li>Mana: <xsl:value-of select="costs/mana_cost"></xsl:value-of></li>
                
            </ul>


        </div>

        <div class="contenedor-imagen">
            <img class="imagen" src="./imatges/{imagen}"/>
        </div>

    </xsl:template>

</xsl:stylesheet>