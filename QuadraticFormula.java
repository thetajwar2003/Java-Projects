import java.util.Scanner;
public class QuadraticFormula{
	public static void main (String[] args){
		Scanner quad = new Scanner(System.in);	
		System.out.println("Enter a: ");
		int a = quad.nextInt();
		
		System.out.println("Enter b: ");
		int b = quad.nextInt();

		System.out.println("Enter c: ");
		int c = quad.nextInt();
		calculate(a, b, c);
	} 
	public static void calculate(int a, int b, int c){
		double temp = Math.pow(b, 2) - 4*a*c;
		double x1 = (b + Math.sqrt(temp))/(2*a);
		double x2 = (b - Math.sqrt(temp))/(2*a);
		System.out.println("The positive root is " + x1 + " and the negative root is " + x2);
	}
}