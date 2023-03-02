public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkT(line, column, toLine, toColumn) && checkPol(toLine) && checkPol(toColumn)) {
            boolean hod = false;

            if (chessBoard.board[toLine][toColumn] != null) {
                if (color.equals("White") && chessBoard.board[toLine][toColumn].getColor().equals("Black")) {
                    if (line + 1 == toLine & column + 1 == toColumn) {
                        hod = true;
                    }
                    if (line + 1 == toLine & column - 1 == toColumn) {
                        hod = true;
                    }
                }
                if (color.equals("Black") && chessBoard.board[toLine][toColumn].getColor().equals("White")) {
                    if (line - 1 == toLine & column + 1 == toColumn) {
                        hod = true;
                    }
                    if (line - 1 == toLine & column - 1 == toColumn) {
                        hod = true;
                    }
                }

            }
            if (chessBoard.board[toLine][toColumn] == null) {

                if (color.equals("White")) {

                    if (line == 1 & line + 2 == toLine & column == toColumn
                            && chessBoard.board[toLine - 1][toColumn] == null) {
                        hod = true;
                    }
                    if (line == 1 & line + 1 == toLine & column == toColumn) {
                        hod = true;
                    }
                    if (line != 1 & line + 1 == toLine & column == toColumn) {
                        hod = true;
                    }
                }
                if (color.equals("Black")) {
                    if (line == 6 & line - 2 == toLine & column == toColumn
                            && chessBoard.board[toLine + 1][toColumn] == null) {
                        hod = true;
                    }
                    if (line == 6 & line - 1 == toLine & column == toColumn) {
                        hod = true;
                    }
                    if (line != 6 & line - 1 == toLine & column == toColumn) {
                        hod = true;
                    }
                }
            }

            return hod;
        } else {
            return false;
        }

    }

    @Override
    String getSymbol() {
        return "P";
    }

    boolean checkT(int line, int column, int toLine, int toColumn) {
        if (line == toLine & column == toColumn) {
            return false;
        }
        return true;
    }

    boolean checkPol(int pos) {
        return pos >= 0 && pos <= 7;

    }
}
