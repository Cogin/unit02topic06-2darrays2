public class Minesweeper {

    public static boolean[][] makeMinesweeperBoard(int m, int n, double p) {
        boolean[][] board = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                board[r][c] = Math.random() < p;
            }
        }
        return board;
    }

    public static void printMinesweeperBoard(boolean[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                System.out.print(grid[r][c] ? " *" : " ·");
            }
            System.out.println();
        }
    }

    public static int[][] makeNeighborBoard(boolean[][] grid) {
        int[][] neighborBoard = new int[grid[0].length][grid.length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == true) {
                    neighborBoard[r][c] = -1;
                    
                    if (r > 0) {
                        if (neighborBoard[r - 1][c] != -1) neighborBoard[r - 1][c]++;
                    }
                    if (r < grid.length - 1) {
                        if (neighborBoard[r + 1][c] != -1) neighborBoard[r + 1][c]++;
                    }
                    if (c > 0) {
                        if (neighborBoard[r][c-1] != -1) neighborBoard[r][c - 1]++;
                    }
                    if (c < grid[0].length - 1) {
                        if (neighborBoard[r][c + 1] != -1) neighborBoard[r][c + 1]++;
                    }
                    if (r > 0 && c > 0) {
                        if (neighborBoard[r - 1][c - 1] != -1) neighborBoard[r - 1][c - 1]++;
                    }
                    if (r > 0 && c < grid[0].length - 1) {
                        if (neighborBoard[r - 1][c + 1] != -1) neighborBoard[r - 1][c + 1]++;
                    }
                    if (r < grid.length - 1 && c > 0) {
                        if (neighborBoard[r + 1][c - 1] != -1) neighborBoard[r + 1][c - 1]++;
                    }
                    if (r < grid.length - 1 && c < grid[0].length - 1) {
                        if (neighborBoard[r + 1][c + 1] != -1) neighborBoard[r + 1][c + 1]++;
                    }

                }
            }
            
        }
        return neighborBoard;
    }

    public static void printNeighborBoard(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                System.out.print(grid[r][c] == -1 ? " *" : " " + grid[r][c]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        boolean[][] board = makeMinesweeperBoard(10, 10, 0.2);
        int[][] neighborBoard = makeNeighborBoard(board);
        printNeighborBoard(neighborBoard);
    }
}
