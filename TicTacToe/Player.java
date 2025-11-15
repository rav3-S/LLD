class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private int score;

    Player(int id, String name, Symbol symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.score = 0;
    }

    int getScore() {
        return score;
    }

    void incrementScore() {
        score++;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public char getPlayerMark() {
        return symbol.getMark();
    }
}