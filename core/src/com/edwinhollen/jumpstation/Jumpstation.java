package com.edwinhollen.jumpstation;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.edwinhollen.jumpstation.scenes.GameScene;
import com.edwinhollen.jumpstation.scenes.TitleScene;

public class Jumpstation extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private static Scene currentScene;
	private static Scene nextScene = null;
	
	@Override
	public void create () {
		//batch = new SpriteBatch();
		//img = new Texture("badlogic.jpg");
		currentScene = new GameScene();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		currentScene.render();
		if(nextScene != null){
			setNewScene(nextScene);
		}
	}

	public static void changeScene(Scene newScene){
		nextScene = newScene;
	}

	private static void setNewScene(Scene newScene){
		currentScene.dispose();
		currentScene = newScene;
	}
}
