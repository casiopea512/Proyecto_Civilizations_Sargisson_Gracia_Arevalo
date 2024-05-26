package exceptions;

//crear algo y no dispongamos de los recursos necesarios

public class ResourceException extends Exception{
	public ResourceException(String mensaje) {
		super(mensaje);
	}
}
