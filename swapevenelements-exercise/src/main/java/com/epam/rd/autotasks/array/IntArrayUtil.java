package com.epam.rd.autotasks.array;

import java.util.Arrays;

public class IntArrayUtil {

	public static void swapEven(int[] array) {
		if(array == null || array.length < 2){
			return;
		}
		int i = 0;
		int j = array.length - 1;

		while (i < j){
			if(array[i] % 2 == 0 && array[j] % 2 == 0){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		{
			int[] array = null;
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
		{
			int[] array = new int[] {};
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
		{
			int[] array = new int[] { 10, 5, 3, 4 };
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
		{
			int[] array = new int[] { 100, 2, 3, 4, 5 };
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
		{
			int[] array = new int[] { 100, 2, 3, 45, 33, 8, 4, 54 };
			swapEven(array);
			System.out.println(Arrays.toString(array));
		}
	}

}
