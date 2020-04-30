package pack1;

public class User3 implements Talk
{
    private String firstName;
    private String lastName;

    enum status {active, inactive, probation};
    status status;

    void methodVersion()
    {
        System.out.println("User version!");
    }

    User3(){}

    User3(String fn, String ln)
    {
        firstName = fn;
        lastName = ln;
    }

    void displayName()
    {
        System.out.println(firstName + " " + lastName);
    }

    public void sayHi()
    {
        System.out.println("User3 implementing Talk!");
    }

    final void finalMethod()
    {
        System.out.println("Hey, I'm a final method! You can never override me.");
    }
}
