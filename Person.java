public class Person implements Comparable
{
	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final Identity DEFAULT_STORY =  new Identity("Unknown", "Unknown");
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name; 
	private Identity story;
	private int privilege;

	// CONSTRUCTORS	
	public Person(String name, Identity story, int privilege) {
		this.setAll(name, story, privilege);
	}
		
	public Person() {
		this(DEFAULT_NAME, DEFAULT_STORY, DEFAULT_PRIVILEGE);
	}
	
	public Person(Person original) {
		if(original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setAll(original.name, original.story, original.privilege);
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setStory(Identity story) {
		this.story = story;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setAll(String name, Identity story, int privilege) {
		this.setPrivilege(privilege);
		this.setName(name);
		this.setStory(story);
	}

	// ACCESSORS / GETTERS
	public String getName() {
		return this.name;
	}
		
	public Identity getStory() {
		return this.story;
	}

	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	@Override
	public String toString()
	{
		return "My name is "+ this.name + " and "+ this.story + "\n"
				+ "According to this calculator I ended up with "+ this.privilege + " estimated privilege points";
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if (other == null || (!(other instanceof Person))) 
		{
		    return false;
		}
		
		Person otherPerson = (Person) other;
		return this.name.equals(otherPerson.name) && this.story.equals(otherPerson.story) &&
			this.privilege == otherPerson.privilege;	
	}

	// INTERFACE METHODS
	@Override
	public int compareTo(Object o)
	{
		if(o == null || (!(o instanceof Person)))
		{
			throw new IllegalArgumentException("Calling object is not an instance of a Person class.");
		}

		Person other = (Person) o;
		int result = -2;

		if (this.privilege < other.privilege)
		{
			result = -1; //-1 = first object is less than second object
		}
		else if(this.privilege == other.privilege)
		{
			result = 0; //0 = objects are equal
		}
		else if(this.privilege > other.privilege)
		{
			result = 1; //1 = second object is less than first object
		}

		return result;
	}

}