package activities;

import java.util.*;

public class Activity4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the length of the array:");
		int length = sc.nextInt();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			System.out.print("Enter the elements:");
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < length; i++) {
			System.out.println(arr[i]);
		}
		sc.close();
		Activity4 ob = new Activity4();
		ob.insertionSort(arr);
		for (int i = 0; i < length; i++) {
			System.out.println(arr[i]);
		}
	}

	public int[] insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; ++i) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		return arr;
	}

}
