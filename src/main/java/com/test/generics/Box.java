package com.test.generics;

public class Box<T> {

	private T t;

	public void add(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}

	public static void main(String[] args) {
		Box<Integer> integerBox = new Box<Integer>();
		Box<String> stringBox = new Box<String>();
		Box<Float> floatBox = new Box<Float>();

		integerBox.add(new Integer(10));
		stringBox.add(new String("Hello World"));
		floatBox.add(new Float(11.9457));
		try {
			System.out.printf("Integer Value :%d\n\n", integerBox.get());
			System.out.printf("String Value :%s\n", stringBox.get());
			System.out.printf("Float Value :%.5f\n", floatBox.get());

		} finally {
		}
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
}

interface cache<K, V> {
	public void put(K key, V value);

	public V get(K key);
}
