package com.athenz.minis.movingball;

import com.athenz.Core;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BallScreen implements Screen {
	private final Core core;

  private Ball ball; 

	public BallScreen(final Core core) {
		this.core = core;

    this.ball = new Ball(20f, 200f);
	}

  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    // FIRST UPDATE
    this.ball.update(delta);

    this.core.getShapeRenderer().begin(ShapeRenderer.ShapeType.Filled);

    // THEN DRAW
    this.ball.draw(this.core.getShapeRenderer());

    this.core.getShapeRenderer().end();
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