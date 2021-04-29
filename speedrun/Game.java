/**
 *  A game is the thing that players run in. They are different for different platforms (PC, Xbox, etc.)
 */

public class Game {
    
    private String name;
    private Platform platform;
    /**
     * Initializes a game with name and platform. 
     * 
     * @param name The name of the game.
     * @param platform The platform of the game. 
     */
    public Game(String name, Platform platform){
        assert(platform != null);
        this.name = name; this.platform = platform;
    }

    /**
     * Two games are equal if they have the same name and same platform. 
     */
    public boolean equals(Object o){
        Game g = (Game)o;
        return (this.getName().equals(g.getName())) && (this.getPlatform().equals(g.getPlatform()));
    }
    
    public String getName(){
        return name;
    }

    public Platform getPlatform(){
        return platform;
    }

    public String toString(){
        return String.format("%s(%s)",name, platform.getName()); 
    }
}

