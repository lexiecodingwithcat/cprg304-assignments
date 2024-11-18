package exceptions;

@SuppressWarnings("serial")
public class EmptyQueueException extends Exception {

	  public EmptyQueueException() {
	        super("Queue is empty.");
	    }

	  
	    public EmptyQueueException(String message) {
	        super(message);
	    }
	

}
