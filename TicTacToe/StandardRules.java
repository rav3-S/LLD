public class StandardRules implements Rules {

    @Override
    public boolean isValidMove(Board board, int row, int col) {
        return board.isCellEmpty(row, col);
    }

    @Override
    public boolean checkWin(Board board, Symbol symbol) {
        int size = board.getSize();

        // CHECK ROW WIN

        for (int i = 0; i < size; i++) {
            boolean win = true;
            for (int j = 0; j < size; j++) {
                if (board.getCell(i, j) != symbol) {
                    win = false;
                    break;
                }
            }
            if (win)
                return true;
        }

        // CHECK COL WIN
        for (int j = 0; j < size; j++) {
            boolean win = true;
            for (int i = 0; i < size; i++) {
                if (board.getCell(i, j) != symbol) {
                    win = false;
                    break;
                }
            }
            if (win)
                return true;
        }

        // CHECK DIAGOBNAL WIN
        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (board.getCell(i, i) != symbol) {
                win = false;
                break;
            }
        }
        if (win)
            return true;

        // CHECK ANTI DIAGOBNAL WIN
        win = true;
        for (int i = 0; i < size; i++) {
            if (board.getCell(i, size - 1 - i) != symbol) {
                win = false;
                break;
            }
        }

        return win;

    }

    @Override
    public boolean checkDraw(Board board) {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.isCellEmpty(i, j))
                    return false;
            }
        }
        return true;
    }

}
