

public class SudokuSolver {

    private static final int GRID_SIZE = 9;
    public static void main(String args[]){
        int[][] board = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };

        printBoard(board);

        if (solveBoard(board)) {
            System.out.println("Solved");
        } else {
            System.out.println("Unsolvable board");
        }

        printBoard(board);

    }

    private static void printBoard(int[][] board){
        for(int row = 0; row < GRID_SIZE; row++) {
            if (row % 3 == 0 && row != 0) {
                System.out.println("-----------");
            }
            for(int col = 0; col < GRID_SIZE; col++) {
                if (col % 3 == 0 && col != 0) {
                    System.out.print("|");
                }
                System.out.print(board[row][col]);

            }
            System.out.println();

        }
    }

    private static boolean isNumberInRow(int[][] board,int number,int rowNumber){
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[rowNumber][i] == number){
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] board,int number,int colNumber){
        for(int i = 0; i < GRID_SIZE; i++){
            if(board[i][colNumber] == number){
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInSquare(int[][] board,int number,int rowNumber, int colNumber){
        int row = rowNumber - (rowNumber % 3);
        int col = colNumber - (colNumber % 3);
        for(int i = row; i < row + 3; i++){
            for(int j = col; j < col + 3; j++){
                if(board[i][j] == number){
                    return true;
                }

            }
        }
        return false;
    }

    private static boolean isValidNumber(int[][] board,int number,int rowNumber,int colNumber){
        return !isNumberInRow(board,number,rowNumber) && !isNumberInColumn(board,number,colNumber) && !isNumberInSquare(board,number,rowNumber,colNumber);
    }

    private static boolean solveBoard(int[][] board) {
        for(int row = 0; row < GRID_SIZE;row++){
            for(int col = 0; col < GRID_SIZE;col++){
                if(board[row][col] == 0){
                    for(int number = 0;number <= GRID_SIZE;number++){
                        if(isValidNumber(board,number,row,col)){
                            board[row][col] = number;

                            if(solveBoard(board)) {
                                return true;
                            }
                            else{
                                board[row][col] = 0;
                            }


                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }
}
