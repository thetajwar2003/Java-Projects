import java.util.Scanner;
public class BinarySearch{
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int[] arr = new int [100];
		for (int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*201);
		}
		System.out.print("Enter a num: ");
		int num = sc.nextInt();
		arr = sort(arr);
		System.out.print("Number of comparisons: " + search(num, arr, 0, arr.length-1) + " times ");
	}
	public static int search(int n, int[] arr, int start, int end){
		if(start>end){
			return -1;
		}
		int mid = (start+end)/2;
		if (n == arr[mid]){
			return mid;
		}
		else if(n<arr[mid]){
			return search(n, arr, start, mid-1);
		}
		else{
			return search(n, arr, mid+1, end);
		}
	}
	public static int[] sort(int [] arr){
		int temp = 0;
		for(int i = 0; i < arr.length; i++){
			for (int j= i+1; j<arr.length; j++){
				if(arr[i]>arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
}