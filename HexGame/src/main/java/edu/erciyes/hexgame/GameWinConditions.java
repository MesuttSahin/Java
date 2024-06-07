package edu.erciyes.hexgame;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GameWinConditions
{
    public boolean checkWin(int row, int col, String color, String[][] matrix, Set<String> visited) {
        String key = row + "-" + col;
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == null || !matrix[row][col].equals(color) || visited.contains(key)) {
            return false;
        }
        visited.add(key);
        if ((color.equals("RED") && row == 0) || (color.equals("BLUE") && col == 0)) {
            if (controlChain(visited, matrix, color)) {
                return true;
            }
        }

        boolean win = false;
        win |= checkWin(row, col - 1, color, matrix, new HashSet<>(visited));
        win |= checkWin(row, col + 1, color, matrix, new HashSet<>(visited));
        win |= checkWin(row - 1, col, color, matrix, new HashSet<>(visited));
        win |= checkWin(row + 1, col, color, matrix, new HashSet<>(visited));
        win |= checkWin(row - 1, col + 1, color, matrix, new HashSet<>(visited));
        win |= checkWin(row + 1, col - 1, color, matrix, new HashSet<>(visited));
        return win;
    }

    private boolean controlChain(Set<String> visited, String[][] matrix, String color) {
        Queue<String> queue = new LinkedList<>(visited);
        Set<String> seen = new HashSet<>();
        while (!queue.isEmpty()) {
            String hex = queue.poll();
            seen.add(hex);
            String[] coordinates = hex.split("-");
            int row = Integer.parseInt(coordinates[0]);
            int col = Integer.parseInt(coordinates[1]);
            if ((color.equals("RED") && row == matrix.length - 1) || (color.equals("BLUE") && col == matrix[0].length - 1)) {
                return true;
            }
            int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, 1}, {1, -1}};
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                String newKey = newRow + "-" + newCol;
                if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length && visited.contains(newKey) && !seen.contains(newKey)) {
                    queue.offer(newKey);
                }
            }
        }
        return false;
    }

    public boolean checkWinFromRight(int row, int col, String color, String[][] matrix, Set<String> visited) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == null || !matrix[row][col].equals(color) || visited.contains(row + "-" + col)) {
            return false;
        }
        visited.add(row + "-" + col);
        if (color.equals("BLUE") && col == matrix[0].length - 1) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] != null && matrix[i][0].equals("BLUE")) {
                    if (checkPathFromLeftToRight(row, col, i, 0, matrix, new HashSet<>())) {
                        return true;
                    }
                }
            }
        }
        boolean win = false;
        win |= checkWinFromRight(row, col - 1, color, matrix, new HashSet<>(visited));
        win |= checkWinFromRight(row, col + 1, color, matrix, new HashSet<>(visited));
        win |= checkWinFromRight(row - 1, col, color, matrix, new HashSet<>(visited));
        win |= checkWinFromRight(row + 1, col, color, matrix, new HashSet<>(visited));
        win |= checkWinFromRight(row - 1, col + 1, color, matrix, new HashSet<>(visited));
        win |= checkWinFromRight(row + 1, col - 1, color, matrix, new HashSet<>(visited));
        return win;
    }
    private boolean checkPathFromLeftToRight(int startRow, int startCol, int endRow, int endCol, String[][] matrix, Set<String> visited) {
        if (startRow == endRow && startCol == endCol) {
            return true;
        }
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, 1}, {1, -1}, {1, 1}};

        for (int[] dir : directions) {
            int newRow = startRow + dir[0];
            int newCol = startCol + dir[1];

            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length && !visited.contains(newRow + "-" + newCol) && matrix[newRow][newCol] != null && matrix[newRow][newCol].equals("BLUE")) {
                visited.add(newRow + "-" + newCol);
                if (checkPathFromLeftToRight(newRow, newCol, endRow, endCol, matrix, visited)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean checkWinFromBottom(int row, int col, String color, String[][] matrix, Set<String> visited) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == null || !matrix[row][col].equals(color) || visited.contains(row + "-" + col)) {
            return false;
        }

        visited.add(row + "-" + col);

        if (color.equals("RED") && row == matrix.length - 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] != null && matrix[0][i].equals("RED")) {
                    if (checkPath(row, col, 0, i, matrix, new HashSet<>())) {
                        return true;
                    }
                }
            }
        }
        boolean win = false;
        win |= checkWinFromBottom(row, col - 1, color, matrix, new HashSet<>(visited));
        win |= checkWinFromBottom(row, col + 1, color, matrix, new HashSet<>(visited));
        win |= checkWinFromBottom(row - 1, col, color, matrix, new HashSet<>(visited));
        win |= checkWinFromBottom(row + 1, col, color, matrix, new HashSet<>(visited));
        win |= checkWinFromBottom(row - 1, col + 1, color, matrix, new HashSet<>(visited));
        win |= checkWinFromBottom(row + 1, col - 1, color, matrix, new HashSet<>(visited));
        win |= checkWinFromBottom(row + 1, col + 1, color, matrix, new HashSet<>(visited));
        return win;
    }

    private boolean checkPath(int startRow, int startCol, int endRow, int endCol, String[][] matrix, Set<String> visited) {
        if (startRow == endRow && startCol == endCol) {
            return true;
        }

        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, 1}, {1, -1}, {1, 1}};

        for (int[] dir : directions) {
            int newRow = startRow + dir[0];
            int newCol = startCol + dir[1];

            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length && !visited.contains(newRow + "-" + newCol) && matrix[newRow][newCol] != null && matrix[newRow][newCol].equals("RED")) {
                visited.add(newRow + "-" + newCol);
                if (checkPath(newRow, newCol, endRow, endCol, matrix, visited)) {
                    return true;
                }
            }
        }

        return false;
    }
}