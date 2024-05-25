
CREATE OR REPLACE PROCEDURE update_resources(
    primary_key NUMBER,
    v_food NUMBER,
    v_wood NUMBER,
    v_iron NUMBER,
    v_mana NUMBER
)
IS
BEGIN
    UPDATE civilization_stats
    SET food_amount = v_food,
        wood_amount = v_wood,
        iron_amount = v_iron,
        mana_amount = v_mana
    WHERE civilization_id = primary_key;
     COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END;

/

CREATE OR REPLACE PROCEDURE update_buildingsAndTechnologies(
    p_civilization_id NUMBER,
    p_magicTower_counter NUMBER,
    p_church_counter NUMBER,
    p_farm_counter NUMBER,
    p_smithy_counter NUMBER,
    p_carpentry_counter NUMBER,
    p_technology_defense_level NUMBER,
    p_technology_attack_level NUMBER
)
IS
BEGIN
    UPDATE civilization_stats
    SET 
        magicTower_counter = p_magicTower_counter,
        church_counter = p_church_counter,
        farm_counter = p_farm_counter,
        smithy_counter = p_smithy_counter,
        carpentry_counter = p_carpentry_counter,
        technology_defense_level = p_technology_defense_level,
        technology_attack_level = p_technology_attack_level
    WHERE civilization_id = p_civilization_id;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END;

/

CREATE OR REPLACE PROCEDURE deleteCivilization ( p_civilization_id NUMBER) IS
BEGIN    
    DELETE FROM battle_log_reporte WHERE civilization_id = p_civilization_id;
    DELETE FROM battle_log_paso_a_paso WHERE civilization_id = p_civilization_id;
    DELETE FROM attack_units_stats WHERE civilization_id = p_civilization_id;
    DELETE FROM defense_units_stats  WHERE civilization_id = p_civilization_id;
    DELETE FROM special_units_stats WHERE civilization_id = p_civilization_id;
    DELETE FROM battle_stats WHERE civilization_id = p_civilization_id;
    DELETE FROM civilization_stats WHERE civilization_id = p_civilization_id;
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END;

/

CREATE OR REPLACE PROCEDURE deleteUnits( p_civilization_id NUMBER) IS
BEGIN
    DELETE FROM attack_units_stats WHERE civilization_id = p_civilization_id;
    DELETE FROM defense_units_stats  WHERE civilization_id = p_civilization_id;
    DELETE FROM special_units_stats WHERE civilization_id = p_civilization_id;
    COMMIT;
END;
