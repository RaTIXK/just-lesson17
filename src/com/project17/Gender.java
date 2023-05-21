package com.project17;

public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private String readableName;

    Gender(String readableName) {
        this.readableName = readableName;
    }

    public String getReadableName() {
        return readableName;
    }
}
