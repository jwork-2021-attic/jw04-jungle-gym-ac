package com.anish.calabashbros;

public class SelectSorter<T extends Creature&Comparable<T>> implements Sorter<T> {

    private Matrix<T> a;

    @Override
    public void load(Matrix<T> a) {
        this.a = a;
    }

    private void swap(int iFirst,int jFirst, int iSecond,int jSecond) { //only Swap the index in the Matrix,doesn't change its position!
        T temp;
        temp = a.get(iFirst,jFirst);
        a.set(iFirst,jFirst,a.get(iSecond, jSecond));
        a.set(iSecond,jSecond,temp);
        plan += "" + a.get(iFirst,jFirst) + "<->" + a.get(iSecond,jSecond) + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        int maxI,maxJ;
        for (int i = 0; i < a.length*a.width - 1; i++) {
            maxI=0;
            maxJ=0;
            for(int j=0;j<a.length*a.width-i;j++){
                if(a.get(j/a.length,j%a.length).compareTo(a.get(maxI,maxJ))>0){
                    maxI=j/a.length;
                    maxJ=j%a.length;
                }
            }
            swap(maxI,maxJ,(a.length*a.width-1-i)/a.length,(a.length*a.width-1-i)%a.length);
        }
    }


    @Override
    public String getPlan() {
        return this.plan;
    }

}