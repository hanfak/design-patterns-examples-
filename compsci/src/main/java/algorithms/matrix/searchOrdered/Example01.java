package algorithms.matrix.searchOrdered;

public class Example01 {

    // Time complexity = O(m+n)
    // Space compl = O(i) as matrix is given

    // Algo
    //- We start from 1st row & last column of matrix
    //- If value matches, we print the row & column index
    //- If value is greater than current matrix value, we go in next row
    //- If value is less than current matrix value, we go in previous column
    //- We do this until, row is less than last row & column is greater of equal to 1st column

    public static void main(String... args) {
        int[][] mat = {{2, 7, 15},
                        {4, 9, 19},
                        {6, 10, 24}};

        Example01.search(mat, 5);
    }

    public static void search(int[][] mat, int val) {
        if(mat.length == 0) {
            System.out.println("Matrix is Blank");
            return;
        }

        int totalRows = mat.length;
        int totalColumns = mat[0].length;

        int row, column;
        row = 0;
        column = totalColumns - 1;

        while(row < totalRows && column >= 0) {
            if(mat[row][column] == val) {
                System.out.println("Value is present at: "+ row +" " + column);
                return;
            }

            if(val > mat[row][column]) {
                row++;
            } else {
                column--;
            }
        }

        System.out.println("Value is not present in Matrix");
    }
}
