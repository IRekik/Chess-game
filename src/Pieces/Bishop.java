package Pieces;
import java.util.ArrayList;

public class Bishop extends Piece {
	private int xPos;
	private int yPos;
	private static int numOfBishops=0;
	private boolean isWhite;
	private boolean firstMove;
	
	public Bishop(boolean isWhite) {
		this.isWhite = isWhite;
		if (isWhite) {
			yPos = 1;
			xPos = 3 + (numOfBishops*3);
		}
		else {
			yPos = 8;
			xPos = 3 + (numOfBishops*3);
		}
		numOfBishops++;
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
	public void resetNumOfBishops() {
		numOfBishops=0;
	}
	public String[] getRange(int x, int y, Piece[][] board) {
		Piece target = board[x-1][y-1];
		ArrayList <String> possibleMoves = new ArrayList<String>();
		boolean keepLooping=true;
		// top right
		for (int i=x,j=y;i<8 && j < 8 && keepLooping;i++,j++) {
			if (board[i][j] == null) {
				possibleMoves.add(Integer.toString(i+1)+Integer.toString(j+1));
			}
			else if (board[i][j].isWhite() == target.isWhite()) {
				keepLooping = false;
			}
			else if (board[i][j].isWhite() != target.isWhite()) {
				possibleMoves.add(Integer.toString(i+1)+Integer.toString(j+1));
				keepLooping = false;
			}
		}
		// top left
		keepLooping = true;
		for (int i=x-2,j=y; i>=0 && j < 8 && keepLooping;i--,j++) {
			if (board[i][j] == null) {
				possibleMoves.add(Integer.toString(i+1)+Integer.toString(j+1));
			}
			else if (board[i][j].isWhite() == target.isWhite()) {
				keepLooping = false;
			}
			else if (board[i][j].isWhite() != target.isWhite()) {
				possibleMoves.add(Integer.toString(i+1)+Integer.toString(j+1));
				keepLooping = false;
			}
		}
		// bottom right
		keepLooping = true;
		for (int i=x,j=y-2; i<8 && j >= 0 && keepLooping;i++,j--) {
			if (board[i][j] == null) {
				possibleMoves.add(Integer.toString(i+1)+Integer.toString(j+1));
			}
			else if (board[i][j].isWhite() == target.isWhite()) {
				keepLooping = false;
			}
			else if (board[i][j].isWhite() != target.isWhite()) {
				possibleMoves.add(Integer.toString(i+1)+Integer.toString(j+1));
				keepLooping = false;
			}
		}
		// bottom left
		keepLooping = true;
		for (int i=x-2,j=y-2; i>=0 && j >= 0 && keepLooping;i--,j--) {
			if (board[i][j] == null) {
				possibleMoves.add(Integer.toString(i+1)+Integer.toString(j+1));
			}
			else if (board[i][j].isWhite() == target.isWhite()) {
				keepLooping = false;
			}
			else if (board[i][j].isWhite() != target.isWhite()) {
				possibleMoves.add(Integer.toString(i+1)+Integer.toString(j+1));
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
