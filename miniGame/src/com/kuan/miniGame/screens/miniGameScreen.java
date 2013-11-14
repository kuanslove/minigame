package com.kuan.miniGame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
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
	private Image gameButton;

	private OrthographicCamera cam;
	private SpriteBatch batch;

	private boolean started = false;

	public miniGameScreen(miniGame game) {
		this.game = game;
		stage = new Stage();
		skin = new Skin();
		skin.add("start", new Texture("data/start.png"));
		skin.add("stop", new Texture("data/stop.png"));
		gameButton = new Image(skin, "start");
		// gameButton.setSize(800, 500);
		gameButton.setOrigin(gameButton.getWidth() / 2,
				gameButton.getHeight() / 2);
		// gameButton.setRotation(90);
		gameButton.setPosition(
				Gdx.graphics.getWidth() / 2 - gameButton.getWidth() / 2,
				Gdx.graphics.getHeight() - gameButton.getHeight()-20);
		gameButton.addListener(new ClickListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {

				if (!started) {
					gameButton.setDrawable(skin, "stop");
					started = !started;
				} else {
					gameButton.setDrawable(skin, "start");
					started = !started;
				}

				return false;
			}

			@Override
			public void touchDragged(InputEvent event, float x, float y,
					int pointer) {
				// TODO Auto-generated method stub
				super.touchDragged(event, x, y, pointer);
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				// TODO Auto-generated method stub
				super.touchUp(event, x, y, pointer, button);
			}

			@Override
			public void enter(InputEvent event, float x, float y, int pointer,
					Actor fromActor) {
				// TODO Auto-generated method stub
				super.enter(event, x, y, pointer, fromActor);
			}

			@Override
			public void exit(InputEvent event, float x, float y, int pointer,
					Actor toActor) {
				// TODO Auto-generated method stub
				super.exit(event, x, y, pointer, toActor);
			}

			@Override
			public void cancel() {
				// TODO Auto-generated method stub
				super.cancel();
			}

			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO Auto-generated method stub
				super.clicked(event, x, y);
			}

			@Override
			public boolean isOver(Actor actor, float x, float y) {
				// TODO Auto-generated method stub
				return super.isOver(actor, x, y);
			}

			@Override
			public boolean inTapSquare(float x, float y) {
				// TODO Auto-generated method stub
				return super.inTapSquare(x, y);
			}

			@Override
			public void invalidateTapSquare() {
				// TODO Auto-generated method stub
				super.invalidateTapSquare();
			}

			@Override
			public boolean isPressed() {
				// TODO Auto-generated method stub
				return super.isPressed();
			}

			@Override
			public boolean isOver() {
				// TODO Auto-generated method stub
				return super.isOver();
			}

			@Override
			public void setTapSquareSize(float halfTapSquareSize) {
				// TODO Auto-generated method stub
				super.setTapSquareSize(halfTapSquareSize);
			}

			@Override
			public float getTapSquareSize() {
				// TODO Auto-generated method stub
				return super.getTapSquareSize();
			}

			@Override
			public void setTapCountInterval(float tapCountInterval) {
				// TODO Auto-generated method stub
				super.setTapCountInterval(tapCountInterval);
			}

			@Override
			public int getTapCount() {
				// TODO Auto-generated method stub
				return super.getTapCount();
			}

			@Override
			public float getTouchDownX() {
				// TODO Auto-generated method stub
				return super.getTouchDownX();
			}

			@Override
			public float getTouchDownY() {
				// TODO Auto-generated method stub
				return super.getTouchDownY();
			}

			@Override
			public int getPressedButton() {
				// TODO Auto-generated method stub
				return super.getPressedButton();
			}

			@Override
			public int getPressedPointer() {
				// TODO Auto-generated method stub
				return super.getPressedPointer();
			}

			@Override
			public int getButton() {
				// TODO Auto-generated method stub
				return super.getButton();
			}

			@Override
			public void setButton(int button) {
				// TODO Auto-generated method stub
				super.setButton(button);
			}

		});

		stage.addActor(gameButton);
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

		batch.begin();

		stage.draw();

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
