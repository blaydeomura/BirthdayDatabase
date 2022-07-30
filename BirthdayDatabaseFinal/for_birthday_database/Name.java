package for_birthday_database;

import java.io.Serializable;
import java.util.Objects;


public class Name implements Serializable{
	

	private String first;
	private String middle; 
	private String last;
	
	
	public Name(String theFirst, String theMiddle, String theLast) {
		first = theFirst;
		middle = theMiddle;
		last = theLast;
	}
	
	public Name(String theFirst, String theLast) {
		first = theFirst;
		middle = "";
		last = theLast;
	}
	
	public String getFirst() {
		return first;
	}
	
	public String getMiddle() {
		return middle;
	}
	
	public String getLast() {
		return last;
	}
	
	public void setFirst(String theNewFirst) {
		first = theNewFirst;
	}
	
	
	public void setMiddle(String theNewMiddle) {
		middle = theNewMiddle;
	}
	
	public void setLast(String theNewLast) {
		last = theNewLast;
	}
	
	public String toString() {
		if(middle.isEmpty()) {
			return first + " " + last;
		}else {
			return first + " " + middle + " " + last;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(first, last, middle);
	}


	
	@Override
	public boolean equals(Object obj)
	{
		Name n2 = (Name)obj;
		if(this.getFirst().equals(n2.getFirst()) && getLast().equals(n2.getLast()))
		{
			return true;
		}else {
			return false;
		}
	}
	
	//new object with same values
	@Override
	public Name clone()
	{
		return new Name(this.getFirst(), this.getMiddle(), this.getLast());
	}

	
	
	
}