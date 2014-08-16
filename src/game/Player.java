/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package game;
 
import java.util.ArrayList;
import java.util.Random;
 
/**
 *
 * 
 */
public abstract class Player {
    public ArrayList<Move> moveHistory;
    boolean willDie;
    boolean isSafe;
    int bullets;
    protected static Random rand = new Random();
    public int getBullets(){
        return bullets;
    }
    public final String getInfo(){
        return getClass().getName() + "("+bullets+"b)";
    }
    public abstract Move getMove(ArrayList<Player> otherPlayers, ArrayList<Player> deadPlayers);
}