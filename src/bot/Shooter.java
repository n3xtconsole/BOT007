/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

import game.Move;
import static game.Move.*;
import game.Player;
import java.util.ArrayList;

/**
 *
 *  
 */
public class Shooter extends Player {

    @Override
    public Move getMove(ArrayList<Player> otherPlayers, ArrayList<Player> deadPlayers) {
        if(getBullets() > 0){
            Move m = Shoot;
            m.shotPlayer = otherPlayers.get(0);
            return m;
        }
        return Reload;
}
}