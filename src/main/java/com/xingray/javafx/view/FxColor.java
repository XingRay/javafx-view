package com.xingray.javafx.view;


import com.xingray.java.view.Color;

public class FxColor {
    public static Color toColor(javafx.scene.paint.Color color) {
        return Color.rgb(color.getOpacity(), (int) (color.getRed() * 0xff), (int) (color.getGreen() * 0xff), (int) (color.getBlue() * 0xff));
    }

    public static javafx.scene.paint.Color fromColor(Color color) {
        return javafx.scene.paint.Color.rgb(color.getRed(), color.getGreen(), color.getBlue(), color.getOpacity());
    }
}
