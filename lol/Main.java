import java.util.ArrayList;
import java.time.ZonedDateTime;
import java.time.Duration;

public class Main{

    final static String[] CHAMPION_NAMES = {"Aatrox", "Ashe", "Blizcrank", "Nautilus", "Draven", 
                                            "Tristana", "Zyra", "Orianna", "Veigar", "Zoe"};
    final static int NUM_PLAYERS_PER_MATCH = 10;
    static ArrayList<Champion> champions;
    static ArrayList<Summoner> summs;
    public static void main(String[] args){
        // Create some example champions.
        champions = new ArrayList<>();
        for (String name : CHAMPION_NAMES){
             champions.add(new Champion(name.toLowerCase(), name));
        }
        // Create some example summoners.
        summs =  new ArrayList<>();
        for (int i = 0; i < NUM_PLAYERS_PER_MATCH; i++){
            summs.add(new Summoner("summoner"+i));
        }
        // Split the summoners and champions.
        Summoner[] blues = (Summoner[])summs.subList(0, 5).toArray(new Summoner[5]);
        Champion[] bluechamps = (Champion[])champions.subList(0, 5).toArray(new Champion[5]);
        Summoner[] reds = (Summoner[])summs.subList(5, 10).toArray(new Summoner[5]);
        Champion[] redchamps = (Champion[])champions.subList(5, 10).toArray(new Champion[5]);

        // Create some matches.
        ZonedDateTime start = ZonedDateTime.now();  
        ZonedDateTime end = start.plus(Duration.ofSeconds(60*60));

        Match m1 = new Match(start, end, blues, reds, bluechamps, redchamps);
        Match m2 = new Match(end.plus(Duration.ofSeconds(60*60)), end.plus(Duration.ofSeconds(120*60)), blues, reds, bluechamps, redchamps);
        System.out.println(m1);

        // Try with some scores:
        Summoner best =  m1.getBestPlayer();
        System.out.println("Best summoner: " + best);
        m1.increase(Match.ScoreType.KILLS, best, 10);
        m1.increase(Match.ScoreType.ASSISTS, best, 5);
        m1.increase(Match.ScoreType.KILLS, reds[3], 7);
        m1.increase(Match.ScoreType.ASSISTS, reds[3], 20);
        best =  m1.getBestPlayer();
        System.out.println("Now best summoner is:" + best);
        System.out.println("Average kills per match of best player: "+ best.getAverageKillsPerMatch());

    }
}