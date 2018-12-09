package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	public static void main(String[] args) {
		BufferedReader br;
		try {
			String r = "";
			br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/encrypt.txt"));
			String s = br.readLine();
			for (int i = 0; i < s.length()/2; i++) {
				int add = hexToInt(s.substring(2*i, 2*i+2));
				r+=((char)add);
				
			}
			JOptionPane.showMessageDialog(null, r);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		

	}

	public static int hexToInt(String s) {
	int first = Integer.parseInt(s.substring(0, 1)) *16;
	int second=0;

	try {
		second = Integer.parseInt(s.substring(1,2));
	}
	catch (NumberFormatException e){
		char c1 = s.charAt(1);
		Character c = Character.valueOf(c1);
		second=(int)c -55;
	}
	return first+second;
	}

}
