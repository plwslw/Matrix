import java.io.*;
import java.util.*;

public class Matrix{

    public int[][] A;

    public Matrix(int x, int y){
	A = new int[x][y];
    }

    public Matrix(int x){
	this(4,x);
    }

    public Matrix(){
	this(4,1);
    }

    public Matrix(int [][] x){
	A = x;
    }
    
    public void scalarMultiply(int k){
	for (int i=0;i<A.length;i++)
	    for (int j=0;j<A.length;j++)
		A[i][j]*=k;
    }
    
    public static Matrix identity(int n){
	int [][]A = new int [n][n];
	for (int i=0;i<n;i++)
	    for (int j=0;j<n;j++){
		if (i==j) A[i][j] = 1;
		else A[i][j] = 0;
	    }
	Matrix ret = new Matrix(A);
	return ret;
    }

    //Multiplies by B on the left
    //Updates A with result
    public int[][] matrixMultiply(Matrix B){
	int m=B.A.length;
	int n=A[0].length;
	int r=A.length;
	
	int C[][] = new int [m][n];//Initialized with zeros

	for (int i=0;i<m;i++)
	    for (int j=0;j<n;j++)
		for (int k=0;k<r;k++)
		    C[i][j]+=B.A[i][k]*A[k][j];

	A=C;
	return A;//To do right multiplication, can call B.matrixMultiply(A)
    }

    public void addColumn(int [] x){
	for (int i=0;i<A.length;i++){
	    int [] B = A[i];
	    A[i] = new int[A[i].length + 1];
	    for (int j=0;j<A[i].length -1;j++)
		A[i][j] = B[j];
	    A[i][A[i].length-1] = x[i];
	}

    public String toString(){
	String s = "";
	for (int i=0;i<A.length;i++){
	    s+="\t";
	    for (int j=0;j<A[i].length;j++){
		s+=(A[i][j]+"   ");
	    }
	    s+="\n";
	}
	return s;
    }

    public static void main(String[] args){
	System.out.println("4x4 Identity:");
	Matrix A = identity(4);
	System.out.print(A);

	int [][]B1 = {{1,2,3,4},{6,5,3,5},{-1,14,-6,3},{0,9,-3,4}}; //4x4
	int [][]E1 = {{5,6},{7,8},{9,8},{1,1}};

	Matrix B = new Matrix(B1);
	Matrix E = new Matrix(E1);
		
	System.out.println("\nMatrix B:\n" + B);
	B.scalarMultiply(2);
	System.out.println("\nTesting scalar Multiplication: 2xB\n" + B);

	System.out.println("\nTesting Matrix Multiplication:");
	Matrix m1=new Matrix(2,1);
	Matrix m2=new Matrix(1,2);
	int [][] m1A={{1},{1}};
	m1.A=m1A;
	int [][] m2A={{2,2}};
	m2.A=m2A;
	m2.matrixMultiply(m1);
	System.out.println(m1);
	
	//System.out.println("\nMatrix E:\n");

    }
}
