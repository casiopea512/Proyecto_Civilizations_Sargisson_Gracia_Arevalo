import pypyodbc as pyodbc
#import oracledb as driverOracle
#import cx_Oracle as cxo

print("Empieza conexción")

#cnxn = pyodbc.connect('DRIVER={SQL Server};SERVER=localhost;DATABASE=Civilization;UID=admin;PWD=admin')
# cursor = cnxn.cursor()
# cursor.execute('select * from civilization_stats')
#
# for row in cursor.fetchall():
#     print(row)

#cnxn = driverOracle.connect(user="admin",password="admin",dsn='localhost/xepdb1')

db_host = 'localhost'
db_name = 'Civilization'
db_user = 'admin'
db_pswd = 'admin'

connection_string = 'Driver={SQL Server};Server='+ db_host + ';Database='+db_name +';UID='+db_user +';PWD='+db_pswd +';'
db = pyodbc.connect(connection_string)

# query
cursor = db.cursor()
query = 'select * from civilization_stats'
cursor.execute(query)

while True:
    row = cursor.fetchone()
    if not row:
        break
    print("Respuesta: "+row)

print("Conexión correcta")

cursor.close()
db.close()


print("Fin conexión")