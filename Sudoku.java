public class Sudoku{

    public static boolean isSafe(int sudoku[][],int row, int col,int dig){
        // column check
        for(int i=0;i<=8;i++){
            if(sudoku[i][col]==dig){
                return false;
            }
        }

        // Row check
        for(int j=0;j<=8;j++){
            if(sudoku[row][j]==dig){
                return false;
            }
        }

        // grid check
        int sr= (row/3)*3;
        int sc= (col/3)*3;
         // 3*3 grid
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){

                if(sudoku[i][j]==dig){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean sudokuSolwer(int sudoku[][],int row, int col ){
        // base case
        if(row==9){
            return true;
        }

        int nextrow=row,nextcol=col+1;
        if(col+1==9){
            nextrow=row+1;
            nextcol=0;
        }
        
        if(sudoku[row][col]!=0){
            return sudokuSolwer(sudoku,nextrow,nextcol);
        }

        // recursion
        for(int Digit=1;Digit<=9;Digit++){
            if(isSafe(sudoku,row,col,Digit)){
                sudoku[row][col]=Digit;
                    if(sudokuSolwer(sudoku,nextrow,nextcol)){//soln exists
                            return true;
                    }
            sudoku[row][col]=0;
            }
        }

        return false;

    }

    public static void printSudoku(int sudoku[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void main(String args[]){
        int sudoku[][]={
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3}
            };

        if(sudokuSolwer(sudoku,0,0)){
            System.out.println("Sudoku exists!");
        }else{
            System.out.println("Sudoku doesnt exists!");    
        }

        printSudoku(sudoku);
    }
}