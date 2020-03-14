public class MergeSort{
	public static void main(String[] args){
		int [] arr = new int [(int)(Math.random()*100)];
		for (int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*100);
		}
		split(arr, 0, arr.length-1);
		String str = "";
		for (int i = 0; i< arr.length; i++){
			str += arr[i] + " ";
		}
		System.out.print(str);
	}
	public static void split (int[] arr, int start, int end){
		if (start < end){
			int mid = (start+end)/2;
			split(arr, start, mid);
			split(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	public static void merge(int [] arr, int start, int mid, int end){
		int length1 = mid - start + 1;
		int length2 = end - mid;
		
		int[] sub1 = new int [length1];
		int[] sub2 = new int [length2];
		
		for(int i = 0; i < length1; ++i){
			sub1[i] = arr[i + start];
		}
		for (int j = 0; j < length2; ++j){
			sub2[j] = arr[mid + j + 1];
		}
		int index1 = 0; 
		int index2 = 0; 
		int arr_index = start;
		while (index1 < length1 && index2 < length2){
			if (sub1[index1] <= sub2[index2]){
				arr[arr_index] = sub1[index1];
				index1++;
			}
			else{
				arr[arr_index] = sub2[index2];
				index2++;
			}
			arr_index++;
		}
		while (index1 < length1) { 
			arr[arr_index] = sub1[index1]; 
			index1++; 
			arr_index++; 
		} 
  		while (index2 < length2) { 
			arr[arr_index] = sub2[index2]; 
			index2++; 
			arr_index++; 
		} 
	}
}