package activities;

public class Car {
	private String color;
	private String transmission;
	private int make;
	private int doors = 4;
	private int tyres = 4;
	
	Car(){
		
	}
	
	Car(String color, String transmission, int make) {
		this.color = color;
		this.transmission = transmission;
		this.make = make;
	}
	
	public void displayCharacteristics() {
		System.out.println(color + " " + transmission + " " + make + " " + tyres + " "+ doors);
	}
	
	public void accelerate() {
		System.out.println("This car is accelerating");
	}
	
	public void brake() {
		System.out.println("This car is braking");
	}
}
