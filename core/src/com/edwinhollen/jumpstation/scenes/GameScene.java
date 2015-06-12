package com.edwinhollen.jumpstation.scenes;

import com.badlogic.gdx.Gdx;
import com.edwinhollen.jumpstation.Entity;
import com.edwinhollen.jumpstation.EntitySystem;
import com.edwinhollen.jumpstation.RenderableEntities;
import com.edwinhollen.jumpstation.Scene;
import com.edwinhollen.jumpstation.components.ImageComponent;
import com.edwinhollen.jumpstation.components.PositionComponent;
import com.edwinhollen.jumpstation.systems.ImageSystem;

import java.time.Instant;
import java.util.Random;

/**
 * Created by Edwin on 6/11/2015.
 */
public class GameScene extends Scene {
    private EntitySystem ces;
    private Random random;
    public GameScene(){
        System.out.println("Entering game scene...");
        this.ces = new EntitySystem()
            // add systems
            .addSystem(new ImageSystem());

        this.random = new Random(Instant.now().getEpochSecond());

        int layoutWidth = 3;
        int layoutHeight = 3;
        int roomWidth = 4;
        int roomHeight = 4;

        // generate layout
        // 000  0 = empty
        // 010  1 = room
        // 000

        int[][] layout = new int[layoutWidth][layoutHeight];
        layout[Math.round(layoutHeight/2)][Math.round(layoutWidth/2)] = 2;

        for(int row = 0; row < layoutHeight; row++){
            System.out.print("\n");
            for(int col = 0; col < layoutWidth; col++){
                Entity e = new Entity();
                if(layout[row][col] == 0){
                    layout[row][col] = random.nextBoolean() ? 1 : 0;
                }
                String imageName = "floor_light"+layout[row][col]+".png";
                e.addComponent(new ImageComponent(imageName));
                e.addComponent(new PositionComponent(col*48, row*48));
                ces.entities.add(e);
            }
        }
    }

    @Override
    public void render() {
        ces.sort().forEach(RenderableEntities::render);
    }

    @Override
    public void dispose() {

    }
}
