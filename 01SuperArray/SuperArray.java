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

	private void increaseCap(){
		resize(data.length + 1);
	}
	private void decreaseCap(){
		resize(data.length - 1);
	}	
	public void clear(){
		for (int i = 0; i < data.length; i++){
			data[i] = null;
		}
		elements = 0;
	}
	public String toString(){
		String str = "[ ";
		for (int i = 0; i < data.length; i++){
			str += data[i] + " ";
		}
		str += "]";
		return str;
	}

	public void add(Object o){
		add(elements, o);
	}
	public void add(int index, Object o){
		if(index > elements || index < 0){
			System.out.println("Out of Bounds.");
		}
		if(elements == data.length){
			increaseCap();
		}
		for(int i = elements; i > index; i--){
			data[i] = data[i - 1];
		}
		elements++;
		data[index] = o;
	}

	public Object get(int index){
		if (index < 0  || index >= elements){
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
			if(lastIndex < data.length - 1){
				decreaseCap();
			}
			for(int i = index; i < lastIndex; i++){
				data[i] = data[i + 1];
			}
			data[lastIndex] = null;
			elements--;
			return ret;
		}
	}
	public static void main(String[]args){
		SuperArray a = new SuperArray();
		System.out.println(a.toString());
		System.out.println(a.size());
		a.add(5);
		a.add("w");
		System.out.println(a.toString());
		System.out.println(a.size());
		a.resize(15);
		System.out.println(a.toString());
		a.clear();
		System.out.println(a.toString());
		a.add(7);
		a.add("b");
		a.add(50);
		a.add("aw");
		System.out.println(a.toString());
		System.out.println(a.get(3));
		a.set(2,"swag");
		System.out.println(a.toString());
	}
}