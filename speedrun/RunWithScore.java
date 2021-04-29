
public class RunWithScore extends Run{
    
    private int score;  // Normalized 1 to 100.

    public RunWithScore(User u, Game g, int time, int score){
        super(u, g, time);
        assert(score>0); assert(score<=100);
        this.score = score;
    }
    
    @Override
    public int getTime(){
        int penalty = 100 - score;
        return time + penalty;
    }

    public String toString(){
        return super.toString()+ "[penalty of "+ (100-score) + " sec.]";
    }
}
