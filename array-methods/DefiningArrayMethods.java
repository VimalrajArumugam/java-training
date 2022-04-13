package arrayMethods;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

public class DefiningArrayMethods {

	int[] array = new int[] { 2, 4, 3, 7, 0 };
	int[] array1 = new int[] { 0, 1, 2, 3, 4 };
	int[] array2 = new int[] { 0, 1, 2, 3, 4, 5 };

	public void getFirstandLastElements() {

		try {
			int firstElement = array[0];
			int lastElement = array[array.length - 1];

			System.out.println("Display the First and Last Elements :");
			System.out.println(firstElement);
			System.out.println(lastElement);
		} 
		catch (IndexOutOfBoundsException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

	public void getRandomValues() {

		int anyValue = array[new Random().nextInt(array.length)];
		System.out.println(anyValue);

	}

	public void appendNewItem() {

		int[] newArray = Arrays.copyOf(array, array.length + 1);
//		int newItem =newArray[newArray.length - 1];
		newArray = ArrayUtils.add(array, 7);
		for (int i : newArray) {
			System.out.println(i);
		}

	}

	public void insertBetweenTwoValues() {

		try {
			int[] largerArray = ArrayUtils.insert(3, array, 77);
			for (int insertTwoValues : largerArray) {
				System.out.println(insertTwoValues);
			}
		} catch (IndexOutOfBoundsException ioe) {
			System.out.println(ioe.getMessage());
		}

	}

	public void compareTwoArrays() {

		boolean areEqual = Arrays.equals(array1, array2);
		System.out.println(areEqual);
	}

	public void arrayIsEmpty() {

		boolean isEmpty = ArrayUtils.isEmpty(array);
		System.out.println(isEmpty);
	}

	public void shuffleElements() {

		ArrayUtils.shuffle(array);
		for (int shuffle : array) {
			System.out.println(shuffle);
		}
	}
	

	public void boxing() {
		int[] array = new int[] { 2, 4, 3, 7, 0 };  //  PRIMITIVE DATA TYPE ((NON OBJECT)
		Integer[] list = ArrayUtils.toObject(array); //  NON PRIMITIVE DATA TYPE (( OBJECT)
//		Integer[] objectArray = { 3, 5, 2, 5, 14, 4 };
//		int[] array = ArrayUtils.toPrimitive(list);
		for (int boxUnbox : list) {
			System.out.println(boxUnbox);
		}

	}
	
	public void unBoxing() {

		Integer[] list = ArrayUtils.toObject(array);
//		Integer[] objectArray = { 3, 5, 2, 5, 14, 4 };
		int[] array = ArrayUtils.toPrimitive(list);
		for (int boxUnbox : array) {
			System.out.println(boxUnbox);
		}

	}

	public void removeDuplicates() {

		// Box
		Integer[] list = ArrayUtils.toObject(array); // convert to wrapper
		// Remove duplicates
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(list));
		// Create array and unbox
		ArrayUtils.toPrimitive(set.toArray(new Integer[set.size()]));
		System.out.println(set);

	}

	public void printArray() {

		String arrayAsString = ArrayUtils.toString(array);
		System.out.println(arrayAsString.getClass().getSimpleName());
		System.out.println(arrayAsString.getClass().getTypeName());
		System.out.println(arrayAsString);
	}

	public void mapArrayToAnotherArray() {
		
		int[] array1 = new int[] { 0, 1, 2, 3, 4 };
		String str = ArrayUtils.toString(array1);
		String[] str1 = ArrayUtils.addAll(null, str);
		for (String string : str1) {
			System.out.println(string);
		}
		
		
		
		String[] stringArray = Arrays.stream(array).mapToObj(value -> String.format("Value: %s", value))
				.toArray(String[]::new);
		for (String mapArrayToAnother : stringArray) {
			System.out.println(mapArrayToAnother);
		}

	}

	public void filterValue() {

		int[] evenArray = Arrays.stream(array).filter(value -> value % 2 != 0).toArray();
		for (int filter : evenArray) {
			System.out.println(filter);
		}

	}

	public void removeFirstElements() {

		int[] val = (ArrayUtils.remove(array, 2));
		System.out.println(Arrays.toString(val));
		System.out.println(val.getClass().getSimpleName());
		for (int i : val) {
			System.out.println(i);
		}

	}

}
