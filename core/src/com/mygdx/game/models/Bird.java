package com.mygdx.game.models;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;

public final class Bird extends MovingObject {
    private enum BirdState { init, aim, fly }

    private static final String PICNAME = "bird.png";

    public static final int WIDTH = 60;
    public final static int HEIGHT = 60;

    private BirdState state = BirdState.init;

    public Bird() {
        super(new Vector2(MyGdxGame.TWEETY_START_X, MyGdxGame.TWEETY_START_Y), WIDTH, HEIGHT, PICNAME, new Vector2(0,0));
    }
    /* TO IMPLEMENT LATER
    public void unFreeze() {
        super.unFreeze();
        state = BirdState.fly;
    }
    */

    public void accelerate(float dt) {

    }
}
