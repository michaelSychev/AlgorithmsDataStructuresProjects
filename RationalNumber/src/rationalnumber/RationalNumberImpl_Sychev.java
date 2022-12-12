package rationalnumber;
import java.lang.Math;
public class RationalNumberImpl_Sychev implements RationalNumber
{
    private int m_reducedrawNumerator;
    private int m_reducedrawDenimonator;
    //pre:takes two ints
    //post:returns reduced rational number a/b
    public RationalNumberImpl_Sychev(int rawNumerator, int rawDenominator)
    {
        assert rawDenominator !=0: "Cant have rawDenimonator = 0";
        this.m_reducedrawNumerator = rawNumerator;
        this.m_reducedrawDenimonator = rawDenominator;
        //reduction
        final int copyrawNumerator = m_reducedrawNumerator;//create copy of raw numerator and raw denominator
        final int copyrawDenimonator = m_reducedrawDenimonator;
        int lcm = getGCF(copyrawNumerator,copyrawDenimonator);//insert copies into euclidean algorithm to find lcm
        m_reducedrawNumerator = m_reducedrawNumerator/lcm;//divide lcm from num and denom to reduce numbers
        m_reducedrawDenimonator = m_reducedrawDenimonator/lcm;
        //format negatives
        if(m_reducedrawNumerator<0 || m_reducedrawDenimonator<0)//if either number is negative we check formatting
        {
            if(m_reducedrawNumerator<0 && m_reducedrawDenimonator>0)//if exclusively num < 0
            {
                //we do nothing, this is preferred format
            }
            else if(m_reducedrawNumerator>0 && m_reducedrawDenimonator<0)//if exclusively denom < 0
            {
                m_reducedrawNumerator = m_reducedrawNumerator *-1;//mutliply both numbers by -1 to move - to rawNumerator
                m_reducedrawDenimonator = m_reducedrawDenimonator*-1;
            }
            //if both are negative the number is positive and needs no negative formatting
        }

    }


    @Override
    public int getNumerator()
    {
        return m_reducedrawNumerator;
    }

    @Override
    public int getDenominator()
    {
        return m_reducedrawDenimonator;
    }

    @Override
    public double getValue()
    {
        double rv = (double)getNumerator()/getDenominator();
        return rv;
    }
    @Override
    public String toString()
    {
        return String.valueOf(m_reducedrawNumerator)+"/"+String.valueOf(m_reducedrawDenimonator);
    }
    //pre:none
    //post:returns most simplified form of rational number a/b
    public static int getGCF(int a,int b)
    {
        if (a == 0)
        {
            return b;
        }

        return getGCF(b%a, a);
    }


    public static void main(String[] args)
    {
        RationalNumberImpl_Sychev object1 = new RationalNumberImpl_Sychev(2,1);
        RationalNumberImpl_Sychev object2 = new RationalNumberImpl_Sychev(1,0);

        System.out.println(RationalNumberUtils_Sychev.multiply(object1,object2));

    }
}
