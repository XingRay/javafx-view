package com.xingray.javafx.view;

import com.xingray.java.view.Canvas;
import com.xingray.java.view.View;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.Region;

public class FxView extends Region implements View {

    private final FxCanvas fxCanvas = new FxCanvas();

    private Runnable invalidateTask;
    private boolean invalidated;

    double locateX;
    double locateY;
    double width;
    double height;

    public FxView() {
        super();
        Node node = fxCanvas.getCanvas();
        getChildren().add(node);
        node.relocate(locateX, locateY);
    }

    @Override
    public void invalidate() {
        if (invalidated) {
            return;
        }
        invalidated = true;
        if (invalidateTask == null) {
            invalidateTask = new Runnable() {
                @Override
                public void run() {
                    draw();
                }
            };
        }
        Platform.runLater(invalidateTask);
    }


    @Override
    public void resizeRelocate(double x, double y, double width, double height) {
        super.resizeRelocate(x, y, width, height);
        if (locateX == x && locateY == y && this.width == width && this.height == height) {
            return;
        }
        locateX = x;
        locateY = y;
        this.width = width;
        this.height = height;
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        // do nothing
    }

    private void draw() {
        fxCanvas.clear();
        fxCanvas.setWidth(getWidth());
        fxCanvas.setHeight(getHeight());
        onDraw(fxCanvas);
        invalidated = false;
    }

//    @Override
//    public Node getStyleableNode() {
//        System.out.println("getStyleableNode");
//        return null;
//    }
//
//    @Override
//    public boolean hasProperties() {
//        System.out.println("hasProperties");
//        return super.hasProperties();
//    }
//
//    @Override
//    public void setUserData(Object value) {
//        System.out.println("setUserData");
//        super.setUserData(value);
//    }
//
//    @Override
//    public Object getUserData() {
//        System.out.println("getUserData");
//        return super.getUserData();
//    }
//
//    @Override
//    public Node lookup(String selector) {
//        System.out.println("lookup");
//        return super.lookup(selector);
//    }
//
//    @Override
//    public Set<Node> lookupAll(String selector) {
//        System.out.println("lookupAll");
//        return super.lookupAll(selector);
//    }
//
//    @Override
//    public void toBack() {
//        System.out.println("toBack");
//        super.toBack();
//    }
//
//    @Override
//    public void toFront() {
//        System.out.println("toFront");
//        super.toFront();
//    }
//
//    @Override
//    public WritableImage snapshot(SnapshotParameters params, WritableImage image) {
//        System.out.println("snapshot");
//        return super.snapshot(params, image);
//    }
//
//    @Override
//    public void snapshot(Callback<SnapshotResult, Void> callback, SnapshotParameters params, WritableImage image) {
//        System.out.println("snapshot");
//        super.snapshot(callback, params, image);
//    }
//
//    @Override
//    public Dragboard startDragAndDrop(TransferMode... transferModes) {
//        System.out.println("startDragAndDrop");
//        return super.startDragAndDrop(transferModes);
//    }
//
//    @Override
//    public void startFullDrag() {
//        System.out.println("startFullDrag");
//        super.startFullDrag();
//    }
//
//    @Override
//    public void relocate(double x, double y) {
//        System.out.println("relocate" + "w:" + getWidth() + " h:" + getHeight());
//        super.relocate(x, y);
//    }
//
//    @Override
//    public boolean isResizable() {
//        System.out.println("isResizable");
//        return super.isResizable();
//    }
//
//    @Override
//    public Orientation getContentBias() {
//        System.out.println("getContentBias");
//        return super.getContentBias();
//    }
//
//    @Override
//    public void resize(double width, double height) {
//        System.out.println("resize" + "w:" + getWidth() + " h:" + getHeight());
//        super.resize(width, height);
//    }
//
//    @Override
//    public double getBaselineOffset() {
//        System.out.println("getBaselineOffset");
//        return super.getBaselineOffset();
//    }
//
//    @Override
//    public double computeAreaInScreen() {
//        System.out.println("computeAreaInScreen");
//        return super.computeAreaInScreen();
//    }
//
//    @Override
//    public boolean contains(double localX, double localY) {
//        System.out.println("contains");
//        return super.contains(localX, localY);
//    }
//
//    @Override
//    public boolean contains(Point2D localPoint) {
//        System.out.println("contains");
//        return super.contains(localPoint);
//    }
//
//    @Override
//    public boolean intersects(double localX, double localY, double localWidth, double localHeight) {
//        System.out.println("intersects");
//        return super.intersects(localX, localY, localWidth, localHeight);
//    }
//
//    @Override
//    public boolean intersects(Bounds localBounds) {
//        System.out.println("intersects");
//        return super.intersects(localBounds);
//    }
//
//    @Override
//    public Point2D screenToLocal(double screenX, double screenY) {
//        System.out.println("screenToLocal");
//        return super.screenToLocal(screenX, screenY);
//    }
//
//    @Override
//    public Point2D screenToLocal(Point2D screenPoint) {
//        System.out.println("screenToLocal");
//        return super.screenToLocal(screenPoint);
//    }
//
//    @Override
//    public Bounds screenToLocal(Bounds screenBounds) {
//        System.out.println("screenToLocal");
//        return super.screenToLocal(screenBounds);
//    }
//
//    @Override
//    public Point2D sceneToLocal(double x, double y, boolean rootScene) {
//        System.out.println("sceneToLocal");
//        return super.sceneToLocal(x, y, rootScene);
//    }
//
//    @Override
//    public Point2D sceneToLocal(Point2D point, boolean rootScene) {
//        System.out.println("sceneToLocal");
//        return super.sceneToLocal(point, rootScene);
//    }
//
//    @Override
//    public Bounds sceneToLocal(Bounds bounds, boolean rootScene) {
//        System.out.println("sceneToLocal");
//        return super.sceneToLocal(bounds, rootScene);
//    }
//
//    @Override
//    public Point2D sceneToLocal(double sceneX, double sceneY) {
//        System.out.println("sceneToLocal");
//        return super.sceneToLocal(sceneX, sceneY);
//    }
//
//    @Override
//    public Point2D sceneToLocal(Point2D scenePoint) {
//        System.out.println("sceneToLocal");
//        return super.sceneToLocal(scenePoint);
//    }
//
//    @Override
//    public Point3D sceneToLocal(Point3D scenePoint) {
//        System.out.println("sceneToLocal");
//        return super.sceneToLocal(scenePoint);
//    }
//
//    @Override
//    public Point3D sceneToLocal(double sceneX, double sceneY, double sceneZ) {
//        System.out.println("sceneToLocal");
//        return super.sceneToLocal(sceneX, sceneY, sceneZ);
//    }
//
//    @Override
//    public Bounds sceneToLocal(Bounds sceneBounds) {
//        System.out.println("sceneToLocal");
//        return super.sceneToLocal(sceneBounds);
//    }
//
//    @Override
//    public Point2D localToScreen(double localX, double localY) {
//        System.out.println("localToScreen");
//        return super.localToScreen(localX, localY);
//    }
//
//    @Override
//    public Point2D localToScreen(Point2D localPoint) {
//        System.out.println("localToScreen");
//        return super.localToScreen(localPoint);
//    }
//
//    @Override
//    public Point2D localToScreen(double localX, double localY, double localZ) {
//        System.out.println("localToScreen");
//        return super.localToScreen(localX, localY, localZ);
//    }
//
//    @Override
//    public Point2D localToScreen(Point3D localPoint) {
//        System.out.println("localToScreen");
//        return super.localToScreen(localPoint);
//    }
//
//    @Override
//    public Bounds localToScreen(Bounds localBounds) {
//        System.out.println("localToScreen");
//        return super.localToScreen(localBounds);
//    }
//
//    @Override
//    public Point2D localToScene(double localX, double localY) {
//        System.out.println("localToScene");
//        return super.localToScene(localX, localY);
//    }
//
//    @Override
//    public Point2D localToScene(Point2D localPoint) {
//        System.out.println("localToScene");
//        return super.localToScene(localPoint);
//    }
//
//    @Override
//    public Point3D localToScene(Point3D localPoint) {
//        System.out.println("localToScene");
//        return super.localToScene(localPoint);
//    }
//
//    @Override
//    public Point3D localToScene(double x, double y, double z) {
//        System.out.println("localToScene");
//        return super.localToScene(x, y, z);
//    }
//
//    @Override
//    public Point3D localToScene(Point3D localPoint, boolean rootScene) {
//        System.out.println("localToScene");
//        return super.localToScene(localPoint, rootScene);
//    }
//
//    @Override
//    public Point3D localToScene(double x, double y, double z, boolean rootScene) {
//        System.out.println("localToScene");
//        return super.localToScene(x, y, z, rootScene);
//    }
//
//    @Override
//    public Point2D localToScene(Point2D localPoint, boolean rootScene) {
//        System.out.println("localToScene");
//        return super.localToScene(localPoint, rootScene);
//    }
//
//    @Override
//    public Point2D localToScene(double x, double y, boolean rootScene) {
//        System.out.println("localToScene");
//        return super.localToScene(x, y, rootScene);
//    }
//
//    @Override
//    public Bounds localToScene(Bounds localBounds, boolean rootScene) {
//        System.out.println("localToScene");
//        return super.localToScene(localBounds, rootScene);
//    }
//
//    @Override
//    public Bounds localToScene(Bounds localBounds) {
//        System.out.println("localToScene");
//        return super.localToScene(localBounds);
//    }
//
//    @Override
//    public Point2D parentToLocal(double parentX, double parentY) {
//        System.out.println("parentToLocal");
//        return super.parentToLocal(parentX, parentY);
//    }
//
//    @Override
//    public Point2D parentToLocal(Point2D parentPoint) {
//        System.out.println("parentToLocal");
//        return super.parentToLocal(parentPoint);
//    }
//
//    @Override
//    public Point3D parentToLocal(Point3D parentPoint) {
//        System.out.println("parentToLocal");
//        return super.parentToLocal(parentPoint);
//    }
//
//    @Override
//    public Point3D parentToLocal(double parentX, double parentY, double parentZ) {
//        System.out.println("parentToLocal");
//        return super.parentToLocal(parentX, parentY, parentZ);
//    }
//
//    @Override
//    public Bounds parentToLocal(Bounds parentBounds) {
//        System.out.println("parentToLocal");
//        return super.parentToLocal(parentBounds);
//    }
//
//    @Override
//    public Point2D localToParent(double localX, double localY) {
//        System.out.println("localToParent");
//        return super.localToParent(localX, localY);
//    }
//
//    @Override
//    public Point2D localToParent(Point2D localPoint) {
//        System.out.println("localToParent");
//        return super.localToParent(localPoint);
//    }
//
//    @Override
//    public Point3D localToParent(Point3D localPoint) {
//        System.out.println("localToParent");
//        return super.localToParent(localPoint);
//    }
//
//    @Override
//    public Point3D localToParent(double x, double y, double z) {
//        System.out.println("localToParent");
//        return super.localToParent(x, y, z);
//    }
//
//    @Override
//    public Bounds localToParent(Bounds localBounds) {
//        System.out.println("localToParent");
//        return super.localToParent(localBounds);
//    }
//
//    @Override
//    public boolean usesMirroring() {
//        System.out.println("usesMirroring");
//        return super.usesMirroring();
//    }
//
//    @Override
//    public void requestFocus() {
//        System.out.println("requestFocus");
//        super.requestFocus();
//    }
//
//    @Override
//    public EventDispatchChain buildEventDispatchChain(EventDispatchChain tail) {
//        System.out.println("buildEventDispatchChain");
//        return super.buildEventDispatchChain(tail);
//    }
//
//    @Override
//    public String getTypeSelector() {
//        System.out.println("getTypeSelector");
//        return super.getTypeSelector();
//    }
//
//    @Override
//    public Styleable getStyleableParent() {
//        System.out.println("getStyleableParent");
//        return super.getStyleableParent();
//    }
//
//    @Override
//    protected Boolean getInitialFocusTraversable() {
//        System.out.println("getInitialFocusTraversable");
//        return super.getInitialFocusTraversable();
//    }
//
//    @Override
//    protected Cursor getInitialCursor() {
//        System.out.println("getInitialCursor");
//        return super.getInitialCursor();
//    }
//
//    @Override
//    public List<CssMetaData<? extends Styleable, ?>> getCssMetaData() {
//        System.out.println("getCssMetaData");
//        return super.getCssMetaData();
//    }
//
//    @Override
//    public Object queryAccessibleAttribute(AccessibleAttribute attribute, Object... parameters) {
//        System.out.println("queryAccessibleAttribute");
//        return super.queryAccessibleAttribute(attribute, parameters);
//    }
//
//    @Override
//    public void executeAccessibleAction(AccessibleAction action, Object... parameters) {
//        System.out.println("executeAccessibleAction");
//        super.executeAccessibleAction(action, parameters);
//    }
//
//    @Override
//    protected ObservableList<Node> getChildren() {
//        System.out.println("getChildren");
//        return super.getChildren();
//    }
//
//    @Override
//    public ObservableList<Node> getChildrenUnmodifiable() {
//        System.out.println("getChildrenUnmodifiable");
//        return super.getChildrenUnmodifiable();
//    }
//
//    @Override
//    protected <E extends Node> List<E> getManagedChildren() {
//        System.out.println("getManagedChildren");
//        return super.getManagedChildren();
//    }
//
//    @Override
//    public void requestLayout() {
//        System.out.println("requestLayout");
//        super.requestLayout();
//    }
//
//    @Override
//    protected double computePrefWidth(double height) {
//        System.out.println("computePrefWidth");
//        return super.computePrefWidth(height);
//    }
//
//    @Override
//    protected double computePrefHeight(double width) {
//        System.out.println("computePrefHeight");
//        return super.computePrefHeight(width);
//    }
//
//    @Override
//    protected double computeMinWidth(double height) {
//        System.out.println("computeMinWidth");
//        return super.computeMinWidth(height);
//    }
//
//    @Override
//    protected double computeMinHeight(double width) {
//        System.out.println("computeMinHeight");
//        return super.computeMinHeight(width);
//    }
//
//    @Override
//    protected void layoutChildren() {
//        System.out.println("layoutChildren");
//        super.layoutChildren();
//    }
//
//    @Override
//    protected void updateBounds() {
//        System.out.println("updateBounds");
//        super.updateBounds();
//    }
}
