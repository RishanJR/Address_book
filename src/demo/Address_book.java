package demo;
import java.util.*;

//Records the info of the user
//Define parameters for the Array list
class Person_info{
	String first_name, last_name, address, city, state;
	int zip, phone_number;
	
	//Constructor
	public Person_info(String fn, String ln, String add, String place, String st, int postal, int ph_no) {
		first_name=fn;
		last_name=ln;
		address=add;
		city=place;
		state=st;
		zip=postal;
		phone_number=ph_no;
	}

	//Printing the details of the user
	public void print_detail() {
		System.out.println("First name - "+first_name+"\nLast name - "+last_name+"\nAddress - "+address+"\nCity - "+city+"\nState - "+state+"\nZip - "+zip+"\nPhone number - "+phone_number);
	}
}

//Function include add, modify, delete and print user details 
public class Address_book {

	//Storing details of users in array list (persons)
	ArrayList<Person_info> persons;
	
	//Constructor
	public Address_book() {
		persons = new ArrayList<Person_info>();
	}
	
	public void add_user() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter user's first name");
		String fn = sc.nextLine();
		System.out.println("Enter user's last name");
		String ln = sc.nextLine();
		System.out.println("Enter user's address");
		String add = sc.nextLine();
		System.out.println("Enter user's city");
		String place = sc.nextLine();
		System.out.println("Enter user's state");
		String st = sc.nextLine();
		System.out.println("Enter user's zip");
		int postal = sc.nextInt();
		System.out.println("Enter user's phone number");
		int ph_no = sc.nextInt();
		
		Person_info p = new Person_info(fn, ln, add, place, st, postal, ph_no);
		
		//Calling function to add user details into the array list
		persons.add(p);
	}
	
	public void modify_user(String name) {
		//count to check if the name given by the user matches existing records
		int count=0;
		for(int i=0 ; i<persons.size() ; i++) {
			Person_info p = (Person_info)persons.get(i);
			if(name.equals(p.first_name)) {
				persons.remove(i);
				add_user();
				count=1;
			}
		}
		if(count==0) {
			System.out.println("The name doesn't exist");
		}
	}
	
	public void delete_user(String name) {
		//count to check if the name provided by the user matches existing records
		int count=0;
		for(int i=0 ; i<persons.size() ; i++) {
			Person_info p = (Person_info)persons.get(i);
			if(name.equals(p.first_name)) {
				persons.remove(i);
				count=1;
			}
		}	
		if(count==0) {
			System.out.println("The name doesn't exist");
		}
	}
	
	public void print_users() {
		if(persons.size()==0)
			System.out.println("There are no users in the address book");
		else
			for(int i=0 ; i<persons.size() ; i++) {
				System.out.println("\nUser "+(i+1)+" details are:");
				Person_info p = (Person_info)persons.get(i);
				p.print_detail();
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//object "add" created of the class Address_book
		Address_book add = new Address_book();
		int res=0;
		
		Scanner sc = new Scanner(System.in);
		
		while(res!=4) {
			
			System.out.println("Enter 1 to add new user, 2 to modify, 3 to delete and 4 to exit the program");
			//res to check the output of the user to perform the following functions (add,modify,delete and exit)
			res=sc.nextInt();
			switch (res) {
			case 1:
				add.add_user();				
				break;
			case 2:
				System.out.println("\nEnter the first name of the user you want to modify");
				String name = sc.next();
				add.modify_user(name);			
				break;
			case 3:
				System.out.println("\nEnter the first name of the user you want to delete");
				String fn = sc.next();
				add.delete_user(fn);
			default:
				break;
			}
		}
		//printing the details in the address book
		System.out.println("\nThe Address book details are:");
		add.print_users();		
	}
}