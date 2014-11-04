package com.test.trickyquestions;

public class TrickyQuestion2_2 {
	
	/**
	 * Java program to demonstrate that private method can not be overridden in Java.
	 * This Java programs calls both private and non private method with child class 
	 * object on constructor of parent class.
	 * Only non private method of Child class invoked while private method of 
	 * Parent class is invoked, Which confirms that private method can not be overridden in Java
	 *  and only be hidden if we declare same method in Child class.
	 * @author
	 */
	  
	    public static void main(String args[]) {
	        //shows that private method can not be overridden in Java     
	        Parent parent = new Child();
	        
//	        System.err.println("++++++++++++++++++++++");
//	        
//	        Child child = new Child();
//	        
//	        System.err.println("++++++++++++++++++++++");
//	        
//	        Parent par = new Parent();
	    }
	}

	class Parent{
	  
	    public Parent(){
	        name();
	        normal();
	    }
	  
	    private void name(){
	        System.err.printf("private method inside Parent class in Java %n");
	    }
	  
	    public void normal(){
	        System.err.println("non private method from Parent class can be overridden");
	    }
	  
	}

	class Child extends Parent{
		
//		public Child() {
//			name();
//		}
	  
	    /*
	     * Private method can not be overridden in Java, they can only be hidden
	     */
	    private void name(){
	        System.err.printf("private method inside Child class in Java %n");
	    }
	  
	    @Override
	    public void normal(){
	        System.err.println("non private overridden method from Child class ");
	    }
	  
	}

