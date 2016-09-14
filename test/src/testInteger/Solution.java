package testInteger;


public class Solution extends Exception
{
    public static void main(String[] args)
    {
        Integer first = 5;
        Integer two = 5;
        if (first == two)  System.out.println(first + " = " + two);

        first = 130;
        two = 130;
        /*if (first == two)*/  System.out.println(first.hashCode() + " = " + two.hashCode());
        //if (first.equals(two))  System.out.println(first + " = " + two);

        int five = 5;
        //if (five instanceof Object)  System.out.println(first + " = " + two);
    }

    private interface sad
    {

    }
}
