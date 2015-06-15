package com.edwinhollen.jumpstation.systems;

import com.edwinhollen.jumpstation.Component;
import com.edwinhollen.jumpstation.ComponentSystem;
import com.edwinhollen.jumpstation.Entity;
import com.edwinhollen.jumpstation.EntitySystem;
import com.edwinhollen.jumpstation.components.ImageComponent;
import com.edwinhollen.jumpstation.components.PositionComponent;
import com.edwinhollen.jumpstation.components.TileComponent;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Edwin on 6/14/2015.
 */
public class TileSystem implements ComponentSystem {
    @Override
    public List<Class<? extends Component>> accepts() {
        return Arrays.asList(TileComponent.class, ImageComponent.class, PositionComponent.class);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void render(List<Entity> entities) {
        entities.forEach(entity -> {
            TileComponent tc = (TileComponent) entity.getComponentByClass(TileComponent.class);
            ImageComponent ic = (ImageComponent) entity.getComponentByClass(ImageComponent.class);
            PositionComponent pc = (PositionComponent) entity.getComponentByClass(PositionComponent.class);
            pc.x = (tc.col) * 48;
            pc.y = (tc.row) * 48;
            switch(tc.type){
                case EMPTY:
                    ic.imageName = "floor_empty.png";
                    break;
                case FLOOR:
                    ic.imageName = "floor_light.png";
                    break;
            }
        });
    }
}
