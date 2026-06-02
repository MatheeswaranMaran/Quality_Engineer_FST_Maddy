package activities;

abstract class Book {
	// Class Properties
	String title;

	// Abstract Method
	abstract public void setTitle(String title);

	// Concrete Method
	public String getTitle() {
		return title;
	}

}

class MyBook extends Book {

	// Abstract Method Implementation
	public void setTitle(String title) {
		if (title.length() < 3) {
			System.out.println("Length of the title is too small");
		} else if (title.length() > 30) {
			System.out.println("Length of the title is too long");
		} else {
			this.title = title;
		}
	}
}

public class Activity5 {

	public static void main(String[] args) {

		// Object Creation
		MyBook obj = new MyBook();

		obj.setTitle("Sherlock Holmes");
		System.out.println(obj.getTitle());
		obj.setTitle("The Adventures of Sherlock Holmes");
		System.out.println(obj.getTitle());
	}

}
