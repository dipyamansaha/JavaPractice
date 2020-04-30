package pack2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyCuteProgram
{
    void inputFromFile() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("src/students.txt"));

        while (sc.hasNextLine())
        {
            System.out.println(sc.nextLine());
        }

        sc.close();
    }

    void inputFromFile2() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("src/students2.txt"));

        List<String> students2 = new ArrayList<String>();

        while(sc.hasNextLine())
        {
            students2.add(sc.nextLine());
        }

        for(int i = 0; i < students2.size(); i++)
        {
            System.out.println("Name-" + (i+1) + ": " + students2.get(i));
        }

        sc.close();
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        MyCuteProgram myCuteProgram = new MyCuteProgram();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1: inputFromFile()");
        System.out.println("Enter 2: inputFromFile2()");
        System.out.println("Enter 3: ");
        System.out.println("Enter 4: ");
        System.out.println("Enter 5: ");
        System.out.println("Enter 6: ");
        System.out.println("Enter 7: ");
        System.out.println("Enter 8: ");
        System.out.println("Enter 9: ");
        System.out.println("Enter 10: ");
        System.out.println("Enter 11: ");
        System.out.println("Enter 12: ");

        int num = sc.nextInt();

        switch(num)
        {
            case 1:
                System.out.println("Calling Method-1... \n");
                myCuteProgram.inputFromFile();
                break;

            case 2:
                System.out.println("Calling Method-2... \n");
                myCuteProgram.inputFromFile2();
                break;

            default:
                System.out.println("\nTry again later!\n");
        }
    }
}
