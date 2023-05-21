package com.project17;

public class Main {
    public static void main(String[] args) {
        Canditate canditate1, canditate2;
        canditate1 = new Canditate("01027048537", "Rati Kvariani", Gender.MALE) {
            @Override
            public String makeStatement() {
                return "I, Rati Kvariani, will make our country great again";
            }
        };

        canditate2 = new Canditate("01027048538", "Georgi Koplani", Gender.MALE) {
            @Override
            public String makeStatement() {
                return "I, Rati Kvariani, will make our country great again better";
            }
        };

        System.out.println(canditate1.makeStatement());
        System.out.println(canditate2.makeStatement());


        Voter[] voter1 =
                {
                        new Voter("213663464654", "voter 1", Gender.MALE),
                        new Voter("213663464654", "voter 2", Gender.MALE),
                        new Voter("213663464654", "voter 3", Gender.MALE),
                        new Voter("213663464654", "voter 4", Gender.MALE),
                        new Voter("213663464654", "voter 5", Gender.MALE),
                };

        Voter[] voter2 =
                {
                        new Voter("213663464655", "voter 6", Gender.MALE),
                        new Voter("213663464655", "voter 7", Gender.MALE),
                        new Voter("213663464655", "voter 8", Gender.MALE),

                };


        Vote[] votes = {
                new Vote(voter1[0], canditate1),
/*                new Vote(voter1[1], canditate1),
                new Vote(voter1[2], canditate1),
                new Vote(voter1[3], canditate1),
                new Vote(voter1[4], canditate1),*/

                new Vote(voter2[0], canditate2),
                new Vote(voter2[1], canditate2),
                new Vote(voter2[2], canditate2)
        };

        Vote.Calculator calculator = new Vote.Calculator();
        System.out.println("The winner is " +  calculator.revealWinner(votes));
    }
}