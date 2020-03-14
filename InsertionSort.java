public class InsertionSort{
	public static void main(String[] args){
		int [] arr = {70, 72, 86, 33, 36, 25, 37, 20, 11, 10};
		sort(arr);
		String str = "";
		for (int i = 0; i< arr.length; i++){
			str += arr[i] + " ";
		}
		System.out.print(str);
	}
	public static void sort(int [] arr){
		int n = arr.length; 
		for (int i = 1; i < n; ++i) { 
			int key = arr[i]; 
			int j = i - 1; 
			while (j >= 0 && arr[j] > key){ 
				arr[j + 1] = arr[j]; 
				j = j - 1; 
			} 
			arr[j + 1] = key; 
		} 
	} 
}