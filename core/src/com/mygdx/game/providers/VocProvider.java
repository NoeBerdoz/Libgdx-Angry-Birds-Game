package com.mygdx.game.providers;

import com.mygdx.game.MyGdxGame;
import com.mygdx.game.data.Vocabulary;
import com.mygdx.game.data.Word;

import java.util.ArrayList;

public class VocProvider {

    // static variable single_instance of type VocProvider
    private static VocProvider single_instance = null;

    public ArrayList<Vocabulary> vocs; // all available vocs

    // private constructor restricted to this class itself
    private VocProvider()
    {
        vocs = new ArrayList<Vocabulary>();
        Word w;
        Vocabulary voc = new Vocabulary("l'argent");
        w = new Word("La banque", "The bank"); voc.addWord(w);
        w = new Word("Liquide", "Cash"); voc.addWord(w);
        vocs.add(voc);
    }

    // static method to create instance of Singleton class
    public static VocProvider getInstance()
    {
        if (single_instance == null)
            single_instance = new VocProvider();

        return single_instance;
    }

    public Vocabulary pickAVoc() {
        return vocs.get(MyGdxGame.alea.nextInt(vocs.size()));
    }
}
