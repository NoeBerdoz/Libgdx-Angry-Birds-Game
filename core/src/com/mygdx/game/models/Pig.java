package com.mygdx.game.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.data.Word;

public final class Pig extends TextualObject {

    // Characteristics
    private static final String PICNAME = "pig.png";
    private static final int WIDTH = 100;
    public static final int HEIGHT = 100;
    private Bubble scream = null;
    private Word word; // The word with both languages

    public Pig(Vector2 position, Word word) {
        super(position, WIDTH, HEIGHT, PICNAME, word.getValue1());
        this.word = word;
        Gdx.app.log("ANGRY", "New pig carrying word: "+word);
    }

    public String getWordForDisplay() { return super.getText(); }

    public Word getWord() {
        return word;
    }

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
    } // Create a new bubble for the word

    public void shutUp()
    {
        this.scream = null;
    }
}
