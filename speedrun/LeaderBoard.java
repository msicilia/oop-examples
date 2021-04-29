/**
 * leaderboards collect runs according to the game.
 */

import java.util.ArrayList;

public class LeaderBoard {

    private Game game;
    private ArrayList<Run> runs;

    public LeaderBoard(Game g){
        this.game = g; this.runs = new ArrayList<>();
    }
    
    /**
     * Requests the user that is in the nth position in the leaderboard. 
     * @param n The position requested, from 1 to the length of the leaderboard.
     * @return The user at position n in the leaderboard, null otherwise.
     */
    public User getNthUser(int n){
        assert(n < runs.size());
        return runs.get(n-1).getUser();
    }
    
    public User getLastUser(){
        return runs.get(runs.size()-1).getUser();
    }

    /**
     * Checks that the game of the run is the same of the leaderboard. 
     * If it is  the case, adds the run to the leaderboard. 
     * 
     * @param r
     */
    public void addRun(Run r){
        assert(r.getGame().equals(this.game));
        int i = 0;
        boolean larger = false;
        while (i<runs.size() && !larger){
            Run aux = runs.get(i);
            if (aux.getTime()<=r.getTime())
                i++;
            else
                larger=true;
        }
        if (larger)
            runs.add(i, r);
        else
            runs.add(r);

    }

    /**
     * Returns a collection of sorted runs, from best to worse for the game.
     * @return an ArrayList of sorted Runs.
     */
    public ArrayList<Run> getRuns(){
        return runs;
    }

    /**
     * Prints the leaderboard. 
     */
    public void print(){
        System.out.println("====================");
        System.out.println("LEADERBOARD FOR: " + this.game);
        for (Run r: runs)
            System.out.println(r);
        System.out.println("====================");

    }
}
