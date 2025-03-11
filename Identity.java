public class Identity
{
    private String pronouns;
    private String background;

    public Identity(String pronouns, String background)
    {
        this.pronouns = pronouns;
        this.background = background;
    }

    public Identity()
    {
        this.pronouns = null;
        this.background = null;
    }

    public String toString()
    {
        return "Pronouns: " + this.pronouns + ", Background: " + this.background;
    }

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