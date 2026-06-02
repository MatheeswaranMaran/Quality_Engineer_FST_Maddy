package activities;

import java.util.*;

public class Activity13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the age: ");

		String age = sc.next();

		sc.close();

		String result = registerUser(age);

		System.out.println(result);

	}

	public static String registerUser(String age) {
		try {
			int n = Integer.parseInt(age);

			if (n < 18) {
				throw new IllegalArgumentException("Users must be atleast 18 years old.");
			}
			return "Registration successful! Welcome aboard.";
		} catch (NumberFormatException e) {
			return "Error: Age must be a valid number.";
		} catch (IllegalArgumentException e) {
			return (e.getMessage());
		}
	}

}
