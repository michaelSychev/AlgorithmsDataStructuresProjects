package tictactoe;

public class comparingObjects
{
    public Mark numberEqualNumber(int a, int b)
    {
        Mark rv   = null; //default to false
        if(a == b)
        {
            rv = Mark.O;
        }
        return rv;
    }
    public static void main(String[] args)
    {
        comparingObjects o1 = new comparingObjects();
        if(Mark.X == o1.numberEqualNumber(0,0))
        {
            System.out.println("the clauses are equal");
        }
    }
}
