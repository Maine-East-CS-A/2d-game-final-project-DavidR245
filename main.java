import java.util.Scanner;

public class main{

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("What difficulty of Minesweeper would you like to play?\n1 = 20 Bombs\n2 = 30 Bombs\n3 = 40 Bombs");
        int diff = scan.nextInt();
        MineSweeper ms = new MineSweeper(diff);
        ms.printBoard();
        System.out.println("Your Board has been printed, so sweep the board without hitting any mines!");
        boolean check = false;
        while (check == false){
            System.out.println("Give an X Coordinate (1-18) and Y Coordinate (1-14):");
            int n = scan.nextInt();
            int l = scan.nextInt();
            check = ms.changeBoard(l, n);
            ms.printBoard();
            if (check == true){
                ms.printFBoard();
                System.out.println("You chose a bomb! You lose!");
            }
        }


    }

}