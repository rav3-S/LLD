public interface Rules {
    boolean isValidMove(Board b, int row, int col);

    boolean checkWin(Board b, Symbol symbol);

    boolean checkDraw(Board b);
}