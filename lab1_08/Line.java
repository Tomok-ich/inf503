public class Line{
	Point start;
	Point end;

	void move(double deltaX, double deltaY){
		start.move(deltaX, deltaY);
		end.move(deltaX, deltaY);
	}
	// специальное название метода для автоматического преобразования обьекта в строку
	public String toString(){
		return "[" + start.x + "; " + start.y + "] - [" + end.x + "; " + end.y + "]";
	}
}