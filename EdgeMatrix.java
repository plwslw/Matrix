import java.io.*;
import java.util.*;

public class EdgeMatrix extends Matrix{

    public EdgeMatrix(){
	super();
    }

    public EdgeMatrix(double[][] x){
	super(x);
    }	
    
    public void addEdge(double x1, double x2, double y1, double y2, double z1, double z2){
	double [] P1={x1, y1, z1, 1};
	double [] P2={x2, y2, z2, 1};
	addColumn(P1);
	addColumn(P2);
    }

    public static void main(String[] args){
	System.out.println("4x4 Identity:");
	EdgeMatrix A = identity();
	System.out.print(A);

	double [][]B1 = {{1,2,3,4},{6,5,3,5},{-1,14,-6,3},{0,9,-3,4}}; //4x4
	double [][]E1 = {{5,6},{7,8},{9,8},{1,1}};

	EdgeMatrix B = new EdgeMatrix(B1);
	EdgeMatrix E = new EdgeMatrix(E1);
		
	System.out.println("\nMatrix E:\n" + E);
	E.scalarMultiply(2);
	System.out.println("\nTesting scalar Multiplication: 2xE\n" + E);

	System.out.println("B:" +B);
	System.out.println("\nTesting Matrix Multiplication: BxE");
	E.matrixMultiply(B);
	System.out.println(E);
	
	//System.out.println("\nMatrix E:\n");

    }
}
