import java.util.Scanner;
public class TicTacToe{
  public static void main (String[] args){
    Scanner sc = new Scanner(System.in);
    String [][] gameBoard = {{" ", "  |", " ", "  |", " "}, {"---", "|", "---", "|", "---"},{" ", "  |", " ", "  |", " "}, {"---", "|", "---", "|", "---"},{" ", "  |", " ", "  |", " "}};
    String [] availSpaces = {"(0,0)", "(0,2)", "(0,4)", "(2,0)", "(2,2)", "(2,4)", "(4,0)", "(4,2)", "(4,4)"};
    boolean winner = false;
    int count = 0;
    int row = 0;
    int column = 0;
    printBoard(gameBoard);
    while(winner == false && count != 9){
      //PLAYER X 
      printAvailSpaces(availSpaces);
      System.out.print("Enter the row number from the selection above: ");
      row = sc.nextInt(); 
      System.out.print("Enter the column number from the selection above: ");
      column = sc.nextInt(); 
      if (legalMoves(row, column, availSpaces) == true){ //if valid move
        count++; // add 1 to counter
        x_turn(row, column, gameBoard); //change empty string to x
        printBoard(gameBoard); //print the board
        removeSpot(row, column, availSpaces); //remove the spot from available spaces
        if(x_wins(gameBoard) == true){
          System.out.println("Player X won!");
          System.exit(0);
        }
        else if(count == 9){
          System.out.println("It is a draw!");
          System.exit(0);
        }
      }
      else{
        System.out.print("You did not enter a valid location. Try again.");
        printAvailSpaces(availSpaces);
        System.out.print("Enter the row number from the selection above: ");
        row = sc.nextInt(); 
        System.out.print("Enter the column number from the selection above: ");
        column = sc.nextInt(); 
        if (legalMoves(row, column, availSpaces) == true){ //if valid move
          x_turn(row, column, gameBoard); //change empty string to x
          printBoard(gameBoard); //print the board
          removeSpot(row, column, availSpaces); //remove the spot from available spaces
          count++; // add 1 to counter
          if(x_wins(gameBoard) == true){
            System.out.println("Player X won!");
            System.exit(0);
          }
          else if(count == 9){
            System.out.println("It is a draw!");
            System.exit(0);
          }
        }
      }
      //PLAYER O
      printAvailSpaces(availSpaces);
      System.out.print("Enter the row number from the selection above: ");
      row = sc.nextInt(); 
      System.out.print("Enter the column number from the selection above: ");
      column = sc.nextInt(); 
      if (legalMoves(row, column, availSpaces) == true){ //if valid move
        o_turn(row, column, gameBoard); //change empty string to O
        printBoard(gameBoard); //print the board
        removeSpot(row, column, availSpaces); //remove the spot from available spaces
        count++; // add 1 to counter
        if(o_wins(gameBoard) == true){
          System.out.println("Player O won!");
          System.exit(0);
        }
        else if(count == 9){
          System.out.println("It is a draw!");
          System.exit(0);
        }
      }
      else{
        System.out.print("You did not enter a valid location. Try again.");
        printAvailSpaces(availSpaces);
        System.out.print("Enter the row number from the selection above: ");
        row = sc.nextInt(); 
        System.out.print("Enter the column number from the selection above: ");
        column = sc.nextInt(); 
        if (legalMoves(row, column, availSpaces) == true){ //if valid move
          o_turn(row, column, gameBoard); //change empty string to O
          printBoard(gameBoard); //print the board
          removeSpot(row, column, availSpaces); //remove the spot from available spaces
          count++; // add 1 to counter
          if(x_wins(gameBoard) == true){
            System.out.println("Player O won!");
            System.exit(0);
          }
          else if(count == 9){
            System.out.println("It is a draw!");
            System.exit(0);
          }
        }
      }
    }
  }
  public static void x_turn(int r, int c, String[][] gameBoard){
      gameBoard[r][c] = "X";
    }
  public static void o_turn(int r, int c, String[][] gameBoard){
    gameBoard[r][c] = "O";
  }
  
  //check if move is legal
  public static boolean legalMoves(int r, int c, String [] availSpaces){
    String combine = "(" + r + "," + c + ")";
    for (int i = 0; i < availSpaces.length; i++){
      if (availSpaces[i].equals(combine)){
        removeSpot(r, c, availSpaces);
        i = availSpaces.length;//end for loop
        return true;
      }
    }
    return false;
  }
    //remove spot
  public static void removeSpot(int r, int c, String[] availSpaces){
    String space = "(" + r + "," + c + ")";
    for (int i = 0; i < availSpaces.length; i++){
      if (availSpaces[i].equals(space)){
        availSpaces[i] = "";
      }
    }
  }
  //prints out the available spaces 
  public static void printAvailSpaces(String[] availSpaces){
    String as = "";
    for (int i = 0; i < availSpaces.length; i++){
      as += availSpaces[i]+ "";
    }
    System.out.println(as);
  }
  
  //prints board
  public static void printBoard(String[][] gameBoard){
    String str = "";
    for(int r = 0; r < gameBoard.length; r++){
      for (int c = 0; c<gameBoard[0].length;c++){
        str += gameBoard[r][c];
      }
      str += "\n";
    }
    System.out.println(str);
  }
  //all possibilities for x to win
  public static boolean x_wins(String [][] gb){
     if(gb[0][0] == "X" && gb[0][2] == "X" && gb[0][4] == "X" ||//three in a row
        gb[2][0] == "X" && gb[2][2] == "X" && gb[2][4] == "X" ||
        gb[4][0] == "X" && gb[4][2] == "X" && gb[4][4] == "X" ||
        gb[0][0] == "X" && gb[2][0] == "X" && gb[4][0] == "X" ||//three in a column
        gb[0][2] == "X" && gb[2][2] == "X" && gb[4][2] == "X" ||
        gb[0][4] == "X" && gb[2][4] == "X" && gb[4][4] == "X" ||
        gb[0][0] == "X" && gb[2][2] == "X" && gb[4][4] == "X" ||//diagonals
        gb[0][4] == "X" && gb[2][2] == "X" && gb[4][0] == "X"){
      return true;
    }
    else{
      return false;
    }
  }
  //all possibility for o to win
  public static boolean o_wins(String [][] gb){
     if(gb[0][0] == "O" && gb[0][2] == "O" && gb[0][4] == "O" ||//three in a row
        gb[2][0] == "O" && gb[2][2] == "O" && gb[2][4] == "O" ||
        gb[4][0] == "O" && gb[4][2] == "O" && gb[4][4] == "O" ||
        gb[0][0] == "O" && gb[2][0] == "O" && gb[4][0] == "O" ||//three in a column
        gb[0][2] == "O" && gb[2][2] == "O" && gb[4][2] == "O" ||
        gb[0][4] == "O" && gb[2][4] == "O" && gb[4][4] == "O" ||
        gb[0][0] == "O" && gb[2][2] == "O" && gb[4][4] == "O" ||//diagonals
        gb[0][4] == "O" && gb[2][2] == "O" && gb[4][0] == "O"){
      return true;
    }
    else{
      return false;
    }
  }
}