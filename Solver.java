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
        boolean positionStat;
        boolean heightStat;
        boolean heightGreaterLower;

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
                System.out.println("Number of guesses: "+guesses+", Correct player: "+correctPlayer.getName());
                break;
            }

            
            for(int j=0;j<possiblePlayers.size();j++)
            {

                //Team filtering
                if(guessPlayer.getTeam().equals(correctPlayer.getTeam()))
                {
                    if(!possiblePlayers.get(j).getTeam().equals(guessPlayer.getTeam()))
                    {
                        System.out.println(possiblePlayers.get(j).getName());
                        possiblePlayers.remove(j);
                        j--;
                        continue;
                    }
                }
                else
                {
                    if(possiblePlayers.get(j).getTeam().equals(guessPlayer.getTeam()))
                    {
                        System.out.println(possiblePlayers.get(j).getName());
                        possiblePlayers.remove(j);
                        j--;
                        continue;
                    }
                    if(correctPlayer.hasBeenOnTeam(guessPlayer.getTeam()))
                    {
                        if(!possiblePlayers.get(j).hasBeenOnTeam(guessPlayer.getTeam()))
                        {
                            System.out.println(possiblePlayers.get(j).getName());
                            possiblePlayers.remove(j);
                            j--;
                            continue;
                        }
                    }
                }
                //confrence filtering
                if(guessPlayer.getTeam().getConfrence().equals(correctPlayer.getTeam().getConfrence()))
                {
                    if(!possiblePlayers.get(j).getTeam().getConfrence().equals(guessPlayer.getTeam().getConfrence()))
                    {
                        System.out.println(possiblePlayers.get(j).getName());
                        possiblePlayers.remove(j);
                        j--;
                        continue;
                    }
                }
                else
                {
                    if(possiblePlayers.get(j).getTeam().getConfrence().equals(guessPlayer.getTeam().getConfrence()))
                    {
                        System.out.println(possiblePlayers.get(j).getName());
                        possiblePlayers.remove(j);
                        j--;
                        continue;
                    }
                }
                // division filtering
                if(guessPlayer.getTeam().getDivision().equals(correctPlayer.getTeam().getDivision()))
                {
                    if(!possiblePlayers.get(j).getTeam().getDivision().equals(guessPlayer.getTeam().getDivision()))
                    {
                        System.out.println(possiblePlayers.get(j).getName());
                        possiblePlayers.remove(j);
                        j--;
                        continue;
                    }
                }
                else
                {
                    if(possiblePlayers.get(j).getTeam().getDivision().equals(guessPlayer.getTeam().getDivision()))
                    {
                        System.out.println(possiblePlayers.get(j).getName());
                        possiblePlayers.remove(j);
                        j--;
                        continue;
                    }
                }
                // position filtering
                if(guessPlayer.getPosition().equals(correctPlayer.getPosition()))
                {
                    if(!possiblePlayers.get(j).getPosition().equals(guessPlayer.getPosition()))
                    {
                        System.out.println(possiblePlayers.get(j).getName());
                        possiblePlayers.remove(j);
                        j--;
                        continue;
                    }
                }
                else
                {
                    if(possiblePlayers.get(j).getPosition().equals(guessPlayer.getPosition()))
                    {
                        System.out.println(possiblePlayers.get(j).getName());
                        possiblePlayers.remove(j);
                        j--;
                        continue;
                    }
                }
                //age filtering
                if(guessPlayer.getAge()==correctPlayer.getAge())
                {
                    if(!(possiblePlayers.get(j).getAge()==guessPlayer.getAge()))
                    {
                        System.out.println(possiblePlayers.get(j).getName());
                        possiblePlayers.remove(j);
                        j--;
                        continue;
                    }
                }
                else if(guessPlayer.getAge()<correctPlayer.getAge())
                {
                    if(Math.abs(guessPlayer.getAge()-correctPlayer.getAge())<=2)
                    {
                        if(!(Math.abs(possiblePlayers.get(j).getAge()-guessPlayer.getAge())<=2&&Math.abs(possiblePlayers.get(j).getAge()-guessPlayer.getAge())>0)||possiblePlayers.get(j).getAge()<=guessPlayer.getAge())
                        {
                            System.out.println(possiblePlayers.get(j).getName());
                            possiblePlayers.remove(j);
                            j--;
                            continue;
                        }
                    }
                    else
                    {
                        if(possiblePlayers.get(j).getAge()<=guessPlayer.getAge())
                        {
                            System.out.println(possiblePlayers.get(j).getName());
                            possiblePlayers.remove(j);
                            j--;
                            continue;
                        }
                    }
                }
                else
                {
                    if(Math.abs(guessPlayer.getAge()-correctPlayer.getAge())<=2)
                    {
                        if(!(Math.abs(possiblePlayers.get(j).getAge()-guessPlayer.getAge())<=2&&Math.abs(possiblePlayers.get(j).getAge()-guessPlayer.getAge())>0)||possiblePlayers.get(j).getAge()>=guessPlayer.getAge())
                        {
                            System.out.println(possiblePlayers.get(j).getName());
                            possiblePlayers.remove(j);
                            j--;
                            continue;
                        }
                    }
                    else
                    {
                        if(possiblePlayers.get(j).getAge()>=guessPlayer.getAge())
                        {
                            System.out.println(possiblePlayers.get(j).getName());
                            possiblePlayers.remove(j);
                            j--;
                            continue;
                        }
                    }
                }
                //number filtering
            }
            guessPlayer = possiblePlayers.get(0);
            System.out.println("size = "+possiblePlayers.size());

        }
    }
}
