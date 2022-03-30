package PartB;
import BasicIO.*;


/** This program solves the maze problem
 * @author Esbah Majoka
 * Student Number 7357981
 * @version 3.0 (March 24th)                                                     */
public class PathFinder {
    private ASCIIDataFile file;         // Reading the file
    private char [][] maze;             //Array to save Array
    private int startX, startY;         // Position
    public PathFinder ( ) { // constructor
        file = new ASCIIDataFile();
        boolean solved = false;             // Solved maze
        int width = file.readInt();         // Getting width
        int height = file.readInt();        // Getting height
        maze = new char [width][height];
        gettingMaze();
        setStart(width - 1, height - 1);

        file.close();
        printingMaze();

        if (solveMaze(startX, startY, solved))
        { System.out.println("This can be solved"); } // In case, The maze is solved
        else { System.out.println("There is no solution to this maze"); } // In case, Maze is not solved


        printingMaze();
    }

    /** Save the maze as 2D array*/
    public void gettingMaze ( ) {
        String RowOfChars;                          // String as String
        for (int i = 0; i < maze.length; i++){
            RowOfChars = file.readString();         // Reading rows from the file
            maze[i] = RowOfChars.toCharArray();
        }
    }
    /** Displaying the maze  */
    public void printingMaze ( ) {
        for (int i = 0; i < maze.length; i++) {                                         // Checking each row
            for (int j = 0; j < maze[0].length; j++)
            { System.out.print((maze[i][j])); }    // Printing the column
            System.out.println();
        }

    }

    /** This method randomly generates a start point within the maze
     */
    public void setStart (int width, int height) {
        do {
            startX = (int) Math.floor(Math.random() * (height - 0 + 1) + 0);    // Generate random number between 0 and maze max width
            startY = (int) Math.floor(Math.random() * (width - 0 + 1) + 0);     // Generate random number between 0 and maze max height
        } while (maze[startY][startX] == '#' || maze[startY][startX] == 'E');
        maze[startY][startX] = 'S';
    }

    /** This checks every direction until the end point
     *
     */
    public boolean solveMaze (int x, int y, boolean solved) {
        if (maze[y][x] == 'E') { return true; }                                               // If statement for solved maze

        if (maze[y + 1][x] == ' ' && !solved || maze[y + 1][x] == 'E' && !solved ) {    // Check if position below is available
            if (maze[y][x] != 'S') { maze[y][x] = 'V'; }                                // If at start don't draw over S
            solved = solveMaze(x, y + 1, solved);
        }

        if (maze[y][x + 1] == ' ' && !solved || maze[y][x + 1] == 'E' && !solved ) {    // Check if position to the right is available
            if (maze[y][x] != 'S') { maze[y][x] = '>'; }
            solved = solveMaze(x + 1, y, solved);
        }

        if (maze[y - 1][x] == ' ' && !solved || maze[y - 1][x] == 'E' && !solved ) {    // Check if position above is available
            if (maze[y][x] != 'S') { maze[y][x] = '^'; }
            solved = solveMaze(x, y - 1, solved);
        }

        if (maze[y][x - 1] == ' ' && !solved || maze[y][x - 1] == 'E' && !solved ) {    // Check if position to the left is available
            if (maze[y][x] != 'S') { maze[y][x] = '<'; }
            solved = solveMaze(x - 1, y, solved);
        }

        if (!solved) { maze[y][x] = '.'; }                                                    // If  end is found, place dot
        return solved;                                                                              // if the end is found
    }
    public static void main (String[] arg) { PathFinder p = new PathFinder(); }
}
