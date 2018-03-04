

import java.awt.Color;


public final class Canvas extends Shape {

private Canvas() {

}

//singleton pattern
private static Canvas instance = null;


public static Canvas getInstance(final String line) {




if (instance == null) {
instance = new Canvas();
}

final int magicNum1 = 3;
final int magicNum2 = 4;
final int magicNum3 = 5;
final int magicNum4 = 6;
final int magicNum5 = 16;


String[] splits = line.split(" ");
instance.height = Integer.parseInt(splits[1]);
instance.width = Integer.parseInt(splits[2]);
StringBuffer rb = new StringBuffer("");
rb.append(splits[magicNum1].charAt(1));
rb.append(splits[magicNum1].charAt(2));
int r = Integer.parseInt(rb.toString(), magicNum5);

StringBuffer gb = new StringBuffer("");
gb.append(splits[magicNum1].charAt(magicNum1));
gb.append(splits[magicNum1].charAt(magicNum2));
int g = Integer.parseInt(gb.toString(), magicNum5);

StringBuffer bb = new StringBuffer("");
bb.append(splits[magicNum1].charAt(magicNum3));
bb.append(splits[magicNum1].charAt(magicNum4));
int b = Integer.parseInt(bb.toString(), magicNum5);

int a = Integer.parseInt(splits[magicNum2]);

instance.color = new Color(r, g, b, a);

return instance;

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
