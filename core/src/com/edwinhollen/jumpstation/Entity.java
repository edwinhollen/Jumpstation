package com.edwinhollen.jumpstation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    /*
    public List<Component> getComponentsByClass(Class<? extends Component> componentClass){
        return this.components.parallelStream().filter(componentClass::isInstance).collect(Collectors.toList());
    }
    */

    public List<? extends Component> getComponentsByClass(Class<? extends Component> type){
        return this.components.parallelStream().filter(type::isInstance).collect(Collectors.toList());
    }

    public Component getComponentByClass(Class<? extends Component> type){
        return this.getComponentsByClass(type).get(0);
    }
}
