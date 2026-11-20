/**
* File: Lab11.java
* Class: CSCI 1302
* Author: James Rogers, Adam Bojoh, Caden Bray
* Created on: November 20, 2026
* Last Modified: November 20, 2026
* Description: Lab 11 Problems
*/

import java.io.*;

public class Lab11Prob01 {

	public static void main(String[] args) {
		try (
				DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
				DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));
			) 
		{
			while (true) {
				int age = input.readInt();
				String name = input.readUTF();
				String address = input.readUTF();
				int zip = input.readInt();
				double salary = input.readDouble();
				
				output.writeInt(age);
				output.writeUTF(name);
				output.writeUTF(address);
				output.writeInt(zip);
				output.writeDouble(salary);
				// System.out.printf("Age: %d\nFirst and Last Name: %s\nAddress: %s\nZip Code: %s\nSalary: %f", age, name, address, zip, salary);
				System.out.printf("%d %s %s %s %.2f\n", age, name, address, zip, salary);
			}
		} catch (EOFException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
