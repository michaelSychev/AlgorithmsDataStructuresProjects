package bowling;

/**
 * @author kart
 * NOTE: You can "strip this skeleton for parts"
 * Don't assume that all of the preconditions are included
 * Be sure to check this code for correctness
 */
public class SinglePlayerBowlingScoreboardImpl_Sychev extends SinglePlayerBowlingScoreboardAbstract implements AssignmentMetaData
{
	//INTERNAL REPRESENTATION
//	protected static final int MAXIMUM_ROLLS = 21;	//Maximum rolls in a one player game
//	protected String playerName;
//	protected int[] pinsKnockedDownArray = new int[MAXIMUM_ROLLS];
//	protected int rollCount = 0;
	public SinglePlayerBowlingScoreboardImpl_Sychev(String playerName)
	{
		assert playerName != null : "playerName is null!";
		this.playerName = playerName;
	}

	public String getPlayerName()
	{
		return playerName;
	}
	//pre:
		//isGameOver==false,
		//first frame is completed
	public int getCurrentFrame()
	{
		final int STRIKE = 10;
		assert isGameOver() : "Game is over!";
		int rv = 0;//1 is starting value
		//iterate through pdka from 0 to roll count
			//if the current roll is less than 10 we increment by one,
		int currIndex = 0;
		while(currIndex<=rollCount)
		{
			if(pinsKnockedDownArray[currIndex] != STRIKE )//our first roll is not a strike
			{
				currIndex +=2;//no strike so we increment our pointer by 2 and add one to the frame
				rv+=1;
			}
			else //otherwise there is strike
			{
				//if strike we increment pointer by one and add 1 to rv;
				rv++;
				currIndex++;
				throw new RuntimeException("Else clause not tested");
			}
		}

		return rv;
	}

	public Mark getMark(int frameNumber, int boxIndex)
	{
		assert 1 <= frameNumber : "frameNumber = " + frameNumber + " < 1!";
		assert frameNumber <= 10 : "frameNumber = " + frameNumber + " > 10!";
		assert 1 <= boxIndex : "boxIndex = " + boxIndex + " < 1!";
		assert boxIndex <= 3 : "boxIndex = " + boxIndex + " > 3!";
//		Exercise for student: Fix
		assert (boxIndex != 2) || (!isStrike(frameNumber) && !isSpare(frameNumber)) : "boxIndex = " + boxIndex + ", but there was a Strike! : frameNumber = " + frameNumber;
		assert (boxIndex != 2) || (!isSpare(frameNumber)) : "boxIndex = " + boxIndex + ", but there was a Spare! : frameNumber = " + frameNumber;
		Mark mark = null;
		if(frameNumber < 10) mark = getMarkSingleDigitFrameNumber(frameNumber, boxIndex);
		else mark = getMarkTenthFrame(boxIndex);
		assert mark != null : "mark is null!";



		int requestedPosition = (frameNumber*2) - 2 + boxIndex-1;
		Mark rv = Mark.translate(pinsKnockedDownArray[requestedPosition]);

		return rv;
	}

	private Mark getMarkSingleDigitFrameNumber(int frameNumber, int boxIndex)
	{
		assert 1 <= frameNumber : "frameNumber = " + frameNumber + " < 1!";
		assert frameNumber <= 9 : "frameNumber = " + frameNumber + " > 9!";
		assert 1 <= boxIndex : "boxIndex = " + boxIndex + " < 1!";
		assert boxIndex <= 2 : "boxIndex = " + boxIndex + " > 2!";
		int requestedPosition = (frameNumber*2) - 2 + boxIndex;
		Mark rv = Mark.translate(pinsKnockedDownArray[requestedPosition]);
		return rv;
	}



	public int getScore(int frameNumber)
	{
		assert 1 <= frameNumber : "frameNumber = " + frameNumber + " < 1!";
		assert frameNumber <= 10 : "frameNumber = " + frameNumber + " > 10!";
		assert getCurrentFrame()>=frameNumber;
 		int rv = 0;
		for(int i =0;i<(frameNumber*2);i++)
		{
			rv += pinsKnockedDownArray[i];
		}
		System.out.println("GetScore OVER MUST BE PATCHED");
		return rv;

	}
	private Mark getMarkTenthFrame(int boxIndex)
	{
		assert 1 <= boxIndex : "boxIndex = " + boxIndex + " < 1!";
		assert boxIndex <= 3 : "boxIndex = " + boxIndex + " > 3!";

		throw new RuntimeException("NOT IMPLEMENTED!");
	}

	public boolean isGameOver()
	{
		System.out.println("IS GAME OVER MUST BE PATCHED");
		return false;
	}

	public void recordRoll(int pinsKnockedDown)
	{
		assert 0 <= pinsKnockedDown : "pinsKnockedDown = " + pinsKnockedDown + " < 0!";
		assert pinsKnockedDown <= 10 : "pinsKnockedDown = " + pinsKnockedDown + " > 10!";
		assert (getCurrentBall() == 1) ||
				((getCurrentBall() == 2) && (((getCurrentFrame() == 10) && isStrikeOrSpare(getMark(10, 1))) || ((pinsKnockedDownArray[rollCount - 1] + pinsKnockedDown) <= 10))) ||
				((getCurrentBall() == 3) && (((getCurrentFrame() == 10) && isStrikeOrSpare(getMark(10, 2))) || ((pinsKnockedDownArray[rollCount - 1] + pinsKnockedDown) <= 10)));
		assert !isGameOver() : "Game is over!";
		pinsKnockedDownArray[rollCount] = pinsKnockedDown;//send knocked down pins amount to array
		rollCount++;//increment pointer
	}
	//pre:game is not over
	//post:returns what roll attempt is happening(1-3)
	//N
	public int getCurrentBall()
	{
		//assert isGameOver() != false:"bruv";
		System.out.println("MUST BE PATCHED for getcurrentBall");
		int rv =0;
		if(rollCount%2 ==0)//even indices mean first attempt
		{
			rv =1;
		}
		else //odd atempts happen after first roll attempt of a given frame with no strikes or spare
		{
			rv = 2;
		}
		return rv;
	}

	private static final String VERTICAL_SEPARATOR = "#";
	private static final String HORIZONTAL_SEPARATOR = "#";
	private static final String LEFT_EDGE_OF_SMALL_SQUARE = "[";
	private static final String RIGHT_EDGE_OF_SMALL_SQUARE = "]";
	public String getScoreboardDisplay()
	{
		StringBuffer frameNumberLineBuffer = new StringBuffer();
		StringBuffer markLineBuffer = new StringBuffer();
		StringBuffer horizontalRuleBuffer = new StringBuffer();
		StringBuffer scoreLineBuffer = new StringBuffer();
		frameNumberLineBuffer.append(VERTICAL_SEPARATOR);

		markLineBuffer.append(VERTICAL_SEPARATOR);
		horizontalRuleBuffer.append(VERTICAL_SEPARATOR);
		scoreLineBuffer.append(VERTICAL_SEPARATOR);

		for(int frameNumber = 1; frameNumber < 10; frameNumber++)
		{
			frameNumberLineBuffer.append("  " + frameNumber + "  ");

			int currentFrame = getCurrentFrame();
			int currentBall = getCurrentBall();
			boolean canAskAboutBox1 = (frameNumber < currentFrame) || ((frameNumber == currentFrame) && (1 < currentBall));
			boolean canAskAboutBox2 = (frameNumber < currentFrame) || ((frameNumber == currentFrame) && (2 < currentBall));	//Note that (2 < currentBall) must be false
			Mark markInBox1 = (canAskAboutBox1 ? getMark(frameNumber, 1) : Mark.EMPTY);
			Mark markInBox2 = (canAskAboutBox2 ? getMark(frameNumber, 2) : Mark.EMPTY);

			markLineBuffer.append(" ");
			markLineBuffer.append(markInBox1);
			markLineBuffer.append(LEFT_EDGE_OF_SMALL_SQUARE);
			markLineBuffer.append(markInBox2);
			markLineBuffer.append(RIGHT_EDGE_OF_SMALL_SQUARE);

			final int CHARACTER_WIDTH_SCORE_AREA = 5;
			for(int i = 0; i < CHARACTER_WIDTH_SCORE_AREA; i++) horizontalRuleBuffer.append(HORIZONTAL_SEPARATOR);
			if(isGameOver() || frameNumber < getCurrentFrame())
			{
				int score = getScore(frameNumber);
				final int PADDING_NEEDED_BEHIND_SCORE = 1;
				final int PADDING_NEEDED_IN_FRONT_OF_SCORE = CHARACTER_WIDTH_SCORE_AREA - ("" + score).length() - PADDING_NEEDED_BEHIND_SCORE;
				for(int i = 0; i < PADDING_NEEDED_IN_FRONT_OF_SCORE; i++) scoreLineBuffer.append(" ");
				scoreLineBuffer.append(score);
				for(int i = 0; i < PADDING_NEEDED_BEHIND_SCORE; i++) scoreLineBuffer.append(" ");
			}
			else
			{
				for(int i = 0; i < CHARACTER_WIDTH_SCORE_AREA; i++) scoreLineBuffer.append(" ");
			}

			frameNumberLineBuffer.append(VERTICAL_SEPARATOR);
			markLineBuffer.append(VERTICAL_SEPARATOR);
			horizontalRuleBuffer.append(VERTICAL_SEPARATOR);
			scoreLineBuffer.append(VERTICAL_SEPARATOR);
		}
		//Frame 10:
		{
			final String THREE_SPACES = "   ";
			frameNumberLineBuffer.append(THREE_SPACES + 10 + THREE_SPACES);

			int currentFrame = getCurrentFrame();
			int currentBall = getCurrentBall();
			boolean canAskAboutBox1 = (10 < currentFrame) || ((10 == currentFrame) && (1 < currentBall));
			boolean canAskAboutBox2 = (10 < currentFrame) || ((10 == currentFrame) && (2 < currentBall));
			boolean canAskAboutBox3 = (10 < currentFrame) || ((10 == currentFrame) && (3 < currentBall));	//Note that (3 < currentBall) must be false
			Mark markInBox1 = (canAskAboutBox1 ? getMark(10, 1) : Mark.EMPTY);
			Mark markInBox2 = (canAskAboutBox2 ? getMark(10, 2) : Mark.EMPTY);
			Mark markInBox3 = (canAskAboutBox3 ? getMark(10, 3) : Mark.EMPTY);

			markLineBuffer.append(" ");
			markLineBuffer.append(markInBox1);
			markLineBuffer.append(LEFT_EDGE_OF_SMALL_SQUARE);
			markLineBuffer.append(markInBox2);
			markLineBuffer.append(RIGHT_EDGE_OF_SMALL_SQUARE);
			markLineBuffer.append(LEFT_EDGE_OF_SMALL_SQUARE);
			markLineBuffer.append(markInBox3);
			markLineBuffer.append(RIGHT_EDGE_OF_SMALL_SQUARE);

			final int CHARACTER_WIDTH_SCORE_AREA = 8;
			for(int i = 0; i < CHARACTER_WIDTH_SCORE_AREA; i++) horizontalRuleBuffer.append(HORIZONTAL_SEPARATOR);
			if(isGameOver())
			{
				int score = getScore(10);
				final int PADDING_NEEDED_BEHIND_SCORE = 1;
				final int PADDING_NEEDED_IN_FRONT_OF_SCORE = CHARACTER_WIDTH_SCORE_AREA - ("" + score).length() - PADDING_NEEDED_BEHIND_SCORE;
				for(int i = 0; i < PADDING_NEEDED_IN_FRONT_OF_SCORE; i++) scoreLineBuffer.append(" ");
				scoreLineBuffer.append(score);
				for(int i = 0; i < PADDING_NEEDED_BEHIND_SCORE; i++) scoreLineBuffer.append(" ");
			}
			else
			{
				for(int i = 0; i < CHARACTER_WIDTH_SCORE_AREA; i++) scoreLineBuffer.append(" ");
			}

			frameNumberLineBuffer.append(VERTICAL_SEPARATOR);
			markLineBuffer.append(VERTICAL_SEPARATOR);
			horizontalRuleBuffer.append(VERTICAL_SEPARATOR);
			scoreLineBuffer.append(VERTICAL_SEPARATOR);
		}

		return 	getPlayerName() + "\n" +
				horizontalRuleBuffer.toString() + "\n" +
				frameNumberLineBuffer.toString() + "\n" +
				horizontalRuleBuffer.toString() + "\n" +
				markLineBuffer.toString() + "\n" +
				scoreLineBuffer.toString() + "\n" +
				horizontalRuleBuffer.toString();
	}

//SUGGESTED HELPER METHODS
//	public String toString()
//	{
//		return getScoreboardDisplay();
//	}
//
//	private int getRollIndexOfFirstBall(int frameNumber)
//	{
//		throw new RuntimeException("NOT IMPLEMENTED!");
//	}
//
private boolean isStrike(int frameNumber)
{
	int requestedPosition = (frameNumber*2) - 2;
	boolean rv = false;
	if(pinsKnockedDownArray[requestedPosition] == 10)
	{
		rv = true;
	}
	return rv;
}
	//
	private boolean isSpare(int frameNumber)
	{
		int requestedPosition = (frameNumber*2) - 2;
		int pinsSum = 0;
		boolean rv = false;
		pinsSum += pinsKnockedDownArray[requestedPosition]+ pinsKnockedDownArray[requestedPosition+1];
		return rv;
	}


	private boolean isStrikeOrSpare(Mark mark)
	{
		return ((mark == Mark.STRIKE) || (mark == Mark.SPARE));
	}

	//*************************************************
	//*************************************************
	//*************************************************
	//*********ASSIGNMENT METADATA STUFF***************
	public String getFirstNameOfSubmitter()
	{
		final String MY_FIRST_NAME  = "Michael";
		return MY_FIRST_NAME;
	}

	public String getLastNameOfSubmitter()
	{
		final String MY_LAST_NAME  = "SYCHEV";
		return MY_LAST_NAME;
	}

	public double getHoursSpentWorkingOnThisAssignment()
	{
		return 3;
	}

	public int getScoreAgainstTestCasesSubset()
	{
		return 87;
	}

	public static void main(String[] args)
	{
		SinglePlayerBowlingScoreboardImpl_Sychev b = new SinglePlayerBowlingScoreboardImpl_Sychev("michaael");
		b.toString();
		System.out.println("IMPLEMENT SPARES AND STRIKES AFTER 11/10/22");

	}
}