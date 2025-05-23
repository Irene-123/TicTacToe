package model;

public class Player {
    
    PersonalDetails personalDetails;
    String symbol;

    public Player(PersonalDetails personalDetails, String symbol) {
        this.personalDetails = personalDetails;
        this.symbol = symbol;
    }
    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }
    public void setPersonalDetails(PersonalDetails personalDetails) {
        this.personalDetails = personalDetails;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
