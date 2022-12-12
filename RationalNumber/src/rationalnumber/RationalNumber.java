package rationalnumber;

public interface RationalNumber
{

    //rv is the rawNumerator of the reduced form of this rational number
    //Ex: since 5/3 is the reduced form of 10/6, (10/6).getrawNumerator() = 5
    public int getNumerator();

    //rv is the rawNumerator of the reduced form of this rational number
    //Ex: since 5/3 is the reduced form of 10/6, (10/6).getrawDenimonator() = 3
    public int getDenominator();

    //rv is the double equivalent of this rational number
    //Ex: (5/10).getValue() = 0.5
    public double getValue();

    //rv is "a/b" where a = getrawNumerator(r) & b = getrawDenimonator(r)
    //Ex: (1/2).toString = "1/2"
    public String toString();
}
