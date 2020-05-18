package com.mygdx.game.models;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;


public class Wasp extends MovingObject {

    private static final int AGITATION = 15; // How fastly speed changes
    private static final String PICNAME = "wasp.png";
    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    public Wasp(Vector2 position, Vector2 speed) { super(position, WIDTH, HEIGHT, PICNAME, speed); }

    @Override
    public void accelerate(float dt) {
    // Willl do it randomly
        /*
        Vector2 craziness = new Vector2 (MyGdxGame.alea.nextFloat()-(getX()/MyGdxGame.WORLD_WIDTH),MyGdxGame.alea.nextFloat()-(getY()/MyGdxGame.WORLD_HEIGHT));
        speed = speed.add(craziness.scl(AGITATION));*/

        speed.x += (MyGdxGame.alea.nextFloat()-getX()/ MyGdxGame.WORLD_WIDTH)*AGITATION;
        speed.y += (MyGdxGame.alea.nextFloat()-getY()/ MyGdxGame.WORLD_HEIGHT)*AGITATION;

    }
}
