import java.util.Scanner;
import java.lang.StringBuffer; //this class allows me to reverse the numbers when I find bi and hex for dec
import java.lang.Integer; //this class allows me to manipulate the input and see if the hex input is a digit or not
public class NumberConverter{
	public static void main (String[] args){
		Scanner kb = new Scanner(System.in);
		System.out.println("What do you want to convert?\n" + "1)Binary\n"+  "2)Decimal\n" + "3)Hexadecimal");
		int choice = kb.nextInt();
		if (choice == 1){
			System.out.print("Enter the Binary number you want to convert: ");
			int n = kb.nextInt();
			bi2_dec_hex(n); //converts binary to decimal and hex
		}
		if (choice == 2){
			System.out.print("Enter the Decimal number you want to convert: ");
			int n = kb.nextInt();
			dec2_bi_hex(n); // call the methods
		}
		if (choice == 3){
			System.out.print("Enter the hexadecimal number you want to convert: ");
			String n = kb.nextLine();//For some reason, whenever I use n, java automatically inputs 0 and ends the code so I used a heref
			String a = kb.nextLine();// if I get rid of n, the same thing happens
			hex2_dec_bi(a); // call the methods
		}
	}
//CHECK TO SEE IF INPUT IS A BINARY
	public static boolean isItBinary(int n){
		if (n % 10 > 1){
			return false;
		}
		return true;
	}

//BINARY TO REST
	public static void bi2_dec_hex(int n){
		int print_one = n;
		//BINARY TO DECIMAL
		int ans = 0;
		int place_value = 0;
		if (isItBinary(n)){
			while (n != 0){
				ans += (n%10) * Math.pow(2,place_value); //the remainder * 2^of the place
				n = n / 10; //goes on to the next binary digit & changes the original input
				place_value++; // increases the power
			}
			System.out.println(print_one +" in decimal form is: " + ans);
			
			//DECIMAL TO HEX
			if (ans == 0){
				System.out.println(print_one + " in hexadecimal form is: " + 0);
			}
			else{
				String hex_list = "0123456789ABCDEF";
				String hex = "";
				while (ans != 0){
					int num = ans%16;
					hex += hex_list.charAt(num);
					ans /= 16;
				}
				String reverse_list = new StringBuffer(hex).reverse().toString();// when you divide and flip the remainders
				System.out.println(print_one + " in hexadecimal form is: " + reverse_list);
			}
		}
		else{
			System.out.println("Please enter a binary number");
		}
	}


//DECIMAL TO THE REST
	public static void dec2_bi_hex(int n){
		int print_one = n;
		int temp = n;
		//DECIMAL TO BINARY
		String dec_bi = "";
		if (n <= 4095){
			while (n != 0){
				dec_bi += n % 2;
				n /= 2;
			}
			String reverse_list = new StringBuffer(dec_bi).reverse().toString();
			System.out.println(print_one + " in binary form is: " + reverse_list);
			
			//DECIMAL TO HEX
			String dec_hex = "";
			String hex_list = "0123456789ABCDEF";
			while (temp != 0){
				int num = temp % 16;
				dec_hex += hex_list.charAt(num);
				temp /= 16;
			}
			String reverse_list2 = new StringBuffer(dec_hex).reverse().toString();
			System.out.println(print_one + " in hexadecimal form is: " + reverse_list2);	
		}
		else {
			System.out.println("Please enter a smaller number.");
		}
	}


//HEX TO REST
	public static void hex2_dec_bi(String a){
		a = a.toUpperCase();
		String hex = "0123456789ABCDEF";
		int ans = 0;
		//HEX TO DEC
		if (a.length() <= 3){
			for(int i = 0; i < a.length(); i++){
				char c = a.charAt(i);
				int hex_num = hex.indexOf(c);//checks the input and sees where in the string is the input
				ans += hex_num * Math.pow(16, i);	//ex) if the user inputs a, A is the 10th character of string hex so the index of takes the place of letter a and I use it as an int	
				}
			System.out.println( a + " in decimal form is: " + ans);
			
			//DEC TO BINARY
			int temp = ans;
			String hex_bi = "";
			while (temp != 0){
				hex_bi += temp % 2;
				temp /= 2;
			}
			String reverse_list = new StringBuffer(hex_bi).reverse().toString();
			System.out.println(a + " in binary form is: " + reverse_list);
		}
		else {
			System.out.println("Please enter a smaller number.");
		}
	}		
}