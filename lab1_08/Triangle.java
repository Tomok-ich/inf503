public class Triangle{
	Point a;
	Point b;
	Point c;

	double sideLength(Point p1, Point p2){
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
	}

	boolean isEquilateral(){
		double l1 = sideLength(a, b);
		double l2 = sideLength(a, c);
		double l3 = sideLength(c, b);

		return isEquals(l1, l2) && isEquals(l2, l3);
	}

	boolean isEquals(double a, double b){
		return Math.abs(a - b) < 0.0000001;
	}

	public String toString(){
		return "[" + a.x + "; " + a.y + "] - [" + b.x + "; " + b.y + "] - [" + c.x + "; " + c.y + "]";
	}
}