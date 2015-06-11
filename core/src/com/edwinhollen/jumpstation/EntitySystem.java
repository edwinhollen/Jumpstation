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
    public List<Entity> entities = new ArrayList<Entity>();
    public List<ComponentSystem> systems = new ArrayList<ComponentSystem>();
    public Map<ComponentSystem, List<Entity>> sort(){
        Map<ComponentSystem, List<Entity>> returnMap = new HashMap<>();
        this.systems.forEach(system -> {
            returnMap.put(system, entities.stream().filter(entity -> system.accepts().parallelStream().allMatch(aClass -> entity.components.stream().anyMatch(aClass::isInstance))).collect(Collectors.toList()));
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
