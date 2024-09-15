package exceptions;

public class InvalidDamageValueException extends Exception
{

	private static final long serialVersionUID = 8246213049897062451L;

	public InvalidDamageValueException()
	{
		//That string represents the message that you want to appear.
		super( "Damage value must be greater than 0." );
	}

}
