package com.kuan.miniGame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.kuan.miniGame.miniGame;

public class miniGameScreen implements Screen, InputProcessor {

	private miniGame game;
	private Skin skin;
	private Stage stage;
	private Image startBtn, stopBtn, backBtn;

	private OrthographicCamera cam;
	private SpriteBatch batch;
	private TextureAtlas atlas;

	private Sprite track;
	private Sprite minitruck;

	// 500 pixel/s
	private float speed = 8000;
	public float react_time = 0;
	public float dist = 0;
	public boolean crashtriger = false;

	private enum State {
		SET, GO, STOP
	};

	private State state;

	public miniGameScreen(miniGame game) {
		this.game = game;

		state = State.STOP;

		setUI();
		batch = new SpriteBatch();
		cam = new OrthographicCamera();

		InputMultiplexer plex = new InputMultiplexer();
		plex.addProcessor(stage);
		plex.addProcessor(this);
		Gdx.input.setInputProcessor(plex);
	}

	public void setUI() {

		atlas = new TextureAtlas(
				Gdx.files.internal("data/minigame/minigame.pack"),
				Gdx.files.internal("data/minigame"));

		stage = new Stage();
		skin = new Skin();
		skin.addRegions(atlas);

		startBtn = new Image(skin, "startup");
		stopBtn = new Image(skin, "stopup");

		startBtn.setPosition(0, 10);
		stopBtn.setPosition(Gdx.graphics.getWidth() - stopBtn.getWidth(), 10);

		startBtn.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {

				if (state == State.STOP) {
					state = State.SET;
					startBtn.setDrawable(skin, "startdn");
					minitruck.setRegion(atlas.findRegion("minitruck"));
					minitruck.setX(0);
					react_time = 0;
					dist = 0;
					crashtriger = false;
				}

				Gdx.app.log("down", state.toString());
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				state = State.GO;
				startBtn.setDrawable(skin, "startup");
				Gdx.app.log("up", state.toString());
			}

		});

		stopBtn.addListener(new InputListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {

				if (state == State.SET) {
					// show alert
					Gdx.app.log("You press too early.", "Fault");
				} else {
					if (state == State.GO) {
						state = State.STOP;
						Gdx.app.log("time", Float.toString(react_time));
					}
				}
				stopBtn.setDrawable(skin, "stopdn");
				Gdx.app.log("down", state.toString());
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// state = State.GO;
				Gdx.app.log("up", state.toString());
				stopBtn.setDrawable(skin, "stopup");
			}

		});

		track = new Sprite(atlas.findRegion("track"));
		track.setSize(
				Gdx.graphics.getWidth(),
				1.0f * track.getHeight() / track.getWidth()
						* Gdx.graphics.getWidth());
		track.setPosition(0, Gdx.graphics.getHeight() - track.getHeight());

		minitruck = new Sprite(atlas.findRegion("minitruck"));
		minitruck.setSize(track.getHeight() / 3f * minitruck.getWidth()
				/ minitruck.getHeight(), track.getHeight() / 3f);
		minitruck.setPosition(10,
				Gdx.graphics.getHeight() - 0.6f * track.getHeight());

		stage.addActor(startBtn);
		stage.addActor(stopBtn);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		if (state == State.GO) {
			react_time += delta;

			if (dist >= 1500) {
				if (!crashtriger) {
					dist = 1500;
					minitruck.setRegion(atlas.findRegion("minitruck_bang"));
					crashtriger = true;
				}
			} else {
				dist = speed * react_time;
			}
			minitruck.setX(dist);
		}

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
