package Pieces;

public class Pawn extends Piece {
	private int xPos;
	private int yPos;
	private static int numOfPawns=0;
	private boolean isWhite;
	private boolean firstMove;
	private int numOfMoves;
	
	public Pawn(boolean isWhite) {
		this.isWhite = isWhite;
		if (isWhite) {
			yPos = 2;
			xPos = numOfPawns + 1;
		}
		else {
			yPos = 7;
			xPos = 8 - numOfPawns;
		}
		numOfPawns++;
	}
	public boolean isWhite() {
		return isWhite;
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
	public void resetNumOfPawns() {
		numOfPawns=0;
	}
	public void move(int x, int y) {
		xPos = x;
		yPos = y;
		numOfMoves++;
	}
	public String[] getRange (int x, int y,Piece [][] board) {
		Piece whiteLeftDiagonal= null;
		Piece whiteRightDiagonal=null;
		Piece blackLeftDiagonal=null;
		Piece blackRightDiagonal=null;
		try {
			whiteLeftDiagonal= board[x-2][y];
			whiteRightDiagonal=board[x][y];
		}
		catch (Exception e) {
				
		}
		try {
			blackLeftDiagonal= board[x-2][y-2];
			blackRightDiagonal=board[x][y-2];
		}
		catch (Exception e) {
			
		}
		String [] returnValue = null;
		String [] finalReturnValue = null;
		if (isWhite && yPos == 2 && board[x-1][y] == null && board[x-1][y+1] == null) {
			returnValue = new String [2];
			returnValue[0]=Integer.toString(x)+Integer.toString(y+1);
			returnValue[1]=Integer.toString(x)+Integer.toString(y+2);
			return returnValue;
		}
		else if (isWhite && yPos == 2 && board[x-1][y] == null && board[x-1][y+1] != null) {
			returnValue = new String [1];
			returnValue[0]=Integer.toString(x)+Integer.toString(y+1);
			
		}

		else if (isWhite && yPos == 2 && board[x-1][y] != null && board[x-1][y+1] != null) {
			returnValue = null;
		}
		else if (isWhite && yPos != 2 && board[x-1][y] == null) {
			returnValue = new String [1];
			returnValue[0]=Integer.toString(x)+Integer.toString(y+1);
		}
		else if (isWhite && yPos != 2 && board[x-1][y] != null) {
			returnValue = null;
		}
		else if (!isWhite && yPos == 7 && board[x-1][y-3] == null && board[x-1][y-2] == null) {
			returnValue = new String [2];
			returnValue[0]=Integer.toString(x)+Integer.toString(y-1);
			returnValue[1]=Integer.toString(x)+Integer.toString(y-2);
			
		}
		else if (!isWhite && yPos == 7 && board[x-1][y-3] == null && board[x-1][y-2] != null) {
			returnValue = new String [1];
			returnValue[0]=Integer.toString(x)+Integer.toString(y-1);			
		}
		else if (!isWhite && yPos == 7 && board[x-1][y-3] != null && board[x-1][y-2] != null) {
			returnValue = null;		
		}
		else if (!isWhite && yPos != 7 && board[x-1][y-2] == null) {
			returnValue = new String [1];
			returnValue[0] = Integer.toString(x)+Integer.toString(y-1);
		}
		else if (!isWhite && yPos != 7 && board[x-1][y-2] != null) {
			returnValue = null;
		}
		
		if (isWhite && whiteLeftDiagonal != null && whiteRightDiagonal != null) {
			if (returnValue != null) {
				finalReturnValue = new String[returnValue.length+2];
				for (int i = 0; i<returnValue.length;i++) {
					finalReturnValue[i]=returnValue[i];
					
				}
				finalReturnValue[finalReturnValue.length-2] = Integer.toString(x-1)+Integer.toString(y+1);
				finalReturnValue[finalReturnValue.length-1] = Integer.toString(x+1)+Integer.toString(y+1);
			} 
			else {
				finalReturnValue = new String[2];
				finalReturnValue[0] = Integer.toString(x-1)+Integer.toString(y+1);
				finalReturnValue[1] = Integer.toString(x+1)+Integer.toString(y+1);
			}
		}
		else if (isWhite && whiteLeftDiagonal != null && whiteRightDiagonal == null) {
			if (returnValue != null) {
				finalReturnValue = new String[returnValue.length+1];
				for (int i = 0; i<returnValue.length;i++) {
					finalReturnValue[i]=returnValue[i];
				}
				finalReturnValue[finalReturnValue.length-1] = Integer.toString(x-1)+Integer.toString(y+1);
			} 
			else {
				finalReturnValue = new String[1];
				finalReturnValue[0] = Integer.toString(x-1)+Integer.toString(y+1);
			}			
			
		}
		else if (isWhite && whiteLeftDiagonal == null && whiteRightDiagonal != null) {
			if (returnValue != null) {
				finalReturnValue = new String[returnValue.length+1];
				for (int i = 0; i<returnValue.length;i++) {
					finalReturnValue[i]=returnValue[i];
				}
				finalReturnValue[finalReturnValue.length-1] = Integer.toString(x+1)+Integer.toString(y+1);

			} 
			else {
				finalReturnValue = new String[1];
				finalReturnValue[0] = Integer.toString(x+1)+Integer.toString(y+1);

			}
			
		}
		
		else if (!isWhite && blackLeftDiagonal != null && blackRightDiagonal != null) {
			if (returnValue != null) {
				finalReturnValue = new String[returnValue.length+2];
				for (int i = 0; i<returnValue.length;i++) {
					finalReturnValue[i]=returnValue[i];
				}
				finalReturnValue[returnValue.length-2] = Integer.toString(x-1)+Integer.toString(y-1);
				finalReturnValue[returnValue.length-1] = Integer.toString(x+1)+Integer.toString(y-1);
			} 
			else {
				finalReturnValue = new String[2];
				finalReturnValue[0] = Integer.toString(x-1)+Integer.toString(y-1);
				finalReturnValue[1] = Integer.toString(x+1)+Integer.toString(y-1);
			}
			
			
		}
		else if (!isWhite && blackLeftDiagonal != null && blackRightDiagonal == null) {
			if (returnValue != null) {
				finalReturnValue = new String[returnValue.length+1];
				for (int i = 0; i<returnValue.length;i++) {
					finalReturnValue[i]=returnValue[i];
				}
				finalReturnValue[returnValue.length-1] = Integer.toString(x-1)+Integer.toString(y-1);
			} 
			else {
				finalReturnValue = new String[1];
				finalReturnValue[0] = Integer.toString(x-1)+Integer.toString(y-1);
			}
			
		}
		else if (!isWhite && blackLeftDiagonal == null && blackRightDiagonal != null) {
			if (returnValue != null) {
				finalReturnValue = new String[returnValue.length+1];
				for (int i = 0; i<returnValue.length;i++) {
					finalReturnValue[i]=returnValue[i];
				}
				finalReturnValue[returnValue.length-1] = Integer.toString(x+1)+Integer.toString(y-1);

			} 
			else {
				finalReturnValue = new String[1];
				finalReturnValue[0] = Integer.toString(x+1)+Integer.toString(y-1);

			}
			
		}
		else {
			finalReturnValue = returnValue;
		}
		

		return finalReturnValue;
	}
}
