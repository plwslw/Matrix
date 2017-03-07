import java.io.*;
import java.util.*;

public class Draw{

    public static void draw(EdgeMatrix E, Pixel p){
	int lines = E.length();
	draw(E, p, lines);
    }

    public static void draw(EdgeMatrix E, Pixel p, int lines){
	int N = (lines < E.length()) ? lines : E.length();
	for (int i=0;i<N;i+=2)
	    Canvas.line(E[0][i], E[0][i+1], E[1][i], E[1][i+1], p);
    }
    
    public static void main(String[] args){
	Canvas c = new Canvas(500, 500,0,0,0);
	double x, y;
	Pixel p = new Pixel(100, 100,200);
	EdgeMatrix E = new EdgeMatrix();
	
	//
	E.addEdge(0,100,0,100,0,0);
	E.addEdge(500,200,500,200);
	draw(E, p);
	//

	c.save("out.ppm");
    }

}
