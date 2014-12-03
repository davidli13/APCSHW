public class OrderedSuperArray extends SuperArray{
    String[] data;
    int elements = 0;
    
    public OrderedSuperArray(){
	data = new String[10];
    }
    
    public OrderedSuperArray(int n){
	data = new String[n];
    }

    public int size(){
	return elements;
    }

    public void resize(int newCapacity){
	String[] data2 = new String[newCapacity];
	for (int x = 0; x < data.length; x++){
	    data2[x] = data[x];
	}
	data = data2;
    }

    public void clear(){
	for (int i = 0; i < data.length; i++){
	    data[i] = null;
	}
	elements = 0;
    }

    public void add(String o){
	add(elements, o);
    }
    public void add(String o){
        int index = size();
        while( index >0 && get(index-1).compareTo(o) > 0 ){
            index--;
        }
        super.add(index, o);
    }

    public void insertionSort(){
	x
    }

    public void badInsertionSort(){
        OrderedSuperArray c = new OrderedSuperArray();
        while(this.size() > 0){ 
            c.add(this.remove(0));
        }
        while(c.size() > 0){
            this.add(c.remove(0));
        }
    }

    public String get(int index){
	if (index >= data.length || index < 0){
	    System.out.println("Out of Bounds.");
	    return null;
	}
	return data[index];
		
    }

    public String set(int index, String o){
	if(index >= elements || index < 0){
	    System.out.println("Out of Bounds.");
	    return null;
	}
	else{
	    String ret = data[index];
	    data[index] = o;
	    return ret;
	}
    }
    public String remove(int index){
	if(index > elements || index < 0){
	    System.out.println("Out of Bounds.");
	    return null;
	}
	else{
	    String ret = data[index];
	    int lastIndex = elements - 1;
	    if(lastIndex == data.length){
		resize(data.length - 1);
	    }
	    for(int i = index; i < lastIndex; i++){
		data[i] = data[i + 1];
	    }
	    data[lastIndex] = null;
	    elements--;
	    return ret;
	}
    }
    public String toString(){
	String str = "[ ";
	for (int i = 0; i < data.length; i++){
	    str += data[i] + " ";
	}
	str += "]";
	return str;
    }	
    public static void main(String[]args){
	OrderedSuperArray a = new OrderedSuperArray();
	System.out.println(a.toString());
	System.out.println(a.size());
	System.out.println(a);
    }
}
