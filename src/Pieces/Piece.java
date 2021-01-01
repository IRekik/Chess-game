package Pieces;

abstract public class Piece {
	protected int xPos;
	protected int yPos;
	
	abstract public void printPosition();
	abstract public int getXPos();
	abstract public int getYPos();
	abstract public String [] getRange(int x,int y, Piece [][] board);
	abstract public void move(int x, int y);
	abstract public boolean isWhite();
}
