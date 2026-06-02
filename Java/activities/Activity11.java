package activities;

@FunctionalInterface
interface Addable {
	public int add(int num1, int num2);
}

public class Activity11 {

	public static void main(String[] args) {
		// Implementing the function
		Addable ad1 = (num1, num2) -> num1 + num2;

		Addable ad2 = (int num1, int num2) -> {
			return num1 + num2;
		};

		// Call the function
		System.out.println(ad1.add(7, 8));
		System.out.println(ad2.add(1, 2));
	}

}
