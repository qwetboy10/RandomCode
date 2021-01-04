import java.util.Random;

/*  Student information for assignment:
 *
 *  UTEID: tww679
 *  email address: wiesepapetristan@gmail.com
 *  Grader name:
 *  Number of slip days I am using:
 */



/* CS314 Students. Put your experiment results and
 * answers to questions here.
 * Experiment 1
 * - 1000x1000: 1.71 seconds
 * - 2000x2000: 7.05 seconds
 * - 4000x4000: 25.25 seconds
 * Experiment 2
 * - 200x200: 1.03 seconds
 * - 400x400: 10.15 seconds
 * - 800x800: 90.59 seconds
 * Questions
 * 1. 100 seconds
 * 2. O(N^2), yes because doubling N made the time go up by a factor of 4 (or
 *  2^2)
 * 3. 810 seconds
 * 4. O(N^3), my data is supports this because doubling N made the time go up
 *  by a factor of about 8, which is 2^3
 * 5. The largest matrix I could create was 100,000 by 10,000. This means I
 * could allocate 100,000 * 10,000 * 4 bytes, or 4,000,000,000 bytes.
 */

/**
 * A class to run tests on the MathMatrix class
 */
public class MathMatrixTester {
    private static int testNumber = 1;

//    private static void conductExperiments() {
//        Random r = new Random();
//        Stopwatch watch = new Stopwatch();
//        final int size = 1_000;
//        MathMatrix matrix1 = createMat(r,size,size,1_000);
//        MathMatrix matrix2 = createMat(r,size,size,1_000);
//        watch.start();
//        for(int i=0;i<1000;i++)
//        {
//            matrix1.add(matrix2);
//        }
//        watch.stop();
//        System.out.println(watch);
//
//        Random r = new Random();
//        Stopwatch watch = new Stopwatch();
//        final int size = 2_000;
//        MathMatrix matrix1 = createMat(r,size,size,1_000);
//        MathMatrix matrix2 = createMat(r,size,size,1_000);
//        watch.start();
//        for(int i=0;i<1000;i++)
//        {
//            matrix1.add(matrix2);
//        }
//        watch.stop();
//        System.out.println(watch);
//
//        Random r = new Random();
//        Stopwatch watch = new Stopwatch();
//        final int size = 4_000;
//        MathMatrix matrix1 = createMat(r,size,size,1_000);
//        MathMatrix matrix2 = createMat(r,size,size,1_000);
//        watch.start();
//        for(int i=0;i<1000;i++)
//        {
//            matrix1.add(matrix2);
//        }
//        watch.stop();
//        System.out.println(watch);
//
//        Random r = new Random();
//        Stopwatch watch = new Stopwatch();
//        final int size = 200;
//        MathMatrix matrix1 = createMat(r,size,size,1_000);
//        MathMatrix matrix2 = createMat(r,size,size,1_000);
//        watch.start();
//        for(int i=0;i<100;i++)
//        {
//            matrix1.multiply(matrix2);
//        }
//        watch.stop();
//        System.out.println(watch);
//
//        Random r = new Random();
//        Stopwatch watch = new Stopwatch();
//        final int size = 400;
//        MathMatrix matrix1 = createMat(r,size,size,1_000);
//        MathMatrix matrix2 = createMat(r,size,size,1_000);
//        watch.start();
//        for(int i=0;i<100;i++)
//        {
//            matrix1.multiply(matrix2);
//        }
//        watch.stop();
//        System.out.println(watch);
//
//        Random r = new Random();
//        Stopwatch watch = new Stopwatch();
//        final int size = 800;
//        MathMatrix matrix1 = createMat(r,size,size,1_000);
//        MathMatrix matrix2 = createMat(r,size,size,1_000);
//        watch.start();
//        for(int i=0;i<100;i++)
//        {
//            matrix1.multiply(matrix2);
//        }
//        watch.stop();
//        System.out.println(watch);
//
//        int[][] test = new int[100_000][10_000];
//
//    }
    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
    public static void main(String[] args) {
        int[][] vals1 = new int[][]{{1, 5, 7}, {4, 3, 2}};
        int[][] vals2 = new int[][]{{5, 7}, {3, 8}, {4, 4}};
        MathMatrix a = new MathMatrix(vals1);
        MathMatrix b = new MathMatrix(vals2);
        //getNumRows
        //test 1
        expectEqual(a.getNumRows(), 2);
        //test 2
        expectEqual(b.getNumRows(), 3);
        //getNumColums
        //test 3
        expectEqual(a.getNumColumns(), 3);
        //test 4
        expectEqual(b.getNumColumns(), 2);
        //getVal
        //test 5
        expectEqual(a.getVal(0, 0), 1);
        //test 6
        expectEqual(b.getVal(2, 1), 4);
        //add
        //test 7
        MathMatrix addOperand = new MathMatrix(
                new int[][]{{1, 1, 1}, {-1, -1, -1}});
        MathMatrix addResult = new MathMatrix(
                new int[][]{{2, 6, 8}, {3, 2, 1}});
        expectEqual(a.add(addOperand), addResult);
        //test 8
        MathMatrix addOperand2 = new MathMatrix(
                new int[][]{{5, 2}, {8, 4}, {3, 5}});
        MathMatrix addResult2 = new MathMatrix(
                new int[][]{{10, 9}, {11, 12}, {7, 9}});
        expectEqual(b.add(addOperand2), addResult2);
        //subtract
        //test 9
        MathMatrix subtractOperand = new MathMatrix(
                new int[][]{{1, 1, 1}, {-1, -1, -1}});
        MathMatrix subtractResult = new MathMatrix(
                new int[][]{{0, 4, 6}, {5, 4, 3}});
        expectEqual(a.subtract(subtractOperand), subtractResult);
        //test 10
        MathMatrix subtractOperand2 = new MathMatrix(
                new int[][]{{5, 2}, {8, 4}, {3, 5}});
        MathMatrix subtractResult2 = new MathMatrix(
                new int[][]{{0, 5}, {-5, 4}, {1, -1}});
        expectEqual(b.subtract(subtractOperand2), subtractResult2);
        //multiply
        //test 11
        MathMatrix identity = new MathMatrix(new int[][]{{1, 0}, {0, 1}});
        expectEqual(b.multiply(identity), b);
        //test 12
        MathMatrix result = new MathMatrix(new int[][]{{48, 75}, {37, 60}});
        expectEqual(a.multiply(b), result);
        //getScaledMatrix
        //test 13
        MathMatrix scaledResult = new MathMatrix(new int[][]{{0, 0, 0}, {0, 0,
                0}});
        expectEqual(a.getScaledMatrix(0), scaledResult);
        //test 14
        expectEqual(a.getScaledMatrix(1), a);
        //getTranspose
        //test 15
        MathMatrix aTranspose =
                new MathMatrix(new int[][]{{1, 4}, {5, 3}, {7, 2}});
        expectEqual(a.getTranspose(), aTranspose);
        //test 16
        MathMatrix bTranspose =
                new MathMatrix(new int[][]{{5, 3, 4}, {7, 8, 4}});
        expectEqual(b.getTranspose(), bTranspose);
        //equals
        //test 17
        expectEqual(a.equals(b), false);
        //test 18
        expectEqual(a.equals(new MathMatrix(vals1)), true);
        //toString
        //test 19
        expectEqual(a.toString(), "| 1 5 7|\n" + "| 4 3 2|\n");
        //test 20
        expectEqual(b.toString(), "| 5 7|\n" +
                "| 3 8|\n" +
                "| 4 4|\n");
        //isUpperTriangular
        //test 21
        MathMatrix notUpperTriangular = new MathMatrix(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        });
        expectEqual(notUpperTriangular.isUpperTriangular(), false);
        //test 22
        MathMatrix upperTriangular = new MathMatrix(new int[][]{
                {1, 2, 3}, {0, 4, 5}, {0, 0, 6}
        });
        expectEqual(upperTriangular.isUpperTriangular(), true);
    }

    //print the results of the test
    //pre: a != null
    private static void expectEqual(Object a, Object b) {
        System.out.println("Test Number " + testNumber++ + " " +
                (a.equals(b) ? "passed" : "failed"));
    }

    // method that sums elements of mat, may overflow int!
    // pre: mat != null
    private static int sumVals(MathMatrix mat) {
        if (mat == null) {
            throw new IllegalArgumentException("mat may not be null");
        }
        int result = 0;
        final int ROWS = mat.getNumRows();
        final int COLS = mat.getNumColumns();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                result += mat.getVal(r,
                        c); // likely to overflow, but can still do simple check
            }
        }
        return result;
    }

    // create a matrix with random values
    // pre: rows > 0, cols > 0, randNumGen != null
    public static MathMatrix createMat(Random randNumGen, int rows,
                                       int cols, final int LIMIT) {

        if (randNumGen == null) {
            throw new IllegalArgumentException(
                    "randomNumGen variable may no be null");
        } else if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException(
                    "rows and columns must be greater than 0. " +
                            "rows: " + rows + ", cols: " + cols);
        }

        int[][] temp = new int[rows][cols];
        final int SUB = LIMIT / 4;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                temp[r][c] = randNumGen.nextInt(LIMIT) - SUB;
            }
        }

        return new MathMatrix(temp);
    }

    private static void printTestResult(int[][] data1, int[][] data2,
                                        int testNum, String testingWhat) {
        System.out
                .print("Test number " + testNum + " tests the " + testingWhat +
                        ". The test ");
        String result = equals(data1, data2) ? "passed" : "failed";
        System.out.println(result);
    }

    // pre: m != null, m is at least 1 by 1 in size
    // return a 2d array of ints the same size as m and with
    // the same elements
    private static int[][] get2DArray(MathMatrix m) {
        //check precondition
        if ((m == null) || (m.getNumRows() == 0)
                || (m.getNumColumns() == 0)) {
            throw new IllegalArgumentException(
                    "Violation of precondition: get2DArray");
        }

        int[][] result = new int[m.getNumRows()][m.getNumColumns()];
        for (int r = 0; r < result.length; r++) {
            for (int c = 0; c < result[0].length; c++) {
                result[r][c] = m.getVal(r, c);
            }
        }
        return result;
    }

    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1
    // matrices
    //      data1 and data2 are rectangular matrices
    // post: return true if data1 and data2 are the same size and all
    // elements are
    //      the same
    private static boolean equals(int[][] data1, int[][] data2) {
        //check precondition
        if ((data1 == null) || (data1.length == 0)
                || (data1[0].length == 0) || !rectangularMatrix(data1)
                || (data2 == null) || (data2.length == 0)
                || (data2[0].length == 0) || !rectangularMatrix(data2)) {
            throw new IllegalArgumentException(
                    "Violation of precondition: equals check on 2d arrays of " +
                            "ints");
        }
        boolean result = (data1.length == data2.length) &&
                (data1[0].length == data2[0].length);
        int row = 0;
        while (result && row < data1.length) {
            int col = 0;
            while (result && col < data1[0].length) {
                result = (data1[row][col] == data2[row][col]);
                col++;
            }
            row++;
        }

        return result;
    }


    // method to ensure mat is rectangular
    // pre: mat != null, mat is at least 1 by 1
    private static boolean rectangularMatrix(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null"
                    + " and must be at least 1 by 1");
        }
        return MathMatrix.rectangularMatrix(mat);
    }
}
