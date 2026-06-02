package activities;

import java.util.*;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method
		// 1. Creating the map named "colors"
		HashMap<Integer, String> colors = new HashMap<>();

		// 2. Initializing the map
		colors.put(1, "Red");
		colors.put(2, "Blue");
		colors.put(3, "Green");
		colors.put(4, "White");
		colors.put(5, "Black");

		// 2. Print the map
		for (Map.Entry<Integer, String> entry : colors.entrySet()) {
			System.out.println("Key: " + entry.getKey() + " & " + "Value: " + entry.getValue());
		}

		// 3. Remove the color
		System.out.println("Removed color is: " + colors.remove(5));

		// 4. Check whether the green is present
		System.out.println("Verify whether \"Green\" present: " + colors.containsValue("Green"));

		// 5. Print the size
		System.out.println("The size of the map is: " + colors.size());
		System.out.println("The updated map is: " + colors);
	}

}
