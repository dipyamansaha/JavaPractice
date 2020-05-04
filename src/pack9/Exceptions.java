package pack9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Exceptions
{
    public static void main(String[] args)
    {
        try
        {
            int number = Integer.parseInt("Pizza");
        }
        catch(NumberFormatException e)
        {
            System.out.println("Caught the NumberFormatException!");
            e.printStackTrace();
        }

        try
        {
            ArrayList<Integer> x = new ArrayList<Integer>();
            x.get(5);
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println("Caught the IndexOutOfBoundsException!");
            e.printStackTrace();
        }

        doSomething();

        throwOwnException();
    }

    static void doSomething()
    {
        try
        {
            FileInputStream f = new FileInputStream("");
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Caught the FileNotFoundException!");
            e.printStackTrace();
        }
    }

    static void throwOwnException()
    {
        try
        {
            throw new IOException();
        }
        catch(IOException e)
        {
            System.out.println("Caught the IOException (more specific)!");
            e.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("Caught ya!");
            e.printStackTrace();
        }
        finally
        {
            System.out.println("I'm always gonna be executed anyway.");
        }
    }
}
