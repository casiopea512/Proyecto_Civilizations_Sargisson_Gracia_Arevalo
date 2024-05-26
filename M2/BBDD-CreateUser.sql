alter session set "_ORACLE_SCRIPT"=true;


CREATE USER civilization IDENTIFIED BY civilization;
GRANT ALL PRIVILEGES TO civilization;

COMMIT;