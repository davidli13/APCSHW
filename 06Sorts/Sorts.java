public class Sorts{
    public static void bubble(int[]c){
	for (int i = 1; i < c.length; i++){
	    for (int j = i; j > 1; j--){
		int x = c[i];
		if (c[i] < c[i-1]){
		    c[i] = c[i-1];
		    c[i-1] = x;
		}
	    }	    
	}
    }
    
    public static void main(String[]args){
	int[]c = new int[10];
	for (int i = 0; i < 10; i++){
	    c[i] = i;
	}
	Sorts.bubble(c);
    }
}