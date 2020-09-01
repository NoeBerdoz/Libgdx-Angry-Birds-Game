package com.mygdx.game.models;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.models.PhysicalObject;

public final class Tnt extends PhysicalObject {

    // Characteristics
    private static final String PICNAME = "tnt.png";
    private static final int WIDTH = 100;
    public static final int HEIGHT = 100;

    public Tnt(Vector2 position) { super(position, WIDTH, HEIGHT, PICNAME);}
}
