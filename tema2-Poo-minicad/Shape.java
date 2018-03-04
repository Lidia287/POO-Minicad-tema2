

import java.awt.Color;

public class Shape {

protected String line;

public final void setLine(final String line) {
this.line = line;
}

public final String getLine() {
return this.line;
}


protected int height;

public final void setHeight(final int height) {
this.height = height;
}

public final int getHeight() {
return this.height;
}

protected int width;

public final void setWidth(final int width) {
this.width = width;
}

public final int getWidth() {
return this.width;
}

protected Color color;

protected int x1;

public final void setX1(final int x1) {
this.x1 = x1;
}

public final int getX1() {
return this.x1;
}


protected int y1;

public final void setY1(final int y1) {
this.y1 = y1;
}

public final int getY1() {
return this.y1;
}

protected int x2;

public final void setX2(final int x2) {
this.x2 = x2;
}

public final int getX2() {
return this.x2;
}

protected int y2;


public final void setY2(final int y2) {
this.y2 = y2;
}

public final int getY2() {
return this.y2;
}

protected int x3;

public final void setX3(final int x3) {
this.x3 = x3;
}

public final int getX3() {
return this.x3;
}

protected int y3;


public final void setY3(final int y3) {
this.y3 = y3;
}

public final int getY3() {
return this.y3;
}


protected int x;

public final void setX(final int x) {
this.x = x;
}

public final int getX() {
return this.x;
}

protected int y;

public final void setY(final int y) {
this.y = y;
}

public final int getY() {
return this.y;
}

protected int r;

protected int d;

protected int dO;
protected int dV;

protected int h;
protected int l;

protected Color insideColor;
protected Color borderColor;

protected int n;
protected int[] xP;
protected int[] yP;


public Shape() {

}

public Shape(final String line) {
this.line = line;
}


/**
 * This mehod is based on double dispatch
 * it creates a relationship between the shape and the
 * painter.
 * *@param pt represents the painter
 */
public void accept(final Painter pt) {
pt.draw(this);
}
}
