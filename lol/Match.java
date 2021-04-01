import java.time.ZonedDateTime;

import java.util.HashMap;

public class Match {

    public enum ScoreType {KILLS, DEATHS, ASSISTS};
    
    private ZonedDateTime start;
    private ZonedDateTime end;
    private HashMap<String, SummonerMatchPlay> redteam;
    private HashMap<String, SummonerMatchPlay> blueteam;
    /**
     * 
     * @param start  The start time of the match.
     * @param end    The end time of the match.
     * @param blue   Players of blue team.
     * @param red    Players of red team.
     * @param bluec  Champions chosen by players of blue team.
     * @param redc   Champions chosen by players of red team.
     */
    public Match(ZonedDateTime start, ZonedDateTime end, 
                Summoner[] blue, Summoner[] red, 
                Champion[] bluec, Champion[] redc){
         this.start = start; this.end = end;
         redteam = new HashMap<>();
         blueteam = new HashMap<>();
         for (int i=0; i<blue.length; i++){
            SummonerMatchPlay aux = new SummonerMatchPlay(blue[i], this, bluec[i]);
            blueteam.put(blue[i].getName(), aux);
            blue[i].addMatch(aux);
            aux = new SummonerMatchPlay(red[i], this, redc[i]);
            redteam.put(red[i].getName(), aux);
            red[i].addMatch(aux);
         }
    }

    /**
     * Increases the score of a summoner in the match.
     * 
     * @param c  The type of score to be increased.
     * @param s  The summoner to apply the increase.
     * @param amount  How much to increase.
     */
    public void increase(ScoreType c, Summoner s, int amount){
         SummonerMatchPlay aux = blueteam.get(s.getName());
         if (aux == null)  // If not in blue, it must be in red
            aux = redteam.get(s.getName());
        assert(aux != null); 
        for (int i=0; i < amount; i++)
            aux.increment(c);

    }

    /**
     * Get the best player of the match according to the criteria MAX(K+S).
     * 
     * @return The summoner considered best player of the match.
     */
    public Summoner getBestPlayer(){
        int best_score = -1;
        Summoner best_summoner = null;
        for (SummonerMatchPlay sm : blueteam.values()){
            int score = sm.getScore(ScoreType.KILLS) + sm.getScore(ScoreType.ASSISTS);
            if (score > best_score){
               best_summoner = sm.getSummoner();
               best_score = score;
            } 
        } 
        for (SummonerMatchPlay sm : redteam.values()){
            int score = sm.getScore(ScoreType.KILLS) + sm.getScore(ScoreType.ASSISTS);
            if (score > best_score){
               best_summoner = sm.getSummoner();
               best_score = score;
            } 
        } 
        return best_summoner;
    }

    public String toString(){
        return String.format("Match: [%s -%s]", start, end);
    }

}
