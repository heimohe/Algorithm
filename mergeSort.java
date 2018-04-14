package yoozoo.day1;

public class Test9 {

	public static void main(String[] args) {
		// 归并排序
		int[]  arr = {1,4,2,8,12,9};
		int low = 0;
		int high = arr.length-1;
		int[] res = new int[arr.length];
		mSort(arr ,  res , low ,high);

		for(int t = 0 ;t < res.length ; t++){
			System.out.println(res[t]);
		}
	}

	private static void mSort(int[] arr, int[] res, int low, int high) {
		int m; //将数组二等分坐标
		int[] tR2 = new int[arr.length]; //临时数组
		
		if(low == high){
			res[low] = arr[low];
		}else{
			m = (low + high)/2;
			mSort(arr, tR2, low, m);
			mSort(arr, tR2, m+1, high);
			merge(tR2, res , low , m , high); //把临时数组值合并到结果数组中
		}
		
		
	}

	//这是一个合并的过程
	private static void merge(int[] tR2, int[] res, int low, int m, int high) {
		int j,k,l;
		for(j=m+1,k=low; low<=m&&j<=high; k++) {
			if(tR2[low] < tR2[j]){
				res[k] = tR2[low++];
			}else{
				res[k] = tR2[j++];
			}
		}
		
		//把左边的剩余数全部都移动到结果数组中
		if(low <= m){
			for(l=0;l <= m-low;l++){
				res[k+l] = tR2[low+l];
			}
		}
		
		if(j <= high){
			for(l=0; l<= high-j;l++){
				res[k+l] = tR2[j+l];
			}
		}
		
	}

}
