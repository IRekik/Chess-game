package Pieces;
import java.util.ArrayList;

public class Knight extends Piece {
	private int xPos;
	private int yPos;
	private static int numOfKnights=0;
	private boolean isWhite;
	private boolean firstMove;
	
	public Knight(boolean isWhite) {
		this.isWhite = isWhite;
		if (isWhite) {
			yPos = 1;
			xPos = 2 + (numOfKnights*5);
		}
		else {
			yPos = 8;
			xPos = 2 + (numOfKnights*5);
		}
		numOfKnights++;
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
	public void resetNumOfKnights() {
		numOfKnights=0;
	}
	public String[] getRange(int x, int y, Piece[][] board) {
		Piece target = board[x-1][y-1];
		ArrayList <String> possibleMoves= new ArrayList<String>();
		if ((x-3) >= 0 && y < 8 && (board[x-3][y] == null || board[x-3][y].isWhite() != target.isWhite())) 
			possibleMoves.add(Integer.toString(x-2)+Integer.toString(y+1));
		if ((x-2) >= 0 && (y+1) < 8 && (board[x-2][y+1] == null || board[x-2][y+1].isWhite() != target.isWhite())) 
			possibleMoves.add(Integer.toString(x-1)+Integer.toString(y+2));
		if ((x+1) < 8 && y < 8 && (board[x+1][y] == null || board[x+1][y].isWhite() != target.isWhite())) 
			possibleMoves.add(Integer.toString(x+2)+Integer.toString(y+1));
		if ((x) < 8 && (y+1) < 8 && (board[x][y+1] == null || board[x][y+1].isWhite() != target.isWhite()))
			possibleMoves.add(Integer.toString(x+1)+Integer.toString(y+2));
		if ((x-3) >= 0 && (y-2) >= 0 && (board[x-3][y-2] == null || board[x-3][y-2].isWhite() != target.isWhite()))
			possibleMoves.add(Integer.toString(x-2)+Integer.toString(y-1));
		if ((x-2) >= 0 && (y-3) >= 0 && (board[x-2][y-3] == null || board[x-2][y-3].isWhite() != target.isWhite()))
			possibleMoves.add(Integer.toString(x-1)+Integer.toString(y-2));
		if ((x+1) < 8 && (y-2) >= 0 && (board[x+1][y-2] == null || board[x+1][y-2].isWhite() != target.isWhite()))
			possibleMoves.add(Integer.toString(x+2)+Integer.toString(y-1));
		if ((x) < 8 && (y-3) >= 0 && (board[x][y-3] == null || board[x][y-3].isWhite() != target.isWhite()))
			possibleMoves.add(Integer.toString(x+1)+Integer.toString(y-2));
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
