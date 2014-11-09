public class SuperArray{
    Object[] data;
    int elements = 0;

    public SuperArray(){
	data = new Object[10];
    }

    public SuperArray(int n){
	data = new Object[n];
    }

    public String toString(){
	String str = "[ ";
	for (int i = 0; i < data.length; i++){
	    str += data[i] + " ";
	}
	str += "]";
	return str;
    }
    
    public void add(Object e){
	for (int x = 0; x < data.length; x++){
	    if (data[x] == null){
		data[x] = e;
		break;
	    }
	}
    }

    public int size(){
	for (int x = 0; x < data.length; x++){
	    if (data[x] != null){
		elements++;
	    }
	}
	return elements;
    }

    public void resize(int newCapacity){
	data2 = new Object[newCapacity];
	for (int x = 0; x < data.length(); x++){
	    data2[x] = data[x];
	}
	data = data2;
    }
    
    public static void main(String[]args){
	SuperArray a = new SuperArray();
	System.out.println(a.toString());
	System.out.println(a.size());
	a.add(5);
	a.add("w");
	System.out.println(a.toString());
	System.out.println(a.size());
    }
}