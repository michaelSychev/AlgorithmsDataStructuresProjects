package tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;

import tictactoe.Mark;
import tictactoe.TicTacToeBoard;
import tictactoe.TicTacToeBoardImpl_Sychev;


public class tests {

	@Test
	public void testWinnerXrow0() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(0, 0);
		ttt.setMark(1, 0);
		ttt.setMark(0, 1);
		ttt.setMark(2, 0);
		ttt.setMark(0, 2);
		Mark winnerExpected = Mark.X;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerXcol0() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(0, 0);
		ttt.setMark(1, 1);
		ttt.setMark(1, 0);
		ttt.setMark(2, 2);
		ttt.setMark(2, 0);
		Mark winnerExpected = Mark.X;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerXrow1() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(1, 0);
		ttt.setMark(2, 1);
		ttt.setMark(1, 1);
		ttt.setMark(2, 2);
		ttt.setMark(1, 2);
		Mark winnerExpected = Mark.X;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerXrow2() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(2, 0);
		ttt.setMark(1, 1);
		ttt.setMark(2, 1);
		ttt.setMark(1, 0);
		ttt.setMark(2, 2);
		Mark winnerExpected = Mark.X;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerXcol1() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(0, 1);
		ttt.setMark(2, 2);
		ttt.setMark(1, 1);
		ttt.setMark(2, 0);
		ttt.setMark(2, 1);
		Mark winnerExpected = Mark.X;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerXcol2() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(0, 2);
		ttt.setMark(0, 0);
		ttt.setMark(1, 2);
		ttt.setMark(2, 0);
		ttt.setMark(2, 2);
		Mark winnerExpected = Mark.X;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerXdiag1() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(0, 0);
		ttt.setMark(0, 1);
		ttt.setMark(1, 1);
		ttt.setMark(2, 0);
		ttt.setMark(2, 2);
		Mark winnerExpected = Mark.X;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerXdiag2() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(0, 2);
		ttt.setMark(0, 1);
		ttt.setMark(1, 1);
		ttt.setMark(2, 1);
		ttt.setMark(2, 0);
		Mark winnerExpected = Mark.X;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	
	
	//Check O wins
	
	@Test
	public void testWinnerOrow0() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(1, 0);
		ttt.setMark(0, 0);
		ttt.setMark(1, 1);
		ttt.setMark(0, 1);
		ttt.setMark(2, 2);
		ttt.setMark(0, 2);
		Mark winnerExpected = Mark.O;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerOcol0() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(1, 1);
		ttt.setMark(0, 0);
		ttt.setMark(2, 2);
		ttt.setMark(1, 0);
		ttt.setMark(2, 1);
		ttt.setMark(2, 0);
		Mark winnerExpected = Mark.O;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerOrow1() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(2, 1);
		ttt.setMark(1, 0);
		ttt.setMark(0, 1);
		ttt.setMark(1, 1);
		ttt.setMark(2, 2);
		ttt.setMark(1, 2);
		Mark winnerExpected = Mark.O;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerOrow2() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(1, 1);
		ttt.setMark(2, 0);
		ttt.setMark(1, 0);
		ttt.setMark(2, 1);
		ttt.setMark(0, 1);
		ttt.setMark(2, 2);
		Mark winnerExpected = Mark.O;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerOcol1() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(0, 0);
		ttt.setMark(0, 1);
		ttt.setMark(2, 2);
		ttt.setMark(1, 1);
		ttt.setMark(2, 0);
		ttt.setMark(2, 1);
		Mark winnerExpected = Mark.O;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerOcol2() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(1, 0);
		ttt.setMark(0, 2);
		ttt.setMark(0, 0);
		ttt.setMark(1, 2);
		ttt.setMark(2, 1);
		ttt.setMark(2, 2);
		Mark winnerExpected = Mark.O;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerOdiag1() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(1, 2);
		ttt.setMark(0, 0);
		ttt.setMark(0, 1);
		ttt.setMark(1, 1);
		ttt.setMark(2, 0);
		ttt.setMark(2, 2);
		Mark winnerExpected = Mark.O;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerOdiag2() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(0, 0);
		ttt.setMark(0, 2);
		ttt.setMark(0, 1);
		ttt.setMark(1, 1);
		ttt.setMark(2, 1);
		ttt.setMark(2, 0);
		Mark winnerExpected = Mark.O;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testWinnerTie() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(0, 2);
		ttt.setMark(0, 0);
		ttt.setMark(0, 1);
		ttt.setMark(1, 1);
		ttt.setMark(1, 0);
		ttt.setMark(1, 2);
		ttt.setMark(2, 0);
		ttt.setMark(2, 1);
		ttt.setMark(2, 2);
		Mark winnerExpected = null;
		
		assertEquals(winnerExpected, ttt.getWinner());
	}
	
	@Test
	public void testGetTurnTie() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		ttt.setMark(0, 2);
		ttt.setMark(0, 0);
		ttt.setMark(0, 1);
		ttt.setMark(1, 1);
		ttt.setMark(1, 0);
		ttt.setMark(1, 2);
		ttt.setMark(2, 0);
		ttt.setMark(2, 1);
		ttt.setMark(2, 2);
		Mark winnerExpected = null;
		
		assertEquals(winnerExpected, ttt.getTurn());
	}
	
	@Test
	public void testGetTurnO() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		
			ttt.setMark(0, 0);
			ttt.setMark(1, 0);
			ttt.setMark(0, 2);
		
			Mark getTurnEpected = Mark.O;
			
			assertEquals(getTurnEpected, ttt.getTurn());
	
	}
	
	@Test
	public void testGetTurnEmpty() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();

			Mark getTurnEpected = Mark.X;
			
			assertEquals(getTurnEpected, ttt.getTurn());
	
	}
	
	
	
	
	//NB cases
	@Test
	public void NBtestMoveAfterWin() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		try {
		ttt.setMark(1, 0);
		ttt.setMark(0, 2);
		ttt.setMark(0, 0);
		ttt.setMark(1, 2);
		ttt.setMark(2, 0);
		ttt.setMark(2, 2);
		}
		
		catch(AssertionError ae)
		{
			//THIS IS CORRECT BEHAVIOR
		}
	}
	
	@Test
	public void NBtestSetOutsideBoard() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		try {
		ttt.setMark(2, 4);
		ttt.setMark(0, 2);
		ttt.setMark(0, 0);
		ttt.setMark(1, 2);
		ttt.setMark(2, 0);
		}
		
		catch(AssertionError ae)
		{
			//THIS IS CORRECT BEHAVIOR
		}
	}
	
	@Test
	public void NBtestSetNotEmpty() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		try {
		ttt.setMark(2, 0);
		ttt.setMark(0, 2);
		ttt.setMark(0, 0);
		ttt.setMark(1, 2);
		ttt.setMark(2, 0);
		}
		
		catch(AssertionError ae)
		{
			//THIS IS CORRECT BEHAVIOR
		}
	}
	
	@Test
	public void NBtestGetOutsideBoard() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		try {
		ttt.setMark(2, 0);
		ttt.setMark(0, 2);
		ttt.setMark(0, 0);
		ttt.setMark(1, 2);
		
		ttt.getMark(0, 4);
		}
		
		catch(AssertionError ae)
		{
			//THIS IS CORRECT BEHAVIOR
		}
	}
	
	@Test
	public void NBtestGetOutsideBoardNeg() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		try {
		ttt.setMark(-2, 0);
		ttt.setMark(0, 2);
		ttt.setMark(0, 0);
		ttt.setMark(1, 2);

		}
		
		catch(AssertionError ae)
		{
			//THIS IS CORRECT BEHAVIOR
		}
	}
	
	@Test
	public void NBtestSetOutsideBoardNeg() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		try {
		ttt.setMark(2, 0);
		ttt.setMark(0, -2);
		ttt.setMark(0, 0);
		ttt.setMark(1, 2);

		}
		
		catch(AssertionError ae)
		{
			//THIS IS CORRECT BEHAVIOR
		}
	}
	
	@Test
	public void NBtestgetWinnerNoWinner() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		try {
		ttt.setMark(1, 1);
		ttt.setMark(2, 0);
		ttt.setMark(1, 0);
		ttt.getWinner();
		}
		
		catch(AssertionError ae)
		{
			//THIS IS CORRECT BEHAVIOR
		}

	
	}
	
	@Test
	public void NBtestMoveAfterXWins() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		try {
			ttt.setMark(0, 0);
			ttt.setMark(1, 0);
			ttt.setMark(0, 2);
			ttt.setMark(1, 1);
			ttt.setMark(0, 1);
			ttt.setMark(1, 2);
		}
		
		catch(AssertionError ae)
		{
			//THIS IS CORRECT BEHAVIOR
		}

	
	}
	
	@Test
	public void NBtestGetWinnerOnEmptyBoard() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
		try {
			ttt.getWinner();
		}
		
		catch(AssertionError ae)
		{
			//THIS IS CORRECT BEHAVIOR
		}
	
	}
	
	@Test
	public void NBtestTurnAfterXWins() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		
			ttt.setMark(0, 0);
			ttt.setMark(1, 0);
			ttt.setMark(0, 2);
			ttt.setMark(1, 1);
			ttt.setMark(0, 1);
			
			Mark getTurnEpected = null;
			
			assertEquals(getTurnEpected, ttt.getTurn());
			
	}
	
	@Test
	public void KartTestCase2() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Current test board is [5, 3, 1, 4, 8, 6, 0, 7, 2]
		//getMark, setmark, getTurn, isGameOver, getWinner.
		
			ttt.setMark(1, 2); //5 x
			ttt.setMark(1, 0); //3 o
			ttt.setMark(0, 1); //1 x
			ttt.setMark(1, 1); //4 o
			ttt.setMark(2, 2); //8 x
			ttt.setMark(2, 0); //6 o
			ttt.setMark(0, 0); //0 x
			ttt.setMark(2, 1); //7 o
			ttt.setMark(0, 2); //2 x
			
			
			Mark getMarkEpected = Mark.X;
			
			assertEquals(getMarkEpected, ttt.getMark(0, 2));
			
			assertEquals(getMarkEpected, ttt.getWinner());
			
			Mark getMarkEpected2 = Mark.O;
			
			assertEquals(getMarkEpected2, ttt.getMark(2,1));
			
			Mark getMarkEpected3 = null;
			
			assertEquals(getMarkEpected3, ttt.getTurn());
			
			boolean isGameOver = true;
			
			assertEquals(isGameOver, ttt.isGameOver());
			
			try {
				ttt.setMark(0, 1);
			}
			catch(AssertionError ae) {
				//System.out.println(ae);
			}
			
			
	}
	
	
	
	@Test
	public void KartTestCase1() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Current test board is [0, 3, 1, 4, 2].setMark(1, 2)
		
		ttt.setMark(0, 0); //0
		ttt.setMark(1, 0); //3
		ttt.setMark(0, 1); //1
		ttt.setMark(1, 1); //4
		ttt.setMark(0, 2); //2
		
		Mark getMarkEpected = Mark.X;
		
		assertEquals(getMarkEpected, ttt.getMark(0, 2));
		
		assertEquals(getMarkEpected, ttt.getWinner());
		
		Mark getMarkEpected2 = null;
		
		assertEquals(getMarkEpected2, ttt.getMark(2,1));
		
		Mark getMarkEpected3 = null;
		
		assertEquals(getMarkEpected3, ttt.getTurn());
		
		boolean isGameOver = true;
		
		assertEquals(isGameOver, ttt.isGameOver());
		
		try {
		
		
		ttt.setMark(1, 2);
		
		}
		
		catch (AssertionError ae){
			//System.out.println(ae);
		}
		
			
	}
	
	
	@Test
	public void KartTestCase3() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Correctly throw an AssertionError on the call [].getMark(2, 4)
		try {
		
		ttt.getMark(2,4);
		
		}
		
		catch (AssertionError ae){
			//System.out.println(ae);
		}
		
			
	}
	
	@Test
	public void KartTestCase4() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired: Get all questions correct about the game: [2, 6, 7, 8, 0, 1, 3, 4, 5]
		//getMark, setmark, getTurn, isGameOver, getWinner.
		//.getMark(1, 2)
		
		ttt.setMark(0, 2); //2
		ttt.setMark(2, 0); //6
		ttt.setMark(2, 1); //7
		ttt.setMark(2, 2); //8
		ttt.setMark(0, 0); //0
		ttt.setMark(0, 1); //1
		ttt.setMark(1, 0); //3
		ttt.setMark(1, 1); //4
		ttt.setMark(1, 2); //5
		
		Mark getMarkEpected = Mark.X;
		
		assertEquals(getMarkEpected, ttt.getMark(1, 2));
		
		
		Mark getMarkEpected3 = null;
		assertEquals(getMarkEpected3, ttt.getWinner());
		assertEquals(getMarkEpected3, ttt.getTurn());
		
		Mark getMarkEpected2 = Mark.O;
		
		assertEquals(getMarkEpected2, ttt.getMark(1,1));
		
		boolean isGameOver = true;
		
		assertEquals(isGameOver, ttt.isGameOver());
		
		try {
			ttt.setMark(0, 1);
		}
		catch(AssertionError ae) {
			//System.out.println(ae);
		}
		
			
	}
	
	@Test
	public void KartTestCase5() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired: Get all questions correct about the game: [4, 8]
		ttt.setMark(1, 1); //4
		ttt.setMark(2, 2); //8
		
		Mark getMarkEpected = Mark.X;
		
		assertEquals(getMarkEpected, ttt.getTurn());
		assertEquals(getMarkEpected, ttt.getMark(1,1));
		
		ttt.setMark(2, 0); 
		Mark getMarkEpected2 = Mark.O;
		
		assertEquals(getMarkEpected2, ttt.getTurn());
		
		Mark getMarkEpected3 = null;
		assertEquals(getMarkEpected3, ttt.getMark(0,1));
		
		boolean isGameOver = false;
		
		assertEquals(isGameOver, ttt.isGameOver());
		
		try {
		ttt.getWinner();
		}
		catch(AssertionError ae){
			//System.out.println(ae);
			}
		}
			
	@Test
	public void KartTestCase6() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired: Throw an AssertionError on the call [].setMark(4, 3)
		
		try {
		ttt.setMark(4,3);
		}
		catch(AssertionError ae){
			//System.out.println(ae);
			}
		}
	
	@Test
	public void KartTestCase7() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired: Get all questions correct about the game: [3, 8, 4, 7, 5]
		//getMark, setmark, getTurn, isGameOver, getWinner.
		
		ttt.setMark(1, 0); //3
		ttt.setMark(2, 2); //8
		ttt.setMark(1, 1); //4
		ttt.setMark(2, 1); //7
		ttt.setMark(1, 2); //5
		
		
		Mark getMarkEpected = Mark.X;
		
		assertEquals(getMarkEpected, ttt.getMark(1, 2));
		assertEquals(getMarkEpected, ttt.getWinner());
		
		Mark getMarkEpected3 = null;
		assertEquals(getMarkEpected3, ttt.getTurn());
		
		Mark getMarkEpected2 = Mark.O;
		
		assertEquals(getMarkEpected2, ttt.getMark(2,1));
		
		boolean isGameOver = true;
		
		assertEquals(isGameOver, ttt.isGameOver());
		
		try {
			ttt.setMark(2,0);
		}
		catch(AssertionError ae) {
			//System.out.println(ae);
		}
		
			
	}
	
	@Test
	public void KartTestCase9() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired: Get all questions correct about the game: [0, 1, 2, 5, 8, 7, 6, 3, 4]
		//getMark, setmark, getTurn, isGameOver, getWinner.
		
		ttt.setMark(0, 0); //0
		ttt.setMark(0, 1); //1
		ttt.setMark(0, 2); //2
		ttt.setMark(1, 2); //5
		ttt.setMark(2, 2); //8
		ttt.setMark(2, 1); //7
		ttt.setMark(2, 0); //6
		ttt.setMark(1, 0); //3
		ttt.setMark(1, 1); //4

		
		
		Mark getMarkEpected = Mark.X;
		
		assertEquals(getMarkEpected, ttt.getMark(1, 1));
		assertEquals(getMarkEpected, ttt.getWinner());
		
		Mark getMarkEpected3 = null;
		assertEquals(getMarkEpected3, ttt.getTurn());
		
		Mark getMarkEpected2 = Mark.O;
		
		assertEquals(getMarkEpected2, ttt.getMark(2,1));
		
		boolean isGameOver = true;
		
		assertEquals(isGameOver, ttt.isGameOver());
		
		try {
			ttt.setMark(2,0);
		}
		catch(AssertionError ae) {
			//System.out.println(ae);
		}
		
			
	}
	
	@Test
	public void KartTestCase10() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired: Throw an AssertionError on the call [0, 4].getWinner()
		
		ttt.setMark(0,0);
		ttt.setMark(1,1);
		
		try {
			ttt.getWinner();
		}
		catch(AssertionError ae){
			//System.out.println(ae);
		}
	}
		
	
	@Test
	public void KartTestCase11() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired: Get all questions correct about the game: [1, 2, 3]
		//getMark, setmark, getTurn, isGameOver, getWinner.
		
	
		ttt.setMark(0, 1); //1
		ttt.setMark(0, 2); //2
		ttt.setMark(1, 0); //3


		
		
		Mark getMarkEpected = Mark.X;
		
		assertEquals(getMarkEpected, ttt.getMark(0, 1));
		
		
		Mark getMarkEpected3 = null;
		assertEquals(getMarkEpected3, ttt.getMark(0,0));
		
		
		Mark getMarkEpected2 = Mark.O;
		assertEquals(getMarkEpected2, ttt.getTurn());
		assertEquals(getMarkEpected2, ttt.getMark(0,2));
		
		boolean isGameOver = false;
		
		assertEquals(isGameOver, ttt.isGameOver());
		
		try {
			ttt.getWinner();
		}
		catch(AssertionError ae) {
			//System.out.println(ae);
		}
		
			
	}
	
	@Test
	public void KartTestCase12() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired: Get all questions correct about the game: [2]
		//getMark, setmark, getTurn, isGameOver, getWinner.
		
	
		ttt.setMark(0, 2); //2
		
		
		Mark getMarkEpected = Mark.X;
		
		assertEquals(getMarkEpected, ttt.getMark(0, 2));
		
		
		Mark getMarkEpected3 = null;
		assertEquals(getMarkEpected3, ttt.getMark(0,0));
		
		
		Mark getMarkEpected2 = Mark.O;
		assertEquals(getMarkEpected2, ttt.getTurn());
		
		
		boolean isGameOver = false;
		
		assertEquals(isGameOver, ttt.isGameOver());
		
		try {
			ttt.getWinner();
		}
		catch(AssertionError ae) {
			//System.out.println(ae);
		}
		
			
	}
	
	@Test
	public void KartTestCase13() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired: Get all questions correct about the game: [2]
		//getMark, setmark, getTurn, isGameOver, getWinner.
		
	
		ttt.setMark(0, 2); //2
		
		
		Mark getMarkEpected = Mark.X;
		
		assertEquals(getMarkEpected, ttt.getMark(0, 2));
		
		
		Mark getMarkEpected3 = null;
		assertEquals(getMarkEpected3, ttt.getMark(0,0));
		
		
		Mark getMarkEpected2 = Mark.O;
		assertEquals(getMarkEpected2, ttt.getTurn());
		
		
		boolean isGameOver = false;
		
		assertEquals(isGameOver, ttt.isGameOver());
		
		try {
			ttt.getWinner();
		}
		catch(AssertionError ae) {
			//System.out.println(ae);
		}
		
			
	}
	
	@Test
	public void KartTestCase14() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired: Correctly throw an AssertionError on the call [4, 0, 8, 2, 3, 1].setMark(2, 0)
		//getMark, setmark, getTurn, isGameOver, getWinner.
		
	
		ttt.setMark(1, 1); //4
		ttt.setMark(0, 0); //0
		ttt.setMark(2, 2); //8
		ttt.setMark(0, 2); //2
		ttt.setMark(1, 0); //3
		ttt.setMark(0, 1); //1
		
		
		
		Mark getMarkEpected = Mark.O;
		assertEquals(getMarkEpected, ttt.getMark(0, 2));
		assertEquals(getMarkEpected, ttt.getWinner());
		
		
		Mark getMarkEpected3 = null;
		assertEquals(getMarkEpected3, ttt.getMark(2,0));
		assertEquals(getMarkEpected3, ttt.getTurn());
		
		
		Mark getMarkEpected2 = Mark.X;
		assertEquals(getMarkEpected2, ttt.getMark(1,0));
		
		
		boolean isGameOver = true;
		
		assertEquals(isGameOver, ttt.isGameOver());
		
		try {
			ttt.setMark(2,0);
		}
		catch(AssertionError ae) {
			//System.out.println(ae);
		}
		
			
	}
	
	@Test
	public void KartTestCase15() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired: Correctly throw an AssertionError on the call  [2, 6, 7, 8, 0, 1, 3, 4, 5].setMark(1,1)
		//getMark, setmark, getTurn, isGameOver, getWinner.
		
		
		ttt.setMark(0, 2); //2
		ttt.setMark(2, 0); //6
		ttt.setMark(2, 1); //7
		ttt.setMark(2, 2); //8
		ttt.setMark(0, 0); //0
		ttt.setMark(0, 1); //1
		ttt.setMark(1, 0); //3
		ttt.setMark(1, 1); //4
		ttt.setMark(1, 2); //5
		
		
		Mark getMarkEpected = Mark.X;
		assertEquals(getMarkEpected, ttt.getMark(0, 2));
		
		
		
		Mark getMarkEpected3 = null;
		assertEquals(getMarkEpected3, ttt.getTurn());
		assertEquals(getMarkEpected3, ttt.getWinner());
		
		
		Mark getMarkEpected2 = Mark.O;
		assertEquals(getMarkEpected2, ttt.getMark(1,1));
		
		
		boolean isGameOver = true;
		
		assertEquals(isGameOver, ttt.isGameOver());
		
		try {
			ttt.setMark(1,1);
		}
		catch(AssertionError ae) {
			//System.out.println(ae);
		}
		
			
	}
	
	@Test
	public void KartTestCase16() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired: Get all questions correct about the game: []
		
		Mark getMarkEpected = Mark.X;
		assertEquals(getMarkEpected, ttt.getTurn());
		
		boolean isGameOver = false;
		assertEquals(isGameOver, ttt.isGameOver());
		
		Mark getMarkEpected3 = null;
		assertEquals(getMarkEpected3, ttt.getMark(1,1));
		
		
		try {
		ttt.getWinner();
		}
		catch(AssertionError ae){
			//System.out.println(ae);
			}
		
	
		try {
		ttt.setMark(0,3);
		}
		catch(AssertionError ae){
			//System.out.println(ae);
			}
		}
	
	@Test
	public void KartTestCase17() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired:  Correctly throw an AssertionError on the call [5].setMark(1, 2
		
		ttt.setMark(1, 2); //5
		
		Mark getMarkEpected = Mark.O;
		assertEquals(getMarkEpected, ttt.getTurn());
		
		boolean isGameOver = false;
		assertEquals(isGameOver, ttt.isGameOver());
		
		Mark getMarkEpected3 = null;
		assertEquals(getMarkEpected3, ttt.getMark(1,1));
		
		
		try {
		ttt.getWinner();
		}
		catch(AssertionError ae){
			//System.out.println(ae);
			}
		
	
		try {
			ttt.setMark(1, 2);
		}
		catch(AssertionError ae){
			//System.out.println(ae);
			}
		}
	@Test
	public void KartTestCase19() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired: Get all questions correct about the game: [0, 1, 6, 7, 8, 5, 2, 3, 4]
		
		ttt.setMark(0, 1); //1
		ttt.setMark(0, 0); //0
		ttt.setMark(2, 0); //6
		ttt.setMark(2, 1); //7
		ttt.setMark(2, 2); //8
		ttt.setMark(1, 2); //5
		ttt.setMark(0, 2); //2
		ttt.setMark(1, 0); //3
		ttt.setMark(1, 1); //4
		
		Mark getMarkEpected = Mark.X;
		assertEquals(getMarkEpected, ttt.getWinner());
		assertEquals(getMarkEpected, ttt.getMark(1,1));
		
		boolean isGameOver = true;
		assertEquals(isGameOver, ttt.isGameOver());
		
		Mark getMarkEpected3 = null;
		assertEquals(getMarkEpected3, ttt.getTurn());
		
		Mark getMarkEpected2 = Mark.O;
		assertEquals(getMarkEpected2, ttt.getMark(1,0));
		
	
		try {
			ttt.setMark(1, 2);
		}
		catch(AssertionError ae){
			//System.out.println(ae);
			}
		}
	
	@Test
	public void KartTestCase20() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired: Get all questions correct about the game: [0, 1, 2, 6, 7, 8, 3, 4, 5]
		
		ttt.setMark(0, 0); //0
		ttt.setMark(0, 1); //1
		ttt.setMark(0, 2); //2
		ttt.setMark(2, 0); //6
		ttt.setMark(2, 1); //7
		ttt.setMark(2, 2); //8
		ttt.setMark(1, 0); //3
		ttt.setMark(1, 1); //4
		ttt.setMark(1, 2); //5
		
		Mark getMarkEpected = Mark.X;
		assertEquals(getMarkEpected, ttt.getMark(1,2));
		
		boolean isGameOver = true;
		assertEquals(isGameOver, ttt.isGameOver());
		
		Mark getMarkEpected3 = null;
		assertEquals(getMarkEpected3, ttt.getTurn());
		assertEquals(getMarkEpected3, ttt.getWinner());
		
		Mark getMarkEpected2 = Mark.O;
		assertEquals(getMarkEpected2, ttt.getMark(1,1));
		
	
		try {
			ttt.setMark(1, 2);
		}
		catch(AssertionError ae){
			//System.out.println(ae);
			}
		}
	
	@Test
	public void KartTestCase21() {
		TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();
		//Desired:Correctly throw an AssertionError on the call [0, 4, 6].getWinner()
		
		ttt.setMark(0, 0); //0
		ttt.setMark(1, 1); //4
		ttt.setMark(2, 0); //6
		
		
		Mark getMarkEpected = Mark.X;
		assertEquals(getMarkEpected, ttt.getMark(0,0));
		
		boolean isGameOver = false;
		assertEquals(isGameOver, ttt.isGameOver());

		
		Mark getMarkEpected2 = Mark.O;
		assertEquals(getMarkEpected2, ttt.getMark(1,1));
		assertEquals(getMarkEpected2, ttt.getTurn());
	
		try {
			ttt.getWinner();
		}
		catch(AssertionError ae){
			//System.out.println(ae);
			}
		}

}
