import java.util.Scanner;
public class SwapNum{
	public static void main (String[] args){
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter an integer less than 1000: ");
		int n = kb.nextInt();
		swap(n);
	}
	public static void swap(int n){
		if (n < 10){
			System.out.println(n + "0");
		}
		else if (n > 9 && n < 100){
			int o = n % 10; // ones
			int t = n/10; // tens
			String str1 = Integer.toString(o);
			String str2 = Integer.toString(t);
			System.out.println(str1 + str2);
		}
		else if (n >= 100 && n <= 999){
			int o = n % 10;  // ones
			int tens = n % 100; // this leaves the tens and ones 
			int t = tens / 10;  //you only need 10s place 
			int h = n /100; // hun
			String str1 = Integer.toString(h);
			String str2 = Integer.toString(o);
			String str3 = Integer.toString(t);
			System.out.println(str1 + str2 + str3);
		}
		else{
			System.out.println("Read directions");
		}
	}
}