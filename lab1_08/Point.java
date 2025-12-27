/*

	Класс описывающий точку на плоскости

	атрибуты (свойства, члены класса)

	поведение - методы

*/

public class Point{
	double x;
	double y;

	double distanceTo0(){
		return Math.sqrt(x * x + y * y);
	}
	void move(double deltaX, double deltaY){
		x += deltaX;
		y += deltaY;
	}
}