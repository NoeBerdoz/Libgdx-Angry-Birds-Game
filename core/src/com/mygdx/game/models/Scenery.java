package com.mygdx.game.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

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

    public void handleTouchDown(Vector2 point)
    {
        for (PhysicalObject po : scene) {
            if (po instanceof Pig) {
                Pig p = (Pig)po;
                if (p.getBoundingRectangle().contains(point)) {
                    p.sayWord();
                }
            }
        }
    }

    public void handleTouchUp(Vector2 point)
    {
        for (PhysicalObject po: scene) {
            if (po instanceof Pig) {
                ((Pig)po).shutUp();
            }
        }
    }

}
