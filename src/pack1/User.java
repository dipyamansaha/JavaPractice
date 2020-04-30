package pack1;

import java.util.List;
import java.util.Objects;

class User
{
    private String firstName;
    private String lastName;

    String getFullName()
    {
        return firstName + " " + lastName;
    }

    String getFirstName()
    {
        return firstName.toUpperCase();
    }

    void setFirstName(String n1)
    {
        firstName = n1;
    }

    String getLastName()
    {
        return lastName.toUpperCase();
    }

    void setLastName(String n2)
    {
        lastName = n2;
    }

    static void printUser(User u)
    {
        System.out.println(u.getFullName());
    }

    static void printUsers(List<User> users)
    {
        for(User u: users)
        {
            System.out.println(u.getFullName());
        }
    }

    static User findUser(List<User> users, User u)
    {
        for (User user: users)
        {
            if(user.equals(u))
            {
                return user;
            }
        }
        return null;
    }

    static int searchList(List<User> users, User u)
    {
        return searchList(users, u.getFullName());
    }

    static int searchList(List<User> users, String fn, String ln)
    {
        return searchList(users, (fn + " " + ln));
    }

    static int searchList(List<User> users, String fullName)
    {
        for(int i = 0; i < users.size(); i++)
        {
            if(users.get(i).getFullName().equals(fullName))
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) &&
                lastName.equals(user.lastName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(firstName, lastName);
    }
}