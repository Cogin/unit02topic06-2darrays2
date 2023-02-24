public class SelfAvoidingWalk {

    // returns true if it escapes, false otherwise
    // also returns the length of the walk

    public static int sizeofWalk(boolean[][] grid) {
        int topCoords[] = new int[] {0,0};
        int bottomCoords[] = new int[] {0,0};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]) {
                    topCoords[0] = i;
                    topCoords[1] = j;
                }
            }
        }
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid.length - 1; j >= 0; j--) {
                if (grid[i][j]) {
                    bottomCoords[0] = i;
                    bottomCoords[1] = j;
                }
            }
        }
        int x = Math.abs(topCoords[0] - bottomCoords[0]);
        int y = Math.abs(topCoords[1] - bottomCoords[1]);
        return x * y;
    }
    public static int[] doAWalk(int dimension) {
        boolean[][] grid = new boolean[dimension][dimension];
        int length = 0;
        int x = dimension / 2;
        int y = dimension / 2;

        while (
            x >= 0 && x < dimension &&
            y >= 0 && y < dimension &&
            grid[x][y] == false
        ) {
            grid[x][y] = true;

            double r = Math.random();
            if (r < 0.25) {
                // up
                y = y - 1;
            } else if (r < .5) {
                // down
                y = y + 1;
            } else if (r < .75) {
                // left
                x = x - 1;
            } else {
                // right
                x = x + 1;
            }
            length++;
        }

        if (x < 0 || x >= dimension ||
            y < 0 || y >= dimension) {
            return new int[] {1, length};
        } else {
            return new int[] {0, length, sizeofWalk(grid)};
        }
    }

    public static double deadEndRectangleArea(int n, int nTrials){
        int avgArea = 0;
        int totalDeadEnds = 0;
        for (int i = 0; i < nTrials; i++) {
            int[] result = doAWalk(n);
            if (result[0] == 0) {
                avgArea += result[2];
                totalDeadEnds++;
            }
        }
        return (double)avgArea / totalDeadEnds;
        
    }



    public static void printPathLengths(int n, int trials) {
        int deadEndLength = 0;
        int escapeLength = 0;
        int escapes = 0;
        int deadEnds = 0;
        for (int t = 0; t < trials; t++) {
            int[] result = doAWalk(n);
            if (result[0] == 1) {
                escapeLength += result[1];
                escapes++;
            } 
            else {
                deadEndLength += result[1];
                deadEnds++;
            }
        }
        System.out.println("Average escape length: " + (double)escapeLength / escapes);
        System.out.println("Average dead end length: " + (double)deadEndLength / deadEnds);
        //dead end probability
        System.out.println("Dead end probability: " + ((double)deadEnds / trials) * 100 + "%");
        //escape probability
        System.out.println("Escape probability: " + ((double)escapes / trials) * 100 + "%");
    }

    public static void printGrid(boolean[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;

        for (int c = 0; c < nCols + 2; c++) {
            System.out.print("-");
        }
        System.out.println();

        for (int r = 0; r < nRows; r++) {
            System.out.print("|");
            for (int c = 0; c < nCols; c++) {
                if (grid[r][c] == true) {
                    System.out.print(".");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }

        for (int c = 0; c < nCols + 2; c++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        System.out.println(deadEndRectangleArea(10, 10000));

    }
}

// javac Topic07SelfAvoidingRandomWalk.java; java Topic07SelfAvoidingRandomWalk