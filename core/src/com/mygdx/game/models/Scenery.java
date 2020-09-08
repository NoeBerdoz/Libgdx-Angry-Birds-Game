package com.mygdx.game.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Scenery {

    // Scene implementation
    private ArrayList<PhysicalObject> scene;

    public Scenery() {
        scene = new ArrayList<PhysicalObject>();
    }

    public void add(PhysicalObject elem) {
        scene.add(elem);
    }

    public void draw(SpriteBatch batch) {
        for(PhysicalObject elem: scene){
            elem.draw(batch);
        }
    }


}
