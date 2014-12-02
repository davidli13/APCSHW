public class SuperArray{
	Object[] data;
	int elements = 0;

	public SuperArray(){
		data = new Object[10];
	}

	public SuperArray(int n){
		data = new Object[n];
	}

	public int size(){
		return elements;
	}

	public void resize(int newCapacity){
		Object[] data2 = new Object[newCapacity];
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


	public void add(Object o){
		add(elements, o);
	}
	public void add(int index, Object o){
		if(index > elements || index < 0){
			System.out.println("Out of Bounds.");
		}
		if(elements == data.length){
			resize(data.length + 1);
		}
		for(int i = elements; i > index;i--){
			data[i - 1] = data[i];
		}
		elements++;
		data[index] = o;
		;
	}

	public Object get(int index){
		if (index >= data.length || index < 0){
			System.out.println("Out of Bounds.");
			return null;
		}
		return data[index];
		
	}

	public Object set(int index, Object o){
		if(index >= elements || index < 0){
			System.out.println("Out of Bounds.");
			return null;
		}
		else{
			Object ret = data[index];
			data[index] = o;
			return ret;
		}
	}
	public Object remove(int index){
		if(index > elements || index < 0){
			System.out.println("Out of Bounds.");
			return null;
		}
		else{
			Object ret = data[index];
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
		SuperArray a = new SuperArray();
		System.out.println(a.toString());
		System.out.println(a.size());
		a.add(5);
		a.resize(20);
		System.out.println(a.toString());
		a.add("w");
		a.add(5);
		a.add(2,"test");
		a.add(5);
		a.add(8,"onetw");
		a.add(10,7845321);
		a.add(5);
		a.add("yay");
		System.out.println(a.toString());
		a.remove(9);
		a.remove(5);
		System.out.println(a.toString());
	}
}
