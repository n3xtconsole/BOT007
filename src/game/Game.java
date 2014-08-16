/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * 
 */
public class Game {

    public ArrayList<Player> players = new ArrayList<>();
    public ArrayList<Player> deadPlayers = new ArrayList<>();

    public boolean isOver() {
        return players.size() < 2;
    }

    public void runRound() {
        for (Player p : players) {
            ArrayList<Player> players3 = new ArrayList<>(players);
            players3.remove(p);
            Move move = p.getMove(players3, deadPlayers);
            switch (move) {
                case Reload:
                    p.bullets++;

                    System.out.println(p.getInfo() + " reloaded.");
                    break;
                case Shoot:
                    if (p.bullets > 0) {
                        move.shotPlayer.willDie = true;
                        p.bullets--;
                        System.out.println(p.getInfo() + " shot " + move.shotPlayer.getClass().getName());
                    } else {
                        System.out.println(p.getInfo() + " tried to shoot " + move.shotPlayer.getClass().getName());
                    }
                    break;
                case Shield:
                    System.out.println(p.getInfo() + " shielded.");
                    p.isSafe = true;
                    break;
                default:
                    throw new AssertionError(move.name());
            }
        }
        Iterator<Player> it = players.iterator();
        while (it.hasNext()) {
            Player pp = it.next();
            if (pp.willDie && !pp.isSafe) {
                System.out.println(pp.getInfo() + " died.");
                it.remove();
                deadPlayers.add(pp);
            }
        }
    }
}
