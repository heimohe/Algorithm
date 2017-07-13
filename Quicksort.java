package com.test;

public class Quicksort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int targetArr[] = {3,1,5,6,8,4,12,7,23,54,1,5,4};
//		Quicksort sort = new Quicksort();
		int result[] = Sort(targetArr,0,targetArr.length-1);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}

	@SuppressWarnings("unused")
	private static int quickSort(int[] targetArr,int start,int end)
	{
		int i=start,j=end;
		int key = targetArr[start];
		
		while(i<j)
		{
			/*按j--方向遍历目标数组，直到比key小的值为止*/
			while(j>i&&targetArr[j]>=key)
			{
				j--;
			}
			if(i<j)
			{
				/*targetArr[i]已经保存在key中，可将后面的数填入*/
				targetArr[i]=targetArr[j];
				i++;
			}
			/*按i++方向遍历目标数组，直到比key大的值为止*/
			while(i<j&&targetArr[i]<=key)
				/*此处一定要小于等于零，假设数组之内有一亿个1，0交替出现的话，而key的值又恰巧是1的话，那么这个小于等于的作用就会使下面的if语句少执行一亿次。*/
			{
				i++;
			}
			if(i<j)
			{
				/*targetArr[j]已保存在targetArr[i]中，可将前面的值填入*/
				targetArr[j]=targetArr[i];
				j--;
			}
		}
		/*此时i==j*/
		targetArr[i]=key;
		return i;
	}
	
	   public static int[] Sort(int[] array,int start ,int end){
	        if(start>=end){
	        	return array;
	        }
	        int index=quickSort(array,start,end);
	     
	        /*递归调用，把key前面的完成排序*/
	        Sort(array,start,index-1);
	         
	        return Sort(array,index+1,end);
	    }
		
}
