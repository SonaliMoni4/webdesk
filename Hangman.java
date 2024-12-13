import java.util.Random;
import java.util.Scanner;

public class Hangman {

    private String word;
    private String guessedWord;
    private int attempts;

    public Hangman(String word) {
        this.word = word;
        this.guessedWord = "";
        for (int i = 0; i < word.length(); i++) {
            this.guessedWord += "_";
        }
        this.attempts = 10;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (attempts > 0) {
            System.out.println("Guessed word: " + guessedWord);
            System.out.println("Attempts left: " + attempts);
            System.out.print("Enter a letter: ");
            String input = scanner.next();
            if (input.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }
            char letter = input.charAt(0);
            boolean correct = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    guessedWord = guessedWord.substring(0, i) + letter + guessedWord.substring(i + 1);
                    correct = true;
                }
            }
            if (!correct) {
                attempts--;
                System.out.println("Incorrect guess.");
            }
            if (!guessedWord.contains("_")) {
                System.out.println("Congratulations, you won! The word was " + word);
                return;
            }
        }
        System.out.println("Game over. The word was " + word);
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "cherry", "date", "elderberry"};
        Random random = new Random();
        Hangman hangman = new Hangman(words[random.nextInt(words.length)]);
        hangman.play();
    }
}