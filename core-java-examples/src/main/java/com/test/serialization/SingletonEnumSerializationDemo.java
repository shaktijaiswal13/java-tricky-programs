package com.test.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Singleton Enum class serialization/deserialization demo. No need to do anything for serialization
 * of enum singleton.
 *
 */
public class SingletonEnumSerializationDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		SingletonEnum singleton = SingletonEnum.INSTANCE;
		System.out.println(singleton.hashCode() + ", " + singleton.INSTANCE.hashCode());
		FileOutputStream fos = new FileOutputStream(new File("singletonEnum.ser"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(singleton);
		oos.close();
		
		FileInputStream fis = new FileInputStream(new File("singletonEnum.ser"));
		ObjectInputStream ois = new ObjectInputStream(fis);
		SingletonEnum singleton1 = (SingletonEnum) ois.readObject();
		System.out.println(singleton1.hashCode() + ", " + singleton1.INSTANCE.hashCode());
		ois.close();
		
		FileInputStream fis2 = new FileInputStream(new File("singletonEnum.ser"));
		ObjectInputStream ois2 = new ObjectInputStream(fis2);
		SingletonEnum singleton2 = (SingletonEnum) ois2.readObject();
		System.out.println(singleton2.hashCode() + ", " + singleton2.INSTANCE.hashCode());
		ois2.close();
	}

}
