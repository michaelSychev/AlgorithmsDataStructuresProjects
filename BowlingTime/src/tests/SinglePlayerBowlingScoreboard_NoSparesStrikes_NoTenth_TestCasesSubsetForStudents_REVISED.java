package tests;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.junit.Assert.assertEquals;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.Before;
import org.junit.Test;

import bowling.AssignmentMetaData;
import bowling.Mark;
import bowling.SinglePlayerBowlingScoreboard;
import bowling.SinglePlayerBowlingScoreboardImpl_Sychev;

/**
 * @author kart
 *
 */
public class SinglePlayerBowlingScoreboard_NoSparesStrikes_NoTenth_TestCasesSubsetForStudents_REVISED {
	public static final String PACKAGE_NAME = "bowling";
	public static final String PREFIX = "SinglePlayerBowlingScoreboard";
	public static final String SUFFIX = "";
	protected static SinglePlayerBowlingScoreboard singlePlayerBowlingScoreboard_STUDENT;
	protected static AssignmentMetaData assignmentMetaData_STUDENT;
	protected static final String BOWLER_NAME = "Big Lebowski";
	protected static String TEST_GOAL_MESSAGE;
	
	@Retention(value=RUNTIME)
	@Target(value=METHOD)
	public @interface Points {
		int value();
	}
	
	@Before
	public void initBeforeEachTestMethod()
	{
		singlePlayerBowlingScoreboard_STUDENT = new SinglePlayerBowlingScoreboardImpl_Sychev(BOWLER_NAME);
		assignmentMetaData_STUDENT = (AssignmentMetaData)singlePlayerBowlingScoreboard_STUDENT;
	}
	
	@Points(value=0)
	@Test(expected=AssertionError.class)
	public void assertionsEnabledTest()
	{
		TEST_GOAL_MESSAGE = "Check whether assertions are enabled";
		assert false;
		throw new RuntimeException("ENABLE ASSERTIONS IN RUN CONFIGURATIONS!");
	}
	@Test
	public void testGetCF1Roll()
	{


		int[] pinsKnockedDownArray3 = new int[]{0};
		recordPins(singlePlayerBowlingScoreboard_STUDENT, pinsKnockedDownArray3);

		assertEquals(1,singlePlayerBowlingScoreboard_STUDENT.getCurrentFrame());

	}
	@Points(value=0)
	@Test(timeout=3000)
	public void hoursWorkedAndTestCasesScoreTest()
	{
		TEST_GOAL_MESSAGE = "Implement all methods in AssignmentMetaData";
		System.out.println("Hours Worked: " + assignmentMetaData_STUDENT.getHoursSpentWorkingOnThisAssignment());
		System.out.println("Score on TestCases_Subset: " + assignmentMetaData_STUDENT.getScoreAgainstTestCasesSubset());
	}
	
	@Points(value=5)
	@Test(timeout=3000)
	public void playerNameTest() {
		TEST_GOAL_MESSAGE = "Get getPlayerName() correct";
		assertEquals(BOWLER_NAME, singlePlayerBowlingScoreboard_STUDENT.getPlayerName());
		System.out.println("playerNameTest:\n" + singlePlayerBowlingScoreboard_STUDENT);
	}
	
	@Points(value=5)
	@Test(expected=AssertionError.class, timeout=3000)
	public void tooManyPinsTest() {
		TEST_GOAL_MESSAGE = "Throw AssertionError when too many pins are sent to recordRoll()";
		int[] pinsKnockedDownArray = new int[]{19};
		recordPins(singlePlayerBowlingScoreboard_STUDENT, pinsKnockedDownArray);
	}
	
	@Points(value=5)
	@Test(expected=AssertionError.class, timeout=3000)
	public void tooManyPinsTest2() {
		TEST_GOAL_MESSAGE = "Throw AssertionError when too many pins are sent to recordRoll()";
		int[] pinsKnockedDownArray = new int[]{7, 7};
		recordPins(singlePlayerBowlingScoreboard_STUDENT, pinsKnockedDownArray);
	}
	
	@Points(value=5)
	@Test(timeout=3000)
	public void noRollsCurrentFrameCurrentBallTest() {
		TEST_GOAL_MESSAGE = "getCurrentFrame() and getCurrentBall both return 1 for empty scoreboard";
		int[] pinsKnockedDownArray = new int[]{};
		recordPins(singlePlayerBowlingScoreboard_STUDENT, pinsKnockedDownArray);		
		assertEquals(1, singlePlayerBowlingScoreboard_STUDENT.getCurrentFrame());
		assertEquals(1, singlePlayerBowlingScoreboard_STUDENT.getCurrentBall());
	}
	
	@Points(value=5)
	@Test(timeout=3000)
	public void twoGutterBallMarkTest_OnlyNineFrames()
	{
		TEST_GOAL_MESSAGE = "Handle gutter balls correctly for first nine frames";
		int[] pinsKnockedDownArray = new int[]{0, 0};
		recordPins(singlePlayerBowlingScoreboard_STUDENT, pinsKnockedDownArray);
		assertEquals(Mark.ZERO, singlePlayerBowlingScoreboard_STUDENT.getMark(1, 1));
		assertEquals(Mark.ZERO, singlePlayerBowlingScoreboard_STUDENT.getMark(1, 2));
	}
	
	@Points(value=5)
	@Test(timeout=3000)
	public void twoGutterBallScoreTest()
	{
		TEST_GOAL_MESSAGE = "Handle getScore(1) correctly for two gutter ball first frame";
		int[] pinsKnockedDownArray = new int[]{0, 0};
		recordPins(singlePlayerBowlingScoreboard_STUDENT, pinsKnockedDownArray);
		assertEquals(0, singlePlayerBowlingScoreboard_STUDENT.getScore(1));
	}
	
	@Points(value=5)
	@Test(timeout=3000)
	public void twoRollsMarkTest()
	{
		TEST_GOAL_MESSAGE = "Handle getMark(1,1) and getMark(1,2) correctly for simple first frame";
		int[] pinsKnockedDownArray = new int[]{7, 2};
		recordPins(singlePlayerBowlingScoreboard_STUDENT, pinsKnockedDownArray);

		assertEquals(Mark.SEVEN, singlePlayerBowlingScoreboard_STUDENT.getMark(1, 1));
		assertEquals(Mark.TWO, singlePlayerBowlingScoreboard_STUDENT.getMark(1, 2));	
	}
	
	@Points(value=5)
	@Test(timeout=3000)
	public void twoRollsMark2Test()
	{
		TEST_GOAL_MESSAGE = "Handle getMark(1,1) and getMark(1,2) correctly for simple first frame";
		int[] pinsKnockedDownArray = new int[]{3, 4};
		recordPins(singlePlayerBowlingScoreboard_STUDENT, pinsKnockedDownArray);

		assertEquals(Mark.THREE, singlePlayerBowlingScoreboard_STUDENT.getMark(1, 1));
		assertEquals(Mark.FOUR, singlePlayerBowlingScoreboard_STUDENT.getMark(1, 2));
	}

	@Points(value=5)
	@Test(timeout=3000)
	public void twoRollsScoreTest()
	{
		TEST_GOAL_MESSAGE = "Handle getScore(1) correctly for simple first frame";
		int[] pinsKnockedDownArray = new int[]{3, 4};
		recordPins(singlePlayerBowlingScoreboard_STUDENT, pinsKnockedDownArray);

		assertEquals(sum(pinsKnockedDownArray, 0, pinsKnockedDownArray.length), singlePlayerBowlingScoreboard_STUDENT.getScore(1));
	}

	@Points(value=5)
	@Test(timeout=3000)
	public void fourRollsMarkTest()
	{
		TEST_GOAL_MESSAGE = "Handle getMark(f,1) and getMark(f,2) correctly for two simple frames";
		int[] pinsKnockedDownArray = new int[]{2, 0, 4, 5};
		recordPins(singlePlayerBowlingScoreboard_STUDENT, pinsKnockedDownArray);

		assertEquals(Mark.TWO, singlePlayerBowlingScoreboard_STUDENT.getMark(1, 1));
		assertEquals(Mark.ZERO, singlePlayerBowlingScoreboard_STUDENT.getMark(1, 2));

		assertEquals(Mark.FOUR, singlePlayerBowlingScoreboard_STUDENT.getMark(2, 1));
		assertEquals(Mark.FIVE, singlePlayerBowlingScoreboard_STUDENT.getMark(2, 2));
	}

	@Points(value=5)
	@Test(timeout=3000)
	public void fourThreesScoreTest()
	{
		TEST_GOAL_MESSAGE = "Handle getScore(f) correctly for two simple frames";
		int[] pinsKnockedDownArray = new int[]{3, 3, 3, 3};
		recordPins(singlePlayerBowlingScoreboard_STUDENT, pinsKnockedDownArray);
		
		for(int frameNumber = 1; frameNumber <= 2; frameNumber++)
		{
			assertEquals(sum(pinsKnockedDownArray, 0, 2*frameNumber), singlePlayerBowlingScoreboard_STUDENT.getScore(frameNumber));
		}
	}

	@Points(value=5)
	@Test(timeout=3000)
	public void fiveRollsScoreTest()
	{
		TEST_GOAL_MESSAGE = "Handle getScore(f) correctly for two simple frames";
		int[] pinsKnockedDownArray = new int[]{2, 3, 4, 5, 6};
		recordPins(singlePlayerBowlingScoreboard_STUDENT, pinsKnockedDownArray);
		
		for(int frameNumber = 1; frameNumber <= 2; frameNumber++)
		{
			assertEquals(sum(pinsKnockedDownArray, 0, 2*frameNumber), singlePlayerBowlingScoreboard_STUDENT.getScore(frameNumber));
		}
	}

	@Points(value=5)
	@Test(timeout=3000)
	public void noSparesOrStrikesNineFrame_CurrentFrameCurrentBallTest()
	{
		TEST_GOAL_MESSAGE = "Handle getCurrentBall() correctly for nine simple frames";
		int[] pinsKnockedDownArray = new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};

		for(int frameNumber = 1; frameNumber <= 9; frameNumber++)
		{
			assertEquals(frameNumber, singlePlayerBowlingScoreboard_STUDENT.getCurrentFrame());
			assertEquals(1, singlePlayerBowlingScoreboard_STUDENT.getCurrentBall());
			
			int firstRollInFrame = pinsKnockedDownArray[2*(frameNumber - 1)];
			assert firstRollInFrame < 10 : "firstRollInFrame = " + firstRollInFrame + " <> 10!";

			singlePlayerBowlingScoreboard_STUDENT.recordRoll(firstRollInFrame);

			assertEquals(frameNumber, singlePlayerBowlingScoreboard_STUDENT.getCurrentFrame());
			assertEquals(2, singlePlayerBowlingScoreboard_STUDENT.getCurrentBall());
			
			int secondRollInFrame = pinsKnockedDownArray[2*(frameNumber - 1) + 1];
			assert secondRollInFrame < 10 : "secondRollInFrame = " + secondRollInFrame + " <> 10!";
			singlePlayerBowlingScoreboard_STUDENT.recordRoll(secondRollInFrame);

			assertEquals(frameNumber + 1, singlePlayerBowlingScoreboard_STUDENT.getCurrentFrame());
			assertEquals(1, singlePlayerBowlingScoreboard_STUDENT.getCurrentBall());
		}
	}

	@Points(value=5)
	@Test(timeout=30000000)
	public void noSparesOrStrikesNineFrame_MarkTest()
	{
		TEST_GOAL_MESSAGE = "Handle getMark(f,1), getMark(f,2) correctly for nine simple frames";
		int[] pinsKnockedDownArray = new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};

		for(int frameNumber = 1; frameNumber <= 9; frameNumber++)
		{
			int firstRollInFrame = pinsKnockedDownArray[2*(frameNumber - 1)];
			assert firstRollInFrame < 10 : "firstRollInFrame = " + firstRollInFrame + " <> 10!";
			
			singlePlayerBowlingScoreboard_STUDENT.recordRoll(firstRollInFrame);
			
			assertEquals(Mark.translate(firstRollInFrame), singlePlayerBowlingScoreboard_STUDENT.getMark(frameNumber, 1));
			
			int secondRollInFrame = pinsKnockedDownArray[2*(frameNumber - 1) + 1];
			assert secondRollInFrame < 10 : "secondRollInFrame = " + secondRollInFrame + " <> 10!";

			singlePlayerBowlingScoreboard_STUDENT.recordRoll(secondRollInFrame);

			assertEquals(Mark.translate(firstRollInFrame), singlePlayerBowlingScoreboard_STUDENT.getMark(frameNumber, 1));
			assertEquals(Mark.translate(secondRollInFrame), singlePlayerBowlingScoreboard_STUDENT.getMark(frameNumber, 2));
		}
	}

	@Points(value=5)
	@Test(timeout=300000)
	public void noSparesOrStrikesNineFrameScoreTest()
	{
		TEST_GOAL_MESSAGE = "Handle getScore(f) correctly for nine simple frames";
		int[] pinsKnockedDownArray = new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};

		for(int frameNumber = 1; frameNumber <= 9; frameNumber++)
		{
			int firstRollInFrame = pinsKnockedDownArray[2*(frameNumber - 1)];
			assert firstRollInFrame < 10 : "firstRollInFrame = " + firstRollInFrame + " <> 10!";
			
			singlePlayerBowlingScoreboard_STUDENT.recordRoll(firstRollInFrame);
			
			int secondRollInFrame = pinsKnockedDownArray[2*(frameNumber - 1) + 1];
			assert secondRollInFrame < 10 : "secondRollInFrame = " + secondRollInFrame + " <> 10!";

			singlePlayerBowlingScoreboard_STUDENT.recordRoll(secondRollInFrame);

			assertEquals(sum(pinsKnockedDownArray, 0, 2*frameNumber), singlePlayerBowlingScoreboard_STUDENT.getScore(frameNumber));
		}
	}
	
	@Points(value=5)
	@Test(timeout=3000)
	public void noSparesOrStrikesNineFrameScore2Test()
	{
		TEST_GOAL_MESSAGE = "Handle getScore(f) correctly for nine simple frames";
		int[] pinsKnockedDownArray = new int[]{1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7, 0, 8, 0, 9, 0};

		for(int frameNumber = 1; frameNumber <= 9; frameNumber++)
		{
			int firstRollInFrame = pinsKnockedDownArray[2*(frameNumber - 1)];
			assert firstRollInFrame < 10 : "firstRollInFrame = " + firstRollInFrame + " <> 10!";
			
			singlePlayerBowlingScoreboard_STUDENT.recordRoll(firstRollInFrame);
			
			int secondRollInFrame = pinsKnockedDownArray[2*(frameNumber - 1) + 1];
			assert secondRollInFrame < 10 : "secondRollInFrame = " + secondRollInFrame + " <> 10!";

			singlePlayerBowlingScoreboard_STUDENT.recordRoll(secondRollInFrame);

			assertEquals(sum(pinsKnockedDownArray, 0, 2*frameNumber), singlePlayerBowlingScoreboard_STUDENT.getScore(frameNumber));
		}
	}

	/**********************************************************************************************************************/
	
	private void recordPins(SinglePlayerBowlingScoreboard bowlingScoreboard, int[] pinsKnockedDownArray)
	{
		for(int i = 0; i < pinsKnockedDownArray.length; i++)
		{
			bowlingScoreboard.recordRoll(pinsKnockedDownArray[i]);
		}
	}
	
	//post: rv = intArray[beginIndex] + intArray[beginIndex + 1] + ... + intArray[endIndex - 1]
	private static int sum(int[] intArray, int beginIndex, int endIndex)
	{
		assert beginIndex >= 0 : "beginIndex = " + beginIndex + " < 0!";
		assert endIndex <= (intArray.length) : "endIndex = " + endIndex + " > " + (intArray.length) + " = (intArray.length)!";
		assert beginIndex < endIndex : "beginIndex = " + beginIndex + " > " + endIndex + " = endIndex!";
		int sum = 0;
		for(int i = beginIndex; i < endIndex; i++)
		{
			sum = sum + intArray[i];
		}
		return sum;
	}
}
