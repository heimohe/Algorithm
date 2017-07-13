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
			/*��j--�������Ŀ�����飬ֱ����keyС��ֵΪֹ*/
			while(j>i&&targetArr[j]>=key)
			{
				j--;
			}
			if(i<j)
			{
				/*targetArr[i]�Ѿ�������key�У��ɽ������������*/
				targetArr[i]=targetArr[j];
				i++;
			}
			/*��i++�������Ŀ�����飬ֱ����key���ֵΪֹ*/
			while(i<j&&targetArr[i]<=key)
				/*�˴�һ��ҪС�ڵ����㣬��������֮����һ�ڸ�1��0������ֵĻ�����key��ֵ��ǡ����1�Ļ�����ô���С�ڵ��ڵ����þͻ�ʹ�����if�����ִ��һ�ڴΡ�*/
			{
				i++;
			}
			if(i<j)
			{
				/*targetArr[j]�ѱ�����targetArr[i]�У��ɽ�ǰ���ֵ����*/
				targetArr[j]=targetArr[i];
				j--;
			}
		}
		/*��ʱi==j*/
		targetArr[i]=key;
		return i;
	}
	
	   public static int[] Sort(int[] array,int start ,int end){
	        if(start>=end){
	        	return array;
	        }
	        int index=quickSort(array,start,end);
	     
	        /*�ݹ���ã���keyǰ����������*/
	        Sort(array,start,index-1);
	         
	        return Sort(array,index+1,end);
	    }
		
}
