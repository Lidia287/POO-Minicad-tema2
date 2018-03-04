

import java.awt.Color;





public class Line extends Shape {


public Line() {

}


/**
 * This mehod sets the components of the line.
 * it is used for the orther forms
 * square, rectangle, diamond
*/
public void set(final int x1, final int y1, final int x2, final int y2, final Color insideColor) {
this.x1 = x1;
this.y1 = y1;
this.x2 = x2;
this.y2 = y2;
this.insideColor = insideColor;
}


public Line(final String line) {
super(line);

final int magicNum1 = 1;
final int magicNum2 = 2;
final int magicNum3 = 3;
final int magicNum4 = 4;
final int magicNum5 = 5;
final int magicNum6 = 6;
final int magicNum7 = 7;
final int magicNum8 = 8;
final int magicNum16 = 16;

String[] splits = line.split(" ");
this.x1 = Integer.parseInt(splits[1]);
this.y1 = Integer.parseInt(splits[2]);

this.x2 = Integer.parseInt(splits[magicNum3]);
this.y2 = Integer.parseInt(splits[magicNum4]);

StringBuffer rb = new StringBuffer("");
rb.append(splits[magicNum5].charAt(1));
rb.append(splits[magicNum5].charAt(2));
int r = Integer.parseInt(rb.toString(), magicNum16);

StringBuffer gb = new StringBuffer("");
gb.append(splits[magicNum5].charAt(magicNum3));
gb.append(splits[magicNum5].charAt(magicNum4));
int g = Integer.parseInt(gb.toString(), magicNum16);

StringBuffer bb = new StringBuffer("");
bb.append(splits[magicNum5].charAt(magicNum5));
bb.append(splits[magicNum5].charAt(magicNum6));
int b = Integer.parseInt(bb.toString(), magicNum16);

int a = Integer.parseInt(splits[magicNum6]);

insideColor = new Color(r, g, b, a);

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

