import pypyodbc as pyodbc

cnxn = pyodbc.connect(
'Trusted_Connection=yes;DRIVER={SQL Server};SERVER=localhost;DATABASE=HOLA;UID=sa;PWD=HOLAMUNDO'
)