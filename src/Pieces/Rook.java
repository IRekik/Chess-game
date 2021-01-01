package Pieces;
import java.util.ArrayList;


public class Rook extends Piece {
	private int xPos;
	private int yPos;
	private static int numOfRooks=0;
	private boolean isWhite;
	private boolean firstMove;
	
	public Rook(boolean isWhite) {
		this.isWhite = isWhite;
		if (isWhite) {
			yPos = 1;
			xPos = 1 + (numOfRooks*7);
		}
		else {
			yPos = 8;
			xPos = 1 + (numOfRooks*7);
		}
		numOfRooks++;
	}
	public void printPosition() {
		System.out.println(xPos+", "+yPos);
	}
	public int getXPos() {
		return xPos;
	}
	public int getYPos() {
		return yPos;
	}
	public void resetNumOfRooks() {
		numOfRooks=0;
	}
	public String[] getRange(int x, int y, Piece[][] board) {
		Piece target = board[x-1][y-1];
		ArrayList <String> possibleMoves = new ArrayList<String>();
		boolean keepLooping=true;
		// Right x axis
		for (int i=x;i<8 && keepLooping;i++) {
			if (board[i][y-1] == null) {
				possibleMoves.add(Integer.toString(i+1)+Integer.toString(y));
			}
			else if (board[i][y-1].isWhite() == target.isWhite()) {
				keepLooping = false;
			}
			else if (board[i][y-1].isWhite() != target.isWhite()) {
				possibleMoves.add(Integer.toString(i+1)+Integer.toString(y));
				keepLooping = false;
			}
		}
		// Left x axis
		keepLooping = true;
		for (int i=x-2;i>=0 && keepLooping;i--) {
			if (board[i][y-1] == null) {
				possibleMoves.add(Integer.toString(i+1)+Integer.toString(y));
			}
			else if (board[i][y-1].isWhite() == target.isWhite()) {
				keepLooping = false;
			}
			else if (board[i][y-1].isWhite() != target.isWhite()) {
				possibleMoves.add(Integer.toString(i+1)+Integer.toString(y));
				keepLooping = false;
			}
		}
		// Up y axis
		keepLooping = true;
		for (int i=y;i<8 && keepLooping;i++) {
			if (board[x-1][i] == null) {
				possibleMoves.add(Integer.toString(x)+Integer.toString(i+1));
			}
			else if (board[x-1][i].isWhite() == target.isWhite()) {
				keepLooping = false;
			}
			else if (board[x-1][i].isWhite() != target.isWhite()) {
				possibleMoves.add(Integer.toString(x)+Integer.toString(i+1));
				keepLooping = false;
			}
		}
		// Down y axis
		keepLooping = true;
		for (int i=y-2;i>=0 && keepLooping;i--) {
			if (board[x-1][i] == null) {
				possibleMoves.add(Integer.toString(x)+Integer.toString(i+1));
			}
			else if (board[x-1][i].isWhite() == target.isWhite()) {
				keepLooping = false;
			}
			else if (board[x-1][i].isWhite() != target.isWhite()) {
				possibleMoves.add(Integer.toString(x)+Integer.toString(i+1));
				keepLooping = false;
			}
		}
		String [] returnValue = new String [possibleMoves.size()];
		for (int i = 0 ; i < possibleMoves.size(); i++) {
			returnValue[i] = possibleMoves.get(i);
		}
		return returnValue;
	}
	public void move(int x, int y) {
		xPos = x;
		yPos = y;		
	}
	public boolean isWhite() {
		return isWhite;
	}
	

}
