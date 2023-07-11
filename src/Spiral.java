public class Spiral {

    static int[][] spiral(int rows, int columns) {
        int maxNumber = rows * columns;
        int[][] spiral = new int[rows][columns];
        int num = 1;
        int startingColumnIndex = 0;
        int startingRowIndex = 0;

        while (num <= maxNumber){
            //first row
            for (int i = startingColumnIndex; i < columns; i++) {
                System.out.println("a");
                spiral[startingColumnIndex][i] = num++;
            }
            startingRowIndex++;
            //first column
            for (int i = startingRowIndex; i < rows; i++) {
                System.out.println("b");
                spiral[i][columns - 1] = num++;
            }
            columns--;
            //last of the remaining rows
            if (startingRowIndex < rows) {
                for (int i = columns - 1; i >= startingColumnIndex; i--) {
                    System.out.println("c");
                    spiral[rows - 1][i] = num++;
                }
                rows--;
            }
            //first of the remaining columns
            if (startingColumnIndex < columns) {
                for (int i = rows - 1; i >= startingRowIndex; --i) {
                    System.out.println("d");
                    spiral[i][startingColumnIndex] = num++;
                }
                startingColumnIndex++;
            }
        }
        //printing the spiral
        for (int i = 0; i < spiral.length; i++) {
            for (int j = 0; j < spiral[i].length; j++) {
                System.out.printf("%4s", spiral[i][j]);
            }
            System.out.println();
        }
        return spiral;
    }

}
