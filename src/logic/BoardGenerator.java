package logic;

import java.util.ArrayList;
import utilities.RGen;

public class BoardGenerator
{
    private char board_generated[][];
    private RGen random_generator = new RGen();
    private int n_lin;
    private int n_col;
    public char not_visited = 'N';
    private ArrayList <Ghost> ghosts = new ArrayList <>();
    private Pacman pacman;
    private Gum[] gums;

    /**
     * Constructor of class BoardGenerator
     */
    public BoardGenerator()
    {
        board_generated = new char[11][11];
    }

    public BoardGenerator(int lin, int col)
    {
        if (lin < 7)
        {
            lin = 7;
        }

        if (col < 7)
        {
            col = 7;
        }

        if (lin % 2 == 0)
        {
            lin++;
        }

        if (col % 2 == 0)
        {
            col++;
        }

        n_lin = lin;
        n_col = col;

        board_generated = new char[n_lin][n_col];
    }

    /**
     *
     * @param lin board's line
     * @param col board's column
     * @return Returns true if coordinates are out of the board, and false otherwise
     */
    private boolean outOfBounds(int lin, int col)
    {
        return (lin >= n_lin || col >= n_col || col < 0 || lin < 0);
    }

    /**
     * Fills the cells with walls, as the depth-first algorithm orders
     */
    private void wallTheMaze()
    {
        for (int i = 1; i < n_col; i++)
        {
            for (int k = 1; k < n_lin; k++)
            {
                if (k % 2 != 0)
                {
                    if (i % 2 == 0)
                    {
                        board_generated[k][i] = Board.wall;
                    }
                    else
                    {
                        board_generated[k][i] = not_visited;
                    }
                }
                else
                {
                    if (i % 2 == 0)
                    {
                        board_generated[k][i] = not_visited;
                    }
                    else
                    {
                        board_generated[k][i] = Board.wall;
                    }
                }
            }
        }


        for (int i = 0; i < n_col; i++)
        {
            board_generated[0][i] = Board.wall;
            board_generated[n_lin - 1][i] = Board.wall;
        }


        for (int i = 0; i < n_lin; i++)
        {
            board_generated[i][0] = Board.wall;
            board_generated[i][n_col - 1] = Board.wall;
        }

    }

    /**
     * At the end of the algorithm, to allow more than one possible path, some walls are unlocked
     */
    private void freeSomeWalls()
    {
        boolean canFreeWall = true;

        for (int i = 1; i < n_lin - 2; i++)
        {
            for (int k = 1; k < n_col - 2; k++)
            {
                if (canFreeWall == true)
                {
                    canFreeWall = false;
                    if (random_generator.nextInt(2) == 1)
                    {
                        board_generated[i][k] = Board.empty;
                    }
                }
                else
                {
                    canFreeWall = true;
                }
            }
        }
    }

    /**
     * Checks if a persona can be placed in a certain cell
     *
     * @param lin maze's line
     * @param col maze's column
     * @return Returns true if the persona can be placed in that cell, and false otherwise
     */
    private boolean checkPersonaPossibility(int lin, int col)
    {
        if (board_generated[lin][col] != Board.empty)
        {
            return false;
        }

        return ((board_generated[lin + 1][col] == Board.empty || board_generated[lin + 1][col] == Board.wall)
                && (board_generated[lin - 1][col] == Board.empty || board_generated[lin - 1][col] == Board.wall)
                && (board_generated[lin][col - 1] == Board.empty || board_generated[lin][col - 1] == Board.wall)
                && (board_generated[lin][col + 1] == Board.empty || board_generated[lin][col + 1] == Board.wall));
    }

    /**
     * Generates the maze
     */
    private void generateMaze()
    {
        int lin = 0, col = 0;

        while (lin % 2 == 0)
        {
            lin = random_generator.nextInt(1, n_lin - 2);
        }

        while (col % 2 == 0)
        {
            col = random_generator.nextInt(1, n_col - 2);
        }

        wallTheMaze();
        notVisited2Wall();
        visitCell(lin, col);

        freeSomeWalls();

    }

    private void visitCell(int lin, int col)
    {
        while (true)
        {

            //System.out.println("[" + lin + "," + col + "] - " + isCellVisited(lin, col));
            board_generated[lin][col] = Board.empty;

            //System.out.println(isCellVisited(lin, col) == true && allAdjacentVisited(lin, col) == true);
            if (isCellVisited(lin, col) == true && allAdjacentVisited(lin, col) == true)
            {
                return;
            }

            //System.out.println(allAdjacentVisited(lin, col));

            int[] newCell = pickCell(lin, col);
            visitCell(newCell[0], newCell[1]);
        }
    }

    private boolean allAdjacentVisited(int lin, int col)
    {
        if (isCellVisited(lin - 2, col) == true
            && isCellVisited(lin + 2, col) == true
            && isCellVisited(lin, col - 2) == true
            && isCellVisited(lin, col + 2) == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean isCellVisited(int lin, int col)
    {
        if (outOfBounds(lin, col))
        {
            return true;
        }

        return (board_generated[lin][col] == Board.empty);
    }

    private void notVisited2Wall()
    {
        for (int i = 0; i < n_lin; i++)
        {
            for (int k = 0; k < n_col; k++)
            {
                if (board_generated[i][k] == not_visited);
                board_generated[i][k] = Board.wall;
            }
        }
    }

    private int[] pickCell(int lin, int col)
    {
        int newLine = -1;
        int newCol = -1;
        int random_number = -1;

        /*
         * select cell
         */

        while (outOfBounds(newLine, newCol) == true || isCellVisited(newLine, newCol) == true)
        {
            newLine = -1;
            newCol = -1;

            random_number = random_generator.nextInt(4);

            switch (random_number)
            {
                case 0:
                    newLine = lin + 2;
                    newCol = col;
                    break;
                case 1:
                    newLine = lin - 2;
                    newCol = col;
                    break;
                case 2:
                    newLine = lin;
                    newCol = col + 2;
                    break;
                case 3:
                    newLine = lin;
                    newCol = col - 2;
                    break;
            }
        }

        /*
         * knock the wall
         */

        switch (random_number)
        {
            case 0:
                board_generated[lin + 1][col] = Board.empty;
                break;
            case 1:
                board_generated[lin - 1][col] = Board.empty;
                break;
            case 2:
                board_generated[lin][col + 1] = Board.empty;
                break;
            case 3:
                board_generated[lin][col - 1] = Board.empty;
                break;
        }

        int[] newCell =
        {
            newLine, newCol
        };

        return newCell;
    }

    /**
     *
     * @return
     */
    public Board nextMaze()
    {
        generateMaze();
        return new Board(n_lin, n_col, board_generated);
    }

    private void placeGhosts()
    {
        for (int i = 0; i < Board.n_ghosts; i++)
        {
            while (true)
            {
                int lin = random_generator.nextInt(0, n_lin);
                int col = random_generator.nextInt(0, n_col);

                if (checkPersonaPossibility(lin, col))
                {
                    ghosts.add(new Ghost(lin, col));
                }
            }
        }
    }

    private void placePacman()
    {
    }
}