import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;

public class GenerateWord {
    private String[] words;

    public GenerateWord() {
        fillWithWordsFromFile();
    }

    private void fillWithWordsFromFile(){
        StringBuilder sb = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(Paths.get("src", "main", "resources", "words.txt").toFile()))){
            reader.lines().forEach(sb::append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        words = sb.toString().split(", ");
    }

    public String getRandomWord(){
        Random random = new Random();
        return words[random.nextInt(words.length)];
    }
}
