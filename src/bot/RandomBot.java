/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;
 
import game.Move;
import game.Player;
import java.util.ArrayList;
 

public class RandomBot extends Player {
 
    @Override
    public Move getMove(ArrayList<Player> otherPlayers, ArrayList<Player> deadPlayers) {
        int i = rand.nextInt(3);
        switch (i) {
            case 0:
                return Move.Reload;
            case 1:
                Move m = Move.Shoot;
                m.shotPlayer = otherPlayers.get(0);
                return m;
            case 2:
                return Move.Shield;
            default:
                throw new AssertionError();
        }
 
    }
}