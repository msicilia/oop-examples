
public class RunWithEasterEggs extends Run{
    
    private int eggs_collected;
    private int bonus_per_egg;

    public RunWithEasterEggs(User u, Game g, int time, int eggs_collected, int bonus_per_egg){
        super(u, g, time);
        assert(eggs_collected>0);
        this.eggs_collected = eggs_collected;
        assert(bonus_per_egg>0);
        this.bonus_per_egg = bonus_per_egg;
    }
    
    @Override
    public int getTime(){
        int bonus = eggs_collected* bonus_per_egg;
        return time - bonus;
    }

    public String toString(){
        return super.toString()+ "[bonus of "+ eggs_collected*bonus_per_egg + " sec.]";
    }
}
