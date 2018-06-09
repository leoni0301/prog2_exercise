import java.util.ArrayList;
import java.util.Collections;


public class Name implements Comparable<Name>{

		private String firstName;
		private String lastName;
		private String middleName;
		
		public Name(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public Name(String firstName, String middleName, String lastName) {
			this(firstName, lastName);
			this.middleName = middleName;
		}
		
		public String getFirstName() {
			return firstName;
		}
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public String getLastName() {
			return lastName;
		}
		
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public String getMiddleName() {
			return middleName;
		}
		
		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}
		
		@Override
		public String toString() {
			if (middleName == null) {
				return firstName + " " + lastName;
			} else {
				return firstName + " " + middleName + " " + lastName;
			}
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Name other = (Name) obj;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (middleName == null) {
				if (other.middleName != null)
					return false;
			} else if (!middleName.equals(other.middleName))
				return false;
			return true;
		}
		
		@Override
		public int compareTo(Name other) {
			String thisLast = lastName;
			String otherLast = other.getLastName();
			int lastComp = thisLast.compareTo(otherLast);
			if (lastComp != 0) {
				return lastComp;
			}
			String thisFirst;
			String otherFirst;
			if (middleName != null) {
				thisFirst = firstName+middleName;
			}else {
				thisFirst = firstName;
			}
			if (other.getMiddleName() != null) {
				otherFirst = other.getFirstName() + other.getMiddleName();
			}else {
				otherFirst = other.getFirstName();
			}
			return thisFirst.compareTo(otherFirst);
		}
		
		
		public static void main(String[] args) {
			Name n1 = new Name("Simon", "Busch");
			Name n2 = new Name("Small", "Test", "Dummy");
			Name n3 = new Name("Great", "Test", "Dummy");
			System.out.println(n1.toString());
			System.out.println(n2.toString());
			System.out.println(n3.toString());
			System.out.println(n2.equals(n3));
			ArrayList<Name> names = new ArrayList<Name>();
			names.add(n1);
			names.add(n2);
			names.add(n3);
			System.out.println(names);
			Collections.sort(names);
			System.out.println(names);
		}
}
