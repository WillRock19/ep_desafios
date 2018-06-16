import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner (System.in);
		
		int numberOfTestCases = scan.nextInt();
		int casesCounter = 0;
		
		while(casesCounter < numberOfTestCases) 
		{
			int stringLength = scan.nextInt();
			int subStringLength = scan.nextInt();
			int numberOfValidstrings = CalculateNumberOfValidStrings(stringLength, subStringLength);
			
			PrintResultToUser(numberOfValidstrings);
			casesCounter++;
		}
		scan.close();
	}
	
	private static int CalculateNumberOfValidStrings(int maxStringLength, int maxSubstringLength) 
	{
		int numberOfValidStrings = 0;
		
		String binaryValue = CreateBinaryStringWithLength(maxStringLength);
		int maxNumber = GenerateBiggestPossibleNumberFromBinary(binaryValue);
		
		for(int number = 0; number <= maxNumber; number++) 
		{
			String currentBinaryNumber = GenerateBinaryNumberFrom(number);
			
			if(!IsInvalidPalindrome(currentBinaryNumber, maxSubstringLength)) 
				numberOfValidStrings++;
		}	
		return numberOfValidStrings;
	}
	
	private static String GenerateBinaryNumberFrom(int number) 
	{
		if(number == 0 || number == 1)
			return "0" + Integer.toBinaryString(number);
		
		return Integer.toBinaryString(number);
	}

	private static void PrintResultToUser(int response) 
	{
		System.out.println(response);
	}

	private static String CreateBinaryStringWithLength(int length) 
	{
		String binaryNumber = "";
		
		for(int index = 0; index < length; index++) 
			binaryNumber = 0 + binaryNumber;

		return binaryNumber;
	}
	
	private static boolean IsInvalidPalindrome(String binaryNumber, int palindromeMaxSize) 
	{	
		char[] wordToTest = binaryNumber.toCharArray();
		
	    int index1 = 0;
	    int index2 = wordToTest.length - 1;
	    while (index2 > index1) 
	    {
	        if (wordToTest[index1] != wordToTest[index2]) 
	        {
	            return false;
	        }
	        ++index1;
	        --index2;
	    }
	    return wordToTest.length >= palindromeMaxSize;
	}

	public static int GenerateBiggestPossibleNumberFromBinary(String binary) 
	{
		String maximunBinaryPossible = binary.replace('0', '1');
		return Integer.parseInt(maximunBinaryPossible, 2);
	}
}
