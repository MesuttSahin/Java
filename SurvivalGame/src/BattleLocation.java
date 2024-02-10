public abstract class BattleLocation extends Location
{

    protected Obstacle obstacle;
    protected String award;
    public BattleLocation(Player player,String name,Obstacle obstacle,String award)
    {
        super(player);
        this.name=name;
        this.obstacle=obstacle;
        this.award=award;

    }

    public boolean getLocation()
    {
        int obsCount=obstacle.obstacleCount();
        System.out.println("Şuan buradasınız: "+this.getName());
        System.out.println("Dikkatli ol! Burada "+obsCount+" tane "+obstacle.getName()+" Yaşıyor...");
        System.out.println("<S> Savaş veya <K> Kaç");
        String selcase=scanner.next();
        selcase=selcase.toUpperCase();
        if (selcase.equals("S"))
        {
            if(combat(obsCount)==true)
            {
                System.out.println(this.getName()+" bölgesindeki tüm düşmanları temizlediniz...");
                if (this.award.equals("Food") && player.getInventory().isFood() == false)
                {
                    System.out.println(this.award+" Kazandınız...");
                    player.getInventory().setFood(true);
                }
                else if (this.award.equals("Water") && player.getInventory().isWater() == false)
                {
                    System.out.println(this.award+" Kazandınız...");
                    player.getInventory().setWater(true);
                }
                if (this.award.equals("FireWood") && player.getInventory().isFirewood() == false)
                {
                    System.out.println(this.award+" Kazandınız...");
                    player.getInventory().setFirewood(true);
                }
                return true;
            }
           if (player.getHealthy() <= 0)
           {
               System.out.println("Öldünüz");
               return false;
           }
        }
        return true;
    }

    public boolean combat(int obsCount)
    {
        for (int i=0;i<obsCount;i++)
        {
            int defObsHealth=obstacle.getHealth();
            playerStats();
            enemyStats();
            while (player.getHealthy() > 0 && obstacle.getHealth() > 0)
            {
                System.out.println("<V> Vur veya <K> Kaç");
                String sellCase = scanner.next();
                sellCase=sellCase.toUpperCase();
                if(sellCase.equals("V")==true)
                {
                    System.out.println("Siz vurdunuz...");
                    obstacle.setHealth(player.getHealthy()-player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth() > 0)
                    {
                        System.out.println();
                        System.out.println("Canavar size vurdu...");
                        player.setHealthy(player.getHealthy()-(obstacle.getDamage()-player.getInventory().getArmor()));
                        afterHit();
                    }

                }
                else
                {
                    return false;
                }

            }
            if (obstacle.getHealth() <=0 && player.getHealthy()>0)
            {
                System.out.println("Düşmanı yendiniz...");
                player.setMoney(player.getMoney()+obstacle.getAward());
                System.out.println("Güncel Paranız: "+player.getMoney());
                obstacle.setHealth(defObsHealth);
            }
            else
            {
                return false;
            }
            System.out.println("------------------------");
        }
        return true;
    }

    public void playerStats()
    {

        System.out.println("*********Oyuncu Değerleri*********");
        System.out.println("Can: "+player.getHealthy());
        System.out.println("Hasar: "+player.getTotalDamage());
        System.out.println("Para: "+player.getMoney());
        if (player.getInventory().getDamage() > 0)
        {
            System.out.println("Silah: "+player.getInventory().getwName());

        }
        if (player.getInventory().getArmor() > 0)
        {
            System.out.println("Zırh: "+player.getInventory().getaName());

        }
    }
    public void enemyStats()
    {
        System.out.println(obstacle.getName()+" Değerleri\n------------------------");
        System.out.println("Can: "+obstacle.getHealth());
        System.out.println("Hasar: "+obstacle.getDamage());
        System.out.println("Ödül: "+obstacle.getAward());
    }

    public void afterHit()
    {
        System.out.println("Oyuncu Canı: "+player.getHealthy());
        System.out.println(obstacle.getName()+" Canı: "+obstacle.getHealth());
        System.out.println();
    }

}
