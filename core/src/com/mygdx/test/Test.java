package com.mygdx.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Test extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture texture;
	private BitmapFont font;
	private GameObject gameObject1,gameObject2;
	
	@Override
	public void create () {

		//initialize
		texture = new Texture("1.png");
		batch = new SpriteBatch();
		font = new BitmapFont();

		font.setColor(Color.BLACK);

		gameObject1 = new GameObject(texture);
		gameObject1.x = 50;
		gameObject1.y = 50;
		gameObject1.height = gameObject1.getTexture().getHeight();
		gameObject1.width = gameObject1.getTexture().getWidth();

		gameObject2 = new GameObject(texture);
		gameObject2.x = 400;
		gameObject2.y = 400;
		gameObject2.height = gameObject2.getTexture().getHeight();
		gameObject2.width = gameObject2.getTexture().getWidth();
	}

	@Override
	public void render () {

	    update();

		Gdx.gl.glClearColor(10, 10, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		batch.draw(gameObject1.getTexture(),gameObject1.x,gameObject1.y);
		batch.draw(gameObject2.getTexture(),gameObject2.x,gameObject2.y);
		font.draw(batch,"Elo",300,300);

		batch.end();

	}

    private void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
			gameObject1.x -= 10;
        }
		if (Gdx.input.isKeyPressed(Input.Keys.W)){
			gameObject1.y += 10;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)){
			gameObject1.y -= 10;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)){
			gameObject1.x += 10;
		}

		if (gameObject1.overlaps(gameObject2)){		//collision
			Gdx.app.exit();
		}

    }

    //clear member after close app
	@Override
	public void dispose() {
		System.out.println("dispose");
		batch.dispose();
		texture.dispose();
		font.dispose();
	}
}
