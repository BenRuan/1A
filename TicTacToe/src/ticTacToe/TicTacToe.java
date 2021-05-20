package ticTacToe;

/**
 * 
 * @author 
 *
 */

public class TicTacToe {
	
	    private String[][] board;
	    private int turn;
	    
	    /**
	     * Creates a new Tic Tac Toe board.  Instantiates the 3x3 board
	     * with all dashes or other place holders.
	     * 
	     * initializes number of turns taken to equal 0
	     */
	    
	    public TicTacToe() {
	    	this.turn = 0;
	        this.board = new String[3][3];
	        for(int row = 0; row < board.length; row++){
	            for(int col = 0; col < board[row].length; col++){
	                board[row][col] = "-";
	            }
	        }
	    }
	    
	    
	   
	    /**
	     * Getter method for current turn number
	     * @return number of turns taken
	     */
	    
	    public int getTurn() {
	    	return turn;
	    }
	    
	    
	    
	   
	   /**
	    * This method prints out the board array on to the console
	    */
	    
	   public void printBoard()
	   {
		   System.out.println("  0 1 2");
	       for(int row = 0; row < board.length; row++){
	           System.out.print(row + " ");
	           for(int col = 0; col < board[row].length; col++){
	               System.out.print(board[row][col] + " ");
	           }
	           System.out.println();
	       }
	   }
	   
	   /**
	    * 
	    * This method determines if space row, col is an available space to choose
	    * @return: true if the board[row][col] is available, false otherwise
	    * 
	    */
	   
	   public boolean pickLocation(int row, int col)
	   {
		   return(row < 3 && row > -1 && col < 3 && col > -1 && board[row][col].equals("-"));
	   }
	   
	   /**
	    * 
	    * This method places an X or O at board[row][col] based on the int turn
	    */
	   
	   public void takeTurn(int row, int col)
	   {
		   if(turn % 2 == 0){
	           board[row][col] = "X";
	       }
	       else{
	           board[row][col] = "O";
	       }
	       turn++;
	   }
	   
	   /**
	    * 
	    * This method checks if any row has all X's or all Os
	    * @return: true if there is a row with all the same value, false otherwise. 
	    */
	   
	   
	   public boolean checkRow()
	   {
		   int countO = 0;
	       int countX = 0;
	       for(int row = 0; row < board.length; row++){
	           for(int col = 0; col < board[row].length; col++){
	                if(board[row][col].equals("O")){
	                    countO++;
	                }
	                else if(board[row][col].equals("X")){
	                    countX++;
	                }
	           }
	           if(countO == 3 || countX == 3){
	               return true;
	           }
	           countO = 0;
	           countX = 0;
	       }
	       return false;
	   }
	   
	   
	   /**
	    * 
	    * This method checks if any col has all X's or all Os
	    * @return: true if there is a col with all the same value, false otherwise. 
	    */
	   
	   public boolean checkCol()
	   {
		   int countO = 0;
	       int countX = 0;
	       for(int row = 0; row < board.length; row++){
	           for(int col = 0; col < board[row].length; col++){
	                if(board[col][row].equals("O")){
	                    countO++;
	                }
	                else if(board[col][row].equals("X")){
	                    countX++;
	                }
	           }
	           if(countO == 3 || countX == 3){
	               return true;
	           }
	           countO = 0;
	           countX = 0;
	       }
	       return false;
	   }
	   
	   
	   /**
	    * 
	    * This method checks if either diagonal has all X's or all Os
	    * @return: true if either diagonal with all the same value, false otherwise. 
	    */
	   
	   public boolean checkDiag()
	   {
		   int countO = 0;
	       int countX = 0;
	       int countO2 = 0;
	       int countX2 = 0;
	       for(int i = 0; i < board.length; i++){
	           if(board[i][i].equals("X")){
	               countX++;
	           }
	           else if(board[i][i].equals("O")){
	               countO++;
	           }
	           
	           if(board[i][2-i].equals("X")){
	               countX2++;
	           }
	           else if(board[i][2-i].equals("O")){
	               countO2++;
	           }
	       }
	       if(countO == 3 || countX == 3 || countO2 == 3 || countX2 == 3){
	           return true;
	       }
	       else{
	           return false;
	       }
	   }
	   
	   /**
	    * 
	    * This method checks if a player has won the game via a row, col, or diagonal
	    * @return: true if the game is won, false otherwise
	    */
	   public boolean checkWin()
	   {
		   return(checkCol() || checkRow() || checkDiag());
	   }

}
