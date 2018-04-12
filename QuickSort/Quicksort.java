//Name Blake Schollmeyer
//Username: bas76530
//700No: 700517653
//Assignment Number: a8
//Folder Name: QuickSort
//Due: 4/11/2016

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Quicksort{

	public static void main(String[] args) throws Exception{

		Scanner input = new Scanner(new File("input.txt"));

		int[] data = new int[100];

		int x, count = 0;

		while (input.hasNext()) {
			x = input.nextInt();
			data[count++] = x;
		}

		//Print out unordered data
		System.out.println("Un-ordered Data");
		System.out.println("---------------");
		print(data,count);

		//Use recurseion to quicksort the list
		quicksortHelper(data, 0, count - 1);

		//Print out ordered data
		System.out.println("\nOrdered Data");
		System.out.println("=-------------");
		print(data,count);


	}


	protected static void quicksortHelper(int[] data, int bottom, int top){
		if(bottom < top){
			int midpoint = partition(data, bottom, top);
			quicksortHelper(data, bottom, midpoint - 1);
			quicksortHelper(data, midpoint + 1, top);
		}
	}

	protected static int partition(int[] data, int bottom, int top){
		int pivot = data[top];
		int firstAfterSmall = bottom;
		for(int i = bottom; i < top; i++){
			if(data[i] <= pivot){
				swap(data, firstAfterSmall, i);
				firstAfterSmall++;
			}
		}
		swap(data, firstAfterSmall, top);
		return firstAfterSmall;

	}

	protected static void swap(int[] data, int i, int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	protected static void print(int[] data, int count){
		for(int i = 0;i < count;i++){
					System.out.print(data[i] + (i < (count - 1)? ", ": ""));

		}
		System.out.print("\n");

	}


}