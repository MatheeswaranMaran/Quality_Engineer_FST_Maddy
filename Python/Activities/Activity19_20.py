import pandas as pd
from pandas import ExcelFile
from pandas import ExcelWriter

data = {
    "FirstName": ["Satvik", "Avinash", "Lahri"],
    "LastName": ["Shah", "Kati", "Rath"],
    "Email": ["satshah@example.com","avinashk@example.com","lahri.rath@example.com"],
    "PhoneNumber": [4537829198, 5892135421, 4528273499]
}

df = pd.DataFrame(data)

writer = ExcelWriter("./activities/users.xlsx")

df.to_excel(writer, sheet_name="Sheet1", index=False)

writer.close()

df = pd.read_excel("./activities/users.xlsx",sheet_name="Sheet1")

print(df)

print("==============================================")

print("The number of rows and columns are")

print(df.shape)

print("==============================================")

print("The email column of the excel")

print(df["Email"])

print("==============================================")

print("The Sheet by sorting with FirstName ascending")

print(df.sort_values("FirstName",ascending=True))