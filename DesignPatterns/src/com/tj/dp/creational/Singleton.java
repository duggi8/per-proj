package com.tj.dp.creational;

import java.lang.reflect.Constructor;

public class Singleton {

	/*********** Eager Initialization **************/
	/**
	 * bean is created on class loading before even any call to method is made-->
	 * not good
	 */

	private static final Singleton instance = new Singleton();

	private Singleton() {
	};

	public static Singleton getInstance() {
		return instance;
	}

	/*********** Static Block Initialization ****************/
	/**
	 * bean is created on class loading before even any call to method is made-->
	 * not good
	 */

	/*
	 * private static Singleton instance;
	 * 
	 * private Singleton() { };
	 * 
	 * static { try { instance = new Singleton(); } catch (Exception e) { throw new
	 * RuntimeException("Exception occurred when creating singleton instance"); } }
	 * 
	 * public static Singleton getInstance() { return instance; }
	 */

	/*********** Lazy Initialization ****************/
	/**
	 * bean is created on demand with method call--> good but synchronization issues
	 */
	/*
	 * private static Singleton instance;
	 * 
	 * private Singleton() { };
	 * 
	 * public static Singleton getInstance() { if (instance == null) { return new
	 * Singleton(); } return instance; }
	 */

	/*********** Bill pugh Initialization ****************/
	/**
	 * here when the singleton class is loaded inner static class is not loaded into
	 * memory and only when someone calls getInstance method ,helper class gets
	 * loaded and singleton instance is created. No thread issues as thread which
	 * calls helper class first helpes it to get loaded and instance created. Once
	 * created as it is final constructor won't be invoked again.
	 */

	/*
	 * private Singleton() {};
	 * 
	 * private static class SingletonHelper{ private static final Singleton INSTANCE
	 * = new Singleton(); }
	 * 
	 * public static Singleton getInstance() { return SingletonHelper.INSTANCE; }
	 */

	/*********** Using Reflection to destroy Singleton Pattern ****************/
	public static void main(String[] args) {
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = null;
		try {
			Constructor[] constructors = Singleton.class.getDeclaredConstructors();
			for (Constructor constructor : constructors) {
				constructor.setAccessible(true);
				instance2 = (Singleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(instance1.hashCode());
		System.out.println(instance2.hashCode());
	}

}