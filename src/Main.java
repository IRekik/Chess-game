import Pieces.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static Piece deletedPiece;
    public static ArrayList <Piece> deadPieces = new ArrayList <Piece>();
    public static boolean firstPlayerPlayed = false;

    public static String pieceToString (Piece p) {
        String className = p.getClass().getName();
        switch(className) {
            case "Pawn": return "P";
            case "Rook": return "R";
            case "Bishop": return "B";
            case "Knight": return "N";
            case "King": return "K";
            case "Queen": return "Q";
            default: return null;
        }
    }

    public static void displayBoard(Piece [][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print(".");
                }
                else {
                    System.out.print(pieceToString(board[i][j]));
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the chess game.");
        System.out.println("Who will be playing the white pieces? Type 1 for player 1 and 2 for player 2");
        Scanner sc = new Scanner(System.in);
        int order = sc.nextInt();
        Player player1 = null;
        Player player2 = null;
        Player firstPlayer = null;
        Player secondPlayer = null;
        boolean keepGoing = false;
        while (keepGoing == false) {
            if (order == 1) {
                player1 = new Player(true, "Player 1");
                firstPlayer = player1;
                player2 = new Player(false, "Player 2");
                secondPlayer = player2;
                keepGoing = true;
            }
            else if (order == 2){
                player1 = new Player(false, "Player 1");
                secondPlayer = player1;
                player2 = new Player(true, "Player 2");
                firstPlayer = player2;
                keepGoing = true;
            }
            else {
                keepGoing = false;
                System.out.println("Please enter a valid number.");
                order = sc.nextInt();
            }
        }
        System.out.println("Generating the board");
        player1.generateAll();
        player2.generateAll();
        Piece [] firstPlayerContainer = firstPlayer.getAllPieces();
        Piece [] secondPlayerContainer = secondPlayer.getAllPieces();
        Piece [][] board = new Piece[8][8];
        refresh(firstPlayerContainer, secondPlayerContainer, board, player1, player2);
        displayBoard(board);
        System.out.println("Let the game start!");
        System.out.println("You are starting first, " + firstPlayer.getName());
        Scanner movement = new Scanner(System.in);
        boolean gameIsDone = false;
        while (!gameIsDone) {
            String move = movement.nextLine();
            if (move.equals("display")) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        System.out.println(board[i][j] + " " + i + " " + j);
                    }
                }
                continue;
            }
            play(firstPlayer, move, board, firstPlayerContainer, secondPlayerContainer, player1, player2);
            if (firstPlayerPlayed == true) {
                firstPlayerPlayed = false;
                move = movement.nextLine();
                if (move.equals("display")) {
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            System.out.println(board[i][j] + " " + i + " " + j);
                        }
                    }
                    continue;
                }
                play(secondPlayer, move, board, firstPlayerContainer, secondPlayerContainer, player1, player2);
            }
        }
    }

    public static void play(Player p, String movement, Piece [][] board, Piece [] firstPlayerContainer, Piece [] secondPlayerContainer, Player firstPlayer, Player secondPlayer) {
        int initialX = Integer.parseInt(movement.substring(0, 1))-1;
        int initialY = Integer.parseInt(movement.substring(1, 2))-1;
        int finalX = Integer.parseInt(movement.substring(2, 3))-1;
        int finalY = Integer.parseInt(movement.substring(3, 4))-1;
        int finalMove = Integer.parseInt(Integer.toString(finalX + 1) + "" + Integer.toString(finalY + 1));

        if (board[initialX][initialY] == null) {
            System.out.println("There are no pieces at that position. Please chose a valid position.");
        }
        else {
            Piece selectedPiece = board[initialX][initialY];
            refresh(firstPlayerContainer, secondPlayerContainer, board, firstPlayer, secondPlayer);
            if(finalX >= 0 && finalX < 8 && finalY >= 0 && finalY < 8 && selectedPiece.getRange(initialX + 1,  initialY + 1,  board) != null ) {
                int [] possibleMovements = new int [selectedPiece.getRange(initialX + 1, initialY + 1, board).length];
                for (int i = 0 ; i< selectedPiece.getRange(initialX + 1, initialY + 1, board).length; i +  + ) {
                    try {
                        possibleMovements[i]=Integer.parseInt(selectedPiece.getRange(initialX + 1, initialY + 1, board)[i]);
                    }
                    catch (Exception e) {

                    }
                    System.out.println(possibleMovements[i]);
                }
                if (isMoveLegit(possibleMovements, finalMove)) {
                    movement(selectedPiece, finalX, finalY, board, firstPlayerContainer, secondPlayerContainer, firstPlayer,  secondPlayer);
                    firstPlayerPlayed=true;
                }
                else {
                    System.out.println("Move not allowed. Replay");
                }
            }
            else {
                System.out.println("Move not allowed. Replay");
            }
            refresh(firstPlayerContainer, secondPlayerContainer, board, firstPlayer, secondPlayer);
            displayBoard(board);
        }
    }
    public static boolean isMoveLegit(int [] possibleMoves, int finalPos) {
        for (int element : possibleMoves) {
            if (element == finalPos) {
                return true;
            }
        }
        return false;
    }
    public static void refresh(Piece[] firstPlayerContainer, Piece[] secondPlayerContainer, Piece[][] board, Player firstPlayer, Player secondPlayer) {
        refreshContainers(firstPlayerContainer, secondPlayerContainer, firstPlayer, secondPlayer);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }
        int xPos = 0;
        int yPos = 0;
        for (int i = 0 ; i< 16; i++) {
            xPos = firstPlayerContainer[i].getXPos();
            yPos = firstPlayerContainer[i].getYPos();
            board [xPos-1][yPos-1] = firstPlayerContainer[i];
        }
        if (deadPieces != null) {
            for (int i = 0 ; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    for (int k = 0 ; k<deadPieces.size(); k++) {
                        if (board[i][j] == deadPieces.get(k)) {
                            if (firstPlayer.getPieceAtPosition(i + 1, j + 1) != null) {
                                board[i][j] = secondPlayer.getPieceAtPosition(i + 1, j + 1);
                            }
                            else {
                                board[i][j] = null;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0 ; i < 16; i++) {
            xPos = secondPlayerContainer[i].getXPos();
            yPos = secondPlayerContainer[i].getYPos();
            board [xPos-1][yPos-1] = secondPlayerContainer[i];
        }
        if (deadPieces != null) {
            for (int i = 0 ; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    for (int k = 0; k < deadPieces.size(); k++) {
                        if (board[i][j] == deadPieces.get(k)) {
                            if (firstPlayer.getPieceAtPosition(i + 1, j + 1) != null) {
                                board[i][j] = firstPlayer.getPieceAtPosition(i + 1, j + 1);
                            }
                            else {
                                board[i][j] = null;
                            }
                        }
                    }
                }
            }
        }

    }

    public static void refreshContainers(Piece [] firstPlayerContainer, Piece [] secondPlayerContainer, Player firstPlayer, Player secondPlayer) {
        for (int i = 0; i < firstPlayerContainer.length; i++) {
            firstPlayerContainer[i] = null;
            secondPlayerContainer[i] = null;
        }
        firstPlayerContainer = firstPlayer.getAllPieces();
        secondPlayerContainer = secondPlayer.getAllPieces();

    }

    public static void movement(Piece selectedPiece, int x, int y, Piece [][] board, Piece [] firstPlayerContainer, Piece [] secondPlayerContainer, Player firstPlayer, Player secondPlayer) {
        if (board[x][y] != null) {
            Piece toAdd= board[x][y];
            deadPieces.add(toAdd);
        }
        selectedPiece.move(x + 1, y + 1);
    }

    public static void removeFromContainer (Piece deletedPiece, Piece [] firstPlayerContainer, Piece [] secondPlayerContainer) {
        for (int i = 0; i < firstPlayerContainer.length; i++) {
            if (deletedPiece == firstPlayerContainer[i]) {
                firstPlayerContainer[i] = null;
            }
            if (deletedPiece == secondPlayerContainer[i]) {
                secondPlayerContainer[i] = null;
            }
        }
    }
}
