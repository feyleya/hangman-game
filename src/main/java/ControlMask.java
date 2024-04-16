import java.util.*;

public class ControlMask {
    private String[] wordWithMask;
    private Set<String> usersLetters = new HashSet<>();
    private final Set<String> uniqLettersOfWord = new HashSet<>();
    private int countOfLettersGuessed = 0;
    private int countOfMistakes = 0;
    private Map<String, List<Integer>> charactersInWord = new HashMap<>();

        public void setWord(String word){
        this.wordWithMask = new String[word.length()];
        Arrays.fill(wordWithMask, "*");
        Collections.addAll(uniqLettersOfWord, word.split(""));
        for (int i = 0; i < word.length(); i++){
            String letter = String.valueOf(word.charAt(i));
            List<Integer> idx = charactersInWord.getOrDefault(letter, new ArrayList<>());
            idx.add(i);
            charactersInWord.put(letter, idx);
        }
    }
    public void updateMask(String ch){
        for (Map.Entry<String, List<Integer>> entry : charactersInWord.entrySet()){
            if (entry.getKey().contains(ch)){
                for (Integer index : entry.getValue()){
                    wordWithMask[index] = entry.getKey();
                }
            }
        }
    }
    public int countUniqLettersOfWord(){
        return uniqLettersOfWord.size();
    }

    public int getCountOfMistakes() {
        return countOfMistakes;
    }

    public Set<String> getUsersLetters() {
        return usersLetters;
    }

    public void setUsersLetters(String ch) {
        usersLetters.add(ch);
    }

    public void printMask(){
        for (int i = 0; i < wordWithMask.length; i++){
            System.out.print(wordWithMask[i]);
        }
        System.out.println();
    }
    public boolean containsUsersLetter(String ch){
        if (usersLetters.contains(ch)){
            return true;
        }else return false;
    }
    public boolean containsLetterInWord(String ch){
        if (uniqLettersOfWord.contains(ch)){
            return true;
        }else return false;
    }

    public int getCountOfLettersGuessed() {
        return countOfLettersGuessed;
    }

    public void incrementCountOfLettersGuessed() {
        countOfLettersGuessed++;
    }

    public void incrementCountOfMistakes(){
        countOfMistakes++;
    }

}
