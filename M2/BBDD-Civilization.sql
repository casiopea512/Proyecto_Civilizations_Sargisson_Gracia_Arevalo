---------------------------------------------------------------------------
-- execute the following statements to create tables
---------------------------------------------------------------------------
--  civilization_stats

CREATE TABLE civilization_stats
  (
    civilization_id NUMBER GENERATED BY DEFAULT AS IDENTITY START WITH 1 PRIMARY KEY,
    name VARCHAR2( 50 ),
    username VARCHAR2( 50 ),
    
    wood_amount NUMBER DEFAULT 0,
    iron_amount NUMBER DEFAULT 0,
    food_amount NUMBER DEFAULT 0,
    mana_amount NUMBER DEFAULT 0,
    
    magicTower_counter NUMBER DEFAULT 0,
    church_counter NUMBER DEFAULT 0,
    farm_counter NUMBER DEFAULT 0,
    smithy_counter NUMBER DEFAULT 0,
    carpentry_counter NUMBER DEFAULT 0,
    
    technology_defense_level NUMBER DEFAULT 0,
    technology_attack_level NUMBER DEFAULT 0,
    battles_counter NUMBER DEFAULT 0    
  );
  
-- attack_units_stats
CREATE TABLE attack_units_stats
  (
    civilization_id NUMBER, -- FK
    unit_id NUMBER GENERATED BY DEFAULT AS IDENTITY START WITH 1,
    type VARCHAR(20) CHECK (type IN ('Swordsman', 'Spearman', 'Crossbow', 'Cannon')),
    armor NUMBER,
    base_damage NUMBER,
    experience NUMBER DEFAULT 0 ,
    sanctified NUMBER(1) DEFAULT 0 NOT NULL CHECK  (sanctified in (0,1)),
    CONSTRAINT fk_aus_civilization FOREIGN KEY (civilization_id) REFERENCES civilization_stats( civilization_id )  ON DELETE CASCADE, 
    CONSTRAINT pk_aus PRIMARY KEY (civilization_id, unit_id)
  );

-- defense_units_stats
CREATE TABLE defense_units_stats
 (
    civilization_id NUMBER, -- FK
    unit_id NUMBER GENERATED BY DEFAULT AS IDENTITY START WITH 1,
    type VARCHAR(20) CHECK (type IN ('ArrowTower', 'Catapult', 'RocketLauncherTower')),
    armor NUMBER,
    base_damage NUMBER,
    experience NUMBER DEFAULT 0,
    sanctified NUMBER(1) DEFAULT 0 NOT NULL CHECK  (sanctified in (0,1)),
    CONSTRAINT fk_dus_civilization FOREIGN KEY( civilization_id ) REFERENCES civilization_stats( civilization_id )  ON DELETE CASCADE, 
    CONSTRAINT pk_dus PRIMARY KEY (civilization_id, unit_id)
  );
-- special_units_stats
CREATE TABLE special_units_stats
 (
    civilization_id NUMBER, -- FK
    unit_id NUMBER GENERATED BY DEFAULT AS IDENTITY START WITH 1,
    type VARCHAR(20) CHECK (type IN ('Magician', 'Priest')),
    armor NUMBER,
    base_damage NUMBER,
    experience NUMBER DEFAULT 0,
    CONSTRAINT fk_sus_civilization FOREIGN KEY( civilization_id ) REFERENCES civilization_stats( civilization_id )  ON DELETE CASCADE,
    CONSTRAINT pk_sus PRIMARY KEY (civilization_id, unit_id)
  );
  
  -- battle_stats
CREATE TABLE battle_stats
  (
    civilization_id NUMBER, -- FK
    num_battle NUMBER GENERATED BY DEFAULT AS IDENTITY START WITH 1,
    wood_acquired NUMBER,
    iron_acquired NUMBER,
   CONSTRAINT fk_battle_civilization FOREIGN KEY( civilization_id ) REFERENCES civilization_stats( civilization_id )  ON DELETE CASCADE, 
   CONSTRAINT pk_battle_stats PRIMARY KEY (civilization_id, num_battle)
  );
  
-- battle_log
CREATE TABLE battle_log
  (
   civilization_id NUMBER, -- FK
   num_battle NUMBER, -- FK
   num_line NUMBER GENERATED BY DEFAULT AS IDENTITY START WITH 1,
   log_entry VARCHAR(500),   
    CONSTRAINT fk_battle_log FOREIGN KEY (civilization_id, num_battle) REFERENCES battle_stats(civilization_id, num_battle) ON DELETE CASCADE,
    CONSTRAINT pk_battle_log PRIMARY KEY (civilization_id, num_battle, num_line)
  );

  
-- civilization_attack_stats
CREATE TABLE civilization_attack_stats
(
    civilization_id NUMBER,
    num_battle NUMBER,
    type VARCHAR2(20) CHECK (type IN ('Swordsman', 'Spearman', 'Crossbow', 'Cannon')),
    inicial NUMBER,
    drops NUMBER,
    CONSTRAINT chk_inicial_drops_attack_stats CHECK (inicial >= drops),
    CONSTRAINT fk_cas_battle_stats FOREIGN KEY (civilization_id, num_battle) REFERENCES battle_stats(civilization_id, num_battle) ON DELETE CASCADE,
    CONSTRAINT pk_civilization_attack_stats PRIMARY KEY (civilization_id, num_battle, type)
);
  
  
-- civilization_defense_stats
CREATE TABLE civilization_defense_stats
  (
     civilization_id NUMBER, -- FK
     num_battle NUMBER, -- FK
     type VARCHAR(20) CHECK (type IN ('ArrowTower', 'Catapult', 'RocketLauncherTower')),
     inicial NUMBER,
     drops NUMBER,
     CONSTRAINT chk_inicial_drops_defense_stats CHECK (inicial >= drops),
    CONSTRAINT fk_cds_battle_stats FOREIGN KEY (civilization_id, num_battle) REFERENCES battle_stats(civilization_id, num_battle) ON DELETE CASCADE,
    CONSTRAINT pk_civilization_defense_stats PRIMARY KEY (civilization_id, num_battle, type)
  );

-- civilization_special_stats
CREATE TABLE civilization_special_stats
  (
    civilization_id NUMBER, -- FK
    num_battle NUMBER, -- FK
    type VARCHAR(20) CHECK (type IN ('Magician', 'Priest')),
    inicial number,
    drops number,
    CONSTRAINT chk_inicial_drops_special_stats CHECK (inicial >= drops),
    CONSTRAINT fk_css_battle_stats FOREIGN KEY (civilization_id, num_battle) REFERENCES battle_stats(civilization_id, num_battle) ON DELETE CASCADE,
    CONSTRAINT pk_civilization_special_stats PRIMARY KEY (civilization_id, num_battle, type)
  );
  
  
-- enemy_attack_stats
CREATE TABLE enemy_attack_stats
(
    civilization_id NUMBER,
    num_battle NUMBER,
    type VARCHAR2(20) CHECK (type IN ('Swordsman', 'Spearman', 'Crossbow', 'Cannon')),
    inicial NUMBER,
    drops NUMBER,
    CONSTRAINT chk_inicial_drops_enemy_attack_stats CHECK (inicial >= drops),
    CONSTRAINT fk_eas_battle_stats FOREIGN KEY (civilization_id, num_battle) REFERENCES battle_stats(civilization_id, num_battle) ON DELETE CASCADE,
    CONSTRAINT pk_enemy_attack_stats PRIMARY KEY (civilization_id, num_battle, type)
);
