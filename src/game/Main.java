/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import bot.RandomBot;
import bot.Shooter;
import java.util.ArrayList;


public class Main {

    ArrayList<Player> players;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Game g = new Game();
        g.players.add(new Shooter());
        g.players.add(new RandomBot());
        while (!g.isOver()) {
            g.runRound();
            System.out.println();
        }
    }

}
