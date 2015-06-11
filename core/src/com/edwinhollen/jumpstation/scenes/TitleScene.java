package com.edwinhollen.jumpstation.scenes;

import com.edwinhollen.jumpstation.Entity;
import com.edwinhollen.jumpstation.EntitySystem;
import com.edwinhollen.jumpstation.RenderableEntities;
import com.edwinhollen.jumpstation.Scene;
import com.edwinhollen.jumpstation.components.ImageComponent;
import com.edwinhollen.jumpstation.components.PhysicsComponent;
import com.edwinhollen.jumpstation.components.PositionComponent;
import com.edwinhollen.jumpstation.systems.ImageSystem;
import com.edwinhollen.jumpstation.systems.PhysicsSystem;

/**
 * Created by Edwin on 6/11/2015.
 */
public class TitleScene extends Scene {
    private EntitySystem ces;

    public TitleScene() {
        this.ces = new EntitySystem()
            .addSystem(new PhysicsSystem())
            .addSystem(new ImageSystem())
            .addEntity(new Entity()
                            .addComponent(new PositionComponent(0, 0))
                            .addComponent(new PhysicsComponent())
            )
            .addEntity(new Entity()
                .addComponent(new PositionComponent(0, 0))
            )
            .addEntity(new Entity()
                .addComponent(new PositionComponent(0, 0))
                .addComponent(new ImageComponent("badlogic.jpg"))
            );
    }

    @Override
    public void render() {
        this.ces.sort().forEach(RenderableEntities::render);
    }
}
