// Categories are the different rulesets for speedruns. Categories are either per-game or per-level (if the game uses individual levels)
// Games are the things users do speedruns in. Games are associated with regions (US, Europe, ...), platforms (consoles, handhelds, ...), genres, engines, developers, game types, publishers, categories, levels and custom variables (like speed=50/100/150cc in Mario Kart games).
// Leaderboards contain non-obsolete runs, sorted by time descending. In contrast to raw runs, leaderboards are automatically grouped according to the game/category/level rules that the moderators have defined.
// Levels are the stages/worlds/maps within a game. Not all games have levels.
// Platforms are hardware devices that run games, for example PC, NES, PS2 etc.
// Regions represent the different distribution zones in which games are published, for example the US, Europe or Japan.
// Runs are the meat of our business at speedrun.com. A run is a finished attempt to play a game, adhering to that game's ruleset. Invalid attempts (use of cheats etc) or obsolete runs (the ones superseded by a better time by the same player(s) in the same ruleset) still count as runs and are available via API.
// Series are collections of games that have been released in context to each other, for example the "GTA" series contains all the games of this franchise. As a series is most often formed after a number of games have been published, many games do not belong to a specific series and are therefore categorized in the "Other" series.
// Users are the individuals who have registered an account on speedrun.com. Users submit (their) runs and moderate games, besides other things that are not covered by this API (like writing posts in the forums).
// Variables are custom criteria to distinguish between runs done in the same category or level. The speed in Mario Kart games (which can be 50cc, 100cc or 150cc) is an example for a variable that has 3 possible values. Variables are defined per-game and can be applicable to either all runs for this game or just full-game or individual-level (IL) runs. Variables can also be restricted to a category.

public class Main {

    
    public static void main(String [] args){
        Platform pc = new Platform("PC"); 
        Platform ps2 = new Platform("PS2");
        Game marioKartPC = new Game("Mario Kart 7", pc);
        Game marioKartPS2 =  new Game("Mario Kart 7", ps2);
        Game minecraftPC = new Game("Minecraft 1.7", pc);
        System.out.println(marioKartPS2);
        System.out.println(marioKartPC.equals(marioKartPS2));

        User pepe = new User("Pepe");
        User juan = new User("Juan");
        User maria = new User("Maria");

        Run r1 = new Run(pepe, marioKartPC, 650);
        Run r2 = new Run(pepe, marioKartPC, 1800);
        Run r3 = new RunWithScore(pepe, marioKartPC, 1800, 98);
        Run r4 = new RunWithScore(juan, marioKartPC, 1700, 50);
        Run r5 = new RunWithScore(juan, minecraftPC, 500, 20);
        Run r6 = new RunWithEasterEggs(pepe, minecraftPC, 700, 4, 10);

        System.out.println(r1);
        System.out.println(r3);

        Run best = pepe.getBestRun();
        System.out.println(best);

        LeaderBoard lb = new LeaderBoard(marioKartPC);
        lb.addRun(r3); lb.addRun(r1); lb.addRun(r2); lb.addRun(r4); 
        lb.print();
        System.out.println(lb.getLastUser());
        System.out.println(lb.getNthUser(1));

        LeaderBoard lb2 = new LeaderBoard(minecraftPC);
        lb2.addRun(r5); lb2.addRun(r6);
        lb2.print();

        LeaderBoard[] boards = {lb, lb2};
        pepe.printPositionsInLeaderBoards(boards);

        System.out.println("Best run for: " + pepe);
        System.out.println(pepe.getBestRun());
    }

}
