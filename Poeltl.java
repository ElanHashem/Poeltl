import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Poeltl
{
    private static final int NUM_DATABASE_PLAYERS = 134;
    

    public static Player randomPlayer() throws FileNotFoundException
    {
        File f = new File("playersList.txt");
        Scanner scan  = new Scanner(f);
        String data;
        int randomNumber = (int)(Math.random()*NUM_DATABASE_PLAYERS);
        
        for(int i=0;i<NUM_DATABASE_PLAYERS;i++)
        {
            data = scan.nextLine();
            if(i==randomNumber)
            {
                ArrayList<Team> teamHistory = new ArrayList<Team>();
                String[] arr = data.split(",");
                if(arr.length==7)
                {
                    String[] history = arr[6].split(";");
                    for(int j=0;j<history.length;j++)
                    {
                        teamHistory.add(Player.getTheTeam(history[j]));
                    }
                }
                    
                scan.close();
                return new Player(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3],arr[4] ,Player.getTheTeam(arr[5]), teamHistory);
            }
                
            
        }
        scan.close();
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        Player correctPlayer = Poeltl.randomPlayer();   
        System.out.println("Guess the player");

        Scanner scan = new Scanner(System.in);

        Player guessPlayer;
        for(int i=0;i<8;i++)
        {
            String output = "";
            String teamOutput;
            String conferanceOutput;
            String divisionOutput;
            String positionOutput;
            String heightOutput;
            String ageOutput;
            String jerseyNumOutput;
            guessPlayer = Player.getThePlayer(scan.nextLine());
            if(guessPlayer==null)
            {
                System.out.println("Name entered not a player please try again");
                i--;
                continue;
            }
            if(correctPlayer.equals(guessPlayer))
            {
                System.out.println("Thats right, the player is "+correctPlayer.getName());
                break;
            }
            //Dealing with team output
            if(correctPlayer.getTeam().equals(guessPlayer.getTeam()))
            {
                teamOutput = guessPlayer.getTeam().getName()+" is the correct team";
            }
            else if(correctPlayer.hasBeenOnTeam(guessPlayer.getTeam()))
            {
                teamOutput = guessPlayer.getTeam().getName()+" is a team that the player used to play on";
            }
            else
            {
                teamOutput = guessPlayer.getTeam().getName()+" is not the team";
            }
            //dealing with confrence output
            if(guessPlayer.getTeam().getConfrence().equals(correctPlayer.getTeam().getConfrence()))
            {
                conferanceOutput = "\n"+guessPlayer.getTeam().getConfrence()+" is the correct confence";
            }
            else
            {
                conferanceOutput = "\n"+guessPlayer.getTeam().getConfrence()+" is the wrong confence";
            }
            if(guessPlayer.getTeam().getDivision().equals(correctPlayer.getTeam().getDivision()))
            {
                divisionOutput = "\n"+guessPlayer.getTeam().getDivision()+" is the correct Divison";
            }
            else
            {
                divisionOutput = "\n"+guessPlayer.getTeam().getDivision()+" is the wrong Divison";

            }
            if(guessPlayer.getPosition().equals(correctPlayer.getPosition()))
            {
                positionOutput = "\n"+guessPlayer.getPosition()+" is the correct position";
            }
            else
            {
                positionOutput = "\n"+guessPlayer.getPosition()+" is the wrong position";

            }
            if(guessPlayer.getHeight().equals(correctPlayer.getHeight()))
            {
                heightOutput = "\n"+guessPlayer.getHeight()+" is the correct height";
            }
            else
            {
                heightOutput = "\n"+guessPlayer.getHeight()+" is "+Player.getComparisonWords(guessPlayer.compareHeight(correctPlayer))+" than the correct height";
                if(guessPlayer.isHeightClose(correctPlayer))
                {
                    heightOutput+=" and within 2 inches";
                }
                
            }
            if(guessPlayer.getAge()==correctPlayer.getAge())
            {
                ageOutput = "\n"+guessPlayer.getAge()+" is the correct age";
            }
            else
            {
                ageOutput = "\n"+guessPlayer.getAge()+" is "+Player.getComparisonWords(guessPlayer.compareAge(correctPlayer))+" than the correct age";
                if(guessPlayer.isAgeClose(correctPlayer))
                {
                    ageOutput+=" and within 2 years";
                }
            }
            if(guessPlayer.getJerseyNumber().equals(correctPlayer.getJerseyNumber()))
            {
                jerseyNumOutput = "\n"+guessPlayer.getJerseyNumber()+" is the correct Jersey Number";
            }
            else
            {
                jerseyNumOutput = "\n"+guessPlayer.getJerseyNumber()+" is "+Player.getComparisonWords(guessPlayer.compareJerseyNumber(correctPlayer))+" than the correct Jersey number";
                if(guessPlayer.isJerseyNumberClose(correctPlayer))
                {
                    jerseyNumOutput+=" and within 2";
                }
            }
            output = teamOutput+conferanceOutput+divisionOutput+positionOutput+heightOutput+ageOutput+jerseyNumOutput;
            System.out.println(output);
            System.out.println();

        }
        scan.close();

    }

}