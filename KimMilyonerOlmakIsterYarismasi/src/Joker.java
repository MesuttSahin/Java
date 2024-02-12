import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Joker
{
    Scanner scanner=new Scanner(System.in);
    private static int sayac1=0;
    private static int sayac2=0;
    public boolean useJoker(String answer)
    {
        System.out.println("1- Çift cevap joker hakkı");
        System.out.println("2- %50 joker hakkı");
        System.out.println("Lütfen kullanmak istediğiniz jokeri seçiniz...");
        int selection=scanner.nextInt();
        scanner.nextLine();

        switch (selection)
        {
            case 1:
                if (sayac1==0)
                {
                    sayac1++;
                    System.out.print("ilk cevap: ");
                    String cevap1=scanner.nextLine();
                    if (cevap1.toUpperCase().equals(answer))
                    {
                        return true;
                    }

                    else
                    {
                        System.out.println("İlk cevap yanlış...");
                        System.out.print("İkinci cevap: ");
                        String cevap2=scanner.nextLine();
                        if (cevap2.toUpperCase().equals(answer))
                        {
                            return true;
                        }
                        else
                        {
                            return false;
                        }
                    }

                }
                else
                {
                    System.out.println("Çift cevap joker hakkınızı kullandınız");
                    useJoker(answer);
                }
                break;
            case 2:
                if (sayac2==0)
                {
                    return use50_50Joker(answer);
                }
                else
                {
                    System.out.println("%50 joker hakkını kullandınız...");
                }
                sayac2++;



        }

        return false;
    }

    private boolean use50_50Joker(String answer) {
        List<String> option = new ArrayList<>();
        option.add("A");
        option.add("B");
        option.add("C");
        option.add("D");

        // Doğru cevabı çıkart
        option.remove(answer);

        // Karıştır ve iki yanlış cevabı seç
        Collections.shuffle(option);
        String wrong1 = option.get(0);
        String wrong2 = option.get(1);

        System.out.println("50-50 Joker: Şıkların yarısı ortadan kaldırıldı. Yanlış Şıklar : " + wrong1 + ", " + wrong2);

        System.out.print("Lütfen doğru cevabı giriniz: ");
        String userAnswer = scanner.nextLine();

        return userAnswer.toUpperCase().equals(answer);
    }
}
