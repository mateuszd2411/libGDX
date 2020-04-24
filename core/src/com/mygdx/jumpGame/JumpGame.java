package com.mygdx.jumpGame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class JumpGame extends ApplicationAdapter {

	private Music music;
	private Texture playerTexture,platformTexture;
	private JumpPlayer player;
    private Array<Platform> platformArray;
    private OrthographicCamera camera;

    private float gravity = -20;

    SpriteBatch batch;
	
	@Override
	public void create () {
	    //initialization
        loadData();
        init();

	}

    private void init() {
	    batch = new SpriteBatch();
	    music.play();
	    camera = new OrthographicCamera(480,800);

	    player = new JumpPlayer(playerTexture);
	    platformArray = new Array<Platform>();

	    //loop for platforms
        for (int i = 1; i < 3; i++){
            Platform p = new Platform(platformTexture);
            p.x = MathUtils.random(480);
            p.y = 200 * i;
            platformArray.add(p);
        }
    }

    private void loadData() {
	    //Select Run -> Edit Configurations from the menu
        //
        //In the "Working Directory:" text box, append "/android/assets" to the path.
        playerTexture = new Texture("player.png");
        platformTexture = new Texture("platform.png");
        music = Gdx.audio.newMusic(Gdx.files.internal("music.ogg"));
    }

    @Override
	public void render () {
	    update();
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		for (Platform p : platformArray){
		    p.draw(batch);
        }
		player.draw(batch);
		batch.end();
	}

    private void update() {

    }

    //clear member after close app
	@Override
	public void dispose() {

	}
}
