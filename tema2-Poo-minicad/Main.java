




import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;




public final class Main {


private Main() {

}

public static void main(final String[] args) {





int n;
Shape[] shapes;

try {
BufferedReader br = new BufferedReader(new FileReader(args[0]));
String line;
n = Integer.parseInt(br.readLine());

//an array of shapes
shapes = new Shape[n];


for (int i = 0; i < n; i++) {

line = br.readLine();
 String[] splits = line.split(" ");
 shapes[i] = ShapeFactory.INSTANCE.getShape(splits[0], line);
}


br.close();

} catch (IOException e) {
throw new RuntimeException(e);
}



//for each shape , i use visitor pattern to do the action
Painter pt = new Painter();
for (Shape s: shapes) {
s.accept(pt);
}




String to = "drawing.png";
try {
ImageIO.write(pt.getImage(), "png", new File(to));
} catch (IOException o) {

}

   }
}
