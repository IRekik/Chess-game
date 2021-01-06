import Pieces.*;

public class Player {
    private boolean isWhite;
    private boolean isFirst;
    private String name;
    private Pawn pawn1;
    private Pawn pawn2;
    private Pawn pawn3;
    private Pawn pawn4;
    private Pawn pawn5;
    private Pawn pawn6;
    private Pawn pawn7;
    private Pawn pawn8;
    private Rook rook1;
    private Rook rook2;
    private Bishop bishop1;
    private Bishop bishop2;
    private Knight knight1;
    private Knight knight2;
    private King king;
    private Queen queen;
    private Piece [] allPieces = new Piece [16];

    public Player(boolean input, String name) {
        isWhite = input;
        if (isWhite == true) {
            isFirst = true;
        }
        else {
            isFirst = false;
        }
        this.name = name;
    }
	
    public boolean isFirst() {
        return isFirst;
    }
	
    public boolean getIsWhite() {
        return isWhite;
    }
	
    public String getName() {
        return name;
    }
	
    public void generatePawns() {
        pawn1 = new Pawn(isWhite);
        pawn2 = new Pawn(isWhite);
        pawn3 = new Pawn(isWhite);
        pawn4 = new Pawn(isWhite);
        pawn5 = new Pawn(isWhite);
        pawn6 = new Pawn(isWhite);
        pawn7 = new Pawn(isWhite);
        pawn8 = new Pawn(isWhite);
        pawn1.resetNumOfPawns();
    }
	
    public void generateRooks() {
        rook1 = new Rook(isWhite);
        rook2 = new Rook(isWhite);
        rook1.resetNumOfRooks();
    }
	
    public void generateBishops() {
        bishop1 = new Bishop(isWhite);
        bishop2 = new Bishop(isWhite);
        bishop1.resetNumOfBishops();
    }
	
    public void generateKnights() {
        knight1 = new Knight(isWhite);
        knight2 = new Knight(isWhite);
        knight1.resetNumOfKnights();
    }
	
    public void generateKing() {
        king = new King(isWhite);
    }
	
    public void generateQueen() {
        queen = new Queen(isWhite);
    }
	
    public void generateAll() {
        generatePawns();
        generateRooks();
        generateBishops();
        generateKnights();
        generateKing();
        generateQueen();
    }

    public void allPiecesInit() {
        // Pawns
        allPieces[0] = (pawn1 != null) ? pawn1 : null;
        allPieces[1] = (pawn2 != null) ? pawn2 : null;
        allPieces[2] = (pawn3 != null) ? pawn3 : null;
        allPieces[3] = (pawn4 != null) ? pawn4 : null;
        allPieces[4] = (pawn5 != null) ? pawn5 : null;
        allPieces[5] = (pawn6 != null) ? pawn6 : null;
        allPieces[6] = (pawn7 != null) ? pawn7 : null;
        allPieces[7] = (pawn8 != null) ? pawn8 : null;
        // Rooks
        allPieces[8] = (rook1 != null) ? rook1 : null;
        allPieces[9] = (rook2 != null) ? rook2 : null;
        // Bishops
        allPieces[10] = (bishop1 != null) ? bishop1 : null;
        allPieces[11] = (bishop2 != null) ? bishop2 : null;
        // Knights
        allPieces[12] = (knight1 != null) ? knight1 : null;
        allPieces[13] = (knight2 != null) ? knight2 : null;
        // King
        allPieces[14] = (king != null) ? king : null;
        // Queen
        allPieces[15] = (queen != null) ? queen : null;
    }

    public Piece [] getAllPieces() {
        allPiecesInit();
        return allPieces;
    }
	
    public void displayAllPieces() {
        for (int i = 0; i < allPieces.length; i++) {
            System.out.println(allPieces[i].getClass() + "," + "("+ allPieces[i].getXPos() + "," + allPieces[i].getYPos() + ")");
        }
    }
	
    public void play() {

    }
	
    public void deletePiece(Piece p) {
        p = null;
    }
	
    public Piece getPieceAtPosition(int x, int y) {
        for (int i = 0; i < allPieces.length; i++) {
            if (allPieces[i].getXPos() == x && allPieces[i].getYPos() == y) {
                return allPieces[i];
            }
        }
        return null;
    }
}
