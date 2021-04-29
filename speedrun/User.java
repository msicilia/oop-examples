/**
 * 
 */

import java.util.ArrayList; 
public class User {

    private String username;
    private ArrayList<Run> runs;

    public User(String username){
        this.username = username; this.runs = new ArrayList<>();
    }
    
    @Override
    public boolean equals(Object o){
        User u = (User)o;
        return u.getUserName().equals(this.getUserName());
    }

    public String getUserName(){
        return username;
    }
    
    /**
     * Returns the best run of the user. It should be called 
     * on users with at least one run. 
     * 
     * @return The best run of the user
     */
    public Run getBestRun(){
        // the list of runs is unordered.
        assert(runs.size()>0);
        Run best = runs.get(0);
        for (int i=1; i<runs.size(); i++){
            if (best.getTime()>runs.get(i).getTime())
                best = runs.get(i);
        }
        return best;
    }

    /**
     * Adds a Run for the user. The user cannot have more than three runs for the same game. 
     * @param r
     */
    public void addRun(Run r){
        runs.add(r);
    }

    /** 
     * Prints the position of the user in the leaderboard.
     */
    public void printPositionsInLeaderBoards(LeaderBoard[] lbs){
        for (LeaderBoard lb : lbs){
            System.out.println("--------");
            // We assume getRuns returns sorted runs.
            ArrayList<Run> aux = lb.getRuns();
            for (int i=0; i < aux.size() ;i++){
                Run r = aux.get(i);
                if (r.getUser().equals(this))
                    System.out.println("["+(i+1)+"] "+ r);
        }
        }
    }

    public String toString(){
        return username;
    }

}
