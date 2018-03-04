

public final class ShapeFactory {

public static final ShapeFactory INSTANCE = new ShapeFactory();

private ShapeFactory() {

}

public static Shape getShape(final String shapeType, final String l) {
if (shapeType == null) {
return null;
}
if (shapeType.equalsIgnoreCase("CIRCLE")) {
return new Circle(l);

  } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
 return new Rectangle(l);

  } else if (shapeType.equalsIgnoreCase("SQUARE")) {
 return new Square(l);
  } else if (shapeType.equalsIgnoreCase("CANVAS")) {
   return Canvas.getInstance(l);
} else if (shapeType.equalsIgnoreCase("LINE")) {
return new Line(l);
 } else if (shapeType.equalsIgnoreCase("TRIANGLE")) {
 return new Triangle(l);
  } else if (shapeType.equalsIgnoreCase("DIAMOND")) {
  return new Diamond(l);
   } else if (shapeType.equalsIgnoreCase("POLYGON")) {
   return new Polygon(l);
   }

  return null;
   }
}
