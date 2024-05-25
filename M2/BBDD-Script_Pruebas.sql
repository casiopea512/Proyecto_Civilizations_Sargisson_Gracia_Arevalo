-- civilization_stats

INSERT INTO civilization_stats (name, username, wood_amount, iron_amount, food_amount, mana_amount, magicTower_counter, church_counter, farm_counter, smithy_counter, carpentry_counter, technology_defense_level, technology_attack_level, battles_counter, time_left)
VALUES ('Civilization A', 'Cowed', 1000, 500, 2000, 300, 3, 2, 5, 4, 3, 2, 3, 10, 110000);
INSERT INTO civilization_stats (name, username, wood_amount, iron_amount, food_amount, mana_amount, magicTower_counter, church_counter, farm_counter, smithy_counter, carpentry_counter, technology_defense_level, technology_attack_level, battles_counter,  time_left)
VALUES ('Civilization B', 'Kahba', 800, 700, 1500, 400, 2, 3, 4, 3, 2, 1, 2, 5, 130000);


-- attack_units_stats

INSERT INTO attack_units_stats (civilization_id, type, armor, base_damage, experience, sanctified)
VALUES (1, 'Swordsman', 10, 20, 15, 1);
INSERT INTO attack_units_stats (civilization_id, type, armor, base_damage, experience, sanctified)
VALUES (1, 'Spearman', 20, 10, 0, 1);
INSERT INTO attack_units_stats (civilization_id, type, armor, base_damage, experience, sanctified)
VALUES (1, 'Crossbow', 30, 3, 25, 1);
INSERT INTO attack_units_stats (civilization_id, type, armor, base_damage, experience, sanctified)
VALUES (1, 'Cannon', 40, 5, 0, 1);
INSERT INTO attack_units_stats (civilization_id, type, armor, base_damage, experience, sanctified)
VALUES (2, 'Swordsman', 5, 20, 0, 0);
INSERT INTO attack_units_stats (civilization_id, type, armor, base_damage, experience, sanctified)
VALUES (2, 'Spearman', 2, 10, 0, 0);
INSERT INTO attack_units_stats (civilization_id, type, armor, base_damage, experience, sanctified)
VALUES (2, 'Crossbow', 4, 3, 0, 0);
INSERT INTO attack_units_stats (civilization_id, type, armor, base_damage, experience, sanctified)
VALUES (2, 'Cannon', 2, 5, 0, 0);


-- defense_units_stats

INSERT INTO defense_units_stats (civilization_id, type, armor, base_damage, experience, sanctified)
VALUES (1, 'ArrowTower', 50, 5, 0, 1);
INSERT INTO defense_units_stats (civilization_id, type, armor, base_damage, experience, sanctified)
VALUES (1, 'Catapult', 60, 3, 0, 1);
INSERT INTO defense_units_stats (civilization_id, type, armor, base_damage, experience, sanctified)
VALUES (1, 'RocketLauncherTower', 70, 2, 0,1);
INSERT INTO defense_units_stats (civilization_id, type, armor, base_damage, experience, sanctified)
VALUES (2, 'ArrowTower', 30,10, 0, 0);
INSERT INTO defense_units_stats (civilization_id, type, armor, base_damage, experience, sanctified)
VALUES (2, 'Catapult', 50, 20, 0, 0);
INSERT INTO defense_units_stats (civilization_id, type, armor, base_damage, experience, sanctified)
VALUES (2, 'RocketLauncherTower', 20,5, 0, 0);


-- special_units_stats

INSERT INTO special_units_stats (civilization_id, type, armor, base_damage, experience)
VALUES (1, 'Magician', 10, 50, 0);
INSERT INTO special_units_stats (civilization_id, type, armor, base_damage, experience)
VALUES (1, 'Priest', 20, 15, 0);
INSERT INTO special_units_stats (civilization_id, type, armor, base_damage, experience)
VALUES (2, 'Magician', 30, 60, 0);
INSERT INTO special_units_stats (civilization_id, type, armor, base_damage, experience)
VALUES (2, 'Priest', 50, 80, 0);


-- battle_stats

INSERT INTO battle_stats (civilization_id)
VALUES (1);
INSERT INTO battle_stats (civilization_id)
VALUES (1);
INSERT INTO battle_stats (civilization_id)
VALUES (1);
INSERT INTO battle_stats (civilization_id)
VALUES (1);
INSERT INTO battle_stats (civilization_id)
VALUES (1);
INSERT INTO battle_stats (civilization_id)
VALUES (1);
INSERT INTO battle_stats (civilization_id)
VALUES (1);
INSERT INTO battle_stats (civilization_id)
VALUES (2);
INSERT INTO battle_stats (civilization_id)
VALUES (2);


-- battle_log_paso_a_paso
INSERT INTO battle_log_paso_a_paso (civilization_id, num_battle, log_entry)
VALUES (1, 1, 'The battle started.');
INSERT INTO battle_log_paso_a_paso (civilization_id, num_battle, log_entry)
VALUES (1, 1, 'Linea 1');
INSERT INTO battle_log_paso_a_paso (civilization_id, num_battle, log_entry)
VALUES (1, 1, 'Linea 2');
INSERT INTO battle_log_paso_a_paso (civilization_id, num_battle, log_entry)
VALUES (1, 1, 'Linea 3');
INSERT INTO battle_log_paso_a_paso (civilization_id, num_battle, log_entry)
VALUES (1, 1, 'Linea 4');
INSERT INTO battle_log_paso_a_paso (civilization_id, num_battle, log_entry)
VALUES (1, 1, 'Linea 5');
INSERT INTO battle_log_paso_a_paso (civilization_id, num_battle, log_entry)
VALUES (1, 1, 'Linea 6');
INSERT INTO battle_log_paso_a_paso (civilization_id, num_battle, log_entry)
VALUES (1, 1, 'The enemy has been defeated.');

-- battle_log_reporte
INSERT INTO battle_log_reporte (civilization_id, num_battle, log_entry)
VALUES (1, 1, 'REPORTE_BATALLA 1');
INSERT INTO battle_log_reporte (civilization_id, num_battle, log_entry)
VALUES (1, 2, 'REPORTE_BATALLA 2');
INSERT INTO battle_log_reporte (civilization_id, num_battle, log_entry)
VALUES (1, 3, 'REPORTE_BATALLA 3');
INSERT INTO battle_log_reporte (civilization_id, num_battle, log_entry)
VALUES (1, 4, 'REPORTE_BATALLA 4');
INSERT INTO battle_log_reporte (civilization_id, num_battle, log_entry)
VALUES (1, 5, 'REPORTE_BATALLA 5');
INSERT INTO battle_log_reporte (civilization_id, num_battle, log_entry)
VALUES (1, 6, 'REPORTE_BATALLA 6');
INSERT INTO battle_log_reporte (civilization_id, num_battle, log_entry)
VALUES (1, 7, 'REPORTE_BATALLA 7');

COMMIT;
