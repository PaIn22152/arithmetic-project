package com.payne.leetCode;

/**
 * Created by payne on 2018-01-11.
 * About 类描述：
 */
public class P_463_IslandPerimeter {

	public int islandPerimeter(int[][] grid) {

	}

	private int getBorderNum(int[] nums){
		boolean isFirst=true;
		int s=0;
		for(int i:nums){
			if(isFirst&&i==1){
				isFirst=false;
			}else if(i==1){
				s++;
			}
		}
		return s;
	}

}