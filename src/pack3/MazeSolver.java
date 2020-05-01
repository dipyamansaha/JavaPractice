package pack3;

import java.util.LinkedList;

public class MazeSolver
{
    static int[][] maze = {
            {2, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1}
    };
    //0 = Wall
    //1 = Path
    //2 = Destination

    static LinkedList<Position> path = new LinkedList<Position>();

    public static void main(String[] args)
    {
        Position p = new Position(0, 10);
        path.push(p);

        while (true)
        {
            int x = path.peek().x;
            int y = path.peek().y;

            maze[x][y] = 0;

            //Down
            if(isValid(x + 1, y))
            {
                if (maze[x + 1][y] == 2)
                {
                    System.out.println("Moved down. You won!");
                    return;
                }
                else if (maze[x + 1][y] == 1)
                {
                    System.out.println("Moved down.");
                    path.push(new Position(x + 1, y));
                    continue;
                }
            }

            //Left
            if(isValid(x, y - 1))
            {
                if (maze[x][y - 1] == 2)
                {
                    System.out.println("Moved left. You won!");
                    return;
                } else if (maze[x][y - 1] == 1)
                {
                    System.out.println("Moved left.");
                    path.push(new Position(x, y - 1));
                    continue;
                }
            }

            //Up
            if(isValid(x - 1, y))
            {
                if (maze[x - 1][y] == 2)
                {
                    System.out.println("Moved up. You won!");
                    return;
                } else if (maze[x - 1][y] == 1)
                {
                    System.out.println("Moved up.");
                    path.push(new Position(x - 1, y));
                    continue;
                }
            }

            //Right
            if(isValid(x, y + 1))
            {
                if (maze[x][y + 1] == 2)
                {
                    System.out.println("Moved right. You won!");
                    return;
                } else if (maze[x][y + 1] == 1)
                {
                    System.out.println("Moved right.");
                    path.push(new Position(x, y + 1));
                    continue;
                }
            }

            path.pop();
            System.out.println("Moved back!");
            if(path.size() <= 0)
            {
                System.out.println("No path.");
                return;
            }
        }
    }

    static boolean isValid(int x, int y)
    {
        if(x < 0 || x >= maze.length || y < 0 || y >= maze[x].length)
        {
            return false;
        }

        return true;
    }
}