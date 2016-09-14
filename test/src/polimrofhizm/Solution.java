package polimrofhizm;


import java.util.HashSet;

public class Solution
{
    public static void main(String[] args)
    {
        //Pet pet = new Cat();

        //Cat cat = new Pet(); //cant compile
        HashSet<Pet> hashSet = new HashSet<>();
        hashSet.add(new Pet(2));
        hashSet.add(new Pet(3));
    }
}

class Pet
{
    int age;

    public Pet(int age) {
        this.age = age;
    }

    public void petMethod()
    {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        return age == pet.age;

    }

    @Override
    public int hashCode() {
        return age;
    }
}

class Cat extends Pet
{
    public Cat(int age) {
        super(age);
    }

    public void catMethod()
    {

    }
}

class A { }
class B extends A { }
class C extends B {
    public static void main(String[] args)
    {
        A obj1 = new A();
        C obj2 = new C();
        obj1 = (B) obj2;
        C obj3 = (C)obj1;
    }
}


