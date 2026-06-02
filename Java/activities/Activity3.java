package activities;

public class Activity3 {

	public static void main(String[] args) {
		// Create the call object
		Activity3 ob1 = new Activity3();
		// Call "adjustDevice"
		System.out.println(ob1.adjustDevice("THERMOSTAT", 42));
		System.out.println(ob1.adjustDevice("THERMOSTAT", 30));
		System.out.println(ob1.adjustDevice("LIGHT", 40));
	}

	public String adjustDevice(String device, int value) {

		return switch (device) {
		// Null case
		case null -> "Device is not mentioned";
		// Guarded Pattern Matching
		case String d when d.equals("THERMOSTAT") && value >= 40 -> "[Thermostat] Warning: Temperature is High";
		// Standard Pattern Matching
		case "THERMOSTAT" -> "[Thermostat] Temperature is set to " + value;

		case "LIGHT" -> "[Light] Adjusting brightness to " + value + "%";
		// Default message
		default -> "No data found";
		};
	}
}