Name: Blake Schollmeyer
Username: bas76530
700no: 700517653
Assignment Number: a3
Folder Name: Domineering
Due: 2/8/16

// Introduced in Chapter 2
/** The game of Domineering. */

public class Domineering {

  //For reading from the console
  public static final java.util.Scanner INPUT
    = new java.util.Scanner(System.in);

  //The player who plays their dominoes horizontally
  public static final boolean HORIZONTAL = false;

  //The player who plays their dominoes vertically
  public static final boolean VERTICAL = true;

  // Array of board squares, true if occupied
  private boolean[][] squares;

  //Char of first player(h/v)
  private char firstPlayer;

  //Number of rows entered by player
  private int nr;
  //Number of columns entered by player
  private int nc;

  // The board is initially empty
  public Domineering(){
	  boolean inputNotValid;
	  do{
		  inputNotValid = false;
		  try{
			  //ask for the size of the game board
			System.out.print("Enter number of Rows and Columns for gameboard (from 1 to 10): ");
			nr = INPUT.nextInt();
			nc = INPUT.nextInt();
			//throw exception if board parameters are out of bounds
			if(nr > 10 || nc > 10 || nr < 1 || nc < 1){
				throw new BoardParametersOutOfBounds("BoardParametersOutOfBouns");
			}
			//ask for the order of players
			do{
				System.out.print("Who goes first (h,You/v,CPU)");
				firstPlayer = INPUT.next().charAt(0);
				if(firstPlayer != 'h' || firstPlayer != 'v' || firstPlayer != 'H' || firstPlayer != 'V'){
					System.out.println("---------------------\nBad data - try Again?\n---------------------");
				}
			}while(firstPlayer != 'h' && firstPlayer != 'v' && firstPlayer != 'H' && firstPlayer != 'V');

		  }catch(java.util.InputMismatchException e){
			  System.out.println("---------------------\nBad data - try Again?\n---------------------");
			  INPUT.nextLine();
			  inputNotValid = true;
		  }catch(BoardParametersOutOfBounds e){
			  System.out.println("-------------------------------\nBad data - try Again?" +
			  						"\nBoardParametersOutOfBounds\nPlease enter Rows and Columns (between 1 to 10)" +
			  						"\n-------------------------------");
			  INPUT.nextLine();
			  inputNotValid = true;
		  }
	  }while(inputNotValid);

    squares = new boolean[nr][nc];
    // Java initializes all array elements to false
  }

  // Return true if there is a legal move for the specified player.
  public boolean hasLegalMoveFor(boolean player) throws ArrayIndexOutOfBoundsException {
    try{
		int rowOffset = 0;
		int columnOffset = 0;
		if (player == HORIZONTAL) {
		  columnOffset = 1;
		} else {
		  rowOffset = 1;
		}
		for (int row = 0; row < (nr - rowOffset); row++) {
		  for (int column = 0; column < (nc - columnOffset); column++) {
			if (!(squares[row][column]
				  || squares[row + rowOffset][column + columnOffset])) {
			  return true;
			}
		  }
		}
    	return false;
	}catch(java.lang.ArrayIndexOutOfBoundsException e){
		throw new ArrayIndexOutOfBoundsException("Enter value on game board");
	}
  }

  //Play until someone wins
  public void play() {
	  boolean player;
	  if(firstPlayer == 'h')
    	player = HORIZONTAL;
      else
      	player = VERTICAL;

    while (true) {
     // System.out.println("\n" + this);
      if (player == HORIZONTAL) {
        System.out.println("Horizontal to play");
        System.out.println("\n" + this);
      } else {

        //System.out.println("Computers turn to play");
      }
      if (!(hasLegalMoveFor(player))) {

        if(player == true)System.out.println("No legal moves -- computer loses!");
        else if(player == false)System.out.println("No legal moves -- You lose!");
      }

      //declear variable inputNotValid to check if the values entered are integers
      boolean inputNotValid;
      do{
		  inputNotValid = false;
		  try{
			  //***if else to check if computer and if it ist to generate a random number
			  if(player == false){
					System.out.print("Enter Row and Column ");
					int row = INPUT.nextInt();
					int column = INPUT.nextInt();
					playAt(row, column, player);
					player = !player;
			  }else if(player == true){
				  int row = ((int)((Math.random()*nr + 1)));
				  int column = ((int)((Math.random()*nc)+1));
				  playAt(row,column, player);
				  System.out.println("**Computer Played**");
				  player = !player;
			  }


		  }catch(java.util.InputMismatchException e){
			  if(player == false){
				  System.out.println("Bad data - try Again?");
				  INPUT.nextLine();
				  inputNotValid = true;
			  }

		  }catch(ArrayIndexOutOfBoundsException e){
			  if(player == false){
				    System.out.print("--------------------------------" +
					"\nDominoOffBoardException" +
					"\nPlease enter values on the board" +
					"\n---------------------------------\n");
					INPUT.nextLine();
			  		inputNotValid = true;
			  }

		  }catch(DominoOnTopOfDominoException e){
			  if(player == false){
					System.out.print("------------------------------------------" +
					"\nDominoOnTopOfDominoException" +
					"\nPlease enter domino that won't overlap another" +
					"\n-------------------------------------------\n");
					INPUT.nextLine();
					inputNotValid = true;
			  }

		  }
		}while(inputNotValid);
    }
  }

  //Play a domino with its upper left corner at row, column
  public void playAt(int row, int column, boolean player) throws DominoOnTopOfDominoException {

    if(player == HORIZONTAL) {
		if(squares[row][column] == true || squares[row][column + 1] == true){
			throw new DominoOnTopOfDominoException("DominoOnTopOfDominoException");
		}else{
			squares[row][column] = true;
			squares[row][column + 1] = true;
		}
    }else{
		if(squares[row][column] == true || squares[row + 1][column] == true){
			throw new DominoOnTopOfDominoException("DominoOnTopOfDominoException");
		}else{
			squares[row][column] = true;
			squares[row + 1][column] = true;
		}
    }
 }

  public String toString() {
	  //declare variable result
	  String result = " ";

    for(int x=0;x<nc;x++){
		result = result + " " + x;
	}
    for (int row = 0; row < nr; row++){
      result += "\n" + row;
      for (int column = 0; column < nc; column++) {
        if (squares[row][column]) {
          result += " #";
        } else {
          result += " .";
        }
      }
    }
    return result;
  }

  class DominoOnTopOfDominoException extends RuntimeException {
  	public DominoOnTopOfDominoException(String message){
  		super(message);
  	}
  }

  class BoardParametersOutOfBounds extends RuntimeException {
  	public BoardParametersOutOfBounds(String message){
  		super(message);
  	}
}

  //Create and play the game
  public static void main(String[] args) {
    System.out.println("Welcome to Domineering.\n*******************************************************");
    Domineering game = new Domineering();
    game.play();
  }

}