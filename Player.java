import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player
{
    private String name;
    private String height;
    private int age;
    private String jerseyNumber;
    private String position;
    private Team team;
    private ArrayList<Team> teamHistory;


    //GET RID OF THIS CONSTRUCTOR
    public Player(String name, String height, int age, String jerseyNumber,Team team,ArrayList<Team> teamHistory)
    {
        this.name = name;
        this.height = height;
        this.age = age;
        this.jerseyNumber = jerseyNumber;
        this.team = team;
        this.teamHistory = teamHistory;
       
    }

    public Player(String name, String height, int age, String jerseyNumber,String position, Team team,ArrayList<Team> teamHistory)
    {
        this.name = name;
        this.height = height;
        this.age = age;
        this.jerseyNumber = jerseyNumber;
        this.team = team;
        this.teamHistory = teamHistory;
        this.position = position;
       
    }

    public String getName()
    {
        return name;
    }

    public String getHeight()
    {
        return height;
    }

    public int getAge()
    {
        return age;
    }

    public String getJerseyNumber()
    {
        return jerseyNumber;
    }

    public Team getTeam()
    {
        return team;
    }

    public ArrayList<Team> getTeamHistory()
    {
        return teamHistory;
    }

    public String getPosition()
    {
        return position;
    }

    public int getInches()
    {
        String firstNum = height.substring(0,1);
        String secondNum = height.substring(2);

        int feet = Integer.parseInt(firstNum);
        int inches = Integer.parseInt(secondNum);

        return 12*feet+inches;
    }

    public boolean isHeightClose(Player other)
    {
        if(Math.abs(this.getInches()-other.getInches())<=2)
        {
            return true;
        }
        return false;
    }

    public int compareHeight(Player other)
    {
        if(this.getInches()>other.getInches())
        {
            return 1;
        }
        if(this.getInches()<other.getInches())
        {
            return -1;
        }
        return 0;
    }

    public boolean isJerseyNumberClose(Player other)
    {
        int thisNum = Integer.parseInt(this.jerseyNumber);
        int otherNum = Integer.parseInt(other.jerseyNumber);
        if(Math.abs(thisNum-otherNum)<=2)
        {
            return true;
        }
        return false;
    }

    public int compareJerseyNumber(Player other)
    {
        int thisNum = Integer.parseInt(this.jerseyNumber);
        int otherNum = Integer.parseInt(other.jerseyNumber);
        
        if(thisNum>otherNum)
        {
            return 1;
        }
        else if(thisNum<otherNum)
        {
            return -1;
        }
        return 0;
    }

    public boolean isAgeClose(Player other)
    {
        if(Math.abs(age-other.getAge())<=2)
        {
            return true;
        }
        return false;
    }

    public int compareAge(Player other)
    {
        if(age>other.getAge())
        {
            return 1;
        }
        else if(age<other.getAge())
        {
            return -1;
        }
        return 0;
    }

    public boolean hasBeenOnTeam(Team t)
    {
        for(int i=0;i<teamHistory.size();i++)
        {
            if(teamHistory.get(i).getName().equals(t.getName()))
            {
                return true;
            }
        }
        return false;
    }

    public static Team getTheTeam(String teamName) throws FileNotFoundException
    {
        File teamsList = new File("C:\\Users\\elan0\\PotelProject\\teamsList.txt");
        Scanner scanner = new Scanner(teamsList);
        String teams;
        while(scanner.hasNextLine())
        {
            teams = scanner.nextLine();
            if(teams.split(",")[0].equals(teamName))
            {
                scanner.close();
                return new Team(teams.split(",")[0], teams.split(",")[1], teams.split(",")[2]);
            }
        }
        scanner.close();
        throw new IllegalArgumentException();
    }

    public static Player getThePlayer(String name) throws FileNotFoundException
    {
        File f = new File("C:\\Users\\elan0\\PotelProject\\playersList.txt");
        Scanner scan  = new Scanner(f);
        String data;

        while(scan.hasNextLine())
        {
            data = scan.nextLine();
            if(data.split(",")[0].equals(name))
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
                return new Player(arr[0], arr[1], Integer.parseInt(arr[2]), arr[3], arr[4],Player.getTheTeam(arr[5]), teamHistory);
            }
        }
        scan.close();
        return null;
    }

    public boolean equals(Player other)
    {
        if(name.equals(other.getName())&&age==other.getAge()&&height.equals(other.getHeight()))
        {
            return true;
        }
        return false;
    }

    public static String getComparisonWords(int i)
    {
        if(i>0)
        {
            return "Higher";
        }
        else if(i<0)
        {
            return "Lower";
        }
        return "equal";
    }

    
}
