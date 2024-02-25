import com.sun.jdi.CharType;
import java.util.Scanner;
import java.lang.ref.SoftReference;
import java.util.Random;

public class Run
{
    private String[] words = {"çiğköfte", "bilgisayar", "araba", "pencere", "apartman", "yazılım"};

    private String selectedWord;
    private StringBuilder guessedWord;
    private int mistakeCount;

    public Run() {
        Random random = new Random();
        selectedWord = words[random.nextInt(words.length)];
        guessedWord = new StringBuilder("_".repeat(selectedWord.length()));
        mistakeCount = 0;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Tahmin edilen kelime: " + guessedWord);
            System.out.print("Bir harf veya kelime tahmini yapın: ");
            String guess = scanner.nextLine().toLowerCase();

            if (guess.length() == 1) {
                makeLetterGuess(guess.charAt(0));
            } else {
                makeWordGuess(guess);
            }

            if (gameOver()) {
                break;
            }
        }

        scanner.close();
    }

    private void makeLetterGuess(char letter) {
        boolean correctGuess = false;

        for (int i = 0; i < selectedWord.length(); i++) {
            if (selectedWord.charAt(i) == letter) {
                guessedWord.setCharAt(i, letter);
                correctGuess = true;
            }
        }

        if (!correctGuess) {
            mistakeCount++;
            System.out.println("Yanlış tahmin! Kalan hata sayısı: " + (3 - mistakeCount));
        }
    }

    private void makeWordGuess(String guess) {
        if (guess.equals(selectedWord)) {
            guessedWord = new StringBuilder(selectedWord);
        } else {
            mistakeCount++;
            System.out.println("Yanlış tahmin! Kalan hata sayısı: " + (3 - mistakeCount));
        }
    }

    private boolean gameOver() {
        if (mistakeCount == 3) {
            System.out.println("Üzgünüm, oyunu kaybettin. Doğru kelime: " + selectedWord);
            return true;
        } else if (guessedWord.toString().equals(selectedWord)) {
            System.out.println("Tebrikler, oyunu kazandınız!");
            return true;
        }

        return false;
    }
}
