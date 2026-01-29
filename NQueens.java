public class NQueens{

    public static boolean isSafe(char[][] board,int row,int col){
            // vertical up
            for(int i=row-1;i>=0;i--){
                if(board[i][col]=='Q'){
                    return false;
                }
            }
            // right digonal up
            for(int i=row-1,j=col+1;i>=0 && j<board[0].length;i--,j++){
                if(board[i][j]=='Q'){
                    return false;
                }
            }
            // left diagonal up
            for(int i=row-1,j=col-1;i>=0 &&j>=0;i--,j--){
                if(board[i][j]=='Q'){
                    return false;
                }
            }

            return true;
    }


    public static void nQueens(char[][] board,int row){

    // Base   
    if(board.length==row){
        printBoard(board);
        return;
    }
    // recursion
        for(int i=0;i<board.length;i++){
              if(isSafe(board,row,i)) {
                board[row][i]='Q';
                nQueens(board,row+1);//fun call
                board[row][i]='x';
              } 
            
        }
    }


    public static void printBoard(char board[][]){
        
    System.out.println("------Chess board------");

            for(int i=0;i<board.length;i++)
            {
                for(int j=0;j<board.length;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }        

   }

    public static void main(String args[]){
        int n= 4;
        char board[][]= new char[n][n];

        // initialize board

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]='X';
            }
        }

        nQueens(board,0);
    }
}