package pack1;

public class Teacher2 extends User3 implements Talk
{
    @Override
    void methodVersion()
    {
        System.out.println("Teacher version!");
        super.methodVersion();
    }

    @Override
    public void sayHi()
    {
        System.out.println("Teacher2 implementing Talk!");
    }
}
