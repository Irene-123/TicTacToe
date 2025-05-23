package model;

public enum GenderEnum {

    MALE("M"), FEMALE("F");

    private String value; 
    private GenderEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
