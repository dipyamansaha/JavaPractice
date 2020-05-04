package pack6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class CollectionStuff
{
    public static void main(String[] args)
    {
        //Jagged array
        int[][] ages = new int[5][3];
        ages[0] = new int[10];
        ages[1] = new int[7];
        System.out.println(Arrays.deepToString(ages));

        //ArrayList
        ArrayList<Integer> ages2 = new ArrayList<Integer>();
        ages2.add(9);
        System.out.println(ages2.get(0));

        //hashCode
        String s = "Hello";
        String t = "Hello";
        Object u = "Bye";
        System.out.println(s.hashCode());
        System.out.println(t.hashCode());
        System.out.println(u.hashCode());
        System.out.println(s.equals(t));
        System.out.println(t.equals(u));

        //HashMap
        HashMap<String, Integer> ids = new HashMap<String, Integer>();
        ids.put("Jack", 5);
        ids.put("Wendy", 345);
        System.out.println(ids.get("Wendy"));

        ids.put("Wendy", ids.get("Wendy") + 1);
        System.out.println(ids.get("Wendy"));

        ids.put("Danny", ids.getOrDefault("Danny", 0) + 1);
        System.out.println(ids.get("Danny"));

        Set<String> keys = ids.keySet();
        for(String key: keys)
        {
            System.out.println(key + ": " + ids.get(key));
        }
    }
}