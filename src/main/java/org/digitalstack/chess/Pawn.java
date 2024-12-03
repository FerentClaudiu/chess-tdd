package org.digitalstack.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChesssBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        //verfica daca mutarea este permisa si daca pozitia pe tabla este legala
        if(movementType !=MovementType.MOVE || chessBoard.isLegalBoardPosition(newX,newY)){
            return;}

        //variabila care arata daca mutarea este valida
        boolean isMoveValid= false;

        //verifica mutarea in functie de culoare
        if(pieceColor ==PieceColor.BLACK) {
            //piesa negra se muta doar o pozitie in jos -1
            isMoveValid = (newX == xCoordinate && newY == yCoordinate - 1);
        }else if (pieceColor ==PieceColor.WHITE){
            //piesa alba se poate muta doar o pozitie +1
            } else if (pieceColor == PieceColor.WHITE) {
            isMoveValid = (newX == xCoordinate && newY == yCoordinate + 1);
        }

        //daca mutarea este valida , se actualizeaza coordonatele
        if(isMoveValid){
           setXCoordinate(newX);
           setYCoordinate(newY);
        }

    }



    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.format("Current X: %s\nCurrent Y: %s\nPiece Color: %s", xCoordinate, yCoordinate, pieceColor);
    }
}
