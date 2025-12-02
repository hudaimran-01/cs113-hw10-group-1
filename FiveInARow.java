public class FiveInARow extends TurnBasedGame {

   //extend board
	//2d array
	String[][] gameboard = new String [15][15];

	public void initialise() {
		for (int i = 0; i < gameboard.length; i++) {
			for (int j = 0; j < gameboard[0].length; j++) {
				gameboard[i][j] = " ";
			}
		}
	}


   public FiveInARow(Player player1, Player player2) {
      super(player1, player2);
   }

   private boolean isValidPosition(int i, int j) {
      if(i >= 0 && i <= 14 && j >= 0 && j <= 14 && gameboard[i][j].equals(" ")) {
         return true;
      }
      else {
         return false;
      }
   }

   private boolean hasFiveInARow(String marker) {
		//edit to 5
		//vertical
		for (int j = 0; j < 15; j++) {
			for (int i = 0; i <= 10; i++) {
				if (gameboard[i][j] == marker && gameboard[i+1][j] == marker && gameboard[i+2][j] == marker && gameboard[i+3][j] == marker && gameboard[i+4][j] == marker) {
					return true;
				}
			}
		}
		//horizontal
		for (int i = 0; i < 15; i++) {
			for(int j = 0; j <= 10; j++) {
				if (gameboard[i][j] == marker && gameboard[i][j+1] == marker && gameboard [i][j+2] == marker && gameboard[i][j+3] == marker && gameboard[i][j+4] == marker) {
					return true;
				}
			}
		}
		//diagonal down
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				if (gameboard[i][j] == marker && gameboard[i+1][j+1] == marker && gameboard[i+2][j+2] == marker && gameboard[i+3][j+3] == marker && gameboard[i+4][j+4] == marker) {
					return true;
				}
			}
		}
		//diagonal up
		for (int i = 0; i <= 10; i++) {
			for (int j = 14; j >= 4; j--) {
				if (gameboard[i][j] == marker && gameboard[i+1][j-1] == marker && gameboard[i+2][j-2] == marker && gameboard[i+3][j-3] == marker && gameboard[i+4][j-4] == marker) {
					return true;
				}
			}
		}
		return false;
   }

   private boolean gameboardIsFull() {
		//same
      for (int i = 0; i <= 14; i ++) {
			for (int j = 0; j <= 14; j++) {
         	if(gameboard[i][j].equals(" ")) {
            	return false;
				}
         }
      }
      return true;
   }

   private void printGameboard() {
		//extend grid
		//for loop
		System.out.println("   |00|01|02|03|04|05|06|07|08|09|10|11|12|13|14|");
		for (int j = 0; j < 15; j++) {
			if (j >= 10) {
				System.out.print(j + " |");
			} else {
				System.out.print("0" + j + " |");
			}
			for (int i = 0; i < 15; i ++) {
				System.out.print(gameboard[i][j] + " |");
			}
			System.out.println();
			System.out.println("   ----------------------------------------------");
		}
   }

   private void printWinner() {
      if(hasFiveInARow("1")) {
         System.out.println("*** " + player1.getName() + " wins! ***");
      }
      else if(hasFiveInARow("0")) {
         System.out.println("*** " + player2.getName() + " wins! ***");
      }
      else {
         System.out.println("*** " + player1.getName() + " and " + player2.getName() + " tie! ***");
      }
   }

	public boolean isNum(String input) {
		for(int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(input.charAt(i))) {
				return false;
			}
		}
		return true;
	}

   protected void evaluateMove(String move) {
		//edit for two inputs
		//check string format
		//locate comma & position
		boolean foundcomma = false;
		int i = 0;
		while(i < move.length() && foundcomma == false) {
			if (move.charAt(i) == ',') {
				foundcomma = true;
			}
			i++;
		}
		//wrong format
		if (foundcomma == false) {
			System.out.println("please input in format x,y");
			System.out.println("* " + getCurrentPlayerName() + "'s Turn *");
         playOneTurn();
			finishCurrentTurn();
		} else {
			//split string
			String[] position = move.split(",");
			//not int
			if (!isNum(position[0]) || !isNum(position[1])) {
				System.out.println("please input integers in format x,y");
				System.out.println("* " + getCurrentPlayerName() + "'s Turn *");
				playOneTurn();
				finishCurrentTurn();
			} else {
				int m = Integer.parseInt(position[0]);
				int n = Integer.parseInt(position[1]);
		   	if(isFirstPlayerTurn()) {
		      	if(!isValidPosition(m,n)) {
		         	// throw new IllegalArgumentException("Player 1's move was invalid.");
		         	this.evaluateMove(player1.makeOneMove());
		      	} else {
		         	gameboard[m][n] = "1";
		      	}
		   	} else {
				   if(!isValidPosition(m, n)) {
				      //throw new IllegalArgumentException("Player 2's move was invalid.");
						this.evaluateMove(player2.makeOneMove());

				   } else {
				      gameboard[m][n] = "0";
				   }
		   	}
			}
		}
   }

   public void play() {
		initialise();
		//same
      System.out.println("=== Game Started ===\n");
      System.out.println("Numbers 0 through 14 are valid inputs\n");
		System.out.println("input coordinates in format x,y");
      printGameboard();
      System.out.println();

      while(!hasFiveInARow("1") && !hasFiveInARow("0") && !gameboardIsFull()) {
         System.out.println("* " + getCurrentPlayerName() + "'s Turn *");
         playOneTurn();
         System.out.println();
         printGameboard();
         System.out.println();
      }

      printWinner();
      System.out.println();
      System.out.println("=== Game Finished ===");
   }
}
