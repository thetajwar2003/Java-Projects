import java.util.*;
public class sequentialSearch{
  public static void main(String[] args){
    Scanner s = new Scanner (System.in);
    int [] arr = new int [100];
    for (int i = 0; i < arr.length; i++){
      arr[i] = (int)(Math.random()*201);
    }
    System.out.print("enter num: ");
    int k = s.nextInt();
    System.out.print("Number of comparisons: " +seq(k, arr) + " times ");
  }
  public static int seq(int num, int [] arr){
    int count = 0;
    for (int i: arr){
      if (num == i){
        count++; 
      }
    }
    return count;
  }
}