import java.util.*;
public class ChooseSort{
	public static void main (String[] main){
		Scanner sc = new Scanner (System.in);
		
		int[] arr = new int [10];
		for (int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random()*101);
		}
		
		System.out.print("Which sorting algorithm would you like to use? \n1) Selection Sort \n2) Insertion Sort \n3) Merge Sort \n4) Quick Sort \nEnter number: ");
		int choice = sc.nextInt();
		System.out.println("Initial array: " + Arrays.toString(arr));
		switch (choice) {
			case 1:
				selectionSort(arr);
				System.out.println("Sorted array: " + Arrays.toString(arr));
				System.out.println("Selection sort has a best, average, and worst case time complexity of n^2 or O(n^2).");
				break;
			case 2:
				insertionSort(arr);
				System.out.println("Sorted array: " + Arrays.toString(arr));
				System.out.println("Insertion sort has an average and worst case time complexity of n^2 or O(n^2). Best case complexity is O(n),");
				break;
			case 3:
				mergeSort(arr, 0, arr.length-1);
				System.out.println("Sorted array: " + Arrays.toString(arr));
				System.out.println("Merge sort has a best, average, and worst case time complexity of n log(n) or O(n log(n))");
				break;
			case 4:
				quickSort(arr, 0, arr.length-1);
				System.out.println("Sorted array: " + Arrays.toString(arr));
				System.out.println("Quick sort has a best and average case time complexity of n log(n) or O(n log(n)). Worst case complexity is O(n^2).");
				break;
			default:
				System.out.println("Not one of the choices.");
				break;
		}
	}
	//****SELECTION SORT***
	public static void selectionSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			int min = i;
			for (int j = i+1; j < arr.length; j++){
				if (arr[j] < arr[min]){
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			if(i != 0 && i != arr.length-1){
				System.out.println("Step " + i +": " + Arrays.toString(arr));
			}
		}	
		
	}
	
	//****INSERTION SORT****
	public static void insertionSort(int [] arr){ 
		for (int i = 1; i < arr.length; ++i) { 
			int key = arr[i]; 
			int j = i - 1; 
			while (j >= 0 && arr[j] > key){ 
				arr[j + 1] = arr[j]; 
				j = j - 1; 
			} 
			arr[j + 1] = key; 
			if(i != 0 && i != arr.length-1){
				System.out.println("Step " + i +": " + Arrays.toString(arr));
			}
		}
		
	} 
	
	//****MERGE SORT****
	public static void mergeSort (int[] arr, int start, int end){
		if (start < end){
			int mid = (start+end)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	public static void merge(int [] arr, int start, int mid, int end){
		int count = 1;
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
			System.out.println("Step " + count +": " + Arrays.toString(arr));
			count++;
		}
		while (index1 < length1) { 
			arr[arr_index] = sub1[index1]; 
			index1++; 
			arr_index++; 
			count++;
		} 
  		while (index2 < length2) { 
			arr[arr_index] = sub2[index2]; 
			index2++; 
			arr_index++; 
			count++;
		}	
	}

	
	//****QUICK SORT****
	public static int split(int [] arr, int min, int max, int count){
		int pivot = arr[max];  
		int i = (min-1); // index of smaller element 
		for (int j=min; j<max; j++) { 
			if (arr[j] < pivot) { 
				i++;
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
			System.out.println("Step " + count +": "+ Arrays.toString(arr));
			count++;
		}
		int temp = arr[i+1]; 
		arr[i+1] = arr[max]; 
		arr[max] = temp; 
		return i+1; 
	} 
	public static void quickSort(int [] arr, int min, int max){
		int count = 0;
		if (min < max) { 
			count++;
			int pi = split(arr, min, max, count);
			quickSort(arr, min, pi-1); 
			quickSort(arr, pi+1, max); 
		} 
	}
}