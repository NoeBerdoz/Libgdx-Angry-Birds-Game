package com.mygdx.game.models;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.data.Word;

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

    /**
     * Pick a word at random among those that are in the remaining pigs
     * @return
     */
    public Word pickAWord()
    {
        // build a list of pigs
        ArrayList<Pig> pigs = new ArrayList<Pig>();
        for (PhysicalObject phob : scene) {
            if (phob instanceof Pig) {
                pigs.add((Pig)phob);
            }
        }
        // pick one word at random
        return pigs.get(MyGdxGame.alea.nextInt(pigs.size())).getWord();
    }

}
