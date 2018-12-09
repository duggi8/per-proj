package teja.test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String orginalString = "https://www.baeldung.com/sha-256-hashing-javaoooooooooooooooooooooooooooooooooooooooooooooooooo";
		String orginalString2 = "https://www.baeldung.com/sha-256-hashing-jaa";
		byte[] enc = orginalString.getBytes(StandardCharsets.UTF_8); //encodes the string
		System.out.println(enc.length);
	/*	for(int i = 0; i< enc.length;i++) {
			System.out.println(enc[i]);
		}
		*/
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		byte[] encodedHash =  md.digest(orginalString.getBytes(StandardCharsets.UTF_8));
		System.out.println(encodedHash.length);
		
		for(int i = 0; i< encodedHash.length;i++) {
			System.out.println(encodedHash[i]);
		}
		System.out.println(bytesToHex(encodedHash));
		System.out.println(bytesToHex(md.digest(orginalString2.getBytes(StandardCharsets.UTF_8))));
		System.out.println(bytesToHex(encodedHash).equals(bytesToHex(md.digest(orginalString2.getBytes(StandardCharsets.UTF_8)))));
		
	}
	
	public static String bytesToHex(byte[] b) {
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<b.length;i++) {
			String hex = Integer.toHexString(0xFF & b[i]);
			int temp = 0xFF & b[i];
			
			System.out.println(temp);
			if(hex.length()==1)
				sb.append('0');
			sb.append(hex);
			
		}

		return sb.toString();
	}
	public static void partition(int[] a,int l ,int h) {
		int p = l;
		
		
	}

}
