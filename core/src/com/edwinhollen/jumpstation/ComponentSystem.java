package com.edwinhollen.jumpstation;

import java.util.List;

/**
 * Created by Edwin on 6/11/2015.
 */
public interface ComponentSystem extends RenderableEntities {
    List<Class<? extends Component>> accepts();
}
