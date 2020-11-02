/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marko.gfx;

import java.util.ArrayList;

/**
 *
 * @author Amr
 */
public class spriteSheet {


    private ArrayList<Entity> list;
    private int current = 0;

    public spriteSheet() {
        list = new ArrayList<>();
    }

    public void addSheet(int x, int y, int w, int h, String iconName) {

        Entity n = new Entity(x, y, w, h, iconName);
        list.add(n);
    }

    public Entity getEntity(int i) {
        return list.get(i);
    }

    public Entity nextSprite() {
        if (current + 1 == list.size()) {
            current = -1;
        }
        return list.get(++current);
    }
    
    public void endSequence(){
        current = 0 ;
    }

}
