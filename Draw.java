import java.io.*;
import java.util.*;

public class Draw{

    public static void addEdge(Matrix E, int x1, int x2, int y1, int y2, int z1, int z2){
	int [] coords1 = new int [4];
	int [] coords2=new int [4];

	coords1[0] =x1;
	coords1[1]=y1;
	coords1[2]=z1;
	coords1[3]=1;

	coords2[0] =x2;
	coords2[1]=y2;
	coords2[2]=z2;
	coords2[3]=1;

	E.addColumn(coords1);
	E.addColumn(coords2);
    }

    public static void draw(Matrix E, Pixel p){
	for (int i=0;i<E[0].length;i+=2)
	    Canvas.line(E[0][i], E[0][i+1], E[1][i], E[1][i+1], p);
    }
    
    public static void main(String[] args){
	Canvas c = new Canvas(500, 500,0,0,0);
	double x, y;
	Pixel p = new Pixel(100, 100,200);
	boolean odd = false;

	int[][] E= {{},{},{},{}};
	//
	addEdge(0,100,0,100,0,0);
	addEdge(500,200,500,200);
	draw(E, p);
	//

	c.save("out.ppm");
    }

}
