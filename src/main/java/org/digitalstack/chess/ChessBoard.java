package org.digitalstack.chess;

public class ChessBoard {

    private static final int MAX_PAWNS_PER_COLOR =8 ;
    public static int BOARD_WIDTH = 7;
    public static int BOARD_HEIGHT = 7;
    private final Pawn[][] pieces;
    private int blackPawnCount;
    private int whitePawnCount;

    public ChessBoard() {
        pieces = new Pawn[BOARD_WIDTH][BOARD_HEIGHT];
    }

    public void add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        int x = xCoordinate;
        int y = yCoordinate;

        // verfica daca poziția este legala si daca nu  exista deja o piesa in acea poziție
        if (!isLegalBoardPosition(x, y) || pieces[x][y] != null) {
setPawnOffBoard(pawn);
            return;
        }
        // verifica dacă numarul de pioni pentru culoarea respectiva este sub limita maxima
        if ((pieceColor == PieceColor.BLACK && blackPawnCount >= MAX_PAWNS_PER_COLOR) || (pieceColor == PieceColor.WHITE && blackPawnCount >= MAX_PAWNS_PER_COLOR)) {
            setPawnOffBoard(pawn);
            return;
        }
        //adauga piesele si seteaza coordonatele
        pieces[x][y] = pawn;
        pawn.setXCoordinate(x);
        pawn.setYCoordinate(y);
        pawn.setChessBoard(this);

        if (pieceColor == PieceColor.BLACK) {
            blackPawnCount++;
        } else {
            whitePawnCount++;
        }
    }


    boolean isLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return xCoordinate >= 0 && xCoordinate < BOARD_WIDTH && yCoordinate >= 0 && yCoordinate < BOARD_HEIGHT;
        //throw new UnsupportedOperationException("Need to implement ChessBoard.IsLegalBoardPosition()");
        }

    public void setPawnCoordinates(Pawn pawn,int xCoordinate,int yCoordinate){
        pawn.setXCoordinate(xCoordinate);
        pawn.setYCoordinate(yCoordinate);
    }
private void setPawnOffBoard(Pawn pawn) {
        pawn.setYCoordinate(-1);
        pawn.setYCoordinate(-1);
}}
