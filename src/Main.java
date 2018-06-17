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
			String currentBinaryNumber = GenerateBinaryNumberFrom(number, binaryValue.length());
			
			if(!IsInvalidPalindrome(currentBinaryNumber, maxSubstringLength)) 
				numberOfValidStrings++;			
		}	
		return numberOfValidStrings;
	}
	
	private static String GenerateBinaryNumberFrom(int number, int maximumNumberOfBits) 
	{
		String response = Integer.toBinaryString(number);
		
		if(response.length() < maximumNumberOfBits) 
			return AddZerosToBinaryLeftSide(response, maximumNumberOfBits);
			
		return response;
	}

	private static void PrintResultToUser(int response) 
	{
		System.out.println(response);
	}

	private static String CreateBinaryStringWithLength(int length) 
	{
		char charThatRepresentsEmpty = '\0';
		return new String(new char[length]).replace(charThatRepresentsEmpty, '0');
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

	public static String AddZerosToBinaryLeftSide(String binaryNumber, int maximumNumberOfBitsAllowed) 
	{
		String zerosToAdd = "";
		int numberOfZerosToAdd = maximumNumberOfBitsAllowed - binaryNumber.length();
		
		if(numberOfZerosToAdd > 0) 
		{
			for(int index = 0; index < numberOfZerosToAdd; index++) 
				zerosToAdd = "0" + zerosToAdd;			
		}
		return zerosToAdd + binaryNumber;
	}
}
