package com.edwinhollen.jumpstation.components;

import com.edwinhollen.jumpstation.Component;

/**
 * Created by Edwin on 6/11/2015.
 */
public class PositionComponent implements Component {
    public int x = 0, y = 0;

    public PositionComponent(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
