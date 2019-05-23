/**
 * Represents a Social Security Number (SSN), which has 3 parts:
 * 1. Area (A): Between 1 and 999.
 * 2. Group (G): Between 1 and 99.
 * 3. Serial (S): Between 1 and 9999.
 * A SSN has 9 digits and is in the format, AAA-GG-SSSS.
 * For this simulation, it's assumed that every SSN in existence was generated randomly.
 * 
 * @author Taha Quraishi
 */

package pa4;

import java.util.Random;

public class SocialSecurityNumber {
	
	// Area section of a SSN; between 1 and 999. 
	private String area;
	// Group section of a SSN; between 1 and 99.
	private String group;
	// Serial section of a SSN; between 1 and 9999.
	private String serial;
	// Formatted SSN; AAA-GG-SSSS.
	private String SSN;
	// Random object to generate area, group, and serial numbers.
	private Random random;

	/**
	 * Creates a SocialSecurityNumber object that initializes 
	 * the random object and stores the formatted SSN.
	 * Uses generateAreaNumber, generateGroupNumber, and generateSerialNumber to create a formatted SSN.
	 */
	public SocialSecurityNumber() {
		random = new Random();
		SSN = generateAreaNumber() + "-" + generateGroupNumber() + "-" + generateSerialNumber();
	}
	
	/**
	 * Generates and stores an area number between 1 and 999.
	 * 
	 * @return Area number between 1 and 999; includes leading 0's if generated area number is less than 3 digits.
	 */
	private String generateAreaNumber() {
		int areaNumber = 1 + random.nextInt(999);
		return area = "" + ((areaNumber / 100) % 10) + ((areaNumber / 10) % 10) + ((areaNumber / 1) % 10); // Gets the digit at the 1's place, 10's place, and 100's place; stores and returns this String.
	}
	
	/**
	 * Generates and stores a group number between 1 and 99.
	 * 
	 * @return Group number between 1 and 99; includes leading 0's if generated group number is less than 2 digits.
	 */
	private String generateGroupNumber() {
		int groupNumber = 1 + random.nextInt(99);
		return group = "" + ((groupNumber / 10) % 10) + ((groupNumber / 1) % 10); // Gets the digit at the 1's place and 10's place; stores and returns this String.
	}
	
	/**
	 * Generates and stores a serial number between 1 and 9999.
	 * 
	 * @return Group number between 1 and 9999; includes leading 0's if generated serial number is less than 4 digits.
	 */
	private String generateSerialNumber() {
		int serialNumber = 1 + random.nextInt(9999);
		return serial = "" + ((serialNumber / 1000) % 10) + ((serialNumber / 100) % 10) + ((serialNumber / 10) % 10) + ((serialNumber / 1) % 10); // Gets the digit at the 1's place, 10's place, 100's place, and 1000's place; stores and returns this String.
	}
	
	/**
	 * Gets the area section in a SSN.
	 * 
	 * @return Area section in a SSN as a String.
	 */
	public String getArea() {
		return area;
	}
	
	/**
	 * Gets the group section in a SSN.
	 * 
	 * @return Group section in a SSN as a String.
	 */
	public String getGroup() {
		return group;
	}
	
	/**
	 * Gets the serial section in a SSN.
	 * 
	 * @return Serial section in a SSN as a String.
	 */
	public String getSerial() {
		return serial;
	}
	
	/**
	 * Gets the formatted SSN.
	 * 
	 * @return Formatted SSN as a String.
	 */
	public String getSSN() {
		return SSN;
	}
	
	/**
	 * Gets the unformatted SSN.
	 * Does not include any dashes and leading 0's in area, but includes leading 0's in group and serial.
	 * 
	 * @return Unformatted SSN as an int.
	 */
	public int getSSNWithoutFormatting() {
		return Integer.parseInt(getArea() + "" + getGroup() + "" + getSerial()); // Converts String objects to an int.
	}

}
