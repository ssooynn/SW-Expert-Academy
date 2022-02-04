package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_flatten{
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/ws/input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int T=1; T<10; T++) {
			int dump = Integer.parseInt(in.readLine());
			String[] numbers = in.readLine().split(" ");
	
			int[] nums = new int[100];
			for(int i=0; i<100; i++) {
				nums[i] = Integer.parseInt(numbers[i]);
			}
			int ans = 0;
			for(int i=0; i<dump; i++) {
				int min = 101;
				int max = -1;
				int min_index = 0;
				int max_index = 0;
				
				for(int j=0; j<100; j++) {
					if(max < nums[j]) {
						max = nums[j];
						max_index = j;
						}
					if(min > nums[j]) {
						min = nums[j];
						min_index = j;
						}
				}
				ans = max - min;
				if(ans>=0 && ans < 2) {
					break;
				}
				nums[max_index] -=1;
				nums[min_index] +=1;
			}
			System.out.println("#"+T+" "+ans);
		}
	}
}
