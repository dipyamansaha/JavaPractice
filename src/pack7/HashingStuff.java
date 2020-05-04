package pack7;

import java.util.HashMap;
import java.util.HashSet;

public class HashingStuff
{
    public static void main(String[] args)
    {
        HashSet<String> words = new HashSet<String>();
        words.add("hello");
        words.add("bye");
        words.add("hello");
        words.add("bye");
        words.add("abc");
        words.add("xyz");
        words.add("xyz");
        words.add("pqr");
        words.add("efg");
        words.add("uvw");

        for(String s: words)
        {
            System.out.println(s);
        }

        System.out.println(words.contains("xyz"));

        Person p = new Person("email@email.com", "Kubrick");
        Position pos1 = new Position(10, 10);
        p.position = pos1;

        Person q = new Person("email@email.com", "Kubrick");
        Position pos2 = new Position(10, 10);
        q.position = pos2;

        System.out.println(p.equals(q));

        System.out.println(p.hashCode());
        System.out.println(q.hashCode());

        HashSet<Person> people = new HashSet<Person>();
        people.add(p);
        people.add(q);

        System.out.println(people.contains(p));

        Person newPerson = new Person("email@email.com", "Kubrick");
        Position newPos = new Position(10, 10);
        newPerson.position = newPos;

        System.out.println("HashSet: " + people.contains(newPerson));
        HashMap<String, Person> peeps = new HashMap<String, Person>();
        peeps.put("email@email.com", newPerson);
        System.out.println("HashMap: " + peeps.containsKey("email@email.com"));
    }
}