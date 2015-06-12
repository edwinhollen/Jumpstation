package com.edwinhollen.jumpstation.systems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.edwinhollen.jumpstation.Component;
import com.edwinhollen.jumpstation.ComponentSystem;
import com.edwinhollen.jumpstation.Entity;
import com.edwinhollen.jumpstation.components.ImageComponent;
import com.edwinhollen.jumpstation.components.PositionComponent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Edwin on 6/11/2015.
 */
public class ImageSystem implements ComponentSystem {
    private SpriteBatch batch;
    private Map<String, Texture> loadedTextures;

    public ImageSystem(){
        batch = new SpriteBatch();
        loadedTextures = new HashMap<>();
    }

    public Texture getTexture(String filename){
        if(!loadedTextures.containsKey(filename)) {
            loadedTextures.put(filename, new Texture(Gdx.files.internal(filename)));
        }
        return loadedTextures.get(filename);
    }

    @Override
    public List<Class<? extends Component>> accepts() {
        return Arrays.asList(ImageComponent.class, PositionComponent.class);
    }

    @Override
    public void dispose() {
        this.loadedTextures.forEach((s, texture) -> {
            texture.dispose();
        });
        this.loadedTextures.clear();
        this.batch.dispose();
    }

    @Override
    public void render(List<Entity> entities) {
        batch.begin();
        entities.forEach(entity -> {
            PositionComponent pos = (PositionComponent) entity.getComponentByClass(PositionComponent.class);
            entity.getComponentsByClass(ImageComponent.class).forEach(imageComponent -> {
                batch.draw(this.getTexture(((ImageComponent) imageComponent).imageName), Math.round(pos.x), Math.round(pos.y));
            });
        });
        batch.end();
    }
}
