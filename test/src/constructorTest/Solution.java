package constructorTest;


public class Solution
{
    public static void main(String[] args)
    {
        new B();
    }

    static class A
    {
        {
            System.out.println("non-static initialize");
        }
        static
        {
            System.out.println("static initialize");
        }

        public A()
        {
            System.out.println("class A");
        }
    }

    static class B extends A
    {
        public B()
        {
            System.out.println("class B");
        }
    }
}
