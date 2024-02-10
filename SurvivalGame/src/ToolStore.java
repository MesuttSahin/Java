import java.util.Scanner;

public class ToolStore extends NormalLocation
{
    Scanner scanner=new Scanner(System.in);
    public ToolStore(Player player) {
        super(player, "Mağaza");
        this.player=player;

    }

    public boolean getLocation()
    {
        System.out.println("Para: "+player.getMoney());
        System.out.println("1-Silahlar");
        System.out.println("2-Zırhlar");
        System.out.println("3-Çıkış");
        System.out.print("Seçiminiz: ");
        int selTool=scanner.nextInt();
        int sellItemId;
        switch (selTool)
        {
            case 1:
                sellItemId=weaponMenu();
                buyWeapon(sellItemId);
                break;
            case 2:
                sellItemId=armorMenu();
                buyArmor(sellItemId);
                break;
        }
        return true;
    }
    public void buyArmor(int sellItemId)
    {
        int avoid=0,price=0;
        String aName=null;
        switch (sellItemId)
        {
            case 1:
                avoid=1;
                aName="Hafif Zırh";
                price=15;
                break;
            case 2:
                avoid=3;
                aName="Orta Zırh";
                price=25;
                break;
            case 3:
                avoid=5;
                aName="Tüfek";
                price=40;
                break;
            default:
                System.out.println("Geçersiz işlem");
                break;
        }

        if (player.getMoney() >= price && price>0)
        {
            player.getInventory().setArmor(avoid);
            player.getInventory().setaName(aName);
            player.setMoney(player.getMoney()-price);
            System.out.println(aName+"  Silahı satın aldınız, Engellenen Hasar: "+player.getInventory().getArmor());
            System.out.println("Kalan para: "+player.getMoney());
        }
        else
        {
            System.out.println("Bakiye yetersiz..!");
        }
    }
    public int armorMenu()
    {
        System.out.println("1- Hafif => Para: 15 => Engelleme: +1");
        System.out.println("2- Orta => Para: 25 => Engelleme: +3");
        System.out.println("3- Ağır => Para: 40 => Engelleme: +5");
        System.out.println("4- Çıkış");
        int sellArmor=scanner.nextInt();
        return sellArmor;
    }

    public int weaponMenu()
    {
        System.out.println("1- Tabanca => Para: 25 => Hasar: +2");
        System.out.println("2- Kılıç => Para: 35 => Hasar: +3");
        System.out.println("3- Tüfek => Para: 45 => Hasar: +7");
        System.out.println("4- Çıkış");
        int sellWeapon=scanner.nextInt();
        return sellWeapon;
    }

    public void buyWeapon(int sellItemId)
    {
        int damage=0,price=0;
        String wName=null;
        switch (sellItemId)
        {
            case 1:
                damage=2;
                wName="Tabanca";
                price=25;
                break;
            case 2:
                damage=3;
                wName="Kılıç";
                price=35;
                break;
            case 3:
                damage=7;
                wName="Tüfek";
                price=45;
                break;
            default:
                System.out.println("Geçersiz işlem");
                break;
        }

        if (player.getMoney() > price && price>0)
        {
            player.getInventory().setDamage(damage);
            player.getInventory().setwName(wName);
            player.setMoney(player.getMoney()-price);
            System.out.println(wName+"  Silahı satın aldınız, Önceki hasar: "+player.getDamage()+"\tYeni Hasar: "+(player.getDamage()+player.getInventory().getDamage()));
            System.out.println("Kalan para: "+player.getMoney());
        }
        else
        {
            System.out.println("Bakiye yetersiz..!");
        }
    }
}
