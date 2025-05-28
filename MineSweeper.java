public class MineSweeper {

    private String[][] board;
    private String[][] gameBoard;
    public MineSweeper(int difficulty){
        board = new String[14][18];
        gameBoard = new String[14][18];
        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[r].length; c++) {
                board[r][c] = "⬜️";
            }
        }
        int mineAmount = 30;
        if (difficulty == 1){
            mineAmount = 20;
        }
        else if (difficulty == 2){
            mineAmount = 30;
        }
        else if (difficulty == 3){
            mineAmount = 40;
        }
        for (int i = 0; i < mineAmount; i++){
            int rRow = (int)(Math.random()*14);
            int rCol = (int)(Math.random()*18);
            if (!board[rRow][rCol].equals("💣")){
                board[rRow][rCol] = "💣";
            }
            else{
                i--;
            }
        }
        for (int c = 0; c < gameBoard.length; c++){
            for (int z = 0; z < gameBoard[0].length; z++){
                gameBoard[c][z] = "⬜️";
                if (!board[c][z].equals("💣")){
                    board[c][z] = "⬜️";
                }
            }
        }

    }
    public void printFBoard(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.println("     1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 ");
        int counter = 1;
        for (int k = 0; k < board.length; k++){
            System.out.print(counter + " ");
            if (counter < 10)
                System.out.print(" ");
            counter++;
            for (int m = 0; m < board[0].length; m++){
                System.out.print("|" + board[k][m]);
            }
            System.out.println("|");
        }
    }

    public void printBoard(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        System.out.println("     1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 ");
        int counter = 1;
        for (int k = 0; k < gameBoard.length; k++){
            System.out.print(counter + " ");
            if (counter < 10)
                System.out.print(" ");
            counter++;
            for (int m = 0; m < gameBoard[0].length; m++){
                System.out.print("|" + gameBoard[k][m]);
            }
            System.out.println("|");
        }
    }
    public boolean changeBoard(int row, int col){
        int numBombs = 0;
        boolean bombSelected = false;
        row--;
        col--;
        if (gameBoard[row][col].equals(board[row][col])){
            if (row == 0){
                if (col > 0 && col < 17){
                    if (board[row+1][col].equals("💣"))
                        numBombs++;
                    if (board[row][col+1].equals("💣"))
                        numBombs++;
                    if (board[row][col-1].equals("💣"))
                        numBombs++;
                    if (board[row+1][col+1].equals("💣"))
                        numBombs++;
                    if (board[row+1][col-1].equals("💣"))
                        numBombs++;
                }
                    
                else if (col == 0){
                    if (board[row+1][col].equals("💣"))
                        numBombs++;
                    if (board[row][col+1].equals("💣"))
                        numBombs++;
                    if (board[row+1][col+1].equals("💣"))
                        numBombs++;
                }
                else if (col == 17){
                    if (board[row+1][col].equals("💣"))
                        numBombs++;
                    if (board[row][col-1].equals("💣"))
                        numBombs++;
                    if (board[row+1][col-1].equals("💣"))
                        numBombs++;
                }
            }
            else if (row == 13){
                if (col > 0 && col < 17){
                    if (board[row-1][col].equals("💣"))
                        numBombs++;
                    if (board[row][col+1].equals("💣"))
                        numBombs++;
                    if (board[row][col-1].equals("💣"))
                        numBombs++;
                    if (board[row-1][col+1].equals("💣"))
                        numBombs++;
                    if (board[row-1][col-1].equals("💣"))
                        numBombs++;
                }
                else if (col == 0){
                    if (board[row-1][col].equals("💣"))
                        numBombs++;
                    if (board[row][col+1].equals("💣"))
                        numBombs++;
                    if (board[row-1][col+1].equals("💣"))
                        numBombs++;
                }
                else if (col == 17){
                    if (board[row-1][col].equals("💣"))
                        numBombs++;
                    if (board[row][col-1].equals("💣"))
                        numBombs++;
                    if (board[row-1][col-1].equals("💣"))
                        numBombs++;
                }
            }
            else if (col == 0 && (row > 0 && row < 13)){
                if (board[row+1][col].equals("💣"))
                    numBombs++;
                if (board[row-1][col].equals("💣"))
                    numBombs++;
                if (board[row][col+1].equals("💣"))
                    numBombs++;
                if (board[row+1][col+1].equals("💣"))
                    numBombs++;
                if (board[row-1][col+1].equals("💣"))
                    numBombs++;
            }
            else if (col == 17 && (row > 0 && row < 13)){
                if (board[row+1][col].equals("💣"))
                    numBombs++;
                if (board[row-1][col].equals("💣"))
                    numBombs++;
                if (board[row][col-1].equals("💣"))
                    numBombs++;
                if (board[row+1][col-1].equals("💣"))
                    numBombs++;
                if (board[row-1][col-1].equals("💣"))
                    numBombs++;
            }
            else{
                if (board[row+1][col].equals("💣"))
                    numBombs++;
                if (board[row-1][col].equals("💣"))
                    numBombs++;
                if (board[row][col-1].equals("💣"))
                    numBombs++;
                if (board[row][col+1].equals("💣"))
                    numBombs++;
                if (board[row+1][col-1].equals("💣"))
                    numBombs++;
                if (board[row-1][col-1].equals("💣"))
                    numBombs++;
                if (board[row+1][col+1].equals("💣"))
                    numBombs++;
                if (board[row-1][col+1].equals("💣"))
                    numBombs++;
            }
        }
        else{
            bombSelected = true;
        }
        if (bombSelected == false){
            if (numBombs == 0){
                gameBoard[row][col] = "0️⃣ ";
            }
            if (numBombs == 1){
                gameBoard[row][col] = "1️⃣ ";
            }
            if (numBombs == 2){
                gameBoard[row][col] = "2️⃣ ";
            }
            if (numBombs == 3){
                gameBoard[row][col] = "3️⃣ ";
            }
            if (numBombs == 4){
                gameBoard[row][col] = "4️⃣ ";
            }
            if (numBombs == 5){
                gameBoard[row][col] = "5️⃣ ";
            }
            if (numBombs == 6){
                gameBoard[row][col] = "6️⃣ ";
            }
            if (numBombs == 7){
                gameBoard[row][col] = "7️⃣ ";
            }
            if (numBombs == 8){
                gameBoard[row][col] = "8️⃣ ";
            }
            
        }
        return bombSelected;
    }

}