package JavaFinalProject;

@SuppressWarnings("serial")
public class NotEnoughArgumentException extends Exception
{
		
		public NotEnoughArgumentException()
		{
			super("argument Error!");
		}		
	
		public NotEnoughArgumentException(String message)
		{
			super(message);
		}
	
}