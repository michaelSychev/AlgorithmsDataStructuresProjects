package rationalnumber;

public class RationalNumberUtils_Sychev
{
    //rv is true when both rational numbers are of equal value
    //ex: 2/4 and 6/12 returns true becuase both are 0.5
    public static boolean equal(RationalNumber r1, RationalNumber r2)
    {
        assert r1!=null && r2!=null:"Cannot input null value";
        boolean rv = false;
        if(r1.getValue() == r2.getValue())
        {
            rv = true;
        }
        return rv;
    }

    //rv = r1+r2, where + is regular numerical addition
    public static RationalNumber add(RationalNumber r1, RationalNumber r2)//given a/b + c/d simplifies to ad+cb/bd
    {
        assert r1!=null && r2!=null:"Cannot input null value";
        assert r1.getDenominator()!=0 && r2.getDenominator()!=0:"cant divide by 0";
        int rawNumerator =   (  r1.getNumerator()  *  r2.getDenominator() )  +  (r2.getNumerator()  *  r1.getDenominator());
        int rawDenimonator = (r1.getDenominator()*r2.getDenominator());
        return new RationalNumberImpl_Sychev(rawNumerator,rawDenimonator);
    }

    //rv = r1-r2 where - is regular numerical subtraction
    public static RationalNumber subtract(RationalNumber r1, RationalNumber r2)//given a/b - c/d simplifies to ad-cb/bd
    {
        assert r1!=null && r2!=null:"Cannot input null value";
        assert r1.getDenominator()!=0 && r2.getDenominator()!=0:"cant divide by 0";
        int rawNumerator =   (  r1.getNumerator()  *  r2.getDenominator() )  -  (r2.getNumerator()  *  r1.getDenominator());
        int rawDenimonator = (r1.getDenominator()*r2.getDenominator());
        return new RationalNumberImpl_Sychev(rawNumerator,rawDenimonator);
    }

    //rv = r1*r2 where * is regular numerical multiplication
    public static RationalNumber multiply(RationalNumber r1, RationalNumber r2)//given a/b*c/d simplifies to ac/bd
    {
        assert r1!=null && r2!=null:"Cannot input null value";
        assert r1.getDenominator()!=0 && r2.getDenominator()!=0:"cant divide by 0";
        int rawNumerator =   (r1.getNumerator()*r2.getNumerator());
        int rawDenimonator = (r1.getDenominator()*r2.getDenominator());
        return new RationalNumberImpl_Sychev(rawNumerator,rawDenimonator);
    }

    //rv = r1/r2 where / is regular numerical division
    //pre:r2 cant be 0 and neither number can be null
    //post:returns r1/r2
    public static RationalNumber divide(RationalNumber r1, RationalNumber r2)//calls multiplication with r2's reciprocal
    {
        assert r1!=null && r2!=null:"Cannot input null value";
        assert r1.getDenominator()!=0 && r2.getDenominator()!=0:"cant divide by 0";
        assert r2.getValue()!=0: "Cant divide by zero!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
        RationalNumberImpl_Sychev reciprocalR2 = new RationalNumberImpl_Sychev(r2.getDenominator(),r2.getNumerator());
        return multiply(r1,reciprocalR2);
    }
    //pre:if a or b have negative value, a must hold negative value at time of call
    //rv = -r1 where - is regular numerical negation
    public static RationalNumber negate(RationalNumber r1)
    {
        assert r1.getDenominator()!=0 :"cant divide by 0";
        assert r1!=null:"Cannot input null value";
        int rawNumerator = r1.getNumerator()*-1;
        int rawDenimonator = r1.getDenominator();
        return new RationalNumberImpl_Sychev(rawNumerator,rawDenimonator);
    }

}
