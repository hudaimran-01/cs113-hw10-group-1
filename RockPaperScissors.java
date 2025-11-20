public class RockPaperScissors extends RoundBasedGame {

	private int scoreToWin;
	private int player1Score;
	private int player2Score;

	public RockPaperScissors(Player player1, Player player2, int scoreToWin) {
		super(player1, player2);
		if(scoreToWin < 1) {
			throw new IllegalArgumentException("scoreToWin must be a positive integer.");
		}
		this.scoreToWin = scoreToWin;
		player1Score = 0;
		player2Score = 0;
	}

	private boolean isValidMove(String move) {
		if(move.equals("rock") || move.equals("paper") || move.equals("scissors")) {
			return true;
		}
		else {
			return false;
		}
	}

	private void printScores() {
		System.out.println(player1.getName() + "'s score: " + player1Score);
		System.out.println(player2.getName() + "'s score: " + player2Score);
	}

	private void printWinner() {
		if(player1Score >= scoreToWin) {
			System.out.println("*** " + player1.getName() + " wins! ***");
		}
		else {
			System.out.println("*** " + player2.getName() + " wins! ***");
		}
	}

	public void evaluateMoves(String move1, String move2) {
		System.out.println("moves: [" + move1 + ", " + move2 + "]");

		if(!isValidMove(move1)) {
			throw new IllegalArgumentException("Player 1's move was invalid.");
		}
		else if(!isValidMove(move2)) {
			throw new IllegalArgumentException("Player 2's move was invalid.");
		}
		else if((move1.equals("rock") && move2.equals("scissors")) || (move1.equals("scissors") && move2.equals("paper")) || (move1.equals("paper") && move2.equals("rock"))) {
			player1Score++;
		}
		else if(!move1.equals(move2)) {
			player2Score++;
		}
	}

	public void play() {
		System.out.println("=== Game Started ===\n");

		while(player1Score < scoreToWin && player2Score < scoreToWin) {
			System.out.println("* Round " + getCurrentRound() + " *");
			playOneRound();
			printScores();
			System.out.println();
		}

		printWinner();
		System.out.println();
		System.out.println("=== Game Finished ===");
	}

}
