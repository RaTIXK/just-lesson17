package com.project17;

import java.util.Objects;

public abstract  class Person {
        protected String pid;
        protected String name;
        protected Gender gender;
        protected boolean isDead;

        public Person() {
        }

        public Person(String pid, String name, Gender gender) {
                this.pid = pid;
                this.name = name;
                this.gender = gender;
        }


        public String getPid() {
                return pid;
        }

        public void setPid(String pid) {
                this.pid = pid;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Gender getGender() {
                return gender;
        }

        public void setGender(Gender gender) {
                this.gender = gender;
        }

        public boolean isDead() {
                return isDead;
        }

        public void setIsDead(boolean dead) {
                this.isDead = dead;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return isDead == person.isDead && Objects.equals(pid, person.pid) && Objects.equals(name, person.name) && gender == person.gender;
        }

        @Override
        public int hashCode() {
                return Objects.hash(pid, name, gender, isDead);
        }

        @Override
        public String toString() {
                return "Person{" +
                        "pid='" + pid + '\'' +
                        ", name='" + name + '\'' +
                        ", gender=" + gender +
                        ", dead=" + isDead +
                        '}';
        }
}
