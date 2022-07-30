package for_birthday_database;

import java.util.ArrayList;
import java.util.Objects;
import java.io.EOFException;
import java.io.Serializable;

//implements Serializable to mmake it allowed to do that
public class Date implements Serializable{
		
		private Month month;
		private int day;
		private int year;
		
		public Date(Month theMonth, int theDay, int theYear) throws IllegalArgumentException{
			//if the month and day not valid, throw exception
			if(!isValidDay(theMonth, theDay)) {
				throw new IllegalArgumentException(theDay + " is a bad day for " + theMonth.getName() + "!");
			}
			//If the year is negative, throw exception
			if(theYear <= 0) {
				throw new IllegalArgumentException("Year cannot be negative!");
			}
			//setting variables
			month = theMonth;
			day = theDay;
			year = theYear;
		}
		
		private boolean isValidDay(Month theMonth, int theDay) {
			int d = theMonth.getDay();
			return (theDay > 0 && theDay <= d);
		}
		
		public Month getMonth(){
			return month;
		}

		public int getDay(){
			return day;
		}

		public int getYear(){
			return year;
		}
		

		public void setMonth(Month theMonth){
			if(isValidDay(theMonth, day)){
				month = theMonth;
			}else{
				System.out.println(theMonth + " " + day + " is not a valid date.");
			}
		}


		public void setDay(int theDay){
			if(isValidDay(month, theDay)){
				day = theDay;
			}else{
				System.out.println(theDay + " is not a valid day in " + month.getName() + ".");
			}
		}


		public void setYear(int theYear){
			if(theYear < 0){
				System.out.println("The year cannot be a negative number.");
			} else{
				year = theYear;
			}
		}
	
		
		@Override 
		public boolean equals(Object o) 
		{
			//Date d2 object = casted argument object o
			Date d2 = (Date)o;
			//d2 is the 2nd object being compared
			if(this.getMonth().getNum() == d2.getMonth().getNum() && getDay() == d2.getDay() && getYear() == d2.getYear())
			{
				return true;
			}
			return false;
		}
		
		
		@Override
		public int hashCode() {
			return Objects.hash(day, month, year);
		}
		
		
		@Override
		public Date clone()
		{
			//creating copy of Date reference
			return new Date(this.getMonth(), this.getDay(), this.getYear()); 
		}
		
		@Override
		public String toString(){
			return month.getName() + " " + day + ", " + year;
		}
		

	
	
		
				
}
