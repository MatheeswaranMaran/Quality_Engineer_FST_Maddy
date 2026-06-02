package activities;

interface BicycleParts {

	public static final int tyres = 2;
	public static final int maxSpeed = 100;
}

interface BicycleOperations {

	public void applyBrakes(int decrement);

	public void speedUp(int increment);
}

class Bicycle implements BicycleParts, BicycleOperations {

	public int gears;
	public int currentSpeed;

	Bicycle(int g, int cs) {

		this.gears = g;
		this.currentSpeed = cs;
	}

	public void applyBrakes(int decrement) {

		currentSpeed -= decrement;

		System.out.println("The cycle slowed down by " + decrement + " km/h.\n");
	}

	public void speedUp(int increment) {

		currentSpeed += increment;

		System.out.println("The cycle sped up by " + increment + " km/h.\n");

	}

	public void bicycleDesc() {

		System.out.printf(
				"This is a bicycle with %d gears and %d max speed. \n It is currently going at the speed of %d km/h",
				this.gears, BicycleParts.maxSpeed, this.currentSpeed);
	}
}

class MountainBike extends Bicycle {

	int seatHeight;

	MountainBike(int g, int cs, int sh) {

		// Calling parent constructor
		super(g, cs);

		// Initializing child variable
		this.seatHeight = sh;
	}

	public void setHeight(int newHeight) {
		this.seatHeight = newHeight;
	}

	public void bicycleDesc() {
		System.out.printf(
				"This is a Mountain Bike with %d gears and has a seat height of %d.\nIt is going at the speed of %d km/h.\n\n",
				this.gears, this.seatHeight, this.currentSpeed);
	}
}

public class Activity7 {

	public static void main(String[] args) {

		MountainBike mb = new MountainBike(5, 40, 10);

		// Calling the functions
		mb.bicycleDesc();

		mb.speedUp(20);

		mb.bicycleDesc();

		mb.applyBrakes(10);

		mb.setHeight(15);

		mb.bicycleDesc();
	}

}
