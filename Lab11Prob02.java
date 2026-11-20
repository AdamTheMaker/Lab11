import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab11Prob02 {

	public static void main(String[] args) {
		try (
				DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
				DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));
			) 
		{
			int age = 0;
			String name = "";
			String address = "";
			int zip = 0;
			double salary = 0.0;
			while (true) {
				age = input.readInt();
				name = input.readUTF();
				address = input.readUTF();
				zip = input.readInt();
				salary = input.readDouble();
				
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
	class Person {
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
			return String.format("%s", name);
		}
	}

}
}
