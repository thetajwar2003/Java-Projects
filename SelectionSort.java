public class SelectionSort{
  public static void main(String[] args){
    int [] arr = new int[30];
    for (int i = 0; i< arr.length; i++){
      arr[i] = (int) (Math.random()*101);
    }
    sort(arr);
    String str = " ";
    for (int i = 0; i< arr.length; i++){
      str += arr[i] + " ";
    }
    System.out.print(str);
  }
  public static void sort(int[] arr){
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
    }
  }
}