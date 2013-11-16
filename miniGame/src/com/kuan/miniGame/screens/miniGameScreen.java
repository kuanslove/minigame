package com.kuan.miniGame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.kuan.miniGame.miniGame;

public class miniGameScreen implements Screen, InputProcessor {

	private miniGame game;
	private Skin skin;
	private Stage stage;
	private Image startBtn, stopBtn, backBtn;

	private OrthographicCamera cam;
	private SpriteBatch batch;

	private boolean started = false;
	private Sprite track;
	private Sprite minitruck;

	// 500 pixel/s
	private int speed = 500;
	
	public miniGameScreen(miniGame game) {
		this.game = game;

		stage = new Stage();
		skin = new Skin();
		skin.add("start", new Texture("data/minigame/start.png"));
		skin.add("stop", new Texture("data/minigame/stop.png"));
		skin.add("back", new Texture("data/minigame/back.png"));
		
		startBtn = new Image(skin, "start");
		stopBtn = new Image(skin, "stop");
		
		startBtn.setPosition(0, 10);
		stopBtn.setPosition(Gdx.graphics.getWidth()-stopBtn.getWidth(), 0);
		
		
		track = new Sprite(new Texture(
				Gdx.files.internal("data/minigame/track.jpg")));
		track.setSize(
				Gdx.graphics.getWidth(),
				1.0f * track.getHeight() / track.getWidth()
						* Gdx.graphics.getWidth());
		track.setPosition(0, Gdx.graphics.getHeight() - track.getHeight());

		minitruck = new Sprite(new Texture(
				Gdx.files.internal("data/minigame/minitruck.png")));
		minitruck.setSize(track.getHeight() / 3f * minitruck.getWidth()
				/ minitruck.getHeight(), track.getHeight() / 3f);
		minitruck.setPosition(
				10,
				Gdx.graphics.getHeight() - 0.6f*track.getHeight());

		stage.addActor(startBtn);
		stage.addActor(stopBtn);
		batch = new SpriteBatch();
		cam = new OrthographicCamera();

		InputMultiplexer plex = new InputMultiplexer();
		plex.addProcessor(stage);
		plex.addProcessor(this);
		Gdx.input.setInputProcessor(plex);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();
		batch.begin();
		track.draw(batch);
		minitruck.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		cam.viewportWidth = width / 10;
		cam.viewportHeight = height / 10;
		cam.update();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
