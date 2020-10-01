
public class PhD extends Graduate{
    private String dissertationTopic;

    public PhD(String name, LocalDate dob, String dissertationTopic){
        super(name,dob);
        this.dissertationTopic = dissertationTopic;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString() + " PhD Student.");
        sb.append(String.format(" - dissertation is about %s", this.getDissertationTopic()));
        return sb.toString();
    }
    @Override
    public String getStanding(){
        return "edu.ucdenver.university.PhD";
    }
    public String getDissertationTopic(){
        return dissertationTopic;

    }
}
