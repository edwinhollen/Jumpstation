package com.edwinhollen.jumpstation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Edwin on 6/11/2015.
 */
public class EntitySystem {
    private List<Entity> entities = new ArrayList<Entity>();
    private List<ComponentSystem> systems = new ArrayList<ComponentSystem>();
    public Map<ComponentSystem, List<Entity>> sort(){
        Map<ComponentSystem, List<Entity>> returnMap = new HashMap<>();
        this.systems.forEach(system -> {
            returnMap.put(system, entities.stream().filter(entity -> {
                return system.accepts().parallelStream().allMatch(acceptedClass -> {
                    return acceptedClass.isInstance(entity);
                });
            }).collect(Collectors.toList()));
        });
        return returnMap;
    }
    public EntitySystem addEntity(Entity entity){
        this.entities.add(entity);
        return this;
    }
    public EntitySystem removeEntity(Entity entity){
        this.entities.remove(entity);
        return this;
    }
    public EntitySystem addSystem(ComponentSystem system){
        this.systems.add(system);
        return this;
    }
    public EntitySystem removeSystem(ComponentSystem system){
        this.systems.remove(system);
        return this;
    }
}
