package pack1;

class Student extends User2
{
    boolean verified = true;
    String major;

    Student()
    {
        System.out.println("Creating a student...");
    }

    public Student(String f, String l)
    {
        fName = f;
        lName = l;
    }

    @Override
    void sayHello2()
    {
        System.out.println("Hi! I'm a student. My major is " + major + ". My name is " + fName + " " + lName + ".");
    }
}
