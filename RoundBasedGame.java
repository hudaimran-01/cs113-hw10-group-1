abstract public class RoundBasedGame extends TwoPlayerGame {

	private int currentRound;

	public RoundBasedGame(Player player1, Player player2) {
		super(player1, player2);
		currentRound = 0;
	}

	public int getCurrentRound() {
		return currentRound;
	}

	private void finishCurrentRound() {
		currentRound++;
	}

	protected void playOneRound() {
		String move1 = player1.makeOneMove();
		String move2 = player2.makeOneMove();
		this.evaluateMoves(move1, move2);
		this.finishCurrentRound();
	}

	abstract protected void evaluateMoves(String move1, String move2);

}
