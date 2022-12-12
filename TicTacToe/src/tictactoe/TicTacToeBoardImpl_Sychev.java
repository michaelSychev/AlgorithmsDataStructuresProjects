package tictactoe;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TicTacToeBoardImpl_Sychev implements TicTacToeBoard
{
    protected static final int NO_MOVE = -1;
    protected static final int NO_MATCH = -1;
    public static final int MAX_COLUMN_VALUE = 3;
    public static final int MAX_ROW_VALUE = 3;
    public static final int MIN_ROW_VALUE = 0;
    public static final int MIN_COLUMN_VALUE = 0;
    //instance variable
    protected int[] movesArray;
    public TicTacToeBoardImpl_Sychev()
    {
        final int CELL_COUNT = ROW_COUNT*COLUMN_COUNT;
        movesArray = new int[CELL_COUNT];
        for(int i =0; i< CELL_COUNT; i++)
        {
            movesArray[i] = NO_MOVE;
        }

    }
    public TicTacToeBoardImpl_Sychev(int[] niceName)
    {
        this.movesArray = niceName;
    }
    //part of pre: 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
    //part of post: rv == null <==> the (row, column) spot on the board is empty
    //given row and column determine if spot on board is empty or x or o marked area
    @Override
    public Mark getMark(int row, int column)
    {
        final int EMPTY_ARRAY_SPOT,DID_NOT_FIND_MOVE = -1;
        final Mark NO_MOVE_MADE = null;

        assert (0<=row && row<=3) && (0<=column && column<=3): "row and column must be from 0 to 3 inclusive";
        Mark rv = NO_MOVE_MADE;
        int requestedArrayBoardSpot = translateBoardToArray(row,column);//gives us the board spot
        int potentialIndexContainingRequestedMoveMade = DID_NOT_FIND_MOVE;
        for(int i =0; i< movesArray.length; i++)
        {
            //i is each index of the array NOT THE SPOT ON THE BOARD
            if(movesArray[i] == requestedArrayBoardSpot)
            {
                potentialIndexContainingRequestedMoveMade = i;
                break;
            }
        }
        if(potentialIndexContainingRequestedMoveMade == DID_NOT_FIND_MOVE)
        {
            rv = NO_MOVE_MADE;
        }
        else if((potentialIndexContainingRequestedMoveMade %2) == 0)
        {
            rv = Mark.X;
        }
        else if((potentialIndexContainingRequestedMoveMade %2)!= 0)
        {
            rv = Mark.O;
        }

        return rv;
    }
    //part of pre: 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
    //part of pre: getMark(row, column) == null
    //part of pre: !isGameOver()
    //post: Left to student
    @Override
    public void setMark(int row, int column)
    {
        assert isGameOver()!=true:"The game is over, bozo";
        assert (0<=row && row<=3) && (0<=column && column<=3): "row and column must be from 0 to 3 inclusive";
        assert getMark(row,column)==null:"Board space is taken";
        int position = translateBoardToArray(row,column);
        movesArray[getNextOpenSpaceInArray()] = position;
    }
    //part of post: rv == null <==> it is neither player's turn (i.e.game is over)
    //part of post: “number of Marks on board is even”è rv == Mark.X
    //part of post: “number of Marks on board is odd” è rv == Mark.O
    @Override
    public Mark getTurn()
    {
        Mark rv = null;

        if(getNextOpenSpaceInArray()==-1 || isGameOver()==true)//out of space or winner is chosen
        {
            rv = null;
        }
        else if(getNextOpenSpaceInArray()%2==0)//if next empty space is even X goes
        {
            rv = Mark.X;
        }
        else if(getNextOpenSpaceInArray()%2 != 0)//if next empty space index is odd  O goes
        {
            rv = Mark.O;
        }
        return rv;
    }
    //part of post: Left to student (see Tic-tac-toe rules in order
    //   to fill this out)
    @Override
    public boolean isGameOver()
    {
        boolean rv = false; //we assume game is not over
        final int NO_MOVES_LEFT = -1;
           //if board is full game is over
            if(determineWinner()==null)
            {
                if(getNextOpenSpaceInArray()==-NO_MOVES_LEFT)
                {
                    rv = true;
                }
            }
            if(determineWinner()!=null)
            {
                rv = true;
            }

        return rv;

    }
    //part of pre: isGameOver()
    //part of post: rv == null <==> neither player won (i.e. the game
    //   ended in a tie)
    @Override
    public Mark getWinner()
    {
        assert isGameOver() == true:"The game has not ended yet bozo";
        Mark rv = null;
        if(determineWinner() ==  Mark.X)
        {
            rv = Mark.X;
        }
        else if(determineWinner() == Mark.O)
        {
            rv = Mark.O;
        }
        return rv;
    }
    public Mark determineWinner()
    {
        // assert isGameOver() == true:"The game has not ended yet bozo";
        Mark rv = null;
        int[] xMoves = IntStream.range(0, movesArray.length).filter(n->n%2==0).map(n->movesArray[n]).toArray();
        int[] OMoves = IntStream.range(0, movesArray.length).filter(n -> n%2!=0).map(n->movesArray[n]).toArray();
        if(containsWinningSet(xMoves)==true)
        {
            rv = Mark.X;
        }
        else if(containsWinningSet(OMoves)==true)
        {
            rv = Mark.O;
        }
        return rv;
    }

    @Override
    public String toString()
    {
        return movesArray.toString();
    }
    //pre: row and column must be valid at time of call(0 through 3)
    //part of pre: 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
    //part of post: rv == null <==> the (row, column) spot on the
    public int translateBoardToArray(int row, int column)
    {
        int rv =0;
        rv = ROW_COUNT*row + column;
        return rv;
    }
    //pre:none
    //post:finds the next avaible element that is -1(means space is open for move to be made)
    public int getNextOpenSpaceInArray()
    {
        final int DID_NOT_FIND_OPEN_SPACE = -1;
        int rv = DID_NOT_FIND_OPEN_SPACE ;//didnt find -1
        for(int i =0;i< movesArray.length;i++)
        {
            if(movesArray[i] == -1)
            {
                rv =  i;
                break;
            }
        }
        return rv;
    }

    //pre:none
    //post: returns true if winning sets are contained in passed in array
    public boolean containsWinningSet(int[] markArray)
    {
        boolean rv = false;
        final int NUMBER_OF_WINNING_SETS = 8;
        Set<Integer> moveSet = Arrays.stream(markArray).boxed().collect(Collectors.toSet());//converts array to set
        Map winningMovesMap = new HashMap<String, HashSet<Integer>>();//create map of String to Set
        winningMovesMap.put("zeroOneTwo",new HashSet(Arrays.asList(0,1,2)));
        winningMovesMap.put("threeFourFive",new HashSet(Arrays.asList(3,4,5)));
        winningMovesMap.put("sixSevenEight",new HashSet(Arrays.asList(6,7,8)));
        winningMovesMap.put("zeroThreeSix",new HashSet(Arrays.asList(0,3,6)));
        winningMovesMap.put("oneFourSeven",new HashSet(Arrays.asList(1,4,7)));
        winningMovesMap.put("twoFiveEight",new HashSet(Arrays.asList(2,5,8)));
        winningMovesMap.put("zeroFourEight",new HashSet(Arrays.asList(0,4,8)));
        winningMovesMap.put("twoFourSix",new HashSet(Arrays.asList(2,4,6)));
        //iterate through map and determine if moveSet is contained in map
        for(  Object currSet : winningMovesMap.values())
        {
            HashSet currWinningSet = (HashSet<Integer>)currSet;
            if(moveSet.containsAll(currWinningSet)== true)
            {
                rv = true;
                break;
            }
        }
        //declare winning sets
//        HashSet zeroOneTwo = new HashSet(Arrays.asList(0,1,2));
//        HashSet threeFourFive = new HashSet(Arrays.asList(3,4,5));
//        HashSet sixSevenEight = new HashSet(Arrays.asList(6,7,8));
//        HashSet zeroThreeSix = new HashSet(Arrays.asList(0,3,6));
//        HashSet oneFourSeven = new HashSet(Arrays.asList(1,4,7));
//        HashSet twoFiveEight = new HashSet(Arrays.asList(2,5,8));
//        HashSet zeroFourEight = new HashSet(Arrays.asList(0,4,8));
//        HashSet twoFourSix = new HashSet(Arrays.asList(2,4,6));
//        //create arrayList and add sets to array
//        ArrayList winningSetList =  new ArrayList();
//        winningSetList.add(zeroOneTwo);
//        winningSetList.add(threeFourFive);
//        winningSetList.add(sixSevenEight);
//        winningSetList.add(zeroThreeSix);
//        winningSetList.add(oneFourSeven);
//        winningSetList.add(twoFiveEight);
//        winningSetList.add(zeroFourEight);
//        winningSetList.add(twoFourSix);
//        //itertate through array of winning sets and check if each set is s subset of a winning array
//        for(int i =0;i<winningSetList.size();i++)
//        {
//            HashSet winningSet =(HashSet<Integer>)winningSetList.get(i);
//            if(moveSet.containsAll(winningSet))
//            {
//                rv = true;
//            }
//        }

        return rv;
    }



    public static void main(String[] args)
    {
        TicTacToeBoard ttt = new TicTacToeBoardImpl_Sychev();

        ttt.setMark(0, 0); //0
        ttt.setMark(1, 0); //3
        ttt.setMark(0, 1); //1
        ttt.setMark(1, 1); //4
        ttt.setMark(0, 2); //2
        Mark Test = ttt.getMark(0,2);




    }


}
