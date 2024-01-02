import org.junit.jupiter.api.*;

import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @studentName David Oti-George
 * @ucid 30141134
 * @TA Mirtabatabaeipour, Amirhossein
 * @date February 11, 2022
 */
class TicTacToeTest {

    int[][] emptyBoard;
    static final int X = 1;
    static final int O = 2;

    /**
     * Tests to see if a square board contains only 0
     * Test should pass if all entries are 0
     */
    @Test
    void createEmpty_3x3_Board() {
    emptyBoard = new int[3][3];
    assertArrayEquals(emptyBoard, TicTacToe.createBoard(3,3));
    }

    /**
     * Tests to see if a board with more columns than rows contains only 0
     * Test should pass if all entries are 0
     */
    @Test
    void createEmpty_3x4_Board() {
        emptyBoard = new int[3][4];
        assertArrayEquals(emptyBoard, TicTacToe.createBoard(3,4));
    }

    /**
     * Tests to see if a board with more rows than columns contains only 0
     * Test should pass if all entries are 0
     */
    @Test
    void createEmpty_4x3_Board() {
        emptyBoard = new int[4][3];
        assertArrayEquals(emptyBoard, TicTacToe.createBoard(4,3));
    }

    /**
     * Tests to see if the right amount of rows are returned for an empty board
     * Test should pass if 3 is returned
     */
    @Test
    void threeRowsInEmptyBoard() {
        emptyBoard = new int[3][4];
        assertEquals(3, TicTacToe.rowsIn(emptyBoard));
    }

    /**
     * Tests to see if the right amount of rows are returned for a filled board
     * Test should pass if 3 is returned
     */
    @Test
    void Filled_3x3_Board() {
        int[][] board = new int[][]{{X,O,X},
                                    {O,X,O},
                                    {X,O,O}};
        assertEquals(3, TicTacToe.rowsIn(board));
    }

    /**
     * Tests to see if the right amount of rows are returned for a filled board with more rows than columns
     * Test should pass if 4
     */
    @Test
    void Filled_4x3_Board() {
        int[][] board = new int[][]{{X,O,0},
                                    {O,X,O},
                                    {X,X,O},
                                    {X,O,O}};
        assertEquals(4, TicTacToe.rowsIn(board));
    }

    /**
     *Tests to see if the right amount of rows are returned for a partly filled board
     *Test should pass if 5 is returned
     */
    @Test
    void fiveRowsInPartlyFilledBoard() {
        int[][] board = new int[][]{{X,O,0},
                                    {O,X,O},
                                    {X,0,O},
                                    {X,O,O},
                                    {O,X,0}};
        assertEquals(5, TicTacToe.rowsIn(board));
    }

    /**
     *Tests to see if the right amount of rows are returned when there are more columns than rows
     *Test should pass if 4 is returned
     */
    @Test
    void fourRowsInFilledBoard() {
        int[][] board = new int[][]{{X,O,X,O,X},
                                    {X,O,O,X,O},
                                    {X,X,O,O,O},
                                    {O,X,X,O,X}};
        assertEquals(4, TicTacToe.rowsIn(board));
    }

    /**
     * Tests to see if the right amount of columns are returned for an empty board
     * Test should pass if 4 is returned
     */
    @Test
    void columnsInEmptyBoard() {
        emptyBoard = new int[3][4];
        assertEquals(4, TicTacToe.columnsIn(emptyBoard));
    }
    /**
     * Tests to see if the right amount of columns are returned for a filled board
     * Test should pass if 3 is returned
     */
    @Test
    void columnsIn_3x3_Board() {
        int[][] board = new int[][]{{0,O,X},
                                    {0,O,O},
                                    {X,0,X}};
        assertEquals(3, TicTacToe.columnsIn(board));
    }

    /**
     * Tests to see if the right amount of columns are returned for a filled board with more columns than rows
     * Test should pass if 4 is returned
     */
    @Test
    void columnsIn_3x4_Board() {
        int[][] board = new int[][]{{0,O,X,O},
                                    {0,O,O,X},
                                    {X,0,X,X}};
        assertEquals(4, TicTacToe.columnsIn(board));
    }

    /**
     * Tests to see if the right amount of columns are returned for a partly filled board
     * Test should pass if 3 is returned
     */
    @Test
    void columnsInPartlyFilledBoard() {
        int[][] board = new int[][]{{0,O,X},
                                    {0,O,O},
                                    {X,0,X},
                                    {X,O,X}};
        assertEquals(3, TicTacToe.columnsIn(board));
    }

    /**
     * Tests to see if a piece can be played in a filled board
     * Test should pass if false is returned
     */
    @Test
    void canPlayOnFullBoard() {
        int[][] board = new int[][]{{X,O,X,X},
                                    {X,O,O,X},
                                    {X,X,O,O},
                                    {O,O,X,O}};
        assertFalse(TicTacToe.canPlay(board, 3,2));
    }

    /**
     * Tests to see if a piece can be played in an open spot
     * Test should pass if true is returned
     */
    @Test
    void canPlayOnOpenSpot() {
        int[][] board = new int[][]{{X, O, X, 0},
                                    {X, O, O, X},
                                    {X, X, O, O},
                                    {O, O, X, O}};
        assertTrue(TicTacToe.canPlay(board, 0, 3));
    }

    /**
     * Tests to see if a piece is played in a corner spot
     * Test should pass if the unplayed board is equal to the played board
     */
    @Test
    void playOnCornerSpot() {
        int[][] unplayedBoard = new int[][]{{X, O, X, 0},
                                            {X, O, O, X},
                                            {X, X, O, O},
                                            {O, O, X, O}};
        int[][] playedBoard = new int[][]{{X, O, X, X},
                                          {X, O, O, X},
                                          {X, X, O, O},
                                          {O, O, X, O}};
        TicTacToe.play(unplayedBoard,0,3,X);
        assertArrayEquals(playedBoard, unplayedBoard);
    }

    /**
     * Tests to see if a piece is played in a central spot
     * Test should pass if the unplayed board is equal to the played board
     */
    @Test
    void playOnCentralSpot() {
        int[][] unplayedBoard = new int[][]{{X, O, X},
                                            {X, 0, O},
                                            {X, X, O}};
        int[][] playedBoard = new int[][]{{X, O, X},
                                          {X, O, O},
                                          {X, X, O}};
        TicTacToe.play(unplayedBoard,1,1,O);
        assertArrayEquals(playedBoard, unplayedBoard);
    }

    /**
     * Tests to see if a full board is full
     * Test should pass if true is returned
     */
    @Test
    void fullBoard() {
        int[][] fullBoard = new int[][]{{X, O, X},
                                        {X, O, O},
                                        {X, X, O}};
        assertTrue(TicTacToe.full(fullBoard));
    }

    /**
     * Tests to see if an empty corner board is full
     * Test should pass if false is returned
     */
    @Test
    void emptyCornerBoard() {
        int[][] cornerBoard = new int[][]{{0,O,X,O},
                                          {X,O,O,X},
                                          {X,X,O,O},
                                          {O,X,X,O},
                                          {O,X,O,O}};
        assertFalse(TicTacToe.full(cornerBoard));
    }

    /**
     * Tests to see if an empty board is full
     * Test should pass if false is returned
     */
    @Test
    void emptyEverywhereBoard() {
        int[][] emptyBoard = new int[][]{{0,0,0,0,0},
                                         {0,0,0,0,0},
                                         {0,0,0,0,0},
                                         {0,0,0,0,0}};
        assertFalse(TicTacToe.full(emptyBoard));
    }

    /**
     * Tests to see if a board with only one spot filled in is full
     * Test should pass if false is returned
     */
    @Test
    void emptyEverywhereBut1Board() {
        int[][] oneOnlyBoard = new int[][]{{0,0,0,0,0},
                                           {0,0,X,0,0},
                                           {0,0,0,0,0}};
        assertFalse(TicTacToe.full(oneOnlyBoard));
    }

    /**
     * Tests to see if a win exists within a first row
     * Test should pass if true is returned
     */
    @Test
    void winInFirstRow() {
        int[][] Board = new int[][]{{O,O,O,O,X},
                                    {X,X,X,O,X},
                                    {X,O,X,X,O}};
        assertTrue(TicTacToe.winInRow(Board,0,O));
    }

    /**
     * Tests to see if a win exists within a first row
     * Test should pass if true is returned
     */
    @Test
    void winInLastRow() {
        int[][] Board = new int[][]{{O, O, O, O, X},
                                    {X, O, X, O, X},
                                    {X, X, X, X, O}};
        assertTrue(TicTacToe.winInRow(Board, 2, X));
    }

    /**
     * Tests to see if a win exists within the center of a given row
     * Test should pass if true is returned
     */
    @Test
    void winInCenterOfRow() {
        int[][] Board = new int[][]{{O, X, O, O, X},
                                    {X, O, X, O, X},
                                    {O, X, X, X, O}};
        assertTrue(TicTacToe.winInRow(Board, 2, X));
    }

    /**
     * Tests to see if a win exists at the end of a row
     * Test should pass if true is returned
     */
    @Test
    void winAtTheEndOfRow() {
        int[][] Board = new int[][]{{O, X, O, O, X},
                                    {X, O, X, O, X},
                                    {O, O, X, X, X}};
        assertTrue(TicTacToe.winInRow(Board, 2, X));
    }

    /**
     * Tests to see if no win exists within the row
     * Test should pass if false is returned
     */
    @Test
    void noWinInRow() {
        int[][] Board = new int[][]{{O, X, O, O, X},
                {X, O, X, O, X},
                {O, X, X, X, O}};
        assertFalse(TicTacToe.winInRow(Board, 1, X));
    }

    /**
     * Tests to see if a win exists within the first column
     * Test should pass if true is returned
     */
    @Test
    void winInFirstColumn() {
        int[][] Board = new int[][]{{O, X, X, O},
                                    {O, O, X, O},
                                    {O, X, X, X}};
        assertTrue(TicTacToe.winInColumn(Board, 0,O));
    }

    /**
     * Tests to see if a win exists within the third column
     * Test should pass if true is returned
     */
    @Test
    void winIn3rdColumn() {
        int[][] Board = new int[][]{{O, X, X, O},
                                    {O, O, X, O},
                                    {O, X, X, X}};
        assertTrue(TicTacToe.winInColumn(Board, 2,X));
    }

    /**
     * Tests to see if a win exists within the middle of a column
     * Test should pass if true is returned
     */
    @Test
    void winInMiddleOfColumn() {
        int[][] Board = new int[][]{{O, O, X, O},
                                    {X, X, O, O},
                                    {O, X, X, X},
                                    {X, X, O, O},
                                    {O, O, X, X}};
        assertTrue(TicTacToe.winInColumn(Board, 1,X));
    }

    /**
     * Tests to see if a win exists at the end of a column
     * Test should pass if true is returned
     */
    @Test
    void winAtEndOfColumn() {
        int[][] Board = new int[][]{{O, X, X, O},
                                    {X, O, O, O},
                                    {O, X, X, X},
                                    {X, X, O, O},
                                    {O, X, X, X}};
        assertTrue(TicTacToe.winInColumn(Board, 1,X));
    }

    /**
     * Tests to see if no win exists within a given column
     * Test should pass if false is returned
     */
    @Test
    void noWinInColumn() {
        int[][] Board = new int[][]{{O, X, X, O},
                                    {X, O, O, O},
                                    {O, X, X, X},
                                    {X, X, O, O},
                                    {O, X, X, X}};
        assertFalse(TicTacToe.winInColumn(Board, 2,X));
    }

    /**
     * BS diagonal starting on the right side
     */
    @Test
    void WinInUpperDiagonalBS() {
        int[][] Board = new int[][]{{O, X, X, O},
                                    {X, O, O, O},
                                    {O, X, O, X},
                                    {X, X, O, X},
                                    {O, X, X, X}};
        assertTrue(TicTacToe.winInDiagonalBS(Board,O));
    }

    /**
     * BS diagonal starting on the bottom
     */
    @Test
    void WinInLowerDiagonalBS() {
        int[][] Board = new int[][]{{O, X, X, O},
                                    {X, O, O, O},
                                    {X, X, O, X},
                                    {X, X, O, O},
                                    {O, X, X, X}};
        assertTrue(TicTacToe.winInDiagonalBS(Board,X));
    }

    /**
     * BS diagonal starting in the corner
     */
    @Test
    void WinInRightCornerDiagonalBS() {
        int[][] Board = new int[][]{{O, X, X, O},
                                    {X, O, O, O},
                                    {X, X, O, X},
                                    {X, X, O, O}};
        assertTrue(TicTacToe.winInDiagonalBS(Board,O));
    }

    /**
     * no win in any backslash diagonal
     */
    @Test
    void NoWinInDiagonalBS() {
        int[][] Board = new int[][]{{O, X, X, O},
                                    {X, X, O, O},
                                    {X, X, O, X},
                                    {X, O, O, O},
                                    {O, X, X, X}};
        assertFalse(TicTacToe.winInDiagonalBS(Board, X));
    }

    /**
     * FS diagonal starting on the left side
     */
    @Test
    void winInUpperDiagonalFS() {
        int[][] Board = new int[][]{{O, X, X, O},
                                    {X, O, X, O},
                                    {O, X, O, X},
                                    {X, X, O, X},
                                    {O, X, X, X}};
        assertTrue(TicTacToe.winInDiagonalFS(Board,X));
    }

    /**
     * FS diagonal starting at the bottom
     */
    @Test
    void winInLowerDiagonalFS() {
        int[][] Board = new int[][]{{O, X, X, O},
                                    {X, O, X, O},
                                    {O, O, O, O},
                                    {X, X, O, X},
                                    {O, O, X, X}};
        assertTrue(TicTacToe.winInDiagonalFS(Board,O));
    }

    /**
     * FS diagonal starting at the corner
     */
    @Test
    void winInLeftCornerDiagonalFS() {
        int[][] Board = new int[][]{{O, X, O},
                                    {X, O, X},
                                    {O, O, O}};
        assertTrue(TicTacToe.winInDiagonalFS(Board,O));
    }

    /**
     * no win in any FS diagonal
     */
    @Test
    void noWinDiagonalFS() {
        int[][] Board = new int[][]{{O, X, X, O},
                                    {X, O, X, O},
                                    {O, O, O, O},
                                    {X, X, 0, X},
                                    {O, O, X, X}};
        assertFalse(TicTacToe.winInDiagonalFS(Board,O));
    }

    /**
     * hint for a row win
     */
    @Test
    void hintForOnePossibleRowWin() {
        int[][] Board = new int[][]{{O, 0, X, O},
                                    {X, O, O, X},
                                    {O, 0, X, X},
                                    {O, O, O, 0},
                                    {X, 0, X, 0}};
        assertArrayEquals(new int []{2,1}, TicTacToe.hint(Board, X));
    }

    /**
     * hint for a column win
     */
    @Test
    void hintForOnePossibleColumnWin() {
        int[][] Board = new int[][]{{O, 0, X, 0, O},
                                    {X, O, O, X, O},
                                    {O, 0, X, X, O},
                                    {O, O, O, 0, X},
                                    {X, 0, X, 0, X}};
        assertArrayEquals(new int []{0,3}, TicTacToe.hint(Board, X));
    }

    /**
     * hint for FS diagonal
     */
    @Test
    void hintForOnePossibleFSDiagonalWin() {
        int[][] Board = new int[][]{{O, 0, X, O},
                                    {X, O, X, X},
                                    {O, 0, X, O},
                                    {O, X, O, 0},
                                    {X, 0, X, 0}};
        assertArrayEquals(new int []{4,1}, TicTacToe.hint(Board, O) );
    }

    /**
     * hint for multiple wins
     */
    @Test
    void hintForMultiplePossibleWins() {
        int[][] Board = new int[][]{{O, X, X, O},
                                    {X, O, O, X},
                                    {O, 0, X, O},
                                    {O, X, O, 0},
                                    {0, 0, X, O}};
        assertArrayEquals(new int []{2,1}, TicTacToe.hint(Board, O) );
    }

    /**
     * hint for no possible wins
     */
    @Test
    void hintForNoPossibleWins() {
        int[][] Board = new int[][]{{O, X, 0, X},
                                    {X, O, O, X},
                                    {0, 0, X, O}};
        assertArrayEquals(new int []{-1,-1}, TicTacToe.hint(Board, O) );
    }

    /**
     * factorial of base case 0
     */
    @Test
    void baseCase0Factorial() {
        assertEquals(BigInteger.ONE,TicTacToe.factorial(0));
    }

    /**
     * factorial of base case 1
     */
    @Test
    void baseCase1Factorial() {
        assertEquals(BigInteger.ONE,TicTacToe.factorial(1));
    }

    /**
     * factorial of a small case
     */
    @Test
    void smallFactorial() {
        assertEquals(new BigInteger("6"),TicTacToe.factorial(3));
    }

    /**
     * factorial of a large case
     */
    @Test
    void largeFactorial() {
        assertEquals(new BigInteger("87178291200"),TicTacToe.factorial(14));
    }

    /**
     * factorial of a large case
     */
    @Test
    void largerFactorial() {
        assertEquals(new BigInteger("15511210043330985984000000"),TicTacToe.factorial(25));
    }
}