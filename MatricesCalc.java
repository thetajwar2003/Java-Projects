import java.util.Scanner;
public class MatricesCalc{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of rows for the 1st matrix (Matrix A): ");
		int mtrxA_row = sc.nextInt();
		System.out.print("Enter the number of columns for the 1st matrix (Matrix A): ");
		int mtrxA_column = sc.nextInt();
		System.out.print("Enter the number of rows for the 2nd matrix (Matrix B): ");
		int mtrxB_row = sc.nextInt();
		System.out.print("Enter the number of columns for the 2nd matrix (Matrix B): ");
		int mtrxB_column = sc.nextInt(); 
		
		//make the arrays witht the given rows and columns
		int [][] mtrxA = new int [mtrxA_row][mtrxA_column];
		int [][] mtrxB = new int [mtrxB_row][mtrxB_column];
		
		//input all the elements for array a 
		for (int row_a = 0; row_a < mtrxA_row; row_a ++){
			for (int column_a = 0; column_a < mtrxA_column; column_a ++){
				System.out.print("Enter A[" + row_a + "][" + column_a + "]: ");
				mtrxA[row_a][column_a] = sc.nextInt();
			}
		}
		
		//input all the elements for array b
		for (int row_b = 0; row_b < mtrxB_row; row_b ++){
			for (int column_b = 0; column_b < mtrxB_column; column_b ++){
				System.out.print("Enter B[" + row_b + "][" + column_b + "]: ");
				mtrxB[row_b][column_b] = sc.nextInt();
			}
		}
		
		// add and minus mtrx must have the same length
		if(mtrxA.length == mtrxB.length && mtrxA[0].length == mtrxB[0].length){
			System.out.println("The result for A+B is: \n" + add(mtrxA, mtrxB));
			System.out.println("The result for A-B is: \n" + subtract(mtrxA, mtrxB));
			//do adding and subtracting matrice
		}
		else{
			System.out.println("For addition and subtraction, matrices must have the same number of rows and columns. Therefore those are illegal matrices.");
		}
		
		//times mtrx must have same # of columns and rows
		if (mtrxA_column == mtrxB_row){
			System.out.println("The result for A*B is: \n" + times(mtrxA, mtrxB));
			//do times
		}
		else{
			System.out.println("For multiplying, the number of columns in Matrix A be equal to the number of rows in Matrix B. Therefore those are illegal matrices.");
		}
	}
	
	//ADD
	public static String add(int[][] a, int [][] b){ //takes in the arrays made above
		String str = "";
		for (int r = 0; r < a.length; r++){ //every row
			for(int i = 0; i < a[0].length; i++){ //every element in the row
				str+= a[r][i] + b[r][i] + " "; // add the element of a and b
			}
			str+= "\n";
		}
		return str; // makes them a string so I can print
	}
	
	//SUBTRACT
	public static String subtract(int[][] a, int [][] b){ //takes in the arrays made above
		String str = "";
		for (int r = 0; r < a.length; r++){ //every row
			for(int i = 0; i < a[0].length; i++){ //every element in the row
				str+= a[r][i] - b[r][i] + " "; // add the element of a and b
			}
			str+= "\n";
		}
		return str; // makes them a string so I can print
	}
	
	//TIMES
	public static String times (int [][] a, int [][] b){  //takes in arrays made above 
		int sum = 0;
		String str = "";
		for(int row_a = 0; row_a < a.length; row_a ++){ // each row in mtrx a 
			for (int e_b = 0; e_b < b[0].length; e_b ++){ // each element in mtrx b
				for(int er_ab = 0; er_ab < a[0].length; er_ab++){ // element in a and row in b 
					sum+= a[row_a][er_ab] * b[er_ab][e_b];
				}
				str += sum+ " ";
				sum = 0;
			}
			str += "\n";
		}
		return str;
	}
}