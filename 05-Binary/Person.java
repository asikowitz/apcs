public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
	this.name = name;
	this.age = age;
    }

    public String getName() {
	return name;
    }
    
    public Integer getAge() {
	return age;
    }

    /*public int compareTo(Person other) {
	return this.getAge().compareTo(other.getAge());
	}*/

    public int compareTo(Person other) {
	return this.getName().compareTo(other.getName());
    }

    public String toString() {
	return name + " : " + age;
    }
}
