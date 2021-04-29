
public class Run {

    private User user;
    private Game game;
    protected int time;

    public Run(User u, Game g, int time){
        this.user = u; this.game = g; this.time = time;
        u.addRun(this); // set the link in the opposite direction.
    }

    @Override
    public boolean equals(Object o){
        Run r = (Run)o;
        return user.equals(r.getUser()) && game.equals(r.getGame()) && this.getTime() == r.getTime();
    }
    
    public boolean betterThan(Run r){
        return this.getTime()<r.getTime();
    }

    public User getUser(){
        return user;
    }

    public Game getGame(){
        return game;
    }

    public int getTime(){
        return time;
    }

    public String toString(){
        return String.format("User %s played game %s within %d seconds.", 
                            user.toString(), game.toString(), getTime());
    }

}
