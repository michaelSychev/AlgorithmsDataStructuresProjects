package test;

import org.junit.Test;
import tournament.Bracket;
import tournament.BracketImpl_Sychev;
import java.util.*;

import static org.junit.Assert.assertTrue;

public class TEST
{
    @Test
    @Points(value = 10)
    public void testEqualsIncompleteBracket()
    {
        List<Integer> intBracket=new ArrayList<Integer>();
        for (int i = 0; i<= 15; i++) {
            intBracket.add(i);
        }
        Bracket<Integer> intBracketTest;
        intBracketTest = new BracketImpl_Sychev<Integer>(intBracket);
        intBracketTest.setWinCount(0, 4);
        intBracketTest.setWinCount(15, 3);

        Set<Integer> bracket = new HashSet<>();
        for (int i = 0; i<= 15; i++) {
            bracket.add(i);
        }

        Set<Integer> viableP = new HashSet<>();
        for (int i = 8; i<= 11; i++) {
            viableP.add(i);
        }

        assertTrue(intBracketTest.getViableParticipants(viableP).equals(viableP));

        for (int i = 12; i<= 15; i++) {
            viableP.add(i);
        }

        Set<Integer> winnerIs15 = new HashSet<>();
        winnerIs15.add(15);
        assertTrue(intBracketTest.getViableParticipants(viableP).equals(winnerIs15));


        //Test Change in top winner

        intBracketTest.setWinCount(2, 4);
        //Nothing changes on right bracket
        assertTrue(intBracketTest.getViableParticipants(viableP).equals(winnerIs15));
        //left braket changed
        Set<Integer> winnerIs2 = new HashSet<>();
        winnerIs2.add(2);
        Set<Integer> leftbracketLevel3 = new HashSet<>();
        for (int i = 0; i<= 7; i++) {
            leftbracketLevel3.add(i);
        }

        Set<Integer> leftbracketLevel2 = new HashSet<>();
        for (int i = 0; i<= 3; i++) {
            leftbracketLevel2.add(i);
        }

        Set<Integer> leftbracketLevel1 = new HashSet<>();
        for (int i = 2; i<= 3; i++) {
            leftbracketLevel1.add(i);
        }

        Set<Integer> leftbrackeNoWinner = new HashSet<>();
        for (int i = 0; i<= 1; i++) {
            leftbrackeNoWinner.add(i);
        }

        //test 2 is the winner at level 4, 3, 2 ,1
        assertTrue(intBracketTest.getViableParticipants(bracket).equals(winnerIs2));
        assertTrue(intBracketTest.getViableParticipants(leftbracketLevel3).equals(winnerIs2));
        assertTrue(intBracketTest.getViableParticipants(leftbracketLevel2).equals(winnerIs2));
        assertTrue(intBracketTest.getViableParticipants(leftbracketLevel1).equals(winnerIs2));
        assertTrue(intBracketTest.getViableParticipants(leftbrackeNoWinner).equals(leftbrackeNoWinner));
    }

    @Test
    @Points(value = 10)
    public void test32bracket()
    {
        List<Integer> intBracket=new ArrayList<Integer>();
        Set<Integer> bracket = new HashSet<>();
        for (int i = 0; i<= 31; i++) {
            intBracket.add(i);
            bracket.add(i);
        }
        Bracket<Integer> intBracketTest;
        intBracketTest = new BracketImpl_Sychev<Integer>(intBracket);
        intBracketTest.setWinCount(0, 4);
        intBracketTest.setWinCount(15, 3);

        assertTrue(intBracketTest.getViableParticipants(bracket).equals(bracket));

        Set<Integer> leftbracket = new HashSet<>();
        for (int i = 0; i<= 15; i++) {
            leftbracket.add(i);
        }
        Set<Integer> winnerIs0 = new HashSet<>();
        winnerIs0.add(0);
        assertTrue(intBracketTest.getViableParticipants(leftbracket).equals(winnerIs0));


        Set<Integer> leftrightbracket = new HashSet<>();
        for (int i = 8; i<= 15; i++) {
            leftrightbracket.add(i);
        }
        Set<Integer> winnerIs15 = new HashSet<>();
        winnerIs15.add(15);
        assertTrue(intBracketTest.getViableParticipants(leftrightbracket).equals(winnerIs15));

        Set<Integer> leftleftbracket = new HashSet<>();
        for (int i = 0; i<= 7; i++) {
            leftleftbracket.add(i);
        }

        winnerIs0.add(0);
        assertTrue(intBracketTest.getViableParticipants(leftbracket).equals(winnerIs0));

        intBracketTest.setWinCount(2,2);

        Set<Integer> noNodeWinner = new HashSet<>();
        for (int i = 0; i<= 7; i++) {
            noNodeWinner.add(i);
        }
        noNodeWinner.remove(1);
        noNodeWinner.remove(0);
        noNodeWinner.remove(3);
        assertTrue(intBracketTest.getViableParticipants(leftleftbracket).equals(noNodeWinner));

        intBracketTest.setWinCount(0, 4);
        assertTrue(intBracketTest.getViableParticipants(leftbracket).equals(winnerIs0));

        Set<Integer> winnerIs16 = new HashSet<>();
        winnerIs16.add(16);

        for (int i = 0; i<= 31; i++) {
            bracket.add(i);
        }

        intBracketTest.setWinCount(16, 5);

        assertTrue(intBracketTest.getViableParticipants(bracket).equals(winnerIs16));
        assertTrue(intBracketTest.getViableParticipants(winnerIs16).equals(winnerIs16));

        //change to winner is 17
        intBracketTest.setWinCount(17, 5);

        Set<Integer> winnerIs17 = new HashSet<>();
        winnerIs17.add(17);
        for (int i = 0; i<= 31; i++) {
            bracket.add(i);
        }
        Set<Integer> rightbracket = new HashSet<>();
        for (int i = 16; i<= 31; i++) {
            rightbracket.add(i);
        }

        Set<Integer> rightbracketLevel2 = new HashSet<>();
        for (int i = 16; i<= 23; i++) {
            rightbracketLevel2.add(i);
        }

        Set<Integer> rightbracketLevel1 = new HashSet<>();
        for (int i = 16; i<= 19; i++) {
            rightbracketLevel1.add(i);
        }


        Set<Integer> rightbracketLevel1NoWinner = new HashSet<>();
        for (int i = 18; i<= 19; i++) {
            rightbracketLevel1NoWinner.add(i);
        }
        Set<Integer> noWinLevel1 = new HashSet<>();
        noWinLevel1.addAll(rightbracketLevel1NoWinner);

        //test 17 is the winner at level 5, 4, 3, 2 ,1
        assertTrue(intBracketTest.getViableParticipants(bracket).equals(winnerIs17));
        assertTrue(intBracketTest.getViableParticipants(rightbracket).equals(winnerIs17));
        assertTrue(intBracketTest.getViableParticipants(rightbracketLevel2).equals(winnerIs17));
        assertTrue(intBracketTest.getViableParticipants(rightbracketLevel1).equals(winnerIs17));
        assertTrue(intBracketTest.getViableParticipants(rightbracketLevel1NoWinner).equals(noWinLevel1));

    }

    @Test
    @Points(value = 10)
    public void test32bracketEquals()
    {
        List<Integer> intMU = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22, 23,24,25,26,27,28,29,30,31);
        List<Integer> intMUreverse = Arrays.asList(30,31,29,28,27,26,25,24,23,22,21,20,19,18,17,  16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,0,1);
        List<Integer> intMUreverse2 = Arrays.asList(17, 16, 19,18,20,21,22, 23,24,25,26,27,28,29,30,31 ,15,14,13,12,11,10,9,8,7,6,5,4,3,2,0,1);

        Bracket<Integer> intBracket;
        intBracket = new BracketImpl_Sychev<Integer>(intMU);
        Bracket<Integer> intBracket2;
        intBracket2 = new BracketImpl_Sychev<Integer>(intMUreverse);
        Bracket<Integer> intBracket3;
        intBracket3 = new BracketImpl_Sychev<Integer>(intMUreverse2);

        assertTrue(intBracket.equals(intBracket2));
        assertTrue(intBracket.equals(intBracket3));
        assertTrue(intBracket2.equals(intBracket3));

        intBracket.setWinCount(0,5);
        intBracket2.setWinCount(0,5);
        intBracket.setWinCount(31,4);
        intBracket2.setWinCount(31,4);

        assertTrue(intBracket.equals(intBracket2));

        intBracket.setWinCount(6,2);
        intBracket2.setWinCount(7,2);

        assertTrue(!intBracket.equals(intBracket2));

        intBracket.setWinCount(6,2);
        intBracket2.setWinCount(6,2);
        intBracket3.setWinCount(6,2);

        assertTrue(!intBracket.equals(intBracket3));
        assertTrue(!intBracket2.equals(intBracket3));

    }


}
