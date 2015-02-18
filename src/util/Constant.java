package util;

public final class Constant {
	
	public static final String path = "";
	
	private Constant(){
		//this prevents even the native class from 
		//calling this ctor as well :
		throw new AssertionError();
	}
}
