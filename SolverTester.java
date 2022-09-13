import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SolverTester 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File f = new File("playersList.txt");
        Scanner scan  = new Scanner(f);
        String data;
        double totalGuesses = 0;
        double totalPlayers = 0;
        while(scan.hasNextLine())
        {
            data = scan.nextLine();
            totalGuesses+=Solver.pickTheSolved(data.split(",")[0]);
            totalPlayers++;
        }
        double average = totalGuesses/totalPlayers;
        System.out.println("\n"+average+" guesses per player");
    }
}
