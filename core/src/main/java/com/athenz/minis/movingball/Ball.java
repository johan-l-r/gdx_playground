package com.athenz.minis.movingball;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Ball {
	private float radius;
	private final float MOVEMENT_SPEED;

	private Vector2 position;
	private Vector2 direction;

	private Color color;

	public Ball(float radius, final float MOVEMENT_SPEED, Color color) {
		this.radius = radius;

		this.MOVEMENT_SPEED = MOVEMENT_SPEED;

		// set random position for the ball
		this.position = new Vector2(
			MathUtils.random(0, Gdx.graphics.getWidth()),
			MathUtils.random(0, Gdx.graphics.getHeight())
		);

		// set random direction to change movement
		this.direction = new Vector2(
			MathUtils.randomBoolean() ? 1 : -1,
			MathUtils.randomBoolean() ? 1 : -1
		);

		this.color = color;
	}

	public void draw(ShapeRenderer renderer) {
		renderer.setColor(this.color);
		renderer.circle(this.position.x, this.position.y, this.radius);
	}

	public void update(float delta) {
		// border collision detection
		if(this.position.x -this.radius  < 0) {
			// invert direction
			this.direction.x *= -1;
		}
		if(this.position.y - this.radius < 0) {
			this.direction.y *= -1;
		}
		if(this.position.x + this.radius > Gdx.graphics.getWidth()) {
			this.direction.x *= -1;
		}
		if(this.position.y + this.radius > Gdx.graphics.getHeight()) {
			this.direction.y *= -1;
		}

		this.position.x += this.direction.x * this.MOVEMENT_SPEED * delta;
		this.position.y += this.direction.y * this.MOVEMENT_SPEED * delta;
	}
}
