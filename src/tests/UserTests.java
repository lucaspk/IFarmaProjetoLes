package tests;

import org.junit.*;

import exceptions.InvalidEmailException;
import exceptions.InvalidNameException;
import exceptions.InvalidNameException;
import exceptions.InvalidPasswordException;
import exceptions.InvalidUsernameException;
import exceptions.InvalidUserDataException;
import model.User;

public class UserTests {
		// criar uma lista de siglas de estados do BR na classe de valida��o. Se for lista n�o cont�m, � inv�lido o estado.
	private String invalidNameWithOnlyLetters;
	private String invalidNameMixingLettersAndSeveralNumbers;
	private String invalidNameMixingLettersAndOnlyOneNumber;
	private String invalidNameMixingLettersAndSpecialChars;
	private String invalidNameMixingLettersAndNumbersAndSpecialChars;
	private String invalidNameWithOnlySpecialChars;
	private String invalidNameWithOnlyNumbers;
	private String invalidNameWithOnlySpaces;
	private String invalidNameWithGraphicAccentuation;
	private String validName;

	private String validUsernameWithOnlyLetters;
	private String validUsernameMixLettersAndNumbers;
	private String validUsernameWithUnderscore;
	private String validUsernameMixLettersNumbersSeparators;
	private String invalidUsernameWithOnlyNumbers;
	private String invalidUsernameWithSpace;
	private String invalidUsernameWithOnlySpecialChars;
	private String invalidUsernameWithOnlySpaces;
	private String invalidUsernameWithGraphicAccentuation;
	
	
	private String invalidPasswordOnlyNumbers;
	private String invalidPasswordWithOnlySpaces;
	private String invalidPasswordLengthInferiorToEight;
	private String validPasswordNumbersAndLetters;
	private String validPasswordNumbersAndSpecialChars;
	private String validPasswordLettersAndSpecialChars;
	private String validPasswordWithLettersAndSpecialCharsAndNumbers;
	
	private String validMail;
	private String invalidMailStartingWithNumber;
	private String invalidMailWithoutAtSymbol;
	private String invalidMailStartingWithDot;
	private String invalidMailStartingWithUnderscore;
	private String invalidMailStartingWithHyphen;
	private String invalidMailWithOnlyNumbersBeforeAtSymbol;
	private String invalidMailWithOnlySpecialCharsBeforeAtSymbol;
	private String invalidMailWithOnlySpacesBeforeAtSymbol;
	private String invalidMailWithOnlySpaces;
	private String invalidMailWithSpace;
	private String validMailWithUnderscoreBeforeAtSymbol;
	private String validMailWithDotBeforeAtSymbol;
	private String validMailWithHyphenBeforeAtSymbol;
	private String validMailWithAtLeastOneLetterBeforeAtSymbol;
	private String invalidMailWithInvalidSpecialCharsBeforeAtSymbol;
	
	private String validAddress ;
	private String validHouseNumber;
	private String validCEP;
	private String validState;
	
	private User userInvalid;
	private User userValid;
	
	
	
	@Before
	public void setUpValidUserData(){
		validName = "Jobson Lucas";
		
		validUsernameWithOnlyLetters = "lucaspk";
		validUsernameMixLettersAndNumbers = "lucaspk96";
		validUsernameWithUnderscore = "lucas_pk";
		validUsernameMixLettersNumbersSeparators = "lucaspk-96";
		
		validMail = "lucas@gmail.com";
		validMailWithUnderscoreBeforeAtSymbol = "lucas_dias@gmail.com";
		validMailWithDotBeforeAtSymbol = "lucas.dias@gmail.com";
		validMailWithHyphenBeforeAtSymbol = "lucas-dias@gmail.com";
		validMailWithAtLeastOneLetterBeforeAtSymbol = "ll5648546@gmail.com";
		
		validPasswordNumbersAndLetters = "6xablau9";
		validPasswordNumbersAndSpecialChars = "564864@#";
		validPasswordLettersAndSpecialChars = "lucas%&*";
		validPasswordWithLettersAndSpecialCharsAndNumbers = "lucas%9621&";
		
		validAddress = "Rua das mulatas saradas";
		
		validHouseNumber = "150";
		
		validCEP = "58410538";
		
		validState = "PB";
	}
	
	@Before
	public void setUpInvalidUserData(){
		invalidNameWithOnlyLetters = "JobsonLucasDias";
		invalidNameWithGraphicAccentuation = "Jo�o Victor Mafra B�i";
		invalidNameWithOnlyNumbers = "1651561681818616818161516156";
		invalidNameWithOnlySpecialChars = "!bs@#      ��*$   |)/%�_=+�{}���?/;:<>���";
		invalidNameWithOnlySpaces = "                           ";
		invalidNameMixingLettersAndSeveralNumbers = "Jobson54654 Lucas245541561";
		invalidNameMixingLettersAndOnlyOneNumber = "Jobson Lucas2";
		invalidNameMixingLettersAndSpecialChars = "Job$@# �u�@! !@#sdf#WER@xcv$%$���&**/-*";
		invalidNameMixingLettersAndNumbersAndSpecialChars = "J156651o51b$@# 156156�u�@!asdqwe2 !@#sdf#WER@xcv$%$���&**/-*";
		
		invalidUsernameWithOnlyNumbers = "3151231531513135153531";
		invalidUsernameWithOnlySpaces = "               ";
		invalidUsernameWithOnlySpecialChars = "!@#$#%#$%&%&&*(*)--==++==*/-/+++";
		invalidUsernameWithSpace = "jobson Lucas";
		invalidUsernameWithGraphicAccentuation = "Jo�o";
		
		invalidMailStartingWithNumber = "9sdfsdf99@gmail.com";
		invalidMailStartingWithDot = ".999@gmail.com";
		invalidMailStartingWithUnderscore= "_999@gmail.com";
		invalidMailStartingWithHyphen= "-999@gmail.com";
		invalidMailWithoutAtSymbol = "999gmail.com";
		invalidMailWithOnlyNumbersBeforeAtSymbol = "999@gmail.com";
		invalidMailWithOnlySpecialCharsBeforeAtSymbol= "+-/*/*+.@gmail.com";
		invalidMailWithOnlySpacesBeforeAtSymbol = "                      @gmail.com";
		invalidMailWithOnlySpaces = "                              ";
		invalidMailWithSpace = "lucas dias@gmail.com";
		invalidMailWithInvalidSpecialCharsBeforeAtSymbol = "luc+a*s&dias@gmail.com";
		
		invalidPasswordOnlyNumbers = "46644684";
		invalidPasswordLengthInferiorToEight = "luc96$%";
		invalidPasswordWithOnlySpaces = "               ";
	}
	
	@Test
	public void testShouldCreateUserEmailWithAtLeastOneLetterBeforeAtSymbol(){
		try {
			userValid = new User(validName, validUsernameWithOnlyLetters,
					validMailWithAtLeastOneLetterBeforeAtSymbol, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testShouldCreateUserEmailWithHyphenBeforeAtSymbol(){
		try {
			userValid = new User(validName, validUsernameWithOnlyLetters,
					validMailWithHyphenBeforeAtSymbol, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testShouldCreateUserEmailWithDotBeforeAtSymbol(){
		try {
			userValid = new User(validName, validUsernameWithOnlyLetters,
					validMailWithDotBeforeAtSymbol, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testShouldCreateUserEmailWithUnderscoreBeforeAtSymbol(){
		try {
			userValid = new User(validName, validUsernameWithOnlyLetters,
					validMailWithUnderscoreBeforeAtSymbol, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testShouldFailCreatingUserEmailWithSpaceBeforeAtSymbol(){
		try {
			userInvalid = new User(validName, validUsernameWithOnlyLetters,
					invalidMailWithSpace, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidEmailException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testShouldFailCreatingUserEmailWithSpecialCharsBeforeAtSymbol(){
		try {
			userInvalid = new User(validName, validUsernameWithOnlyLetters,
					invalidMailWithInvalidSpecialCharsBeforeAtSymbol, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidEmailException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testShouldFailCreatingUserEmailWithOnlySpaces(){
		try {
			userInvalid = new User(validName, validUsernameWithOnlyLetters,
					invalidMailWithOnlySpaces, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidEmailException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testShouldFailCreatingUserEmailWithOnlySpacesBeforeAtSymbol(){
		try {
			userInvalid = new User(validName, validUsernameWithOnlyLetters,
					invalidMailWithOnlySpacesBeforeAtSymbol, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidEmailException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testShouldFailCreatingUserEmailWithOnlySpecialCharsBeforeAtSymbol(){
		try {
			userInvalid = new User(validName, validUsernameWithOnlyLetters,
					invalidMailWithOnlySpecialCharsBeforeAtSymbol, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidEmailException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testShouldFailCreatingUserEmailWithOnlyNumbersBeforeAtSymbol(){
		try {
			userInvalid = new User(validName, validUsernameWithOnlyLetters,
					invalidMailWithOnlyNumbersBeforeAtSymbol, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidEmailException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testShouldFailCreatingUserEmailWithHyphenAsFirstChar(){
		try {
			userInvalid = new User(validName, validUsernameWithOnlyLetters,
					invalidMailStartingWithHyphen, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidEmailException().getMessage(), e.getMessage());
		}
		
	}
	
	
	@Test
	public void testShouldFailCreatingUserEmailWithUnderscoreAsFirstChar(){
		try {
			userInvalid = new User(validName, validUsernameWithOnlyLetters,
					invalidMailStartingWithUnderscore, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidEmailException().getMessage(), e.getMessage());
		}
		
	}
	
	
	@Test
	public void testShouldFailCreatingUserEmailWithDotAsFirstChar(){
		try {
			userInvalid = new User(validName, validUsernameWithOnlyLetters,
					invalidMailStartingWithDot, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidEmailException().getMessage(), e.getMessage());
		}
		
	}
	
	
	@Test
	public void testShouldFailCreatingUserEmailWithoutAtSymbol(){
		try {
			userInvalid = new User(validName, validUsernameWithOnlyLetters,
					invalidMailWithoutAtSymbol, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidEmailException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testShouldFailCreatingUserEmailWithNumberAsFirstChar(){
		try {
			userInvalid = new User(validName, validUsernameWithOnlyLetters,
					invalidMailStartingWithNumber, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidEmailException().getMessage(), e.getMessage());
		}
		
	}
	
	
	@Test
	public void testCreatingUserWithOnlyNumbersAsPassword(){
		try {
			userInvalid = new User(validName, validUsernameWithOnlyLetters, validMail, 
					invalidPasswordOnlyNumbers,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidPasswordException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithPasswordWithOnlySpaces(){
		try {
			userInvalid = new User(validName, validUsernameWithOnlyLetters, validMail, 
					invalidPasswordWithOnlySpaces,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidPasswordException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithPasswordLengthInferiorToEight(){
		try {
			userInvalid = new User(validName, validUsernameWithOnlyLetters, validMail, 
					invalidPasswordLengthInferiorToEight,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidPasswordException().getMessage(), e.getMessage());
		}
		
	}
	
	
	@Test
	public void testCreatingUserWithNumbersAndLettersAndSpecialCharsAsPassword(){
		try {
			userValid = new User(validName, validUsernameWithOnlyLetters, validMail, 
					validPasswordWithLettersAndSpecialCharsAndNumbers,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidPasswordException().getMessage(), e.getMessage());
		}
		
	}
	
	
	@Test
	public void testCreatingUserWithNumbersAndLettersAsPassword(){
		try {
			userValid = new User(validName, validUsernameWithOnlyLetters, validMail, 
					validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidPasswordException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithSpecialCharsAndLettersAsPassword(){
		try {
			userValid = new User(validName, validUsernameWithOnlyLetters, validMail, 
					validPasswordLettersAndSpecialChars,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidPasswordException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithSpecialCharsAndNumbersAsPassword(){
		try {
			userValid = new User(validName, validUsernameWithOnlyLetters, validMail, 
					validPasswordNumbersAndSpecialChars,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidPasswordException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithSpecialCharsAndNumbersInUsername(){
		try {
			userValid = new User(validName, validUsernameMixLettersNumbersSeparators, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithSpecialCharsInUsername(){
		try {
			userValid = new User(validName, validUsernameWithUnderscore, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidUsernameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithNumbersInUsername(){
		try {
			userValid = new User(validName, validUsernameMixLettersAndNumbers, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidUsernameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithGraphAccentuationInUsername(){
		try {
			userInvalid = new User(validName, invalidUsernameWithGraphicAccentuation, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
			
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidUsernameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithSpaceInUsername(){
		try {
			userInvalid = new User(validName, invalidUsernameWithSpace, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidUsernameException().getClass(), e.getClass());
			
		}
		
	}
	
	@Test
	public void testCreatingUserWithOnlySpacesAsUsername(){
		try {
			userInvalid = new User(validName, invalidUsernameWithOnlySpaces, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidUsernameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithOnlyNumbersAsUsername(){
		try {
			userInvalid = new User(validName, invalidUsernameWithOnlyNumbers, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidUsernameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithOnlySpecialCharsAsUsername() throws InvalidUserDataException{
		try {
			userInvalid = new User(validName, invalidUsernameWithOnlySpecialChars, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidUsernameException().getClass(), e.getClass());
		}
		
	}
	
	
	@Test
	public void testCreatingUserValidData(){
		try {
			userValid = new User(validName, validUsernameWithOnlyLetters, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
	
	
	@Test
	public void testCreatingUserWithGraphAccentuationInName(){
		try {
			userInvalid = new User(invalidNameWithGraphicAccentuation, validUsernameWithOnlyLetters, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithOnlyLettersInName(){
		try {
			userInvalid = new User(invalidNameWithOnlyLetters, validUsernameWithOnlyLetters, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithOnlyNumbersAsName(){
		try {
			userInvalid = new User(invalidNameWithOnlyNumbers, validUsernameWithOnlyLetters, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithOnlySpacesAsName(){
		try {
			userInvalid = new User(invalidNameWithOnlySpaces, validUsernameWithOnlyLetters, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithOnlySpecialCharAsName(){
		try {
			userInvalid = new User(invalidNameWithOnlySpecialChars, validUsernameWithOnlyLetters, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
	
	
	@Test
	public void testCreatingUserWithSpecialCharAndNumberInName(){
		try {
			userInvalid = new User(invalidNameMixingLettersAndNumbersAndSpecialChars, validUsernameWithOnlyLetters, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithSpecialCharInName(){
		try {
			userInvalid = new User(invalidNameMixingLettersAndSpecialChars, validUsernameWithOnlyLetters, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
			
	@Test
	public void testCreatingUserWithSingleNumberInName(){
		try {
			userInvalid = new User(invalidNameMixingLettersAndOnlyOneNumber, validUsernameWithOnlyLetters, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
	
	@Test
	public void testCreatingUserWithSeveralNumbersInName(){
		try {
			userInvalid = new User(invalidNameMixingLettersAndSeveralNumbers, validUsernameWithOnlyLetters, validMail, validPasswordNumbersAndLetters,
					validAddress, validHouseNumber, validCEP, validState);
		} catch (InvalidUserDataException e) {
			Assert.assertEquals(new InvalidNameException().getMessage(), e.getMessage());
		}
		
	}
	


}
