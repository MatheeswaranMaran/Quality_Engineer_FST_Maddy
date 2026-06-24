package activities;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;

public class ActionsBase {
	// Initializing the pointer
	private final PointerInput finger = new PointerInput(Kind.TOUCH, "finger");

	// Using the pointer to emulate swipe(drag/swipe)
	public void doSwipe(AppiumDriver driver, int duration, Point start, Point end) {
		// Create the sequence of actions
		Sequence swipe = new Sequence(finger, 1);
		swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), start.getX(), start.getY()));
		swipe.addAction(finger.createPointerDown(0)); // Left Click
		swipe.addAction(
				finger.createPointerMove(Duration.ofMillis(duration), Origin.viewport(), end.getX(), end.getY()));
		swipe.addAction(finger.createPointerUp(0)); // Left Click

		// Perform the sequence of actions
		driver.perform(Arrays.asList(swipe));
	}

	// Action Class
	public void doLongPress(AppiumDriver driver, Point start) {
		Sequence longPress = new Sequence(finger, 1);

		longPress.addAction(
				finger.createPointerMove(Duration.ofMillis(0), Origin.viewport(), start.getX(), start.getY()));
		longPress.addAction(finger.createPointerDown(0)); // Left Click
		longPress.addAction(new Pause(finger, Duration.ofMillis(500)));
		longPress.addAction(finger.createPointerUp(0));

		// Perform the sequence of actions
		driver.perform(Arrays.asList(longPress));
	}

}
