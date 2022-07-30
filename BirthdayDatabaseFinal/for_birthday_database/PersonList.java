package for_birthday_database;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class PersonList implements Serializable{

	ArrayList<Person> list = new ArrayList<Person>();
	
	public boolean add(Person p)
	{
		if(list.contains(p))
		{
			return false;
		} else
		{
			list.add(p);
			return true;
		}
	}
	
	public Person search(Person p)
	{
		if(list.contains(p))
		{
			return p;
		}
		else {
			return null;
		}
	}
	
	
	
	public String saveToFile(String fileName) {
		String messageFromSave = "";
		try {
		ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(fileName));
		for(int i = 0; i < list.size(); i++) {
		oOS.writeObject(list.get(i));
		}
		oOS.flush();
		oOS.close();
		}catch(Exception e) {
		messageFromSave = e.toString();
		}
		return messageFromSave;
		}

		public String loadFromFile(String fileName) {
		String toReturn = "";
		try{
		ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(fileName));
		while(true) {
		Person fromFile = (Person)(oIS.readObject());
		Person found = search(fromFile);
		if(found == null) {
		if(add(fromFile)) {
		toReturn += fromFile + "\n";
		}else {
		toReturn += fromFile + " not successfully added to DB.\n";
		}
		}else {
		toReturn += found + " already in the DB.\n";
		}
		}
		}catch (EOFException eOF){
		}
		catch(Exception e) {
		toReturn += e;
		}
		return toReturn;
		}
	
	
	public boolean delete(Name n)
	{
		Iterator<Person> iter = list.iterator();
		while(iter.hasNext())
		{
			if(iter.next().getName().equals(n))
			{
				iter.remove();
				return true;
			}
		}
		return false;
	}
	

	public String hasBirthdayOn(Date date)
	{
		for(int i = 0; i<list.size(); i++)
		{
			if(list.get(i).getDate().equals( date))
			{
				return list.get(i).toString();
			}
		}
		return "Nobody has that birthday";//get error
	}
	
	
	public String printList()
	{
		String toReturn = "";
		for(int i = 0; i<list.size(); i++)
		{
			toReturn += list.get(i) + "\n";
		}
		return toReturn;
	}
	
	
	

	public String sortAlphab()
	{
		Collections.sort(list);
		return printList(); 
	}
	

	public String sortChronol() 
	{
		Collections.sort(list, new ChronComparator());
		return printList();
	}
	
	
	public String findPersonByName(Name name)
	{
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getName().equals(name))
			{
				return name.toString(); 
			}
		}
		return "Not found";
	}
	

	
}
