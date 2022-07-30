package for_birthday_database;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable, Comparable<Person>{

	private Name name;
	private Date birthday;
	private static int numPeople = 0;
	
	public Person(Name theName, Date theBirthday)
	{
		numPeople++; 
		name = theName;
		birthday = theBirthday;
	}
	
	public Person(String theFirst, String theLast, Month theMonth, int theDay, int theYear)
	{
		name = new Name(theFirst, theLast);
		birthday = new Date(theMonth, theDay, theYear);
		numPeople++;
	}
	
	

	public int getNumPpl()
	{
		return numPeople;
	}
	
	public Date getDate()
	{
		return birthday;
	}
	
	public Name getName()
	{
		return name.clone(); 
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthday, name);
	}


	@Override
	public boolean equals(Object obj)
	{
		Person p2 = (Person)obj;
		if(this.getName().equals(p2.getName()) && this.getDate().equals(p2.getDate()))
		{
			return true;
		}else
		{
			return false;
		}
	}

	
	@Override
	public String toString()
	{
		return "This person's name is: " + name + ", their bday: " + birthday + ". ";
	}

	//Trying to compare ppl alpha
	@Override
	public int compareTo(Person o) {
		
		if(this.getName().getLast().equals(o.getName().getLast())) {
			return this.getName().getFirst().compareTo(o.getName().getFirst());
		}
		return this.getName().getLast().compareTo(o.getName().getLast());
		
	}
	

	
}
