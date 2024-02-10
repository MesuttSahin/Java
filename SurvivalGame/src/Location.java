import java.util.Scanner;

public abstract class Location
{
    Player player;
    String name;
    Scanner scanner=new Scanner(System.in);
    public Location(Player player) {
        super();
        this.player=player;

    }

    public abstract boolean getLocation();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
