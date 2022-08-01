import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Solver 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Player correctPlayer = Poeltl.randomPlayer();
        LinkedList<Player> possiblePlayers = new LinkedList<Player>();
        
        File f = new File("playersList.txt");
        Scanner scan  = new Scanner(f);
        String data;
        while(scan.hasNextLine())
        {
            data = scan.nextLine();
            Player temp = Player.getThePlayer(data.split(",")[0]);
            possiblePlayers.add(temp);
        }

        
    }
}
