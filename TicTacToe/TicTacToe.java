//Name Blake Schollmeyer
//Username: bas76530
//700No: 700517653
//Assignment Number: a9
//Folder Name: TicTacToe
//Due:4/29/16

import java.util.Scanner;
public class TicTacToe {

      /**
      * @param args
      */
      public static final Scanner INPUT = new Scanner(System.in);
      private char[][] squares;
      public TicTacToe(){
            squares = new char[][] {{'.','.','.'},
                                                {'.','.','.'},
                                                {'.','.','.'}};
      }
      public String toString(){
            String result = "  012\n";
            for (int row = 0; row <3; row++){
                  result += row + " ";
                  for(int column = 0; column < 3; column++){
                        result +=  squares[row][column];
                  }
                  result += "\n";
            }
            return result;
      }

      public static void main(String[] args) {
            // TODO Auto-generated method stub
            TicTacToe game = new TicTacToe();
            System.out.println("Welcome to Tic Tac Toe.\n");
            int check = 0;
            while(check == 0 ){
	            System.out.println("Would you like to go first? (y/n): ");
	            String answer = INPUT.nextLine();
	            if(answer.equals("y".trim())){
	            	game.play(1);
	            	break;
	            }
	            else if(answer.equals("n".trim())){
	            	game.play(0);
	            	break;
	            }
	            System.out.println("Invalid answer. Try again.\n");

            }
            System.out.println(game);
            System.out.println("Game over.");

      }
      public boolean gameOver(){
            if (score() != 0){
                  return true;
            }
            for(int row = 0; row<3;row++){
                  for(int column=0; column<3;column++){
                        if(squares[row][column] == '.'){
                              return false;
                        }
                  }
            }
            return true;

      }
      public int score(){
            int lineScore;
            for(int i=0;i<3;i++){
                  lineScore = scoreLine(squares[i][0], squares[i][1], squares[i][2]);
                  if(lineScore != 0){
                        return lineScore;
                  }
                  lineScore = scoreLine(squares[0][i], squares[1][i], squares[2][i]);
                  if(lineScore != 0 ){
                        return lineScore;
                  }

            }
            lineScore = scoreLine(squares[0][0], squares[1][1], squares[2][2]);
                        if(lineScore != 0 ){
                              return lineScore;
                        }
            return scoreLine(squares[0][2], squares[1][1], squares[2][0]);
      }
      protected int scoreLine(char a, char b, char c){
            if((a == 'X') && (b == 'X') && (c == 'X')){return 1;}
            if((a == 'O') && (b == 'O') && (c == 'O')){return -1;}
                        return 0;
      }
      public void play(int first){
    	  char player;
    	  	if(first == 1){
    	  		player = 'O';
    	  	}
    	  	else{
    	  		player = 'X';
    	  	}

            for(int move = 0; move < 9; move++){
                  if(gameOver()){
                        return;
                  }
                  if(player == 'X'){
                        playBestMove();
                        player = 'O';

                  }
                  else{

                  int checkOverlap = 0;
                  int row = 5;
                  int column = 5;
                  System.out.println(this);
                	  while(checkOverlap == 0){

                        int check = 0;

                        while(check == 0){
                              System.out.print("Enter row: ");
                              try{
                            	  row = Integer.parseInt(INPUT.nextLine());
                            	  if ((row == 0) || (row == 1) || (row == 2)) {

                                      break;
                        	  		}
                              }

                              catch(Exception e){

                              }

                              System.out.println("Invalid row, try again.\n");

                        }
                        check = 0;
                        while(check == 0){
                              System.out.print("Enter column: ");
                              try{
                            	  column = Integer.parseInt(INPUT.nextLine());
                            	  if ((column == 0) || (column == 1) || (column == 2)) {

                                      break;
                        	  		}
                              }

                              catch(Exception e){

                              }
                              System.out.println("Invalid column, try again.\n");
                        }

                	  if(squares[row][column] == '.'){
                		  squares[row][column] = 'O';
                          player = 'X';
                          break;
                	  }
                	  else{
                		  System.out.println("You cannot overlap. Try again");
                	  }
                        }
                        }


            }
      }
      public void playBestMove(){
            int score;
            int bestScore = -2;
            int bestRow = -1;
            int bestColumn = -1;

            for(int row = 0; row < 3; row++){
                  for(int column = 0; column < 3; column++){
                        if(squares[row][column] == '.'){
                              squares[row][column] = 'X';
                              score = score();
                              if(score > bestScore){
                                    bestScore = score;
                                    bestRow = row;
                                    bestColumn = column;
                              }
                              squares[row][column] = '.';
                        }
                  }
            }
            squares[bestRow][bestColumn] = 'X';
      }
      protected int minimaxForO(){
            int score = score();
            if(gameOver()){
                  return score;
            }
            int bestScore = 2;
            for(int row = 0; row < 3; row++){
                  for(int column = 0; column < 3; column++){
                        if(squares[row][column] == '.'){
                              squares[row][column] = 'O';
                              score = minimaxForX();
                              if(score < bestScore){
                                    bestScore = score;
                              }
                              squares[row][column] = '.';
                        }
                  }
            }
            return bestScore;
      }
      protected int minimaxForX(){
            int score = score();
            if(gameOver()){
                  return score;
            }
            int bestScore = -2;
            for(int row = 0; row < 3; row++){
                  for(int column = 0; column < 3; column++){
                        if(squares[row][column] == '.'){
                              squares[row][column] = 'X';
                              score = minimaxForO();
                              if(score < bestScore){
                                    bestScore = score;
                              }
                              squares[row][column] = '.';
                        }
                  }
            }
            return bestScore;
      }
}