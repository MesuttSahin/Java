import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Run
{
    Scanner scanner=new Scanner(System.in);
    Random random=new Random();
    Questions questions=new Questions();
    Options op=new Options();
    Answers answers=new Answers();
    Joker joker=new Joker();
    UniqueRandomNumbers unique=new UniqueRandomNumbers();
    Prize prizes=new Prize();
    public static int correct=0;
    public void start()
    {
        System.out.println("********** KİM MİLYONER OLMAK İSTER **********");
        System.out.println("Bilgilendirmeyi görmek ister misiniz? (e/h)");
        String inform=scanner.nextLine();
        if (inform.equals("e"))
            toInform();


        for (int i=0;i<10;i++)
        {
            int questionNumber= UniqueRandomNumbers.generateUniqueRandomNumber(1, 11);
            String question=questions.dataQuestions(questionNumber);
            String options=op.dataOptions(questionNumber);
            String answer=answers.dataAnswers(questionNumber);
            System.out.println("Soru "+(i+1)+" "+question);
            System.out.println(options);
            Timer timer=new Timer();
            TimerTask timerTask=new TimerTask()
            {
                int time=30;
                @Override
                public void run()
                {
                    System.out.print("\rKalan süre: "+time+" saniye");
                    time--;
                    if (time<0)
                    {
                        cancel();
                        System.out.println("\nSüre bitti...");
                        System.out.print("Doğru sayısı: "+correct);
                        prizes.prize(correct);
                    }
                }
            };



            timer.scheduleAtFixedRate(timerTask,0,2000); //1 saniyede bir günceller
            boolean sonuc = false;
            String cevap=scanner.nextLine();
            if (cevap.equalsIgnoreCase("J"))
            {
                timer.cancel();
               sonuc = joker.useJoker(answer);
            }
            timer.cancel();

            if (cevap.toUpperCase().equals(answer) || sonuc)
            {
                System.out.println("Doğru cevap...\nBir sonraki soruya geçiliyor");
                correct++;
            }

            else
            {
                System.out.println("Yanlış cevap...");
                System.out.println("Doğru cevap: "+answer);
                break;
            }
        }

        System.out.println("Doğru sayısı: "+correct);
        prizes.prize(correct);
    }


    public void toInform()
    {
        System.out.println("1) Cevapları verirken lütfen süreye dikkat ediniz çünkü her 2 saniyede bir cevap yazdığınız satır güncellendiğinden cevabınız siliniyor" +
                " ve enter tuşuna bastığınızda null değer dönderiyor bu yüzden 'yanlış cevap' yazdırılıyor konsola ama o 2 saniye içerisinde cevap gönderilirse işlem doğru bir şekilde yapılıyor   ");
    }



}
