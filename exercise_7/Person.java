
public class Person implements Comparable<Person>{

	private Name name;
	private MyDate birthday;
	
	public Person(Name name, MyDate birthday) {
		this.name = name;
		this.birthday = birthday;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public MyDate getBirthday() {
		return birthday;
	}

	public void setBirthday(MyDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return String.format("Name: %-40sBirthday: %s", name, birthday);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override 
	public int compareTo(Person other) {
		Name thisName = name;
		Name otherName = other.getName();
		int nameComp = thisName.compareTo(otherName);
		if (nameComp != 0) {
			return nameComp;
		}
		MyDate thisBirth = birthday;
		MyDate otherBirt = other.getBirthday();
		return thisBirth.compareTo(otherBirt);
	}


}

