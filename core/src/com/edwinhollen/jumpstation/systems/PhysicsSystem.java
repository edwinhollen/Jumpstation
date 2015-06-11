package com.edwinhollen.jumpstation.systems;

import com.edwinhollen.jumpstation.*;
import com.edwinhollen.jumpstation.components.PhysicsComponent;
import com.edwinhollen.jumpstation.components.PositionComponent;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Edwin on 6/11/2015.
 */
public class PhysicsSystem implements ComponentSystem{

    @Override
    public void render(List<Entity> entities) {
        entities.forEach(entity -> {
            PositionComponent pos = (PositionComponent) entity.getComponentByClass(PositionComponent.class);
            PhysicsComponent phys = (PhysicsComponent) entity.getComponentByClass(PhysicsComponent.class);
            pos.x += phys.vX;
            pos.y += phys.vY;

        });
    }

    @Override
    public List<Class<? extends Component>> accepts() {
        return Arrays.asList(PhysicsComponent.class, PositionComponent.class);
    }
}
