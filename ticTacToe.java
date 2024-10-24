import java.util.Scanner;

public class ticTacToe {
    public static void printBoard(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
    }
    public static boolean haveWon(char[][] board,char player){
        //check the row
        for(int i=0;i<board.length;i++){
            if(board[i][0]==player && board[i][1]==player && board[i][2]==player){
                return  true;
            }
        }

        for(int j=0;j<board.length;j++){
            if(board[0][j]==player && board[1][j]==player && board[2][j]==player){
                return  true;
            }
        }
        //check for diagonal
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
            return true;
        }
        if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
            return true;
        }

        return false;
    }
    public static void main(String[] args){
        char[][] board=new char[3][3];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=' ';
            }
        }
        char player='X';
        boolean gameOver=false;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to TicTacToe");
        while(!gameOver){

            printBoard(board);

            System.out.println("Player "+player+" has to enter:(0-based index and (row,column) aspect 0 to 2)");
            int row=sc.nextInt();
            int col=sc.nextInt();
            System.out.println();
            if(board[row][col]==' '){
                board[row][col]=player;//place the element
                gameOver=haveWon(board,player);
                if(gameOver){
                    System.out.println("Player "+player+" has won"+" \uD83D\uDC4F ");
                }else{
                    player=(player=='X')?'O':'X';
                }
            }else{
                System.out.println("invalid move and try again");
            }
        }
        System.out.println();
        printBoard(board);
    }
}
