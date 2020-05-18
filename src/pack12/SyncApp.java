// MULTI-THREADING

package pack12;

class Printer
{
    //synchronized void printDocuments(int numOfCopies, String docName)
    void printDocuments(int numOfCopies, String docName)
    {
        for(int i = 1; i <= numOfCopies; i++)
        {
            try
            {
                Thread.sleep(500);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }

            System.out.println(">> Printing " + docName + " " + i);
        }
    }
}

class MyThread extends Thread
{
    Printer pRef;

    MyThread(Printer p)
    {
        pRef = p;
    }

    @Override
    public void run()
    {
        synchronized(pRef)
        {
            pRef.printDocuments(10, "HagridsProfile.pdf");
        }
    }
}

class YourThread extends Thread
{
    Printer pRef;

    YourThread(Printer p)
    {
        pRef = p;
    }

    @Override
    public void run()
    {
        synchronized(pRef)
        {
            pRef.printDocuments(10, "SlughornsProfile.pdf");
        }
    }
}

public class SyncApp
{
    // 'main' is representing the 'main' thread.
    public static void main(String[] args)
    {
        System.out.println("----Application started----");

        // We have only one object of 'Printer'.
        Printer printer = new Printer();
        // printer.printDocuments(10, "LunasProfile.pdf");

        // Multiple threads are working on the same 'Printer' object.
        // If multiple threads are working on the same object, we must synchronise them.
        MyThread mRef = new MyThread(printer); // 'MyThread' is having a reference to the 'Printer' object.
        YourThread yRef = new YourThread(printer); // 'YourThread' is also having a reference to the 'Printer' object.

        mRef.start();
        /* try
        {
            mRef.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        } */

        yRef.start();

        System.out.println("----Application ended----");
    }
}