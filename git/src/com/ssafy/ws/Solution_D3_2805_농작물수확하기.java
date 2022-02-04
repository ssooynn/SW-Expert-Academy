package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D3_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc =1; tc<=T; tc++) {
			int N = Integer.parseInt(in.readLine());
			int[][] arr = new int[N][N];
			int ans = 0;
			for(int i=0; i<N; i++) {
				String[] tmp = in.readLine().split("");
				for (int j = 0; j < tmp.length; j++) {
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			int start = N/2;
			int end = start+1;
			
			for(int i=0; i<N/2; i++) {
				for(int j=start; j<end; j++) {
					ans+=arr[i][j];
				}
				start -= 1;
				end += 1;
			}
	
			for(int i=(N/2); i<N; i++) {
				for(int j=start; j<end; j++) {
					ans+=arr[i][j];
				}
				start += 1;
				end -= 1;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}	
}
