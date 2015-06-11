package com.edwinhollen.jumpstation.components;

import com.edwinhollen.jumpstation.Component;

/**
 * Created by Edwin on 6/11/2015.
 */
public class ImageComponent implements Component {
    public String imageName;

    public ImageComponent(String imageName) {
        this.imageName = imageName;
    }
}
