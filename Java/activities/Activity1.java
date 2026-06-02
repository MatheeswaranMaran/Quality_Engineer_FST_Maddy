package activities;

public class Activity1 extends Car {

	public static void main(String[] args) {
		Car ob = new Car("Black", "Automatic", 2025);
		ob.displayCharacteristics();
		ob.accelerate();
		ob.brake();

	}

}
