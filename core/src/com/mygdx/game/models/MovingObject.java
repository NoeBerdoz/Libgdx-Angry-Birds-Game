package com.mygdx.game.models;

import com.badlogic.gdx.math.Vector2;

abstract class MovingObject extends PhysicalObject {
    public final static float G = 250f; // Gravity for falling objects

    protected Vector2 speed;
    protected boolean frozen; // Allows to freeze a movement

    public MovingObject(Vector2 position, float width, float height, String picname, Vector2 speed) {
        super(position, width, height, picname);
        this.speed = speed;
    }

    public abstract void accelerate(float dt); // accelerate implements speed change

    public void freeze() { frozen = true; }

    public boolean isFrozen() { return frozen; }

}
