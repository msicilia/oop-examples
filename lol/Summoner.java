import java.util.ArrayList;
/**
 * Represents a League of Legends summoner (player)
 */
public class Summoner{
    
    private String name;
    private ArrayList<SummonerMatchPlay> matches;
    
    public Summoner(String name){
        this.name = name; matches = new ArrayList<>();
    }

    public void addMatch(SummonerMatchPlay m){
        this.matches.add(m);
    }

    public float getAverageKillsPerMatch(){
        float kills = 0;
        for (SummonerMatchPlay m : matches){
            kills += m.getScore(Match.ScoreType.KILLS);
        }
        return kills/matches.size();
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return name;
    }
}