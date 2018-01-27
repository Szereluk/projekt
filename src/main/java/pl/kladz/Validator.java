package pl.kladz;

public class Validator {

	public static boolean isAnswerValid(String answer)
	{
		if(answer.equals("a") || answer.equals("b") || answer.equals("c") || answer.equals("d")) return true;
		else return false;
	}
	
}
