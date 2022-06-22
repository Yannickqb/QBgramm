package Models;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Yannick Ledermann
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Team t1 = new Team(new ArrayList<Player>(), new ArrayList<Coach>(), new ArrayList<Match>(), "Sharks", new Date(2009,7,11), "Schaffhausen", "Shark Tank" );
        Team t2 = new Team(new ArrayList<Player>(), new ArrayList<Coach>(), new ArrayList<Match>(), "Invaders", new Date(2013,8,1), "Langental", "Langental Stadion" );
        Player p1 = new Player(new Date(2003,7,11),"Ledermann", "Yannick", t1, new ArrayList<Match>(), Position.QB);
        Player p2 = new Player(new Date(2000,11,7),"gg", "ff", t2, new ArrayList<Match>(), Position.QB);
        Stats st1 = new Stats(p1, 200, 20, 5, 0, 50, t1);
        Stats st2 = new Stats(p2, 100, 12, 2, 3, 20, t2);
        Match m1 = new Match(t1, t2, 60, 30, new Date(2022, 05, 8), new ArrayList<Stats>(), 1);
        m1.addStats(st1);
        m1.addStats(st2);

        System.out.println(p1.getWinningrec(1, p1.getTeamReference()));
        System.out.println(p1.getPosition());
        System.out.println(st1.getRushing(p1));
        System.out.println(p1.getHistory().get(0).getStats().size());
        System.out.println(p1.averigeSeasonRushing(1));
        System.out.println(st1.getCompletion(p1));
        System.out.println(st1.getPlayer());
        System.out.println(st1.getYards(p1));
        System.out.println(p1.getName());
        System.out.println();

    }
}
