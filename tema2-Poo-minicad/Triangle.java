

import java.awt.Color;

public class Triangle extends Shape {

public Triangle(final String line) {
super(line);

final int magicNum1 = 1;
final int magicNum2 = 2;
final int magicNum3 = 3;
final int magicNum4 = 4;
final int magicNum5 = 5;
final int magicNum6 = 6;
final int magicNum7 = 7;
final int magicNum8 = 8;
final int magicNum9 = 9;
final int magicNum10 = 10;
final int magicNum16 = 16;

String[] splits = line.split(" ");
this.x1 = Integer.parseInt(splits[1]);
this.y1 = Integer.parseInt(splits[2]);

this.x2 = Integer.parseInt(splits[magicNum3]);
this.y2 = Integer.parseInt(splits[magicNum4]);

this.x3 = Integer.parseInt(splits[magicNum5]);
this.y3 = Integer.parseInt(splits[magicNum6]);

StringBuffer rb = new StringBuffer("");
rb.append(splits[magicNum7].charAt(1));
rb.append(splits[magicNum7].charAt(2));
int r = Integer.parseInt(rb.toString(), magicNum16);

StringBuffer gb = new StringBuffer("");
gb.append(splits[magicNum7].charAt(magicNum3));
gb.append(splits[magicNum7].charAt(magicNum4));
int g = Integer.parseInt(gb.toString(), magicNum16);

StringBuffer bb = new StringBuffer("");
bb.append(splits[magicNum7].charAt(magicNum5));
bb.append(splits[magicNum7].charAt(magicNum6));
int b = Integer.parseInt(bb.toString(), magicNum16);

int a = Integer.parseInt(splits[magicNum8]);

this.borderColor = new Color(r, g, b, a);



StringBuffer rb2 = new StringBuffer("");
rb2.append(splits[magicNum9].charAt(1));
rb2.append(splits[magicNum9].charAt(2));
int r2 = Integer.parseInt(rb2.toString(), magicNum16);

StringBuffer gb2 = new StringBuffer("");
gb2.append(splits[magicNum9].charAt(magicNum3));
gb2.append(splits[magicNum9].charAt(magicNum4));
int g2 = Integer.parseInt(gb2.toString(), magicNum16);

StringBuffer bb2 = new StringBuffer("");
bb2.append(splits[magicNum9].charAt(magicNum5));
bb2.append(splits[magicNum9].charAt(magicNum6));
int b2 = Integer.parseInt(bb2.toString(), magicNum16);

int a2 = Integer.parseInt(splits[magicNum10]);

this.insideColor = new Color(r2, g2, b2, a2);


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

