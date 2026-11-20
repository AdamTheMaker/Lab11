/**
* File: Lab11Prob03.java
* Class: CSCI 1302
* Author: James Rogers, Adam Bojoh, Caden Bray
* Created on: November 20, 2026
* Last Modified: November 20, 2026
* Description: Lab 11 Problems
*/

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob03 {

	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<>();
		
		try (
				DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
			) 
		{
			
			while (true) {
				list.add(new Person(input.readInt(), input.readUTF(), input.readUTF(), input.readInt(), input.readDouble()));
			}
		
			
		} catch (EOFException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		Collections.sort(list);
		
		try (
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/people-salary-sorted-objects.dat"));
			) {
			
			for (Person p : list) {
				output.writeObject(p);
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

class Person implements Comparable<Person>, Serializable{
	private int age;
	private String name;
	private String address;
	private int zipCode;
	private double salary;
	
			
	public Person(int age, String name, String address, int zipCode, double salary) {
		setAge(age);
		setName(name);
		setAddress(address);
		setZipCode(zipCode);
		setSalary(salary);
	};
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return String.format("%d %s %s %d $%,.2f", getAge(), getName(), getAddress(), getZipCode(), getSalary());
	}

	@Override
	public int compareTo(Person o) {
		return Double.compare(o.getSalary(), getSalary());
	}
}