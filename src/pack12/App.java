// THREADS

package pack12;

// Regular class 'MyTask'.
/* class MyTask
{
    void executeTask()
    {
        for(int doc = 1; doc <= 10; doc++)
            System.out.println("Printing document #" + doc + " - Printer 2");
        System.out.println();
    }
} */

// 'MyTask' is now a thread - First way.
/* class MyTask extends Thread
{
    @Override
    public void run()
    {
        for(int doc = 1; doc <= 10; doc++)
            System.out.println("Printing document #" + doc + " - Printer 2");
    }
} */

// Random class.
class C{}

// MyTask extends C, Thread{} - Error: Multiple inheritance isn't supported in Java.
// 'MyTask' is now a thread - Second way.
class MyTask extends C implements Runnable
{
    @Override
    public void run()
    {
        for(int doc = 1; doc <= 10; doc++)
            System.out.println("Printing document #" + doc + " - Printer 2");
    }
}

// Another thread.
class YourTask implements Runnable
{
    @Override
    public void run()
    {
        for(int doc = 1; doc <= 10; doc++)
            System.out.println("Printing document #" + doc + " - Printer 3");
    }
}

public class App
{
    // The 'main' method represents the 'main' thread.
    public static void main(String[] args)
    {
        // Whatever we write in here will be executed by the 'main' thread.
        // Threads always execute the jobs in a sequence.
        // Execution context.

        // Job 1
        System.out.println("----Application started----");

        // Job 2
        MyTask myTask = new MyTask(); // 'Child' thread / 'Worker' thread.
        /* myTask.executeTask(); */
        // Till Job 2 is not finished, the below written jobs are waiting and are not executed.
        /* In case Job 2 is a long-running operation, i. e., several documents are supposed to be printed,
           OS/JVM shall give a message that the app is not responding. */
        // Some sluggish behaviour in the app is observed - App seems to hang.

        /* myTask.start(); */ // 'start' internally executes the 'run' method.
        // Now, 'main' and 'MyTask' are both executing parallelly or concurrently!

        Runnable r = new MyTask();
        Thread t = new Thread(r);
        t.setDaemon(true); // Setting the thread 't' as the 'daemon' thread. - Will be executed
        t.start();         // by the JVM whenever the application starts. JVM will execute the
                           // thread 't' along with the 'main' thread.

        new Thread(new YourTask()).start(); // Calling in a single statement.

        // Job 3
        // Some code to print some documents.
        for(int doc = 1; doc <= 10; doc++)
            System.out.println("Printing document #" + doc + " - Printer 1");

        // Job 4
        System.out.println("----Application ended----");
    }
}