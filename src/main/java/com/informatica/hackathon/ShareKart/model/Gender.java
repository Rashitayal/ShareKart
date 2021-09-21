package com.informatica.hackathon.ShareKart.model;

public enum Gender {

    F("female"),
    M("male");

    public String value;

    private Gender(String value) {
        this.value = value;
    }

    public static String valueOfLabel(String label) {
        for (Gender e : values()) {
            if (e.value.equals(label)) {
                return e.name();
            }
        }
        return null;
    }
}
