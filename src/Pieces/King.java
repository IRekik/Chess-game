package Pieces;
import java.util.ArrayList;

public class King extends Piece {
	private int xPos;
	private int yPos;
	private boolean isWhite;
	private boolean firstMove;
	
	public King(boolean isWhite) {
		this.isWhite = isWhite;
		if (isWhite) {
			yPos = 1;
			xPos = 5;
		}
		else {
			yPos = 8;
			xPos = 5;
		}
		
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
	public String[] getRange(int x, int y, Piece[][] board) {
		ArrayList <String> possibleMoves = new ArrayList<String>();
		Piece target = board[x-1][y-1];
		// left
		if ((x-2) >= 0 && (board[x-2][y-1] == null || board[x-2][y-1].isWhite() != target.isWhite())) {
			possibleMoves.add(Integer.toString(x-1)+Integer.toString(y));
		}
		// top left
		if ((x-2) >= 0 && y < 8 && (board[x-2][y] == null || board[x-2][y].isWhite() != target.isWhite())) {
			possibleMoves.add(Integer.toString(x-1)+Integer.toString(y+1));
		}
		// top
		if (y < 8 && (board[x-1][y] == null || board[x-1][y].isWhite() != target.isWhite())) {
			possibleMoves.add(Integer.toString(x)+Integer.toString(y+1));
		}
		// top right
		if (x < 8 && y < 8 && (board[x][y] == null || board[x][y].isWhite() != target.isWhite())) {
			possibleMoves.add(Integer.toString(x+1)+Integer.toString(y+1));
		}
		// right
		if (x < 8 && (board[x][y-1] == null || board[x][y-1].isWhite() != target.isWhite())) {
			possibleMoves.add(Integer.toString(x+1)+Integer.toString(y));
		}
		// bottom right
		if (x < 8 && (y-2) >= 0 && (board[x][y-2] == null || board[x][y-2].isWhite() != target.isWhite())) {
			possibleMoves.add(Integer.toString(x+1)+Integer.toString(y-1));
		}
		// bottom
		if ((y-2) >= 0 && (board[x-1][y-2] == null || board[x-1][y-2].isWhite() != target.isWhite())) {
			possibleMoves.add(Integer.toString(x)+Integer.toString(y-1));
		}
		// bottom left
		if ((x-2) >= 0 && (y-2) >= 0 && (board[x-2][y-2] == null || board[x-2][y-2].isWhite() != target.isWhite())) {
			possibleMoves.add(Integer.toString(x-1)+Integer.toString(y-1));
		}
		ArrayList <String> remove = new ArrayList<String>();
		for (int i= 0;i<8;i++) {
			for (int j=0;j<8;j++) {
				if (board[i][j] != null && board[i][j].isWhite() != target.isWhite()) {
					for (int k=0; k<board[i][j].getRange(i+1, j+1, board).length;k++) {
						
						remove.add(board[i][j].getRange(i+1, j+1, board)[k]);

					}
				}
			}
		}
		ArrayList <String> finalReturn = new ArrayList <String>();
		for (int i=0;i<remove.size();i++) {
			if (!possibleMoves.contains(remove.get(i))){
				finalReturn.add(possibleMoves.get(i));
			}
		}
		String [] finalReturner = new String [finalReturn.size()];
		for (int i = 0;i<finalReturn.size();i++) {
			finalReturner [i] = finalReturn.get(i);
		}
		return finalReturner;
	}
	public void move(int x, int y) {
		xPos = x;
		yPos = y;
	}
	public boolean isWhite() {
		return isWhite;
	}
	
}
