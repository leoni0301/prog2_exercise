
public class Person implements Comparable<Person> {

  private Name name;
  private MyDate birthday;

  public Person(Name name, MyDate birthday) {
    this.name = name;
    this.birthday = birthday;
  }

  public Name getName() {
    return this.name;
  }

  public void setName(Name name) {
    this.name = name;
  }

  public MyDate getBirthday() {
    return this.birthday;
  }

  public void setBirthday(MyDate birthday) {
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return String.format("Name: %-40sBirthday: %s", this.name, this.birthday);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.birthday == null) ? 0 : this.birthday.hashCode());
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
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
    if (this.birthday == null) {
      if (other.birthday != null)
        return false;
    } else if (!this.birthday.equals(other.birthday))
      return false;
    if (this.name == null) {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    return true;
  }

  @Override
  public int compareTo(Person other) {
    Name thisName = this.name;
    Name otherName = other.getName();
    int nameComp = thisName.compareTo(otherName);
    if (nameComp != 0) {
      return nameComp;
    }
    MyDate thisBirth = this.birthday;
    MyDate otherBirt = other.getBirthday();
    return thisBirth.compareTo(otherBirt);
  }


}

