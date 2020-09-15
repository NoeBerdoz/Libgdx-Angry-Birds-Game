package com.mygdx.game.data;

import com.mygdx.game.MyGdxGame;

import java.util.ArrayList;

public class Vocabulary {

    private String vocName;
    private ArrayList<Word> words;

    public Vocabulary(String vocName) {
        this.vocName = vocName;
        this.words = new ArrayList<Word>();
    }

    public void addWord(Word w) {
        words.add(w);
    }

    public Word pickAWord() {
        return words.get(MyGdxGame.alea.nextInt(words.size()));
    }
}
