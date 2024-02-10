import java.util.Scanner;
public class Game
{
    Player player;
    Location location;
    Scanner scanner=new Scanner(System.in);
    public void login()
    {
        System.out.println("Macera Oyununa Hoşgeldiniz");
        System.out.println("İsminizi giriniz: ");
        String playerName=scanner.nextLine();
        player=new Player(playerName);
        player.selectCha();
        start();
    }

    public void start()
    {
        while (true)
        {
            System.out.println();
            System.out.println("------------------------------------------------------");
            System.out.println();
            System.out.println("1-Güvenli Bölge => Size ait güvenli bir mekan,Düşman yok,Can yenilenir");
            System.out.println("2-Mağara => Karşınıza belki zombi çıkabilir !");
            System.out.println("3-Orman=> Karşınıza belki vampir çıkabilir !");
            System.out.println("4-Nehir => Karşınıza belki ayı çıkabilir !");
            System.out.println("5-Mağaza => Silah ve Zırh alabilirsiniz");
            System.out.println("Eylem gerçekleştirmek istediğiniz bir mekan seçiniz....");
            int selLoc=scanner.nextInt();
            while (selLoc<1 || selLoc>5)
            {
                System.out.println("Lütfen geçerli bir mekan giriniz...");
                selLoc=scanner.nextInt();
            }

            switch (selLoc)
            {
                case 1:
                    location=new SafeHouse(player);
                    break;
                case 2:
                    location=new Cave(player);
                    break;
                case 3:
                    location=new Forest(player);
                    break;
                case 4:
                    location=new Cave(player);
                    break;
                case 5:
                    location=new ToolStore(player);
                    break;
                default:
                    location=new SafeHouse(player);
                    break;
            }
            if (location.getClass().getName().equals(("SafeHouse")))
            {
                if (player.getInventory().isFirewood() && player.getInventory().isFood() && player.getInventory().isWater())
                {
                    System.out.println("Tebrikler Oyunu Kazandınız...");
                    break;
                }
            }
            if (!location.getLocation())
            {
                System.out.println("Game Over");
                break;
            }
        }
    }
}
