package com.xingray.javafx.view;

import com.xingray.java.view.Canvas;
import com.xingray.java.view.Color;
import com.xingray.java.view.Paint;
import javafx.scene.canvas.GraphicsContext;

public class FxCanvas implements Canvas {

    private final Paint paint;
    private final javafx.scene.canvas.Canvas canvas;
    private final GraphicsContext gc;

    public FxCanvas() {
        paint = new Paint();
        canvas = new javafx.scene.canvas.Canvas();
        gc = canvas.getGraphicsContext2D();
    }

    public javafx.scene.canvas.Canvas getCanvas() {
        return canvas;
    }

    @Override
    public void setWidth(double width) {
        canvas.setWidth(width);
    }

    @Override
    public void setHeight(double height) {
        canvas.setHeight(height);
    }

    @Override
    public void clear() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @Override
    public void clearRect(double x, double y, double w, double h) {
        gc.clearRect(x, y, w, h);
    }

    @Override
    public Paint getPaint() {
        return paint;
    }

    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        Color color = paint.getDrawColor();
        gc.setStroke(javafx.scene.paint.Color.rgb(color.getRed(), color.getGreen(), color.getBlue(), color.getOpacity()));
        gc.strokeLine(x1, y1, x2, y2);
    }

    @Override
    public void drawText(String text, double x, double y) {
        gc.setStroke(FxColor.fromColor(paint.getTextColor()));
        gc.strokeText(text, x, y);
    }

    @Override
    public void drawRect(double x, double y, double w, double h) {
        gc.setStroke(FxColor.fromColor(paint.getDrawColor()));
        gc.strokeRect(x, y, w, h);
    }

    @Override
    public void fillRect(double x, double y, double w, double h) {
        gc.setFill(FxColor.fromColor(paint.getFillColor()));
        gc.fillRect(x, y, w, h);
    }

    @Override
    public void drawPolyline(double[] xPoints, double[] yPoints, int pointCount) {
        gc.setStroke(FxColor.fromColor(paint.getDrawColor()));
        gc.strokePolyline(xPoints, yPoints, pointCount);
    }
}
