public class DrawHangman {
    private String pos6 = "  -------|\n" +
                          "  |      o\n" +
                          "  |     /|\\\n" +
                          "  |     / \\ \n" +
                          "=======      \n";
    private String pos5 = "  -------|\n" +
                          "  |      o\n" +
                          "  |     /|\\\n" +
                          "  |         \n" +
                          "=======     \n";

    private String pos4 = "  -------|\n" +
                          "  |      o\n" +
                          "  |       \n" +
                          "  |       \n" +
                          "=======   \n";

    private String pos3 = "  -------\n" +
                          "  |      \n" +
                          "  |      \n" +
                          "  |      \n" +
                          "=======  \n";

    private String pos2 =
                         " |      \n" +
                         " |      \n" +
                         " |      \n" +
                         "======= \n";
    private String pos1 =
                    "      \n" +
                    "      \n" +
                    "      \n" +
                    "======= \n";

    private String[] hangman = {pos1, pos2, pos3, pos4, pos5, pos6};

    public String getHangman(int idx) {
        return hangman[idx];
    }
}
