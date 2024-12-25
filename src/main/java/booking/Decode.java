package booking;

import java.util.Base64;

public class Decode {

	    
	    // Method to encode a string to Base64
	    public static String encodeBase64(String input) {
	        return Base64.getEncoder().encodeToString(input.getBytes());
	    }
	    
	    // Method to decode a Base64 encoded string
	    public static String decodeBase64(String encodedInput) {
	        byte[] decodedBytes = Base64.getDecoder().decode(encodedInput);
	        return new String(decodedBytes);
	    }
	    
	    public static void main(String[] args) {
	        String originalString = "MQ==";
	        String decodedString = decodeBase64(originalString);

	        System.out.println("Original String: " + originalString);
	        System.out.println("Decoded String: " + decodedString);
	    }
	}


