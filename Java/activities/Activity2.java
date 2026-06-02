package activities;

public class Activity2 {

	public static void main(String[] args) {

		// Variable to store the sum of 10`s
		int sum = 0;

		// Input array
		int[] nums = { 10, 77, 10, 54, -11, 10 };

		// Iterate through the array
		for (int num : nums) {

			if (num == 10) {
				sum += 10;
			}
		}

		// Validate whether the total sum of matching elements equals 30
		if (sum == 30) {

			System.out.println("True");
		} else {

			System.out.println("False");
		}
	}
}
