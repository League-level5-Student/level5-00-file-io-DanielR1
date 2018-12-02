package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	public static void main(String[] args) {
		String e = JOptionPane.showInputDialog("encrypt this");
		String file ="";
		char[] c = e.toCharArray();
		for (int i = 0; i < c.length; i++) {
			Character c1=Character.valueOf(c[i]);
			int c1i=(int)c1;
			file+=Hexadecimal(c1);
		}
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/encrypt.txt");
			fw.write(file);
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	public static String Hexadecimal(int i) {
		String first = ""+i/16;
		String second="";
		int secondint=i%16;
		if(secondint>9) {
			second=Character.toString((char)(secondint+55));
		}
		else {
			second=""+secondint;
		}
		return first+second;
	}
}
