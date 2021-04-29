/**
 * Platforms are hardware devices that run games, for example PC, NES, PS2 etc.
 */
public class Platform {

    private String name;
    public Platform(String name){
        this.name = name;
    }

    public String getName(){ return name; }

    @Override
    public boolean equals(Object o){
        Platform p = (Platform)o;
        return this.getName().equals(p);
    }

    public String toString(){
        return getName();
    }
}
