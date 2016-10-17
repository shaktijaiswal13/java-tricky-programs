package com.test.classinitialization;

/**
 * A reference to a static field causes initialization of only the class or interface (and super class and interface) 
 * that actually declares it, even though it might be referred to through the name of a subclass, a subinterface, 
 * or a class that implements an interface.
 * 
 * Interface Initialization Does Not Initialize Superinterfaces
 *
 */
class Super {
    static int taxi = 1729;
    static { System.out.print("Super "); }
}

class Sub extends Super {
    static int taxi1 = 1730;
    static { System.out.print("Sub "); }
}

class SubSub extends Sub {
    static int taxi2 = 1731;
    static { System.out.print("SubSub "); }
}

public class InterfaceInitializationTest2 {
    public static void main(String[] args) {
        System.out.println(SubSub.taxi1);
        
        //The reference to SubI.taxi is to a field that is a constant variable; therefore, it does not cause SuperI to be initialized.
        System.out.println(SubI.taxi);

        //The reference to SubSubI.taxi1 is a reference to a field actually declared in interface SubI that is not a constant variable; 
        //this causes initialization of the fields of interface SubI, but not those of interface SuperI, nor those of interface SubSubI.
        System.out.println(SubSubI.taxi1);
    }
    
    public static int out(String name, int value) {
    	System.out.println(name + "=" + value);
    	return value;
    }
}

interface SuperI {
    static int taxi = 1729;
    static int taxiI = InterfaceInitializationTest2.out("taxiI", 23);
}

interface SubI extends SuperI {
    static int taxi1 = InterfaceInitializationTest2.out("taxi1", 1730);
    static int taxiII = InterfaceInitializationTest2.out("taxiII", 24);
}

interface SubSubI extends SubI {
    static int taxi2 = 1731;
}