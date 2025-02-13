package model;

public class Score {
	
	private int scoreForEmpty = 0;
	private int scoreForIncorrect = -1;
	private int scoreForCorrect = 1;
	
	public Score() {
		this(0,-1,1);
	}
	public Score(int scoreForEmpty, int scoreForIncorrect, int scoreForCorrect) {
		this.scoreForEmpty = scoreForEmpty;
		this.scoreForIncorrect = scoreForIncorrect;
		this.scoreForCorrect = scoreForCorrect;
	}
	public int getCorrectValue() {
		return this.scoreForCorrect;
	}
	public int getIncorrectValue() {
		return this.scoreForIncorrect;
	}
	public int getEmptyValue() {
		return this.scoreForEmpty;
	}
}
