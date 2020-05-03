package pack5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileMazeSolver
{
    public static void main(String[] args) throws FileNotFoundException
    {
        ArrayList<FMaze> mazes = readMazes();

        int i = 0;
        while(i < mazes.size())
        {
            System.out.println("Maze-" + (i+1) + ":");
            if(solveMaze(mazes.get(i)))
                System.out.println("You won!");
            else
                System.out.println("No path!");
            System.out.println();
            i++;
        }
    }

    static ArrayList<FMaze> readMazes() throws FileNotFoundException
    {
        ArrayList<FMaze> mazes = new ArrayList<FMaze>();

        Scanner in = new Scanner(new File("src/mazes.txt"));

        while(in.hasNext())
        {
            FMaze m = new FMaze();

            int rows = Integer.parseInt(in.nextLine());
            m.maze = new int[rows][];

            for (int i = 0; i < rows; i++)
            {
                String line = in.nextLine();
                m.maze[i] = Arrays.stream(line.split(", ")).mapToInt(Integer::parseInt).toArray();
            }

            m.start = new FPosition(Integer.parseInt(in.nextLine()), Integer.parseInt(in.nextLine()));

            in.nextLine();  //toss the extra space

            mazes.add(m);
        }

        in.close();

        return mazes;
    }

    static boolean solveMaze(FMaze mz)
    {
        FPosition p = mz.start;
        mz.path.push(p);

        while(true)
        {
            int x = mz.path.peek().x;
            int y = mz.path.peek().y;

            mz.maze[x][y] = 0;

            //Down
            if(isValid(x + 1, y, mz))
            {
                if (mz.maze[x + 1][y] == 2)
                {
                    System.out.println("Moved down.");
                    return true;
                }
                else if (mz.maze[x + 1][y] == 1)
                {
                    System.out.println("Moved down.");
                    mz.path.push(new FPosition(x + 1, y));
                    continue;
                }
            }

            //Left
            if(isValid(x, y - 1, mz))
            {
                if (mz.maze[x][y - 1] == 2)
                {
                    System.out.println("Moved left.");
                    return true;
                } else if (mz.maze[x][y - 1] == 1)
                {
                    System.out.println("Moved left.");
                    mz.path.push(new FPosition(x, y - 1));
                    continue;
                }
            }

            //Up
            if(isValid(x - 1, y, mz))
            {
                if (mz.maze[x - 1][y] == 2)
                {
                    System.out.println("Moved up.");
                    return true;
                } else if (mz.maze[x - 1][y] == 1)
                {
                    System.out.println("Moved up.");
                    mz.path.push(new FPosition(x - 1, y));
                    continue;
                }
            }

            //Right
            if(isValid(x, y + 1, mz))
            {
                if (mz.maze[x][y + 1] == 2)
                {
                    System.out.println("Moved right.");
                    return true;
                } else if (mz.maze[x][y + 1] == 1)
                {
                    System.out.println("Moved right.");
                    mz.path.push(new FPosition(x, y + 1));
                    continue;
                }
            }

            mz.path.pop();
            System.out.println("Moved back!");
            if(mz.path.size() <= 0)
            {
                return false;
            }
        }
    }

    static boolean isValid(int x, int y, FMaze mz)
    {
        if(x < 0 || x >= mz.maze.length || y < 0 || y >= mz.maze[x].length)
        {
            return false;
        }

        return true;
    }
}