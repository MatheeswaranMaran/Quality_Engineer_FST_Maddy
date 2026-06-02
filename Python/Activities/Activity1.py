from datetime import datetime

#Take name and age as input
name = input("Enter your name: ")
age = int(input("Enter your age: "))

#Calculation of when the user becomes 100
current_year = datetime.now().year
year = 100 + current_year - age

#Print the output
print(f"{name} is going to become 100 in the year {year}")