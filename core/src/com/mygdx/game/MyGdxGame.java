package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.models.*;
import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;
import java.util.Queue;

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

	private static final float ELASTICITY = 6f;

	private Texture background;

	private Bird tweety;
	private Wasp waspy;

	/*private Queue<Touch> actions; ENLEVER*/
	protected OrthographicCamera camera;

	private Scenery scenery;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, WORLD_WIDTH, WORLD_HEIGHT); // Make orthogonal matrice
		camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0); // Place on the middle
		camera.update();

		alea = new Random();

		background = new Texture(Gdx.files.internal("background.jpg"));

		batch = new SpriteBatch();

		tweety = new Bird();
		waspy = new Wasp(new Vector2(WORLD_WIDTH / 2, WORLD_HEIGHT / 2), new Vector2(20, 20));

		Gdx.input.setInputProcessor(this); // Initialize tactile input

		// Initialize arraylist
		scenery = new Scenery();


		// Fill ArrayList

		// TNTS
		scenery.add(new Tnt(new Vector2(400, 200)));
		scenery.add(new Tnt(new Vector2(500, 200)));
		scenery.add(new Tnt(new Vector2(500, 280)));
		scenery.add(new Tnt(new Vector2(500, 350)));

		// PIGS
		scenery.add(new Pig(new Vector2(400,290)));

		// BLOCKS
		// Creating 10 blocks
		for (int x=600; x<=1500; x = x+100) {
			scenery.add(new PhysicalObject(new Vector2(x, 200),100,100,"block.png"));
		}


	}

	public void update() {
		float dt = Gdx.graphics.getDeltaTime();

		tweety.accelerate(dt);
		tweety.move(dt);


		waspy.accelerate(dt);
		waspy.move(dt);

		tweety.fly(dt);
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
		scenery.draw(batch);
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
	public boolean touchDown(int screenX, int screenY, int pointer, int button) { // S'active quand le tactile est appuyé
		Vector3 pointTouched = camera.unproject(new Vector3(screenX, screenY, 0));
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) { // S'active quand le tactile est relevé
		tweety.fire();
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) { // S'active lors du maintient du tactile + déplacement
		// Doc intéressante pour le drag balistique : https://stackoverflow.com/questions/10401644/mousejointdef-libgdx-draw-a-trajectory-line-like-angry-birds

		if(!tweety.getMoving()) { // Test si il peut bouger ou pas
			tweety.setPosition(tweety.getX() + Gdx.input.getDeltaX(), tweety.getY() - Gdx.input.getDeltaY());

		}

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
