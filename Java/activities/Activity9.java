package activities;

import java.util.*;

public class Activity9 {

	public static void main(String[] args) {
		HashSet<Object> hs = new HashSet<>();

		// 1. Add Objects inside the HashSet
		hs.add("Maddy");
		hs.add(23);
		hs.add("Parotta");
		hs.add('M');
		hs.add(true);
		hs.add(23092003);

		// 2. Print the size of the HashSet
		System.out.println("The size of the HashSet is " + hs.size());

		// 3. Remove the element

		if (hs.remove(23092003)) {
			System.out.println("Item removed from the set successfully");
		} else {
			System.out.println("Item doesn`t exist");
		}

		// 4. Remove the element which is not present
		if (hs.remove("MaddyWiz007")) {
			System.out.println("Item removed from the set");
		} else {
			System.out.println("Item doesn`t exist");
		}

		// 5. Use the contains() method
		System.out.println("Verify whether \"MaddyWiz\" present: " + hs.contains("MaddyWiz"));

		// 6. Print the updated set
		for (Object s : hs) {
			System.out.println("Object: " + s);
		}
	}

}
