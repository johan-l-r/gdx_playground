package com.athenz.minis.movingball;

import com.athenz.Core;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BallScreen implements Screen {
	private Core core;

	private Ball ball;

	public BallScreen(Core core) {
		this.core = core;

		this.ball = new Ball(20f, 100f, new Color(1f, 1f, 1f, 1f));
	}

	@Override
	public void render(float delta) {
		// clear the screen and fill it with black
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// UPDATE FIRST
		this.ball.update(delta);

		// THEN DRAW
		this.core.getRenderer().begin(ShapeRenderer.ShapeType.Filled);

		// draw here
		this.ball.draw(this.core.getRenderer());

		this.core.getRenderer().end();
	}

	@Override
	public void dispose() {

	}

	@Override public void show() {}
	@Override public void resize(int width, int height) {}
	@Override public void pause() {}
	@Override public void resume() {}
	@Override public void hide() {}
}
