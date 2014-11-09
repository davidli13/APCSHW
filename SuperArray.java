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
	}

	public Object get(int index){
		return data[index];
	}

	public void set(int index, Object e){
		data[index] = e;
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