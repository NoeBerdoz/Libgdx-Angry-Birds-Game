package com.mygdx.game.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public final class Pig extends TextualObject {

    // Characteristics
    private static final String PICNAME = "pig.png";
    private static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    private Bubble scream = null;

    public Pig(Vector2 position, String word) {
        super(position, WIDTH, HEIGHT, PICNAME, word);
        Gdx.app.log("ANGRY", "New pig carrying word: "+word);
    }

    public String getWord() { return super.getText();}

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
        if (scream != null) {
            scream.draw(batch);
        }
    }

    public void sayWord()
    {
        this.scream = new Bubble(this);
    }

    public void shutUp()
    {
        this.scream = null;
    }
}
