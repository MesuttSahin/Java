public class SafeHouse extends NormalLocation
{

    public SafeHouse(Player player) {
        super(player, "Güvenli ev");
        this.player=player;
    }

    public boolean getLocation()
    {
        player.setHealthy(player.getrHealthy());
        System.out.println("Canınız Fullendi...");
        return true;
    }
}
