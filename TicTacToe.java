import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TicTacToe
 {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> CPUPositions = new ArrayList<Integer>();
    static String name = new String();

    
    
    public static void main(String[] args) {

        // prints the original gameboard 

       
        char [][] gameBoard = {{' ', '|', ' ', '|', ' '}, 
        {'-', '+', '-', '+', '-'}, 
        {' ', '|', ' ', '|', ' '}, 
        {'-', '+', '-', '+', '-'}, 
        {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);
        System.out.println("Welcome Player! Please enter your name!");
        Scanner scan = new Scanner(System.in);
        name = scan.nextLine();
        //loops game until victory conditions met 

        
        while(true){
            
            //prompts player to beign game
            scan = new Scanner(System.in);
            System.out.println(name+"'s"+ " turn! Enter your placement (1-9)");
            int pos = scan.nextInt();
            //checks if player entered valid number
            while(pos<1 || pos>9){
                System.out.println("That is not a valid number!");
                System.out.println("Enter your placement (1-9)");
                pos = scan.nextInt();
            }
            while(playerPositions.contains(pos)|| CPUPositions.contains(pos)){
                System.out.println("This position is already taken. Enter another position.");
                pos = scan.nextInt();
            }

            // places position and displays updated gameBoard
            placePiece(gameBoard, pos, name);
            printGameBoard(gameBoard);
            String result = checkWinner();
            System.out.println(result);
            if(result.length()>0){
                break;
            }
            
            // genertes CPUs position and Gameboard
            Random random = new Random();
            int cpuPos = random.nextInt(9)+1;

            while(playerPositions.contains(cpuPos) || CPUPositions.contains(cpuPos)){
                cpuPos = random.nextInt(9)+1;
            }

            System.out.println();
            System.out.println("CPU's turn!");
            placePiece(gameBoard, cpuPos, "CPU");
            printGameBoard(gameBoard);
            result = checkWinner();
            System.out.println(result);
            if(result.length()>0){
                break;
            }

    }
    }

       public static void printGameBoard(char [][] gameBoard){
        for (char[] row: gameBoard){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }

       }

       public static void placePiece(char[][] gameBoard, int pos, String user){
        
        char symbol = ' ';
        if(user.equals(name)){
            symbol = 'X';
            playerPositions.add(pos);
        }
        else if(user.equals("CPU")){
            symbol = '0';
            CPUPositions.add(pos);
        }

        
        switch(pos) {
            case 1: 
            gameBoard[0][0] = symbol;
            break;

            case 2: 
            gameBoard[0][2] = symbol;
            break;

            case 3: 
            gameBoard[0][4] =symbol;
            break;

            case 4: 
            gameBoard[2][0] = symbol;
            break;

            case 5: 
            gameBoard[2][2] = symbol;
            break;

            case 6: 
            gameBoard[2][4] = symbol;
            break;

            case 7: 
            gameBoard[4][0] = symbol;
            break;

            case 8: 
            gameBoard[4][2] = symbol;
            break;

            case 9: 
            gameBoard[4][4] = symbol;
            break;

            default:
            break;


        }
       }

       public static String checkWinner() {

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List leftDiag = Arrays.asList(1, 5, 9);
        List rightDiag = Arrays.asList(3, 5, 7);

        List<List> winning = new ArrayList<List>();

        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(leftDiag);
        winning.add(rightDiag);

        for(List l : winning){
            if(playerPositions.containsAll(l)){
                return "Congratulations you win!";
            }
            else if(CPUPositions.containsAll(l)){
                return "You lose!";
            }
            else if(playerPositions.size() + CPUPositions.size() == 9){
                return "It's a draw, which means no one wins, which means you all lose and your parents probably do not love you :)";
            }
        }
        return "";


       }
        
    } 

