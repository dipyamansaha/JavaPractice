package pack1;

public class Student2 extends User3 implements Talk
{
    @Override
    void methodVersion()
    {
        System.out.println("Student version!");
        super.methodVersion();
    }

    Student2(){}

    Student2(String fn, String ln)
    {
        super(fn, ln);
    }

    @Override
    public void sayHi()
    {
        System.out.println("Student2 implementing Talk!");
    }
}
