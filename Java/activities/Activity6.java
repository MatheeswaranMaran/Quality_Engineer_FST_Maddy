package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {

	private List<String> passengers;
	private int maxPassengers;
	private Date lastTimeTookOff;
	private Date lastTimeLanded;

	public Plane(int maxPassengers) {
		this.maxPassengers = maxPassengers;
		this.passengers = new ArrayList<>();
	}

	// Add passenger
	public void onboard(String passengerName) {

		if (passengers.size() < maxPassengers) {
			passengers.add(passengerName);
			System.out.println(passengerName + " boarded the plane");
		} else {
			System.out.println("Plane is full");
		}
	}

	// Plane takes off
	public Date takeOff() {

		this.lastTimeTookOff = new Date();
		return lastTimeTookOff;
	}

	// Plane lands
	public void land() {

		this.lastTimeLanded = new Date();
		passengers.clear();
	}

	// Getter for landing time
	public Date getLastTimeLanded() {
		return lastTimeLanded;
	}

	// Getter for passengers
	public List<String> getPassengers() {
		return passengers;
	}
}

public class Activity6 {

	public static void main(String[] args) throws InterruptedException {

		// There is a plane with max 10 passengers
		Plane plane = new Plane(10);

		// Add passengers
		plane.onboard("John");
		plane.onboard("Steve");
		plane.onboard("Anna");

		// Plane takes off
		System.out.println("Plane took off at: " + plane.takeOff());

		// Print passengers
		System.out.println("People on the plane: " + plane.getPassengers());

		// Flying...
		Thread.sleep(5000);

		// Plane lands
		plane.land();

		System.out.println("Plane landed at: " + plane.getLastTimeLanded());

		System.out.println("People on the plane after landing: " + plane.getPassengers());
	}
}