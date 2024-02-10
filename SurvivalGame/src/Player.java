import java.util.Scanner;

public class Player
{
    int damage;
    int healthy;
    int money;

    public int getrHealthy() {
        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }

    int rHealthy;
    String name,cName;
    Inventory inventory;

    Scanner scanner=new Scanner(System.in);
    public Player(String name)
    {
        this.name=name;

    }

    public void selectCha()
    {
        switch (chaMenu())
        {
            case 1:
                initPlayer("Samuray",5,21,15);
                break;
            case 2:
                initPlayer("Okçu",7,18,20);
                break;
            case 3:
                initPlayer("Şovalye",8,24,5);
                break;
        }
        System.out.println("Karakter: "+getcName()+"\tHasar: "+getDamage()+"\tSağlık: "+getHealthy()+"\tPara: "+getMoney());
    }

    public void initPlayer(String cName,int damage,int healthy,int money)
    {
        setcName(cName);
        setDamage(damage);
        setHealthy(healthy);
        setMoney(money);
        setrHealthy(healthy);

    }
    public int chaMenu()
    {
        System.out.println("1-Türü: Samuray\t Hasar: 5\t Sağlık: 21\t Para: 15");
        System.out.println("2-Türü: Okçu\t Hasar: 7\t Sağlık: 18\t Para: 20");
        System.out.println("3-Türü: Şovalye\t Hasar: 8\t Sağlık: 24\t Para: 5");
        System.out.println("Lütfen bir karakter seçiniz: ");
        int cId=scanner.nextInt();
        while (cId<1 || cId>3)
        {
            System.out.println("Lütfen geçerli bir Id giriniz...");
            cId=scanner.nextInt();
        }

        return cId;
    }

    public int getTotalDamage()
    {
        return this.getDamage()+this.getInventory().getDamage();
    }
    public Inventory getInventory() {
        if (inventory == null) {
            inventory = new Inventory(); // Eğer null ise yeni bir Inventory oluştur
        }
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
