package activities;

import java.util.*;

public class Activity12 {

	public static void main(String[] args) {
		// Scanner class
		Scanner sc = new Scanner(System.in);

		List<Integer> numList = new ArrayList<>();

		// Getting the elements of the list from the user
		System.out.println("Enter the numbers: ");
		while (sc.hasNextInt()) {
			numList.add(sc.nextInt());
		}
		sc.close();

		// Random Index Generator
		Random r = new Random();
		int randIndex = r.nextInt(numList.size());

		System.out.println("The Random Index is: " + randIndex);
		System.out.println("The Number in the random index is: " + numList.get(randIndex));
	}

}
