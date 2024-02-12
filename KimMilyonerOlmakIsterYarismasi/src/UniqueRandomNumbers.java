import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class UniqueRandomNumbers
{
    //Bu sınıf 1 ile 11 arasında farklı farklı rastgele sayılar üretecek

    public static int generateUniqueRandomNumber(int min, int max) {
        Set<Integer> generatedNumbers = new HashSet<>();
        Random random = new Random();

        while (true) {
            int randomNumber = random.nextInt((max - min) + 1) + min;

            if (!generatedNumbers.contains(randomNumber)) {
                return randomNumber;
            }
        }
    }

}
