package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Touch {

    public static enum Type { down, up, drag }

    public Vector2 point;
    public Type type;

    public Touch (Vector3 ptouch, Type ttype)
    {
        point = new Vector2(ptouch.x,ptouch.y);
        type = ttype;
    }
}
