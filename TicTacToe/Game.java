import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private final Rules rules;
    private Deque<Player> players = new ArrayDeque<>();
    private List<Observers> observers = new ArrayList<>();

    public boolean gameOver;

    Game(Board board, Rules rules) {
        this.board = board;
        this.rules = rules;
        this.gameOver = false;
    }

    public void addPlayer(Player player) {
        players.addLast(player);
    }

    public void addObserver(Observers observer) {
        observers.add(observer);
    }

    public void notify(String msg) {
        for (Observers observer : observers) {
            observer.update(msg);
        }
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        notify("Game Started!");

        board.display();

        while (!gameOver) {
            if (players.size() < 2) {
                notify("Need at least 2 players!");
                break;
            }

            Player currentPlayer = players.peekFirst();
            notify("Now Playing:" + currentPlayer.getName() + "(" + currentPlayer.getPlayerMark() + ")");
            System.out.println("Enter row:");
            int row = sc.nextInt();
            System.out.println("Enter column:");
            int col = sc.nextInt();

            if (!rules.isValidMove(board, row, col)) {
                notify("Invalid Move! Please try again");
                continue;
            }

            boolean placed = board.placeMark(row, col, currentPlayer.getSymbol());

            if (!placed) {
                notify("Error! Please try again");
                continue;
            }

            board.display();

            // Check Win
            if (rules.checkWin(board, currentPlayer.getSymbol())) {
                notify(currentPlayer.getName() + " Wins!!");
                gameOver = true;
                break;
            }

            // Check Draw
            if (rules.checkDraw(board)) {
                notify("Draw Game!!");
                break;
            }

            // put player in back of deque
            players.removeFirst();
            players.add(currentPlayer);
        }

        notify("Game Over!!");
    }

}
