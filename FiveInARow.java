public class FiveInARow extends TurnBasedGame {

   //extend board
	//2d array
	String[][] gameboard = new String [15][15];
	for(int i = 0; i < gameboard.length; i++) {
		for(int j = 0; j < gamebaord[0].length; j++) {
			gameboard[i][j] = " ";
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
      boolean flag0 = gameboard[0].equals(marker);
      boolean flag1 = gameboard[1].equals(marker);
      boolean flag2 = gameboard[2].equals(marker);
      boolean flag3 = gameboard[3].equals(marker);
      boolean flag4 = gameboard[4].equals(marker);
      boolean flag5 = gameboard[5].equals(marker);
      boolean flag6 = gameboard[6].equals(marker);
      boolean flag7 = gameboard[7].equals(marker);
      boolean flag8 = gameboard[8].equals(marker);

      if((flag0 && flag1 && flag2) || (flag3 && flag4 && flag5) || (flag6 && flag7 && flag8) ||
         (flag0 && flag3 && flag6) || (flag1 && flag4 && flag7) || (flag2 && flag5 && flag8) ||
         (flag0 && flag4 && flag8) || (flag2 && flag4 && flag6)) {
         return true;
      }
      else {
         return false;
      }
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
      System.out.println(gameboard[0] + "|" + gameboard[1] + "|" + gameboard[2]);
      System.out.println("-----");
      System.out.println(gameboard[3] + "|" + gameboard[4] + "|" + gameboard[5]);
      System.out.println("-----");
      System.out.println(gameboard[6] + "|" + gameboard[7] + "|" + gameboard[8]);
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

		if (foundcomma == false) {
			System.out.println("please input in format x,y");
		} else {
			//split string
			String[] position = move.split(",");
			int i = Integer.parseInt(position[0]);
			int j = Integer.parseInt(position[1]);
      	if(isFirstPlayerTurn()) {
         	if(!isValidPosition(i,j)) {
            	// throw new IllegalArgumentException("Player 1's move was invalid.");
            	this.evaluateMove(player1.makeOneMove());
         	} else {
            	gameboard[i][j] = "1";
         	}
      	} else {
			   if(!isValidPosition(i, j)) {
			      //throw new IllegalArgumentException("Player 2's move was invalid.");
					this.evaluateMove(player2.makeOneMove());

			   } else {
			      gameboard[i][j] = "0";
			   }
      	}
		}
   }

   public void play() {
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
