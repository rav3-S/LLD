class Board {
    private Symbol[][] grid;
    private int size;
    private final Symbol emptyCell = new Symbol('-');

    Board(int size) {
        this.size = size;
        this.grid = new Symbol[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = emptyCell;
            }
        }
    }

    boolean isCellEmpty(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size)
            return false;

        return grid[row][col] == emptyCell;
    }

    boolean placeMark(int row, int col, Symbol mark) {
        if (row < 0 || row >= size || col < 0 || col >= size)
            return false;

        if (!isCellEmpty(row, col))
            return false;

        grid[row][col] = mark;
        return true;
    }

    Symbol getCell(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size)
            return emptyCell;

        return grid[row][col];
    }

    int getSize() {
        return size;
    }

    // TODO
    void display() {
        System.out.print("   "); // spacing for row labels

        // Print column indices
        for (int col = 0; col < size; col++) {
            System.out.print(col + " ");
        }
        System.out.println();

        // Print each row
        for (int row = 0; row < size; row++) {
            System.out.print(row + "  "); // row index + spacing

            for (int col = 0; col < size; col++) {
                System.out.print(grid[row][col].getMark() + " ");
            }

            System.out.println(); // end of row
        }

        System.out.println(); // blank line after board
    }

}