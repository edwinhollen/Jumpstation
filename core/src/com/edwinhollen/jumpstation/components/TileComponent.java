package com.edwinhollen.jumpstation.components;

import com.edwinhollen.jumpstation.Component;

/**
 * Created by Edwin on 6/14/2015.
 */
public class TileComponent implements Component{
    public TileTypes type;
    public int row, col;

    public TileComponent(int row, int col, TileTypes type){
        this.row = row;
        this.col = col;
        this.type = type;
    }

    public TileComponent(int row, int col) {
        this(row, col, TileTypes.EMPTY);
    }



    public enum TileTypes{
        EMPTY,
        FLOOR
    }
}
