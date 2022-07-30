package for_birthday_database;

import java.util.Comparator;

public class ChronComparator implements Comparator<Person> {

	public int compare(Person p1, Person p2)
	{
		Date date1 = p1.getDate();
		Date date2 = p2.getDate();
		
		if(date1.getYear() == date2.getYear())
		{
			if(date1.getMonth().getNum() == date2.getMonth().getNum())
			{
				if(date1.getDay() == date2.getDay())
				{
					return 0;
				}else {
					return Integer.compare(date1.getDay(), date2.getDay());
				}
			}else {
				return Integer.compare(date1.getMonth().getNum(), date2.getMonth().getNum());
			}
		}else {
			return Integer.compare(date1.getYear(), date2.getYear());
		}
//
	}

	
}
