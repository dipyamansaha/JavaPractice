package pack4;

import pack3.Maze;

import java.util.ArrayList;
import java.util.LinkedList;

public class MultipleMazeSolver
{
    public static void main(String[] args)
    {
        ArrayList<MMaze> mazes = new ArrayList<MMaze>();

        MMaze m = new MMaze();

        //0 = Wall
        //1 = Path
        //2 = Destination

        int[][] maze = {
                {2, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1}
        };

        m.maze = maze;
        m.start = new MPosition(0, 10);
        m.path = new LinkedList<MPosition>();

        MMaze n = new MMaze();

        int[][] n_maze = {
                {2, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0},
                {0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1}
        };

        n.maze = n_maze;
        n.start = new MPosition(0, 10);
        n.path = new LinkedList<MPosition>();

        mazes.add(m);
        mazes.add(n);

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

    static boolean solveMaze(MMaze mz)
    {
        MPosition p = mz.start;
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
                    mz.path.push(new MPosition(x + 1, y));
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
                    mz.path.push(new MPosition(x, y - 1));
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
                    mz.path.push(new MPosition(x - 1, y));
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
                    mz.path.push(new MPosition(x, y + 1));
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

    static boolean isValid(int x, int y, MMaze mz)
    {
        if(x < 0 || x >= mz.maze.length || y < 0 || y >= mz.maze[x].length)
        {
            return false;
        }

        return true;
    }
}