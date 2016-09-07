package setTest;


import java.util.HashSet;

public class setTest
{
    public static void main(String[] args)
    {
        HashSet<Cat> set = new HashSet<>();

        Cat one = new Cat("maks", 16);
        Cat two = new Cat("sharik", 5);

        set.add(one);
        set.add(two);

        int hashOne = one.hashCode();
        boolean isContains =fazcazscv set.contains(one);

        one.age = 100;

        int hashOne2 = one.hashCode();
        boolean isContains2 = set.contains(one);
    }
}
