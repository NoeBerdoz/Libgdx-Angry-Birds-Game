package com.mygdx.game.models;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;

abstract class MovingObject extends PhysicalObject {
    public final static float G = 250f; // Gravity for falling objects

    protected Vector2 speed;
    protected boolean frozen; // Allows to freeze a movement

    public MovingObject(Vector2 position, float width, float height, String picname, Vector2 speed) {
        super(position, width, height, picname);
        this.speed = speed;
    }

    public abstract void accelerate(float dt); // accelerate implements speed change

    public void freeze() {
        this.frozen = true;
    }

    public boolean isFrozen() { return frozen; }

    public void unFreeze() { this.frozen = false; }

    public final void move(float dt)
    {
        if (!frozen) {
            translate(speed.x * dt, speed.y * dt);
            if (getPosition().x < 0 || getPosition().x > MyGdxGame.WORLD_WIDTH || getPosition().y  < MyGdxGame.FLOOR_HEIGHT || getPosition().y > MyGdxGame.WORLD_HEIGHT)
                stop();
        }
    }

    public final void stop()
    {
        speed.x = 0; // Calm down
        speed.y = 0;
    }

}
