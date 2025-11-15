import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome! Please enter board size to play TicTacToe:");
        int size = sc.nextInt();

        Board board = new Board(size);
        Game game = new Game(board, new StandardRules());

        Observers notifier = new AppNotification();
        game.addObserver(notifier);

        // Default
        System.out.println("Playing with 2 Players");

        System.out.println("Enter Player 1 name:");
        String name1 = sc.next();
        Player player1 = new Player(1, name1, new Symbol('X'));

        System.out.println("Enter Player 2 name:");
        String name2 = sc.next();
        Player player2 = new Player(1, name2, new Symbol('O'));

        game.addPlayer(player1);
        game.addPlayer(player2);

        game.play();

    }
}