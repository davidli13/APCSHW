import java.util.*;
public class Sorts{
    public static void Bubble(int[] c){
	boolean mixed = true;
	int x;
	while (mixed){
	    mixed = false;
	    for (int i = 0; i < c.length - 1; i++){
		if (c[i] > c[i+1]){
		    x = c[i];
		    c[i] = c[i+1];
		    c[i+1] = x;
		    mixed = true;
		}
	    }
	}
    }

    public static void InsertionSort(int[] c){
	int x, h; 
	for(int i = 0; i < c.length; i++){
	    x = i;
	    while (x > 0 && c[x] < c[x-1]){
		h = c[x-1];
		c[x-1] = c[x];
		c[x] = h;
		x--;
	    }
	}
    }

    public static void SelectionSort (int[] c){
	int x, min, h;
	for(int i = 0; i < c.length; i++){
	    min = c[i];
	    h = i;
	    for(int j = i; j < c.length; j++){
		if(min >= c[j]){
		    min = c[j];
		    h = j;
		}
	    }
	    x = c[i];
	    c[i] = min;
	    c[h] = x;
	}
    }
        
    public static void RadixSort(int[] c){
	ArrayList<Integer> a = new ArrayList<Integer>();
	int i;
	int e = 0;
	while (e < c.length){    
	    
	}
    }

    public static void main(String[]args){

    }
}