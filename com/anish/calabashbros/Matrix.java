package com.anish.calabashbros;

public class Matrix <T extends Creature & Comparable<T>>{
    private T[][] matrix;
    public final int length,width;

    public Matrix(int length,int width,T[][] m){
        this.length=length;
        this.width=width;
        matrix=m;
    }

    public T get(int i,int j) {
        if ((i < 0) || (j<0) || i>width || j>length ) {
            return null;
        } 
        else {
            return matrix[i][j];
        }
    }
    
    public void set(int i,int j,T val){
        if ((i < 0) || (j<0) || i>width || j>length ) {
            return ;
        } 
        else {
            matrix[i][j]=val;
        }
    }

    public T getBroByRank(int rank) {
        for (int i = 0; i < length; i++)   
            for(int j=0;j< width;j++) {
                if (matrix[i][j].getRank() == rank) {
                return matrix[i][j];
            }
        } 
        return null;
    }
}
