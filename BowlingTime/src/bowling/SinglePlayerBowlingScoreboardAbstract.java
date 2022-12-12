package bowling;

public abstract class SinglePlayerBowlingScoreboardAbstract implements SinglePlayerBowlingScoreboard
{
	protected static final int MAXIMUM_ROLLS = 21;	//Maximum rolls in a one player game
	protected String playerName;
	protected int[] pinsKnockedDownArray = new int[MAXIMUM_ROLLS];
	protected int rollCount = 0;
}
