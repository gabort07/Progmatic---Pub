package company.Comparatorok.Artist;

import java.util.ArrayList;

public class AwardedArtist extends Awards {
    private String personName;
    private ArrayList<String> profession;

    public AwardedArtist(String personName, ArrayList<String> profession) {
        this.personName = personName;
        this.profession = profession;
    }

    public AwardedArtist(String personName, ArrayList<String> profession, String awardName, int year){
        this.personName= personName;
        this.profession = profession;
        super.setAwardedIn(year);
        super.setAwardName(awardName);
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public ArrayList<String> getProfession() {
        return profession;
    }

    public void setProfession(ArrayList<String> profession) {
        this.profession = profession;
    }

}
