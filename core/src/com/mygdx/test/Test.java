package com.mygdx.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Test extends ApplicationAdapter {

	private SpriteBatch batch;
	private Texture texture;
	private BitmapFont font;
	
	@Override
	public void create () {

		//initialize
		texture = new Texture("1.png");
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(Color.BLACK);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(10, 10, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();

		batch.draw(texture,100,100);
		font.draw(batch,"Elo",300,300);

		batch.end();

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
