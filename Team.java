public class Team {
    private String name;
    private String confrence;
    private String division;

    public Team(String name,String confrence, String division)
    {
        this.name = name;
        this.confrence = confrence;
        this.division = division;
    }

    public String getName()
    {
        return name;
    }

    public String getConfrence()
    {
        return confrence;
    }

    public String getDivision()
    {
        return division; 
    }

    public boolean equals(Team other)
    {
        if(name.equals(other.name))
        {
            return true;
        }
        return false;
    }
}
