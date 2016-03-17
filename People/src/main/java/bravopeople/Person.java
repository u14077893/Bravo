package bravopeople;/*
	Author: Mpho Baloyi 
	Student Number: 14133670
	Group Name: Bravo-People
	
	This file defines the Person Class for the Researcher Support System (RSS).
	The class defines the attributes of the user of the system.	
*/

import java.util.LinkedList;

class Person 
{
	private String Name;
	private String Surname;
	private String ID;
	private String email_address;
	private LinkedList<Organisation> organisations;  //Person can belong to 0 or more organisations
	
	//Default contructor with dummy data
	Person()
	{
		Name ="Name";
		Surname = "Surname";
		ID= "00000000000";
		email_address = "email@domain.com";
		organisations = new LinkedList<Organisation>();
	}
	
	Person(String name,String surname,String id,String email)
	{
		setName(name);
		setSurname(surname);
		setEmail(email);
		setID(id);
	}
	
	//Set Functions
	
	public void setName(String name)
	{
		Name = name;
	}
	
	public void setSurname(String surname)
	{
		Surname = surname;
	}
	
	public void setID(String id)
	{
		ID = id;
	}
	
	public void setEmail(String email)
	{
        email_address = email;
	}
	
	//get Functions
	
	public String getName()
	{
		return Name;
	}
	
	public String getSurname()
	{
		return Surname;
	}
	
	public String getID()
	{
		return ID;
	}
	
	String getEmail()
	{
		return email_address;
	}
}