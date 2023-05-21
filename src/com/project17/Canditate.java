package com.project17;

public abstract  class Canditate extends Person{
    public Canditate(String pid, String name, Gender gender) {
        super(pid, name, gender);
    }

    public abstract String makeStatement();
}
