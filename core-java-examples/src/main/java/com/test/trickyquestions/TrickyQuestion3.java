package com.test.trickyquestions;

//Multiple inheritance with interfaces
public class TrickyQuestion3 {

	public static void main(String[] args) {
		Sub sub = new Sub();
		sub.show();
		sub.show(sub);

		Parent1 p1 = new Sub();
		p1.show();
		p1.show(p1);

		Parent2 p2 = new Sub();
		p2.show();
		sub.show(p2);

	}
}

class Sub implements Parent1, Parent2 {

	@Override
	public void show() {
		System.out.println("show called.....");
	}

	@Override
	public void show(Object o) {
		System.out.println("show called..... with object : " + o);
	}

}

interface Parent1 {
	void show(Object o);

	void show();
}

interface Parent2 {
	void show();
}
