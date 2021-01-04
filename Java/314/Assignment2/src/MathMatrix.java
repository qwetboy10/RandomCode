import java.util.Arrays;
//MathMatrix.java - CS314 Assignment 2

/*  Student information for assignment:
 *
 *  On my honor, Tristan Wiesepape, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: tww679
 *  email address: wiesepapetristan@gmail.com
 *  Unique section number: 50915
 *  Number of slip days I am using:
 */

/**
 * A class that models systems of linear equations (Math Matrices)
 * as used in linear algebra.
 */
public class MathMatrix {
    private final int[][] values;

    // instance variable

    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     *
     * @param mat mat !=null, mat.length > 0, mat[0].length > 0,
     *            mat is a rectangular matrix
     */
    public MathMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            throw new IllegalArgumentException("Matrix is invalid");
        }
        if (!rectangularMatrix(mat)) {
            throw new IllegalArgumentException("Matrix is not rectangular");
        }
        //deep copy mat into values
        values = new int[mat.length][mat[0].length];
        for (int r = 0; r < mat.length; r++) {
            System.arraycopy(mat[r], 0, values[r], 0, mat[0].length);
        }
    }


    /**
     * create a MathMatrix of the specified size with all cells set to the
     * intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns.
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal
     * for all valid r and c.
     *
     * @param numRows    numRows > 0
     * @param numCols    numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal) {
        if (numRows <= 0 || numCols <= 0) {
            throw new IllegalArgumentException("Matrix dimensions are invalid");
        }
        //initialize and fill values
        values = new int[numRows][numCols];
        for (int[] value : values) {
            Arrays.fill(value, initialVal);
        }
    }

    /**
     * Get the number of rows.
     *
     * @return the number of rows in this MathMatrix
     */
    public int getNumRows() {
        return values.length;
    }


    /**
     * Get the number of columns.
     *
     * @return the number of columns in this MathMatrix
     */
    public int getNumColumns() {
        return values[0].length;
    }


    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < getNumRows(), col  0 <= col < getNumColumns()
     *
     * @param row 0 <= row < getNumRows()
     * @param col 0 <= col < getNumColumns()
     * @return the value at the specified position
     */
    public int getVal(int row, int col) {
        if (row < 0 || row >= getNumRows() || col < 0 ||
                col >= getNumColumns()) {
            throw new IndexOutOfBoundsException(
                    "Matrix index out of bounds " + row + " " + col);
        }
        return values[row][col];
    }


    /**
     * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumRows(), rightHandSide
     * .numCols() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     *
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(),
     *                      rightHandSide.numCols() = getNumColumns()
     * @return a new MathMatrix that is the result of adding this Matrix to
     * rightHandSide.
     * The number of rows in the returned Matrix is equal to the number of
     * rows in this MathMatrix.
     * The number of columns in the returned Matrix is equal to the number of
     * columns in this MathMatrix.
     */
    public MathMatrix add(MathMatrix rightHandSide) {
        if (getNumRows() != rightHandSide.getNumRows()
                || getNumColumns() != rightHandSide.getNumColumns()) {
            throw new IllegalArgumentException("Argument is wrong size");
        }
        //deep copy values
        MathMatrix ret = new MathMatrix(values);
        //add parameter to ret
        for (int r = 0; r < getNumRows(); r++) {
            for (int c = 0; c < getNumColumns(); c++) {
                ret.values[r][c] += rightHandSide.getVal(r, c);
            }
        }
        return ret;
    }


    /**
     * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumRows(), rightHandSide
     * .numCols() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     *
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(),
     *                      rightHandSide.numCols() = getNumColumns()
     * @return a new MathMatrix that is the result of subtracting
     * rightHandSide from this MathMatrix.
     * The number of rows in the returned MathMatrix is equal to the number
     * of rows in this MathMatrix.
     * The number of columns in the returned MathMatrix is equal to the
     * number of columns in this MathMatrix.
     */
    public MathMatrix subtract(MathMatrix rightHandSide) {
        if (getNumRows() != rightHandSide.getNumRows()
                || getNumColumns() != rightHandSide.getNumColumns()) {
            throw new IllegalArgumentException("Argument is wrong size");
        }
        //deep copy values
        MathMatrix ret = new MathMatrix(values);
        //subtract right hand side from ret
        for (int r = 0; r < getNumRows(); r++) {
            for (int c = 0; c < getNumColumns(); c++) {
                ret.values[r][c] -= rightHandSide.getVal(r, c);
            }
        }
        return ret;
    }


    /**
     * implements matrix multiplication, (this MathMatrix) * rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumColumns()
     * <br>post: This method should not alter the calling object or
     * rightHandSide
     *
     * @param rightHandSide rightHandSide.getNumRows() = getNumColumns()
     * @return a new MathMatrix that is the result of multiplying this
     * MathMatrix and rightHandSide.
     * The number of rows in the returned MathMatrix is equal to the number
     * of rows in this MathMatrix.
     * The number of columns in the returned MathMatrix is equal to the
     * number of columns in rightHandSide.
     */
    public MathMatrix multiply(MathMatrix rightHandSide) {
        if (getNumColumns() != rightHandSide.getNumRows()) {
            throw new IllegalArgumentException("Matrix sizes don't match");
        }
        //Multiplication of matrix of size A*B by matrix of size C*D results
        //in a matrix of size A*D
        int[][] ret = new int[getNumRows()][rightHandSide.getNumColumns()];
        //pick row from first matrix
        for (int r = 0; r < getNumRows(); r++) {
            //pick column from second matrix
            for (int c = 0; c < rightHandSide.getNumColumns(); c++) {
                //multiply ith value of the row by the ith value of the column
                for (int i = 0; i < getNumColumns(); i++) {
                    ret[r][c] += getVal(r, i) * rightHandSide.getVal(i, c);
                }
            }
        }
        return new MathMatrix(ret);
    }


    /**
     * Create and return a new Matrix that is a copy
     * of this matrix, but with all values multiplied by a scale
     * value.
     * <br>pre: none
     * <br>post: returns a new Matrix with all elements in this matrix
     * multiplied by factor.
     * In other words after this method has been called
     * returned_matrix.getVal(r,c) = original_matrix.getVal(r, c) * factor
     * for all valid r and c.
     *
     * @param factor the value to multiply every cell in this Matrix by.
     * @return a MathMatrix that is a copy of this MathMatrix, but with all
     * values in the result multiplied by factor.
     */
    public MathMatrix getScaledMatrix(int factor) {
        //deep copy values
        MathMatrix ret = new MathMatrix(values);
        //scale ret by factor
        for (int r = 0; r < getNumRows(); r++) {
            for (int c = 0; c < getNumColumns(); c++) {
                ret.values[r][c] *= factor;
            }
        }
        return ret;
    }


    /**
     * accessor: get a transpose of this MathMatrix.
     * This Matrix is not changed.
     * <br>pre: none
     *
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose() {
        //make new matrix with columns and rows flipped
        int[][] newMatrix = new int[getNumColumns()][getNumRows()];
        //copy values[r][c] to newMatrix[c][r]
        for (int r = 0; r < newMatrix.length; r++) {
            for (int c = 0; c < newMatrix[0].length; c++) {
                newMatrix[r][c] = getVal(c, r);
            }
        }
        return new MathMatrix(newMatrix);
    }


    /**
     * override equals.
     *
     * @return true if rightHandSide is the same size as this MathMatrix and
     * all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide) {
        /* CS314 Students. The following is standard equals
         * method code. We will learn about in the coming weeks.
         */
        if (rightHandSide != null
                && this.getClass() == rightHandSide.getClass()) {
            // rightHandSide is a non null MathMatrix
            MathMatrix otherMatrix = (MathMatrix) rightHandSide;
            //make sure they are the same size
            if (getNumRows() != otherMatrix.getNumRows() ||
                    getNumColumns() != otherMatrix.getNumColumns()) {
                return false;
            }
            //if any cell is different the matrices are different
            for (int r = 0; r < getNumRows(); r++) {
                for (int c = 0; c < getNumColumns(); c++) {
                    if (getVal(r, c) != otherMatrix.getVal(r, c)) {
                        return false;
                    }
                }
            }
            return true;
        }
        //if right is false or right is not a matrix they aren't equal
        return false;
    }


    /**
     * override toString.
     *
     * @return a String with all elements of this MathMatrix.
     * Each row is on a separate line.
     * Spacing based on longest element in this Matrix.
     */
    public String toString() {
        //find the longest number in values
        int maxWidth = -1;
        for (int r = 0; r < getNumRows(); r++) {
            for (int c = 0; c < getNumColumns(); c++) {
                maxWidth = Math.max(maxWidth, (values[r][c] + "").length());
            }
        }
        //add 1 so there is more spacing
        maxWidth++;
        StringBuilder ret = new StringBuilder();
        for (int r = 0; r < getNumRows(); r++) {
            ret.append('|');
            //format each number right aligned with spaces to the width
            for (int c = 0; c < getNumColumns(); c++) {
                ret.append(
                        String.format("%" + maxWidth + "s", values[r][c] + ""));
            }
            ret.append('|');
            ret.append('\n');
        }
        return ret.toString();
    }


    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main
     * diagonal must be 0.<br>
     * pre: this is a square matrix. getNumRows() == getNumColumns()
     *
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise.
     */
    public boolean isUpperTriangular() {
        if (getNumRows() != getNumColumns()) {
            throw new IllegalStateException("Matrix is not square");
        }
        for (int r = 0; r < getNumRows(); r++) {
            //if any elements are not 0 in the triangle, the matrix is not
            // triangular
            for (int c = 0; c < r; c++) {
                if (values[r][c] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // method to ensure mat is rectangular
    // pre: mat != null, mat has at least one row
    // return true if all rows in mat have the same
    // number of columns false otherwise.
    public static boolean rectangularMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("argument mat may not be null " +
                    "and must have at least one row. mat = "
                    + Arrays.toString(mat));
        }
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;
        while (isRectangular && row < mat.length) {
            isRectangular = (mat[row].length == COLUMNS);
            row++;
        }
        return isRectangular;
    }

}