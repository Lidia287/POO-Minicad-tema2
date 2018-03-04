

import java.awt.Color;

public class Polygon extends Shape {

public Polygon(final String line) {
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

this.n = Integer.parseInt(splits[1]);
this.xP = new int[n];
this.yP = new int[n];

int i = 2;
int j = magicNum3;
int k;

for (k = 0; k < this.n; k++) {

this.xP[k] = Integer.parseInt(splits[i]);
this.yP[k] = Integer.parseInt(splits[j]);

i = i + 2;
j = j + 2;
}

j = j - 2;
j = j + 1;

StringBuffer rb = new StringBuffer("");
rb.append(splits[j].charAt(1));
rb.append(splits[j].charAt(2));
int r = Integer.parseInt(rb.toString(), magicNum16);

StringBuffer gb = new StringBuffer("");
gb.append(splits[j].charAt(magicNum3));
gb.append(splits[j].charAt(magicNum4));
int g = Integer.parseInt(gb.toString(), magicNum16);

StringBuffer bb = new StringBuffer("");
bb.append(splits[j].charAt(magicNum5));
bb.append(splits[j].charAt(magicNum6));
int b = Integer.parseInt(bb.toString(), magicNum16);

int a = Integer.parseInt(splits[j + 1]);

this.borderColor = new Color(r, g, b, a);



StringBuffer rb2 = new StringBuffer("");
rb2.append(splits[j + 2].charAt(1));
rb2.append(splits[j + 2].charAt(2));
int r2 = Integer.parseInt(rb2.toString(), magicNum16);

StringBuffer gb2 = new StringBuffer("");
gb2.append(splits[j + 2].charAt(magicNum3));
gb2.append(splits[j + 2].charAt(magicNum4));
int g2 = Integer.parseInt(gb2.toString(), magicNum16);

StringBuffer bb2 = new StringBuffer("");
bb2.append(splits[j + 2].charAt(magicNum5));
bb2.append(splits[j + 2].charAt(magicNum6));
int b2 = Integer.parseInt(bb2.toString(), magicNum16);

int a2 = Integer.parseInt(splits[j + magicNum3]);

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

