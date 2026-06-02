package activities;

import java.util.*;

public class Activity8 {

	public static void main(String[] args) {

		// Initializing the scanner class
		Scanner sc = new Scanner(System.in);

		// Initializing the ArrayList
		List<String> names = new ArrayList<>();

		// Taking input and storing it in the array
		for (int i = 0; i < 5; i++) {
			System.out.print("Enter name: ");
			names.add(sc.next());
		}

		// Closing the scanner class
		sc.close();

		// 1. Print all the names
		for (String s : names) {
			System.out.println("Name: " + s);
		}

		// 2. Get the 3rd element in the array
		System.out.println("3rd Name: " + names.get(2));

		// 3. Check whether the name is present using contains
		System.out.println("Verify whether \"MaddyWiz007\" exists in the list: " + names.contains("MaddyWiz007"));

		// 4. Check the size of the array
		System.out.println("The size of the list is " + names.size());

		// 5. Remove one element in the array and check the size
		names.remove(1);
		System.out.println("The size of the list is " + names.size());
	}

}
