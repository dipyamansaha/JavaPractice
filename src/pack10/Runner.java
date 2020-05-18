// Comparable AND Comparator

package pack10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner
{
    public static void main(String[] args)
    {
        List<Laptop> laps = new ArrayList<>();

        laps.add(new Laptop("Dell", 16, 800));
        laps.add(new Laptop("Apple", 8, 1200));
        laps.add(new Laptop("Acer", 12, 700));

        System.out.println("Sorting by 'ram': ");

        Collections.sort(laps);

        for(Laptop l : laps)
            System.out.println(l);

        System.out.println("\nSorting by 'price': ");

        Comparator<Laptop> com = new Comparator<Laptop>()
        {
            @Override
            public int compare(Laptop lp1, Laptop lp2)
            {
                if(lp1.getPrice() > lp2.getPrice())
                    return 1;

                return -1;
            }
        };

        Collections.sort(laps, com);

        for(Laptop l : laps)
            System.out.println(l);
    }
}