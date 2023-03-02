public class King extends ChessPiece {
    int line;
    int column;
    public King(String color) {
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
                if (line == toLine & column + 1 == toColumn) {
                    hod = true;

                }

                if (line - 1 == toLine & column == toColumn) {
                    hod = true;
                }

                if (line == toLine & column - 1 == toColumn) {
                    hod = true;
                }


                if (line + 1 == toLine & column == toColumn) {
                    hod = true;
                }


                if (line + 1 == toLine & column + 1 == toColumn) {
                    hod = true;
                }


                if (line - 1 == toLine & column + 1 == toColumn) {
                    hod = true;
                }

                if (line - 1 == toLine & column - 1 == toColumn) {
                    hod = true;
                }


                if (line + 1 == toLine & column - 1 == toColumn) {
                    hod = true;
                }
            if(chessBoard.board[toLine][toColumn] != null&&color.equals(chessBoard.board[toLine][toColumn].getColor())) {
                hod=false;
            }
            return hod;
        } else {
            return false;
        }

    }
    boolean isUnderAttack(ChessBoard board, int line, int column){
     if(this.line==line&this.column==column){
         return true;
     }
        return false;
    }


    @Override
    String getSymbol() {
        return "K";
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
