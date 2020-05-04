package pack8;

import java.util.ArrayList;
import java.util.List;

public class GenericStuff
{
    public static void main(String[] args)
    {
        Pair<Person, Person> pair = new Pair<Person, Person>();
        Person p = new Person("hello", "hello");
        pair.setX(p);
        pair.setY(p);

        Person p2 = pair.getX();

        Pair<Integer, String> pair2 = new Pair<Integer, String>();
        pair2.setX(5);
        pair2.setY("Favourite number");

        Pair<Integer, String> pair3 = new Pair<Integer, String>();
        pair2.setX(10);
        pair2.setY("Number of neighbours");

        ArrayList<Pair<Integer, String>> pears = new ArrayList<Pair<Integer, String>>();
        pears.add(pair2);
        pears.add(pair3);

        ArrayList<Person> people = new ArrayList<Person>();
        Admin a = new Admin();
        people.add(a);

        doSomething(a);

        ArrayList<Admin> admins = new ArrayList<Admin>();

        ArrayList<Person> adminsP = new ArrayList<Person>();

        for(Admin admin: admins)
        {
            adminsP.add((Person)admin);
        }

        doSomething(adminsP);

        ArrayList<Admin> admins2 = new ArrayList<Admin>();

        doSomething2(admins2);

        Admin b = new Admin();
        b.email = "fredo@corleone.com";
        b.lastName = "Corleone";

        ArrayList<Admin> myAdmins = new ArrayList<Admin>();
        myAdmins.add(b);

        List<Person> myPeeps = (List<Person>)(List<?>)myAdmins;

        doSomething3(myPeeps);
    }

    static void doSomething(Person p)
    {
        System.out.println(p);
    }

    static void doSomething(ArrayList<Person> peeps)
    {
        System.out.println(peeps);
    }

    static void doSomething2(ArrayList<? extends Person> peeps)
    {
        System.out.println(peeps);
    }

    static void doSomething3(List<Person> peeps)
    {
        for(Person p: peeps)
        {
            System.out.println(p.email + " ---- " + p.lastName);
        }
    }
}