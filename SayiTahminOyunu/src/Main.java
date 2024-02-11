import java.util.Random;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        //kullanıcının 5 tane tahmin hakkı olsun
        //0-100 arasındaki sayıları tahmin etsin
        //oyun 10 el devam etsin
        //her doğru tahminde 10 puan alsın

        Random random=new Random();
        Scanner scanner=new Scanner(System.in);
        int can=5;
        int dogru=0;
        int yanlis=0;

        for (int i=0;i<10;i++)
        {
            int randomNumber = random.nextInt(0,100);
            System.out.println("Tahmin: ");
            int tahmin=scanner.nextInt();
            if (tahmin==randomNumber)
            {
                System.out.println("Doğru cevap verdiniz...");
                dogru++;
            }

            else
            {
                System.out.println("Yanlış cevap verdiniz..");
                yanlis++;
                can--;
                if (tahmin>randomNumber)
                {
                    System.out.println("Değeri azaltınız... ");
                }
                else
                {
                    System.out.println("Değeri artırınız");
                }

            }

            if (can==0)
            {
                System.out.println("Hakkınız bitti bitti...");
                break;
            }

        }

        System.out.println("Doğru: "+dogru+" Yanlış: "+yanlis+" Puan: "+(dogru*10));

    }
}