package array;

import java.util.*;

public class VirusInfection {

    // Class to represent a cell in the grid
    static class Cell {
        int row;
        int col;

        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int timeToInfect(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Cell> queue = new LinkedList<>();
        int nonInfectedCount = 0;

        // Add all initially infected cells to the queue and count non-infected cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Cell(i, j));
                } else if (grid[i][j] == 1) {
                    nonInfectedCount++;
                }
            }
        }

        if (nonInfectedCount == 0) {
            return 0; // No non-infected cells to begin with
        }

        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infectionSpread = false;

            for (int i = 0; i < size; i++) {
                Cell current = queue.poll();

                for (int[] direction : directions) {
                    int newRow = current.row + direction[0];
                    int newCol = current.col + direction[1];

                    // Check if the cell is within bounds and is non-infected
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Infect the cell
                        queue.add(new Cell(newRow, newCol));
                        nonInfectedCount--;
                        infectionSpread = true;
                    }
                }
            }

            if (infectionSpread) {
                minutes++;
            }
        }

        // Check if there are still non-infected cells left
        return nonInfectedCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 0, 2},
                {1, 1, 0, 0},
                {0, 1, 1, 0}

        };

        int result = timeToInfect(grid);

        if (result == -1) {
            System.out.println("Not all cells can be infected.");
        } else {
            System.out.println("Time to infect all cells: " + result + " minute(s).");
        }

      ///print grid 2 D array
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " " );
            }
        }
    }
}
