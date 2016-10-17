package com.test.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * getConstructors(), getFields() and getMethods() return only public members.
 * To access private members of the class use the method getDeclaredXXX().
 * To use the private member it's setAccessible(true) method needs to be called.
 * If the method is static you supply null instead of an object instance while invoking that method staticMethod.invoke(null, new Object[] {}).
 */
public class ReflectionDemo {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, NoSuchFieldException, SecurityException, NoSuchMethodException {

		Employee emp = new Employee();
		
		Class<?> aClass = Class.forName("com.test.reflection.Employee");
		
		System.out.println("=================== Accessing constructors ===========================");
		
		Constructor<?>[] constructors = aClass.getConstructors();
		for(Constructor<?> constructor : constructors) {
			System.out.println(constructor.getName() + ", " + constructor.getParameterTypes().length);
		}
		
		System.out.println("=================== Accessing Fields ===========================");

		Field[] fields = aClass.getFields();
		for (Field field : fields) {
			System.out.println(field.getName() + ", " + field.getType());
			field.set(emp, 20000);
		}
		
		System.out.println("=================== Accessing private Fields ===========================");

		Field nameField = Employee.class.getDeclaredField("name");
		System.out.println(nameField + ", " + nameField.getType());
		nameField.setAccessible(true);		//to set the value of private field it's setAccessible(true) should be called
		nameField.set(emp, "ABC");
		
		System.out.println(emp.getName() + "," + emp.getSalary());

		System.out.println("=================== Accessing methods ===========================");

		Method[] methods = aClass.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName() + ", " + method.getParameterTypes().length);
//			System.out.println(method.invoke(new Employee(), new Object[]{}));
		}
		
		System.out.println("=================== Invoking Method ===========================");

		Method salaryMethod = aClass.getDeclaredMethod("setSalary", new Class[] {int.class});
		System.out.println(salaryMethod.getName() + ", " + salaryMethod.getParameterTypes().length);
		System.out.println(salaryMethod.invoke(emp, new Object[] {30000}));
		
		System.out.println("Employee value after change" + emp.getName() + "," + emp.getSalary());

		System.out.println("=================== Invoking Static Method ===========================");

		Method staticMethod = aClass.getMethod("print", new Class[] {});
		System.out.println(staticMethod.getName() + ", " + staticMethod.getParameterTypes().length);
		System.out.println(staticMethod.invoke(null, new Object[] {}));
	}
	

}
