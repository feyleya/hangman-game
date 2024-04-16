import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру \"Виселица\"!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Начать новую игру - 1, выйти из игры - 2");
            if (scanner.hasNextInt()) {
                int gameMode = scanner.nextInt();
                if (gameMode == 1) {
                    GameConsole gameConsole = new GameConsole();
                    gameConsole.startGame();
                } else if (gameMode == 2) {
                    return;
                } else {
                    System.out.println("Неверный ввод!");
                    scanner.next();
                }
            } else {
                System.out.println("Неверный ввод!");
                scanner.next();
            }
        }
    }
}
