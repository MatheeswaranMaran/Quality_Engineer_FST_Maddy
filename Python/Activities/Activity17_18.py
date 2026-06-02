import pandas as pd

df = pd.read_csv("data.csv")

print(df)

print("============================================")

print(df["Usernames"])

print("============================================")

print(df.iloc[1])

print("============================================")

print(df.sort_values("Usernames",ascending=True))

print("============================================")

print(df.sort_values("Passwords", ascending=False))