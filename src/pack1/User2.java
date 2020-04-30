package pack1;

abstract class User2
{
    String fName;
    String lName;
    boolean verified = false;

    void sayHello()
    {
        System.out.println("Hi! I'm a user. My name is " + fName + " " + lName + ".");
    }

    abstract void sayHello2();
}
