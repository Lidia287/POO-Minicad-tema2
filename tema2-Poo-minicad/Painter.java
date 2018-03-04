


import java.awt.Color;


import java.awt.image.BufferedImage;
import java.util.Queue;

import java.util.LinkedList;




public class Painter {


private BufferedImage image;


/**
 * This method is used to return the image.
 */
public BufferedImage getImage() {
return this.image;
}


/**
 * This method is used to check
 * if the pixel is in the image.

 */
public boolean checkLimits(final int x, final int y) {
if (y < image.getHeight() && x < image.getWidth() && y >= 0 && x >= 0) {
return true;
}
return false;
}


/**
 * This method is used to return the sign
 * of a substraction.
 */
public int sign(final int a, final int b) {

if (b - a > 0) {
return 1;
}
if (b - a == 0) {
return 0;
}
if (b - a < 0) {
return -1;
}

return 0;

}


/**
 * This method is used to color the shapes.
 */
public void floodfill(final int x, final int y, final Color target, final Color replacement) {


final int magicNum1 = 100;

final int magicNum8 = 8;
final int magicNum16 = 16;

final int magicNum2 = 0x00ff0000;
final int magicNum3 = 0x0000ff00;
final int magicNum4 = 0x000000ff;

if (checkLimits(x, y)) {
Color c1 = new Color(image.getRGB(x, y));
if (c1.equals(target)) {
return;
}
}

Queue<Integer> queueX = new LinkedList<Integer>();
Queue<Integer> queueY = new LinkedList<Integer>();

if (checkLimits(x, y)) {
image.setRGB(x, y, replacement.getRGB());
queueX.add(x);
queueY.add(y);

}


 while (!(queueX.isEmpty()) && !(queueY.isEmpty())) {

int xp = queueX.peek();
queueX.poll();
int yp = queueY.peek();
queueY.poll();

//west


if (checkLimits(xp - 1, yp)) {



int red = 0, green = 0, blue = 0, aa = magicNum1;


int clr = image.getRGB(xp - 1, yp);
  red   = (clr & magicNum2) >> magicNum16;
  green = (clr & magicNum3) >> magicNum8;
  blue  =  clr & magicNum4;



Color c2 = new Color(red, green, blue, aa);

if ((c2.getRGB() != target.getRGB()) && (c2.getRGB() != replacement.getRGB())) {
image.setRGB(xp - 1, yp, replacement.getRGB());
queueX.add(xp - 1);
queueY.add(yp);



}

}

//east


if (checkLimits(xp + 1, yp)) {

int red = 0, green = 0, blue = 0, aa = magicNum1;


int clr = image.getRGB(xp + 1, yp);
  red   = (clr & magicNum2) >> magicNum16;
  green = (clr & magicNum3) >> magicNum8;
  blue  =  clr & magicNum4;
Color c3 = new Color(red, green, blue, aa);


if ((c3.getRGB() != target.getRGB()) && (c3.getRGB() != replacement.getRGB())) {
image.setRGB(xp + 1, yp, replacement.getRGB());
queueX.add(xp + 1);
queueY.add(yp);

}

}

//north


if (checkLimits(xp, yp - 1)) {

int red = 0, green = 0, blue = 0, aa = magicNum1;


int clr = image.getRGB(xp, yp - 1);
  red   = (clr & magicNum2) >> magicNum16;
  green = (clr & magicNum3) >> magicNum8;
  blue  =  clr & magicNum4;
Color c4 = new Color(red, green, blue, aa);


if ((c4.getRGB() != target.getRGB()) && (c4.getRGB() != replacement.getRGB())) {
image.setRGB(xp, yp - 1, replacement.getRGB());
queueX.add(xp);
queueY.add(yp - 1);

}

}


//south

if (checkLimits(xp, yp + 1)) {

int red = 0, green = 0, blue = 0, aa = magicNum1;


int clr = image.getRGB(xp, yp + 1);
  red   = (clr & magicNum2) >> magicNum16;
  green = (clr & magicNum3) >> magicNum8;
  blue  =  clr & magicNum4;
Color c5 = new Color(red, green, blue, aa);


if ((c5.getRGB() != target.getRGB()) && (c5.getRGB() != replacement.getRGB())) {
image.setRGB(xp, yp + 1, replacement.getRGB());
queueX.add(xp);
queueY.add(yp + 1);

}

}

}


return;

}








/**
 * This method is used to draw the canvas.
 */
public void draw(final Canvas c) {

BufferedImage image2 = new BufferedImage(c.width, c.height, BufferedImage.TYPE_INT_ARGB);





for (int i = 0; i < image2.getWidth(); i++) {
for (int j = 0; j < image2.getHeight(); j++) {
image2.setRGB(i, j, c.color.getRGB());
}
}

this.image = image2;



}

/**
 * This method is used to draw the shape.
 */
public void draw(final Shape s) {

}


/**
 * This method is used to draw the circle.
 */
public void draw(final Circle s) {

final int magicNum2 = 2;
final int magicNum3 = 3;
final int magicNum4 = 4;
final int magicNum6 = 6;
final int magicNum10 = 10;


int xc = s.x;
int yc = s.y;
int r = s.r;
int x = 0, y = r;
int d = magicNum3 - magicNum2 * r;
while (y >= x) {

drawCircle(xc, yc, x, y, s.borderColor);
x++;


if (d > 0) {
y--;
d = d + magicNum4 * (x - y) + magicNum10;
} else {
d = d + magicNum4 * x + magicNum6;
}
drawCircle(xc, yc, x, y, s.borderColor);
}






floodfill(s.x, s.y, s.borderColor, s.insideColor);

}


/**
 * This method is used to draw the circle.
 */
private void drawCircle(final int xc, final int yc, final int x, final int y, final Color c) {

if (checkLimits(xc + x, yc + y)) {
image.setRGB(xc + x, yc + y, c.getRGB());
}
if (checkLimits(xc - x, yc + y)) {
image.setRGB(xc - x, yc + y, c.getRGB());
}
if (checkLimits(xc + x, yc - y)) {
image.setRGB(xc + x, yc - y, c.getRGB());
}
if (checkLimits(xc - x, yc - y)) {
image.setRGB(xc - x, yc - y, c.getRGB());
}
if (checkLimits(xc + y, yc + x)) {
image.setRGB(xc + y, yc + x, c.getRGB());
}
if (checkLimits(xc - y, yc + x)) {
image.setRGB(xc - y, yc + x, c.getRGB());
}
if (checkLimits(xc + y, yc - x)) {
image.setRGB(xc + y, yc - x, c.getRGB());
}
if (checkLimits(xc - y, yc - x)) {
image.setRGB(xc - y, yc - x, c.getRGB());
}
}

/**
 * This method is used to draw the line.
 */
public void draw(final Line l) {


int x = l.x1;
int y = l.y1;
int dx = Math.abs(l.x2 - l.x1);
int dy = Math.abs(l.y2 - l.y1);


int s1 = sign(l.x1, l.x2);
int s2 = sign(l.y1, l.y2);

boolean inter = false;
if (dy > dx) {
int d = dx;
dx = dy;
dy = d;
inter = true;
} else {
inter = false;
}

int error = 2 * dy - dx;
for (int i = 0; i <= dx; i++) {
if (checkLimits(x, y)) {
image.setRGB(x, y, l.insideColor.getRGB());
}
while (error > 0) {
if (inter) {
x = x + s1;
} else {
y = y + s2;
}
error = error - 2 * dx;

}
if (inter) {
y = y + s2;
} else {
x = x + s1;
}

error = error + 2 * dy;


}



}

/**
 * This method is used to draw the square.
 */
public void draw(final Square s) {

int x1 = s.x;
int y1 = s.y;

int x2 = s.x + s.d;
int y2 = s.y;

int x3 = s.x + s.d;
int y3 = s.y + s.d;

int x4 = s.x;
int y4 = s.y + s.d;

Line l1 = new Line();
l1.set(x1, y1, x2, y2, s.borderColor);
draw(l1);

Line l2 = new Line();
l2.set(x2, y2, x3, y3, s.borderColor);
draw(l2);

Line l3 = new Line();
l3.set(x3, y3, x4, y4, s.borderColor);
draw(l3);

Line l4 = new Line();
l4.set(x4, y4, x1, y1, s.borderColor);
draw(l4);

for (int i = s.x + 1; i < s.x + s.d; i++) {
for (int j = s.y + 1; j < s.y + s.d; j++) {
if (checkLimits(i, j)) {
image.setRGB(i, j, s.insideColor.getRGB());
}
}
}

}


/**
 * This method is used to draw the rectangle.
 */
public void draw(final Rectangle s) {

int x1 = s.x;
int y1 = s.y;

int x2 = s.x + s.l;
int y2 = s.y;

int x3 = s.x + s.l;
int y3 = s.y + s.h;

int x4 = s.x;
int y4 = s.y + s.h;

Line l1 = new Line();
l1.set(x1, y1, x2, y2, s.borderColor);
draw(l1);

Line l2 = new Line();
l2.set(x2, y2, x3, y3, s.borderColor);
draw(l2);

Line l3 = new Line();
l3.set(x3, y3, x4, y4, s.borderColor);
draw(l3);

Line l4 = new Line();
l4.set(x4, y4, x1, y1, s.borderColor);
draw(l4);

for (int i = s.x + 1; i < s.x + s.l; i++) {
for (int j = s.y + 1; j < s.y + s.h; j++) {
if (checkLimits(i, j)) {
image.setRGB(i, j, s.insideColor.getRGB());
}
}
}

}


/**
 * This method is used to draw the triangle.
 */
public void draw(final Triangle s) {

int x1 = s.x1;
int y1 = s.y1;

int x2 = s.x2;
int y2 = s.y2;

int x3 = s.x3;
int y3 = s.y3;



Line l1 = new Line();
l1.set(x1, y1, x2, y2, s.borderColor);
draw(l1);

Line l2 = new Line();
l2.set(x2, y2, x3, y3, s.borderColor);
draw(l2);

Line l3 = new Line();
l3.set(x3, y3, x1, y1, s.borderColor);
draw(l3);


final int magicNum3 = 3;

int x = (s.x1 + s.x2 + s.x3) / magicNum3;
int y = (s.y1 + s.y2 + s.y3) / magicNum3;



floodfill(x, y, s.borderColor, s.insideColor);





}

/**
 * This method is used to draw the diamond.
 */
public void draw(final Diamond s) {

final int magicNum2 = 2;

int l = s.dO / magicNum2;
int h = s.dV / magicNum2;

int x1 = s.x;
int y1 = s.y - h;

int x2 = s.x + l;
int y2 = s.y;

int x3 = s.x;
int y3 = s.y + h;

int x4 = s.x - l;
int y4 = s.y;

Line l1 = new Line();
l1.set(x1, y1, x2, y2, s.borderColor);
draw(l1);

Line l2 = new Line();
l2.set(x2, y2, x3, y3, s.borderColor);
draw(l2);

Line l3 = new Line();
l3.set(x3, y3, x4, y4, s.borderColor);
draw(l3);

Line l4 = new Line();
l4.set(x1, y1, x4, y4, s.borderColor);
draw(l4);




floodfill(s.x, s.y, s.borderColor, s.insideColor);

}


/**
 * This method is used to draw the polygon.
 */
public void draw(final Polygon s) {

int x = 0;
int y = 0;

for (int i = 0; i < s.n - 1; i++) {
int xs = s.xP[i];
int ys = s.yP[i];

int xf = s.xP[i + 1];
int yf = s.yP[i + 1];

Line l = new Line();
l.set(xs, ys, xf, yf, s.borderColor);
draw(l);

}

int xn = s.xP[s.n - 1];
int yn = s.yP[s.n - 1];

int x1 = s.xP[0];
int y1 = s.yP[0];

Line l = new Line();
l.set(xn, yn, x1, y1, s.borderColor);
draw(l);


for (int i = 0; i < s.n; i++) {

x = x + s.xP[i];
y = y + s.yP[i];

}

x = x / (s.n);
y = y / (s.n);



floodfill(x, y, s.borderColor, s.insideColor);
}




}
