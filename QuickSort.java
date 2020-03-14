public class QuickSort{
	public static void main(String args[]){
		int [] arr = {10, 8, 7, 9, 1, 5, 43, 423, 3};
		sort(arr, 0, arr.length-1);
		String str = "";
		for (int i = 0; i< arr.length; i++){
			str += arr[i] + " ";
		}
		System.out.print(str);
	}
	public static int split(int [] arr, int min, int max){
		int pivot = arr[max];  
		int i = (min-1); // index of smaller element 
		for (int j=min; j<max; j++) { 
			if (arr[j] < pivot) { 
				i++;
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		}
		int temp = arr[i+1]; 
		arr[i+1] = arr[max]; 
		arr[max] = temp; 
		return i+1; 
	} 
	public static void sort(int [] arr, int min, int max){
		if (min < max) { 
			int pi = split(arr, min, max);
			sort(arr, min, pi-1); 
			sort(arr, pi+1, max); 
		} 
	}
}