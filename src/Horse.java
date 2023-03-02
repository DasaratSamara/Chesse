public class Horse extends ChessPiece {
    public Horse(String color) {
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
            int[][] horseArr = new int[2][8];
            horseArr[0][0] = -1;
            horseArr[0][1] = 1;
            horseArr[0][2] = -2;
            horseArr[0][3] = 2;
            horseArr[0][4] = -1;
            horseArr[0][5] = 1;
            horseArr[0][6] = -2;
            horseArr[0][7] = 2;
            horseArr[1][0] = -2;
            horseArr[1][1] = -2;
            horseArr[1][2] = -1;
            horseArr[1][3] = -1;
            horseArr[1][4] = 2;
            horseArr[1][5] = 2;
            horseArr[1][6] = 1;
            horseArr[1][7] = 1;
            for (int i = 0; i < 8; i++) {
                if (line + horseArr[0][i] == toLine & column + horseArr[1][i] == toColumn) {
                    hod = true;
                }
            }
            if (chessBoard.board[toLine][toColumn] != null) {
                if (color.equals(chessBoard.board[toLine][toColumn].getColor())) {
                    hod = false;
                }
            }
                return hod;
            } else {
                return false;
            }
        }

        @Override
        String getSymbol () {
            return "H";
        }

        boolean checkT ( int line, int column, int toLine, int toColumn){
            if (line == toLine & column == toColumn) {
                return false;
            }
            return true;
        }

        boolean checkPol ( int pos){
            return pos >= 0 && pos <= 7;

        }
    }
