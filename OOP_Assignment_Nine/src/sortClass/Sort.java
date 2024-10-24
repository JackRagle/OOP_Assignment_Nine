package sortClass;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Sort {
	
	public static int numLines;
	
	public static int[] createRandomArray(int arrayLength) {
		
		int[] array = new int[arrayLength];
		for(int i = 0; i < arrayLength; i++) {
			array[i] = (int) (Math.random() * 101);
		}
		
		return array;
		
	}
	
	public static void writeArrayToFile(int[] array, String filename) throws IOException {
		
		int[] arrayOut = array;
			
		FileWriter output = new FileWriter(filename);
		
		for(int i : arrayOut) {
			output.write(i + "\n");
		}
		
		output.close();
		
	}
	
	public static int[] readFileToArray(String filename) throws IOException {
		
		File file = new File(filename);
		Scanner input = new Scanner(file);
		
		numLines = 0;
		
		while(input.hasNextInt()) {
			input.nextLine();
			numLines++;
		}
		
		input.close();
		int[] array = new int[numLines];
		Scanner in = new Scanner(file);
		
		for(int i = 0; i < numLines; i++) {
			array[i] = in.nextInt();
		}
		
		in.close();
		
		return array;
		
	}
	
	public static void mergeSort(int[] array, int left, int right) {
		
		if(left < right) {
			int middle = (left + (right - 1)) / 2;
			
			mergeSort(array, left, middle);
			mergeSort(array, middle + 1, right);
			
			merge(array, left, middle, right);
		}
		
	}
	
	public static void merge(int[] array, int left, int middle, int right) {
		
		int leftArraySize = middle - left + 1;
		int rightArraySize = right - middle;
		
		int[] leftArray = new int[leftArraySize];
		int[] rightArray = new int[rightArraySize];
		
		for(int i = 0; i < leftArraySize; i++) {
			leftArray[i] = array[left + i];
		}
		for(int j = 0; j < rightArraySize; j++) {
			rightArray[j] = array[middle + 1 + j];
		}
		
		int i = 0, j = 0;
		
		int k = left;
		
		while(i < leftArraySize && j < rightArraySize) {
			if(leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			}else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		while(i < leftArraySize) {
			array[k] = leftArray[i];
			i++;
			k++;
		}
		
		while(j < rightArraySize) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
		
	}
	
}
