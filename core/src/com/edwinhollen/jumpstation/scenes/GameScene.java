package com.edwinhollen.jumpstation.scenes;

import com.badlogic.gdx.Gdx;
import com.edwinhollen.jumpstation.*;
import com.edwinhollen.jumpstation.components.ImageComponent;
import com.edwinhollen.jumpstation.components.PositionComponent;
import com.edwinhollen.jumpstation.components.TileComponent;
import com.edwinhollen.jumpstation.systems.ImageSystem;
import com.edwinhollen.jumpstation.systems.TileSystem;
import javafx.geometry.Pos;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Edwin on 6/11/2015.
 */
public class GameScene extends Scene {
    private EntitySystem ces;
    private final long SEED = 123;
    private Random random;
    public GameScene(){
        System.out.println("Entering game scene...");
        this.ces = new EntitySystem()
            // add systems
            .addSystem(new ImageSystem())
            .addSystem(new TileSystem());

        random = new Random();

        int layoutWidthMin = 5;
        int layoutHeightMin = 5;
        int layoutWidthMax = 8;
        int layoutHeightMax = 8;
        int roomSize = 3;

        // generate layout
        // 000  0 = empty
        // 010
        // 000  1 = floor
        System.out.println("Generating layout...");
        int[][] layout = new int[random.nextInt(layoutHeightMin, layoutHeightMax)][random.nextInt(layoutWidthMin, layoutWidthMax)];
        layout[Math.round(layout.length/2)][Math.round(layout[0].length/2)] = 1;

        int[][] expandedLayout = new int[layout.length*roomSize][layout[0].length*roomSize];
        for(int row = 0; row < expandedLayout.length; row+=roomSize){
            for(int col = 0; col < expandedLayout[0].length; col+=roomSize){
                int val = layout[row/roomSize][col/roomSize];
                for(int h = 0; h < roomSize; h++){
                    for(int w = 0; w < roomSize; w++){
                        expandedLayout[row+h][col+w] = val;
                    }
                }
            }
        }

        for(int row = 0; row < expandedLayout.length; row++){
            for(int col = 0; col < expandedLayout[0].length; col++){
                Entity e = new Entity();
                TileComponent.TileTypes type;
                switch(expandedLayout[row][col]){
                    case 0:
                        type = TileComponent.TileTypes.EMPTY;
                        break;
                    case 1:
                        type = TileComponent.TileTypes.FLOOR;
                        break;
                    default:
                        type = TileComponent.TileTypes.EMPTY;
                        break;
                }
                e.addComponent(new ImageComponent("floor_empty.png"));
                e.addComponent(new PositionComponent(0, 0));
                e.addComponent(new TileComponent(row, col, type));
                ces.addEntity(e);
            }
        }

        // print
        for(int[] row : layout){
            String endStr = "";
            for(int col : row){
                endStr = endStr.concat(Integer.toString(col));
            }
            System.out.println(endStr);
        }
    }

    @Override
    public void render() {
        ces.sort().forEach(RenderableEntities::render);
    }

    @Override
    public void dispose() {
        this.ces.systems.forEach(ComponentSystem::dispose);
    }
}
