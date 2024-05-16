-- civilization_stats

INSERT INTO civilization_stats (name, username, wood_amount, iron_amount, food_amount, mana_amount, magicTower_counter, church_counter, farm_counter, smithy_counter, carpentry_counter, technology_defense_level, technology_attack_level, battles_counter)
VALUES ('Civilization A', 'Cowed', 1000, 500, 2000, 300, 3, 2, 5, 4, 3, 2, 3, 10);
INSERT INTO civilization_stats (name, username, wood_amount, iron_amount, food_amount, mana_amount, magicTower_counter, church_counter, farm_counter, smithy_counter, carpentry_counter, technology_defense_level, technology_attack_level, battles_counter)
VALUES ('Civilization B', 'Kahba', 800, 700, 1500, 400, 2, 3, 4, 3, 2, 1, 2, 5);


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

INSERT INTO battle_stats (civilization_id, wood_acquired, iron_acquired)
VALUES (1, 300, 150);
INSERT INTO battle_stats (civilization_id, wood_acquired, iron_acquired)
VALUES (1, 500, 175);
INSERT INTO battle_stats (civilization_id, wood_acquired, iron_acquired)
VALUES (2, 150, 50);
INSERT INTO battle_stats (civilization_id, wood_acquired, iron_acquired)
VALUES (2, 310, 5);


-- battle_log

INSERT INTO battle_log (civilization_id, num_battle, log_entry)
VALUES (1, 1, 'The battle started.');
INSERT INTO battle_log (civilization_id, num_battle, log_entry)
VALUES (1, 1, 'The enemy has been defeated.');


-- civilization_attack_stats

INSERT INTO civilization_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 1, 'Swordsman', 50, 15);
INSERT INTO civilization_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 1, 'Spearman', 40, 7);
INSERT INTO civilization_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 1, 'Crossbow', 20, 3);
INSERT INTO civilization_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 1, 'Cannon', 15, 2);
INSERT INTO civilization_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 2, 'Swordsman', 25, 18);
INSERT INTO civilization_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 2, 'Spearman', 3, 1);
INSERT INTO civilization_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 2, 'Crossbow', 40, 35);
INSERT INTO civilization_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 2, 'Cannon', 2, 1);




-- civilization_defense_stats

INSERT INTO civilization_defense_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 1, 'ArrowTower', 25, 15);
INSERT INTO civilization_defense_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 1, 'Catapult', 10, 7);
INSERT INTO civilization_defense_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 1, 'RocketLauncherTower', 5, 3);
INSERT INTO civilization_defense_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 2, 'ArrowTower', 3, 1);
INSERT INTO civilization_defense_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 2, 'Catapult', 26, 14);
INSERT INTO civilization_defense_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 2, 'RocketLauncherTower', 2, 1);

-- civilization_special_stats

INSERT INTO civilization_special_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 1, 'Magician', 5, 2);
INSERT INTO civilization_special_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 1, 'Priest', 3, 1);
INSERT INTO civilization_special_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 2, 'Magician', 10, 5);
INSERT INTO civilization_special_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 2, 'Priest', 1, 1);


-- enemy_attack_stats

INSERT INTO enemy_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 1, 'Swordsman', 25, 10);
INSERT INTO enemy_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 1, 'Spearman', 15, 5);
INSERT INTO enemy_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 1, 'Crossbow', 12, 2);
INSERT INTO enemy_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 1, 'Cannon', 15, 12);
INSERT INTO enemy_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 2, 'Swordsman', 35, 10);
INSERT INTO enemy_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 2, 'Spearman', 3, 1);
INSERT INTO enemy_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 2, 'Crossbow', 40, 5);
INSERT INTO enemy_attack_stats (civilization_id, num_battle, type, inicial, drops)
VALUES (1, 2, 'Cannon', 2, 1);
