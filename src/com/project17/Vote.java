package com.project17;

import javax.swing.*;
import java.util.Objects;

public class Vote {

    private Voter voter;
    private Canditate candidate;

    public Vote(Voter voter, Canditate candidate) {
        this.voter = voter;
        this.candidate = candidate;
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public Canditate getCandidate() {
        return candidate;
    }

    public void setCandidate(Canditate candidate) {
        this.candidate = candidate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote vote = (Vote) o;
        return Objects.equals(voter, vote.voter) && Objects.equals(candidate, vote.candidate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(voter, candidate);
    }


    @Override
    public String toString() {
        return "Vote{" +
                "voter=" + voter +
                ", candidate=" + candidate +
                '}';
    }

    public static class Calculator {

        public Canditate revealWinner(Vote[] votes) {
            // გაირბინე vote მასივი, გამოტოვე მკვდრები,  მეპში გასაღებ "კანდიდატზე" მმიანიჭე ერთი ხმა.
            // "გასაღები" => "მნიშვნელობა".

            // Determinate number of unique candidates

            int uniqueCandidates = 0;
            String pids = "";
            for (Vote vote : votes) {
                if (vote.getVoter().isDead()) {
                    continue;
                }
                final String candidatePid = vote.getCandidate().getPid();
                if (!pids.contains(candidatePid)) {
                    uniqueCandidates += 1;
                    pids += candidatePid;
                }
            }
            Object[][] map = new Object[uniqueCandidates][2];

            // Fill entries with PIDs and zero votes.
            uniqueCandidates = 0;
            pids = "";
            for (Vote vote : votes) {
                if (vote.getVoter().isDead()) {
                    continue;
                }
                final Canditate candidate = vote.getCandidate();
                if (!pids.contains(candidate.getPid())) {
                    map[uniqueCandidates][0] = candidate;
                    map[uniqueCandidates][1] = 0;
                    uniqueCandidates += 1;
                    pids += candidate.getPid();
                }
            }


            // calculate all votes
            for (Vote vote : votes) {
                if (vote.getVoter().isDead()) {
                    continue;
                }

                // find candidate in map.
                for (int i = 0; i < map.length; i++) {
                    Object[] entry = map[i];
                    if (entry[0].equals(vote.getCandidate())) {
                        entry[1] = (Integer) entry[1] + 1;
                    }
                    ;
                }
            }

            //Find max voted candidate

            Canditate maxVotedCandidate = null;
            int maxVotdCandidateVotes = 0;
            for (Vote vote : votes) {

                for (int i = 0; i < map.length; i++) {
                    final Object[] entry = map[i];
                    if ((int) entry[1] > maxVotdCandidateVotes) {
                        maxVotedCandidate = (Canditate) entry[0];
                        maxVotdCandidateVotes = (int) entry[1];

                    }

                }

            }
            return maxVotedCandidate;

        }

    }

}

