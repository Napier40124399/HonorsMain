package Logics;

public class Validation
{
	public boolean checkString(String s)
	{
		if(s.isEmpty()){return false;}
		if(!s.matches("[0-9]+")){return false;}
		
		return true;
	}
}
