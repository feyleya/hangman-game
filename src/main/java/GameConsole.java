import java.util.Scanner;

public class GameConsole {
    public static final int MAX_MISTAKES = 6;
    public static final String SEPARATOR = "---------------------------------------";

    public void startGame() {
        GenerateWord generateWord = new GenerateWord();
        Scanner scanner = new Scanner(System.in);
        String word = generateWord.getRandomWord(); //секретное слово
        DrawHangman drawHangman = new DrawHangman();

        ControlMask controlMask = new ControlMask();
        controlMask.setWord(word);
        while (isGameInProgress(controlMask)) {
            System.out.println(SEPARATOR);
            System.out.println("Введите букву: ");
            String ch = scanner.nextLine();
            if (isValidInput(ch)) {
                System.out.println("Неверный ввод! Нужно ввести одну маленькую букву кириллицы");
                continue;
            }
            if (controlMask.containsUsersLetter(ch)) {
                System.out.println("Вы уже вводили букву: " + ch);
                continue;
            }
            controlMask.setUsersLetters(ch);
            if (controlMask.containsLetterInWord(ch)) {
                userGuessedLetter(controlMask, ch);
            } else {
                userFailedToGuessLetter(controlMask, drawHangman);
            }
        }
        printGameResult(controlMask, word);
    }

    private boolean isGameInProgress(ControlMask controlMask) {
        return controlMask.getCountOfMistakes() != MAX_MISTAKES &&
                controlMask.getCountOfLettersGuessed() != controlMask.countUniqLettersOfWord();
    }

    private void printGameResult(ControlMask controlMask, String word) {
        if (controlMask.getCountOfLettersGuessed() == controlMask.countUniqLettersOfWord()) {
            System.out.println("Вы выиграли! Загаданное слово: " + word);
            System.out.println(SEPARATOR);
        } else {
            System.out.println("Вы проиграли! Загаданное слово: " + word);
            System.out.println(SEPARATOR);
        }
    }

    private void userGuessedLetter(ControlMask controlMask, String ch) {
        System.out.println("Вы угадали букву!");
        controlMask.incrementCountOfLettersGuessed();
        System.out.println("Введенные буквы: " + controlMask.getUsersLetters());
        System.out.println("Количество угаданных букв: " + controlMask.getCountOfLettersGuessed());
        System.out.println("Количество ошибок: " + controlMask.getCountOfMistakes());
        controlMask.updateMask(ch);
        controlMask.printMask();
    }

    private void userFailedToGuessLetter(ControlMask controlMask, DrawHangman drawHangman) {
        System.out.println("Такой буквы нет!");
        System.out.println(drawHangman.getHangman(controlMask.getCountOfMistakes()));
        controlMask.incrementCountOfMistakes();
        System.out.println("Введенные буквы: " + controlMask.getUsersLetters());
        System.out.println("Количество ошибок: " + controlMask.getCountOfMistakes());
        controlMask.printMask();
    }

    private boolean isValidInput(String ch) {
        return (!ch.matches("[а-я]+") || (ch.length() > 1));
    }
}
