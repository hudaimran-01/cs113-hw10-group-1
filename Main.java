public class Main {

	public static void main(String[] args) {
		// For RockPaperScissors:
		// TextInputHumanPlayer player1 = new TextInputHumanPlayer("Bob");
		// RPSComputerPlayer player2 = new RPSComputerPlayer("cpu1", 5, 1, 1);
		// RockPaperScissors game = new RockPaperScissors(player1, player2, 3);
		// game.play();

		// For TicTacToe:
		TextInputHumanPlayer player1 = new TextInputHumanPlayer("Bob");
		TextInputHumanPlayer player2 = new TextInputHumanPlayer("Sally");
		TicTacToe game = new TicTacToe(player1, player2);
		game.play();
	}

}
