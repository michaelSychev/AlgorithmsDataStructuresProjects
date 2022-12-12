package tournament;

import org.junit.Test;
import test.Points;

import java.util.Arrays;

import static tournament.FIFASoccerTeam.*;
import static tournament.FIFASoccerTeam.USA;

public class Testing
{
    @Test(timeout = 0)
    @Points(value = 10)
    public void testTime()
    {
        BracketImpl_Sychev<FIFASoccerTeam> bracketOne = new BracketImpl_Sychev<FIFASoccerTeam>(Arrays.asList(BRAZIL,CHILE,COLOMBIA,URUGUAY,FRANCE,NIGERIA,GERMANY,ALGERIA,NETHERLANDS,MEXICO,COSTA_RICA,GREECE,ARGENTINA,SWITZERLAND,BELGIUM,USA));
        bracketOne.getGroupings(2);
    }
}
