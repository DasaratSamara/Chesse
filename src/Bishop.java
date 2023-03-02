public class Bishop extends ChessPiece {
    public Bishop(String color) {
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

            for (int i = 1; checkPol(line + i) && checkPol(column + i); i++) {
                if (chessBoard.board[line + i][column + i] != null) {
                    if (line + i == toLine & column + i == toColumn && !color.equals(chessBoard.board[toLine][toColumn].getColor())) {
                        hod = true;
                    }
                    break;
                }
                if (line + i == toLine & column + i == toColumn) {
                    hod = true;
                }

            }
            for (int i = 1; checkPol(line - i) && checkPol(column + i) ; i++) {
                if (chessBoard.board[line - i][column + i] != null) {
                    if (line - i == toLine & column + i == toColumn && !color.equals(chessBoard.board[toLine][toColumn].getColor())) {
                        hod = true;
                    }
                    break;
                }

                if (line - i == toLine & column + i == toColumn) {
                    hod = true;
                }
            }
            for (int i = 1; checkPol(line - i) && checkPol(column - i) ; i++) {
                if (chessBoard.board[line - i][column - i] != null) {
                    if (line - i == toLine & column - i == toColumn && !color.equals(chessBoard.board[toLine][toColumn].getColor())) {
                        hod = true;
                    }
                    break;
                }

                if (line - i == toLine & column - i == toColumn) {
                    hod = true;
                }
            }
            for (int i = 1; checkPol(line + i) && checkPol(column - i) ; i++) {

                if (chessBoard.board[line + i][column - i] != null) {
                    if (line + i == toLine & column - i == toColumn && !color.equals(chessBoard.board[toLine][toColumn].getColor())) {
                        hod = true;
                    }
                    break;
                }
                if (line + i == toLine & column - i == toColumn) {
                    hod = true;
                }
            }
            return hod;
        } else {
            return false;
        }
    }

    @Override
    String getSymbol() {
        return "B";
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
