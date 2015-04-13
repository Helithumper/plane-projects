package com.peyton.planeprojects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PlaneMain {
	public static boolean doneStat = false;

	public static boolean contains(int[] nums, int target) {
		for (int i : nums) {
			if (i == target) {
				return true;
			}
		}
		return false;
	}

	public static void multipleParts(int[] nums, int target) {
		ArrayList<Integer> numBuffer = new ArrayList<Integer>();
		boolean done = false;
		for (int i : nums) {
			if (!numBuffer.contains(i)) {
				numBuffer.add(i);
			}
		}
		for (int mainI = 0; mainI < nums.length; mainI++) {
			for (int firstIter = mainI + 1 % nums.length; firstIter < nums.length; firstIter++) {
				if (nums[mainI] * nums[firstIter] == target) {
					/*
					 * System.out.println("Index 1: " + mainI + "\tIndex 2: " +
					 * firstIter + "\nResult: " + (nums[mainI] *
					 * nums[firstIter]));
					 */
					done = true;
				}
			}
		}
		doneStat = done;
	}

	public static int[] fill(int numberOfIntegers) {
		Random rand = new Random();
		int[] result = new int[numberOfIntegers];

		for (int i = numberOfIntegers - 1; i > 0; i--) {
			result[i] = intRandom(0,10);
		}

		return result;
	}
	
	public static int intRandom(int min, int max){
		return (int) ((Math.random()+1) * max);
	}

	public static void main(String[] args) {
		System.out.println();
		Random rand = new Random();
		System.out.println(Arrays.toString(fill(100)));
		int j = 0;
		while (true) {
			for (int i = 0; i < 200; i++) {
				multipleParts(fill(i), Math.abs((int) Math.pow(
						(int) ((Math.random() + 1) * 10), 2)));
				if (doneStat) {

					if (j % 25 == 0) {
						System.out.println(j);
					} else {
						System.out.print(j + "\t");
					}
					j++;
					doneStat = false;
				}
			}
		}
	}
}
