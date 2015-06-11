package com.edwinhollen.jumpstation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Edwin on 6/11/2015.
 */
public class Entity {
    public List<Component> components = new ArrayList<>();
    public Entity(){}
    public Entity addComponent(Component component){
        this.components.add(component);
        return this;
    }
}
