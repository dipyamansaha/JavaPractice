package pack3;

import java.util.LinkedList;

public class MazeSolver
{
    static Maze m = new Maze();

    //0 = Wall
    //1 = Path
    //2 = Destination

    public static void main(String[] args)
    {
        int[][] maze = {
                {2, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1}
        };

        m.maze = maze;
        m.start = new Position(0, 10);
        m.path = new LinkedList<Position>();

        if(solveMaze(m.start))
            System.out.println("You won!");
        else
            System.out.println("No path.");
    }

    static boolean solveMaze(Position p)
    {
        m.path.push(p);

        while(true)
        {
            int x = m.path.peek().x;
            int y = m.path.peek().y;

            m.maze[x][y] = 0;

            //Down
            if(isValid(x + 1, y))
            {
                if (m.maze[x + 1][y] == 2)
                {
                    System.out.println("Moved down.");
                    return true;
                }
                else if (m.maze[x + 1][y] == 1)
                {
                    System.out.println("Moved down.");
                    m.path.push(new Position(x + 1, y));
                    continue;
                }
            }

            //Left
            if(isValid(x, y - 1))
            {
                if (m.maze[x][y - 1] == 2)
                {
                    System.out.println("Moved left.");
                    return true;
                } else if (m.maze[x][y - 1] == 1)
                {
                    System.out.println("Moved left.");
                    m.path.push(new Position(x, y - 1));
                    continue;
                }
            }

            //Up
            if(isValid(x - 1, y))
            {
                if (m.maze[x - 1][y] == 2)
                {
                    System.out.println("Moved up.");
                    return true;
                } else if (m.maze[x - 1][y] == 1)
                {
                    System.out.println("Moved up.");
                    m.path.push(new Position(x - 1, y));
                    continue;
                }
            }

            //Right
            if(isValid(x, y + 1))
            {
                if (m.maze[x][y + 1] == 2)
                {
                    System.out.println("Moved right.");
                    return true;
                } else if (m.maze[x][y + 1] == 1)
                {
                    System.out.println("Moved right.");
                    m.path.push(new Position(x, y + 1));
                    continue;
                }
            }

            m.path.pop();
            System.out.println("Moved back!");
            if(m.path.size() <= 0)
            {
                return false;
            }
        }
    }

    static boolean isValid(int x, int y)
    {
        if(x < 0 || x >= m.maze.length || y < 0 || y >= m.maze[x].length)
        {
            return false;
        }

        return true;
    }
}