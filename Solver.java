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
        Player guessPlayer = Player.getThePlayer("Andrew Wiggins");
        boolean teamStat;
        boolean confrenceStat;
        boolean divisionStat;
        
        File f = new File("playersList.txt");
        Scanner scan  = new Scanner(f);
        String data;
        while(scan.hasNextLine())
        {
            data = scan.nextLine();
            Player temp = Player.getThePlayer(data.split(",")[0]);
            possiblePlayers.add(temp);
        }

        for(int i=0;i<8;i++)
        {
            if(guessPlayer.equals(correctPlayer))
            {
                int guesses = i+1;
                System.out.println("Number of guesses: "+guesses);
                break;
            }

            if(guessPlayer.getTeam().equals(correctPlayer.getTeam()))
            {
                teamStat = true;
            }
            else
            {
                teamStat = false;
            }
            if(guessPlayer.getTeam().getConfrence().equals(correctPlayer.getTeam().getConfrence()))
            {
                confrenceStat = true;
            }
            else
            {
                confrenceStat = false;
            }
            if(guessPlayer.getTeam().getDivision().equals(correctPlayer.getTeam().getDivision()))
            {
                divisionStat = true;
            }
            else
            {
                divisionStat = false;
            }

        }
    }
}
