package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.models.Bird;
import com.mygdx.game.models.PhysicalObject;
import com.mygdx.game.models.Wasp;

import com.badlogic.gdx.InputProcessor;
import javafx.scene.input.TouchPoint;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor{
	SpriteBatch batch;
	Texture img;
	float x;

	public static Random alea;

	public static final int WORLD_WIDTH = 1600;
	public static final int WORLD_HEIGHT = 900;
	public static final int FLOOR_HEIGHT = 120;


	public static final int TWEETY_START_X = 100;
	public static final int TWEETY_START_Y = 200;

	private Texture background;

	private Bird tweety;
	private Wasp waspy;

	@Override
	public void create () {
		alea = new Random();

		background = new Texture(Gdx.files.internal("background.jpg"));

		batch = new SpriteBatch();

		tweety = new Bird();
		waspy = new Wasp(new Vector2(WORLD_WIDTH / 2, WORLD_HEIGHT / 2), new Vector2(20, 20));
	}

	public void update() {
		float dt = Gdx.graphics.getDeltaTime();

		tweety.accelerate(dt);
		tweety.move(dt);


		waspy.accelerate(dt);
		waspy.move(dt);
	}



	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		update();
		batch.draw(background, 0, 0);
		tweety.draw(batch);
		waspy.draw(batch);
		batch.end();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
