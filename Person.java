public class Person implements Comparable
{
	private class Identity {
		private String pronouns, background;
		
		public Identity(String pronouns, String background)
		{
			this.pronouns = pronouns;
			this.background = background;
		}

		public Identity()
		{
			this(Person.DEFAULT_PRONOUNS, Person.DEFAULT_BACKGROUND);
		}
		@Override
		public String toString()
		{
			return "Pronouns: " + this.pronouns + ", Background: " + this.background;
		}
		@Override
		public boolean equals(Object other)
		{
			if(other == null)
			{
				return false;
			}
			else if(!(other instanceof Identity))
			{
				return false;
			}
			else
			{
				Identity o = (Identity) other;
				return this.pronouns.equals(o.pronouns) && this.background.equals(o.background);
			}
		}
	}
	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final String DEFAULT_PRONOUNS = "they/them/their";
	public static final String DEFAULT_BACKGROUND = "I am from Washington.";
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name; 
	private Identity story = new Identity();
	private int privilege;

	// CONSTRUCTORS	
	public Person(String name, String pronouns, String background, int privilege) {
		this.setAll(name, pronouns, background, privilege);
	}
		
	public Person() {
		this(Person.DEFAULT_NAME, Person.DEFAULT_PRONOUNS, Person.DEFAULT_BACKGROUND, Person.DEFAULT_PRIVILEGE);
	}
	
	public Person(Person original) {
		if(original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setAll(original.name, original.story.pronouns, original.story.background, original.privilege);
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {
		this.name = name;
	}

	public void setPronouns(String pronouns)
	{
		this.story.pronouns = pronouns;
	}

	public void setBackground(String background)
	{
		this.story.background = background;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setAll(String name, String pronouns, String background, int privilege) {
		this.setPrivilege(privilege);
		this.setName(name);
		this.setPronouns(pronouns);
		this.setBackground(background);
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
		return "My name is "+ this.name + ", my pronouns are "+ this.story.pronouns + ", and " + this.story.background + "\n"
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