public class RPSComputerPlayer extends Player {

	private int rock;
	private int paper;
	private int scissors;

	public RPSComputerPlayer(String name, int rock, int paper, int scissors) {
		super(name);
		this.rock = rock;
		this.paper = paper;
		this.scissors = scissors;
	}

	public String makeOneMove() {
		int temp = (int)((rock + paper + scissors) * Math.random());
		if(temp < rock) {
			return "rock";
		}
		else if(temp < rock + paper) {
			return "paper";
		}
		else {
			return "scissors";
		}
	}

}
