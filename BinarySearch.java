package yoozoo.day1;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		//二分查找 
		int i = 0;
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[] arr = new int[num ]; //定义一个有序数组
		while(i < num){
			arr[i] = scan.nextInt();
			i++;
		}
		int target = 5; //要在输入的数组里面查找5
		int low = 0;
		int high = arr.length-1;
		int  j = binarysort(arr,low,high,target);
		System.out.println(j + " " + arr[j]);
	}

	private static int binarysort(int[] arr, int low, int high, int target) {
		// 二分查找
		while(low <= high){
			int mid = (low + high)/2;
			if(arr[mid] < target){
				low = mid+1;
			}else if(arr[mid] > target){
				high = mid-1;
			}else{
				return mid ;
			}
		}
		return -1;
		
	}

	

}
