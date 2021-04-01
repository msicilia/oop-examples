/**
 *  This class represents the activity of a match from the standpoint of one of the participating summoners.
 */

public class SummonerMatchPlay {

    private Summoner summoner;
    private Match match;
    private Champion champion;
    private int kills;
    private int deaths;
    private int assists;

    /**
     * Constructs the match-summoner object.  
     * @param s  The summoner playing the match.
     * @param m  The match being played.
     * @param c  The champion selected by the player. 
     */
    public SummonerMatchPlay(Summoner s, Match m, Champion c){
        assert(s != null && m != null && c != null);
        summoner = s; match = m; champion = c;
    }

    public void increment(Match.ScoreType c){
        switch (c){
            case ASSISTS:
                this.assists++;
            break;
            case DEATHS:
                this.deaths++;
            break;
            case KILLS:
                this.kills++;
            break;
            default:
                assert(false); // we should never reach this point.
            break;
        }
         
    }


    public int getScore(Match.ScoreType c){
        switch (c){
            case ASSISTS:
                return assists;
            case DEATHS:
                return deaths;
            case KILLS:
                return kills;
            default:
                assert(false); // we should never reach this point.
            break;
        }
        return 0;
    }

    public Summoner getSummoner(){
        return this.summoner;
    }

}
