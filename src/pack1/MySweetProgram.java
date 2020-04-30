package pack1;
import java.util.*;

public class MySweetProgram
{
    void stringToIntConversion()
    {
        System.out.print("Enter an integer as a string: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println("Entered string: " + str);

        System.out.println("\nConverting the String to an Integer...");
        System.out.println("Object integer (Integer): " + Integer.valueOf(str));
        System.out.println("Primitive integer (int): " + Integer.parseInt(str));
    }

    void objectOperations()
    {
        User user = new User();
        user.setFirstName("Barry");
        user.setLastName("Allen");
        System.out.println(user.getFullName());
        System.out.println();

        User user1, user2;
        user1 = new User();
        user1.setFirstName("Wall.E");
        user1.setLastName("- Earth");
        user2  = new User();
        user2.setFirstName("Eve");
        user2.setLastName("- Axiom");

        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        System.out.println(users.get(0).getFullName() + " & " + users.get(1).getFullName());

        String[] firstNames = {"Travis", "Michael", "Andy", "Trevor"};
        String[] lastNames = {"Bickle", "Corleone", "Dufresne", "Reznik"};

        List<User> userNames = new ArrayList<User>();

        for(int i = 0; i < firstNames.length; i++)
        {
            User u = new User();
            u.setFirstName(firstNames[i]);
            u.setLastName(lastNames[i]);
            userNames.add(u);
        }

        for(User u: userNames)
        {
            System.out.println(u.getFullName());
        }

        User.printUsers(userNames);

        System.out.println("Andy Dufresne is found at index: " + User.searchList(userNames, "Andy", "Dufresne"));
        System.out.println("Michael Corleone is found at index: " + User.searchList(userNames, userNames.get(1)));
        System.out.println("The user is: " + User.findUser(userNames, userNames.get(3)));
    }

    void printUserPassingObject(User u)
    {
        System.out.println(u.getFullName());
    }

    void stringOperations()
    {
        String str = new String("Hey!\\nHow\\tyou\\bdoin'!?");
        System.out.println("String str (containing special characters): " + str);

        String name = "Dipyaman";
        System.out.println(String.format("Hello, %s!\nLength of name: %d", name, name.length()));
        Scanner sc = new Scanner(System.in);

        String str2 = "Yummmm... my oh my chicken pot pie!";
        String str2_1 = " Now with 20% more chicken.";
        String FullStr2 = str2.concat(str2_1);
        String fullStr2 = str2 + str2_1;
        System.out.println(FullStr2);
        System.out.println(fullStr2);
        System.out.println("Last letter in the string str2: " + FullStr2.charAt(str2.length() - 1));
        System.out.println(FullStr2.contains("with"));
        System.out.println(FullStr2.indexOf("my"));
        System.out.println(FullStr2.indexOf("my", FullStr2.indexOf("my") + 1));
        System.out.println(FullStr2.lastIndexOf("my"));
        System.out.println(FullStr2.toUpperCase());
        System.out.println(FullStr2.toLowerCase());
        String str3 = new String("\nYummmm... \tmy oh my chicken pot pie! Now with 20% more chicken.     ");
        System.out.println(str3.strip());
        System.out.println(str3.stripLeading());
        System.out.println(str3.stripTrailing());
        System.out.println(str3.substring(12));
        System.out.println(str3.substring(12,20));
        System.out.println(str3.repeat(50));
        System.out.println(str3.equals("Hello"));
        String str3Dup = str3;
        String str3Dup2 = new String("\nYummmm... \tmy oh my chicken pot pie! Now with 20% more chicken.     ");
        System.out.println(str3Dup.equals(str3));
        System.out.println(str3Dup2.equals(str3));
        System.out.println(str3Dup == str3);
        System.out.println(str3Dup2 == str3);
    }

    void array1DOperations()
    {
        int[] grades = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[][] grades2 = {{1, 2, 3}, {4, 5, 6, 7, 8, 9, 10}};
        System.out.println(grades);
        System.out.println(Arrays.toString(grades));
        System.out.println(grades2);
        System.out.println(Arrays.toString(grades2));
        System.out.println(Arrays.deepToString(grades2));

        int[] grades3 = new int[10];
        System.out.println(grades3);
        System.out.println(Arrays.toString(grades3));
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the required size of the array: ");
        int size = sc.nextInt();
        grades3 = new int[size];
        int[] grades3_Copy = new int[size];
        System.out.println("Enter the array-elements: ");
        for(int i = 0; i < grades3.length ; i++)
        {
            grades3[i] = grades3_Copy[i] = sc.nextInt();
        }
        System.out.println(":" + Arrays.toString(grades3));
        System.out.println(Arrays.toString(grades3_Copy));

        Arrays.sort(grades3);
        System.out.println("Sorted array - grades3: " + Arrays.toString(grades3));
        Arrays.parallelSort(grades3_Copy);
        System.out.println("Parallelly sorted array - grades3: " + Arrays.toString(grades3_Copy));
        System.out.print("Let's search for the integer 7: ");
        System.out.println("Found at index " + Arrays.binarySearch(grades3, 7) + "!");

        if(Arrays.equals(grades3, grades3_Copy))
            System.out.println("Arrays are equal!");

        String[] strArr = new String[5];
        System.out.println("Initial String array: " + Arrays.toString(strArr));
        Arrays.fill(strArr, "");
        System.out.println("Filled String array: " + Arrays.toString(strArr));
        
        List<String> testing = Arrays.asList(strArr);
        System.out.println(testing);
        System.out.println(Arrays.toString(testing.toArray()));
    }

    void array2DOperations()
    {
        int[][] grades =
                {
                    {1, 5, 3},
                    {8, 4, 2, 9, 15, 11},
                    {4, 6, 2},
                    {},
                    {14}
                };

        System.out.println(grades);
        System.out.println(grades[1][1]);
        System.out.println(grades[1][4]);
        System.out.println(Arrays.deepToString(grades));
        System.out.println(grades.length);
        System.out.println(grades[1].length);

        for(int row = 0; row < grades.length; row++)
        {
            for(int col = 0; col < grades[row].length; col++)
            {
                System.out.print(grades[row][col] + "\t");
            }
            System.out.println();
        }
    }

    void arrayListOperations()
    {
        List<Integer> grades = new ArrayList<Integer>();
        grades.add(5);
        grades.add(10);
        System.out.println(grades.get(1));
        grades.add(1, 7);
        System.out.println(grades);
        System.out.println(grades.get(0));
        System.out.println(grades.get(1));
        System.out.println(grades.get(2));
        System.out.println(grades.indexOf(7));
        System.out.println(grades.indexOf(70));
        System.out.println(grades.contains(7));
        System.out.println(grades.isEmpty());
        System.out.println(grades.remove(0));
        System.out.println(grades.get(0));
        System.out.println(grades.get(1));
        grades.clear();
        System.out.println(grades);

        List<Integer> grades2 = Arrays.asList(5, 3, 2, 6, 4);
        System.out.println(grades2);
        System.out.println(Arrays.toString(grades2.toArray()));

        for(int i = 0; i < grades2.size(); i++)
        {
            grades2.set(i, grades2.get(i)*2);
            System.out.println(grades2.get(i));
        }

        for(int grade: grades2)
        {
            System.out.println(grade);
        }

        System.out.println(grades2);
        int[] grades2_int = new int[grades2.size()];
        for(int i = 0; i < grades2_int.length; i++)
        {
            grades2_int[i] = grades2.get(i);
        }
        System.out.println(grades2_int);
        System.out.println(Arrays.toString(grades2_int));

        List<List<Integer>> allGrades = new ArrayList<List<Integer>>();
        allGrades.add(Arrays.asList(33, 11, 77, 55, 44));
        allGrades.add(Arrays.asList(333, 111, 777, 555, 444));
        allGrades.add(Arrays.asList(3333, 1111, 7777, 5555, 4444));

        for(List<Integer> gradeRows: allGrades)
        {
            for(int grade: gradeRows)
            {
                System.out.print(grade + "\t");
            }
            System.out.println();
        }

        Collections.sort(grades2);
        System.out.println(grades2);
        Collections.reverse(grades2);
        System.out.println(grades2);
    }

    void overriddenCalls()
    {
        User me = new User();
        me.setFirstName("Dipyaman");
        me.setLastName("Saha");
        System.out.println(me); //implicitly calls the 'toString()' method

        User you = new User();
        you.setFirstName("Alexandra");
        you.setLastName("Daddario");
        System.out.println(you.equals(me));
        System.out.println(me.hashCode() == you.hashCode());
    }

    void inheritanceStuff()
    {
        Student s = new Student();
        s.major = "Moustache Design";
        System.out.println(s.major);

        Student s2 = new Student();
        s2.major = "Beard Design";
        s2.fName = "Bryan";
        s2.lName = "Cranston";
        s2.sayHello();

        Student s3 = new Student();
        s3.major = "Hair Design";
        s3.fName = "Aaron";
        s3.lName = "Paul";
        s3.sayHello2();

        Teacher t = new Teacher();
        t.fName = "Teach";
        t.lName = "er";

        List<User2> users = new ArrayList<User2>();
        users.add(s2);
        users.add(t);

        for(User2 u: users)
        {
            u.sayHello2();
        }

        Student s4 = new Student("Arthur", "Fleck");
        System.out.println(s4.fName + " " + s4.lName);

        User3 user = new User3();
        Student2 s1 = new Student2();
        Teacher2 t1 = new Teacher2();
        user.methodVersion();
        s1.methodVersion();
        t1.methodVersion();

        Student2 s6 = new Student2("Tony", "Stark");
        s6.displayName();
    }

    void interfaceStuff()
    {
        Student2 s = new Student2("Hannibal", "Lecter");
        List<Talk> thingsThatTalk = new ArrayList<Talk>();
        thingsThatTalk.add(s);
        s.methodVersion();
        s.displayName();
        s.sayHi();
    }

    void finalStuff()
    {
        User3 u = new User3();
        u.finalMethod();
        Student2 s = new Student2();
        s.finalMethod();
        Teacher2 t = new Teacher2();
        t.finalMethod();

        Test test = new Test();
        test.finalClassMethod();
    }

    void enumOperations()
    {
        User3 user = new User3();
        user.status = user.status.inactive;
        System.out.println(user.status);

        switch(user.status)
        {
            case active -> System.out.println("Great!");
            case inactive -> System.out.println("Come back!");
            case probation -> System.out.println("Ouch!");
            default -> System.out.println("Duh.");
        }
    }

    public static void main(String[] args)
    {
        MySweetProgram mySweetProgram = new MySweetProgram();
        Scanner sc = new Scanner(System.in);

        User user = new User();
        user.setFirstName("Dipyaman");
        user.setLastName("Saha");
        System.out.println(user.getFirstName() + " " + user.getLastName() + "'S CODE...\n");

        System.out.println("Enter 1: stringToIntConversion()");
        System.out.println("Enter 2: stringOperations()");
        System.out.println("Enter 3: objectOperations()");
        System.out.println("Enter 4: printUserPassingObject(), static method printUser()");
        System.out.println("Enter 5: array1DOperations()");
        System.out.println("Enter 6: array2DOperations()");
        System.out.println("Enter 7: arrayListOperations()");
        System.out.println("Enter 8: overriddenCalls()");
        System.out.println("Enter 9: inheritanceStuff()");
        System.out.println("Enter 10: interfaceStuff()");
        System.out.println("Enter 11: finalStuff()");
        System.out.println("Enter 12: enumOperations()");

        int num = sc.nextInt();

        switch(num)
        {
            case 1:
                System.out.println("Calling Method-1... \n");
                mySweetProgram.stringToIntConversion();
                break;

            case 2:
                System.out.println("\nCalling Method-2... \n");
                mySweetProgram.stringOperations();

            case 3:
                System.out.println("\nCalling Method-3... \n");
                mySweetProgram.objectOperations();
                break;

            case 4:
                System.out.println("\nCalling Method-4... \n");

                List<User> u = new ArrayList<User>();

                User u1 = new User();
                u1.setFirstName("Tyler");
                u1.setLastName("Durden");
                u.add(u1);

                mySweetProgram.printUserPassingObject(u.get(0));
                User.printUser(u.get(0));
                break;

            case 5:
                System.out.println("\nCalling Method-5... \n");
                mySweetProgram.array1DOperations();
                break;

            case 6:
                System.out.println("\nCalling Method-6... \n");
                mySweetProgram.array2DOperations();
                break;

            case 7:
                System.out.println("\nCalling Method-7... \n");
                mySweetProgram.arrayListOperations();
                break;

            case 8:
                System.out.println("\nCalling Method-8... \n");
                mySweetProgram.overriddenCalls();
                break;

            case 9:
                System.out.println("\nCalling Method-9... \n");
                mySweetProgram.inheritanceStuff();
                break;

            case 10:
                System.out.println("\nCalling Method-10... \n");
                mySweetProgram.interfaceStuff();
                break;

            case 11:
                System.out.println("\nCalling Method-11... \n");
                mySweetProgram.finalStuff();
                break;

            case 12:
                System.out.println("\nCalling Method-12... \n");
                mySweetProgram.enumOperations();
                break;

            default:
                System.out.println("\nTry again later!\n");
        }
    }
}