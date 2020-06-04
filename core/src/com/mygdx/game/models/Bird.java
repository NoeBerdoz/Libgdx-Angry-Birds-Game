package com.mygdx.game.models;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;

public final class Bird extends MovingObject {
    private enum BirdState { init, aim, fly }

    private static final String PICNAME = "bird.png";

    public static final int WIDTH = 60;
    public final static int HEIGHT = 60;

    public float angle; // Balistic angle
    public float v0; // Speed physics

    public boolean moving = false;
    public float time;
    public MathUtils math;

    private BirdState state = BirdState.init;

    public Bird() {
        super(new Vector2(MyGdxGame.TWEETY_START_X, MyGdxGame.TWEETY_START_Y), WIDTH, HEIGHT, PICNAME, new Vector2(0,0));
    }

    @Override
    public void unFreeze() {
        super.unFreeze();
        state = BirdState.fly;
    }

    @Override
    public void accelerate(float dt) {

        if (state == BirdState.fly) speed.y -= MovingObject.G * dt;
    }

    public boolean getMoving() {
        return moving;

    }

    public void fire() {
        if(!moving){
            double theta = 180.0 / Math.PI * Math.atan2(  MyGdxGame.TWEETY_START_X - this.getX(), MyGdxGame.TWEETY_START_Y - this.getY());
            this.angle = (float) (90-theta);
            double dist = Math.hypot(Math.abs(MyGdxGame.TWEETY_START_X - this.getX()), Math.abs(  MyGdxGame.TWEETY_START_Y-this.getY()));
            this.v0 = (float) (dist/10); // Tweety speed on move, divide dist by a lower number to accelerate the lauch
            this.moving = true;
        }

    }

    public void fly(float dt){
        if(moving){
            time += dt; // dt forward the game time
            this.translate(this.Vx(), this.Vy(time));

            if(this.getY() < -500) {
                this.reset();
            }
        }
    }

    public void reset(){
        this.moving = false;
        this.setPosition(MyGdxGame.TWEETY_START_X, MyGdxGame.TWEETY_START_Y);
        this.time = 0;
    }

    private float Vx(){
        return v0*math.cosDeg(angle);
    }

    private float Vy(float time){
        return v0*math.sinDeg(angle)-10*time;
    }

    public void aim(float x, float y)
    {

    }
}
