package com.dawar.pollapi.dto;

import java.util.Collection;

public class VoteResult {
    private int totalValues;
    private Collection<OptionCount> results;
    public int getTotalValues() {
        return totalValues;
    }
    public void setTotalValues(int totalValues) {
        this.totalValues = totalValues;
    }
    public Collection<OptionCount> getResults() {
        return results;
    }
    public void setResults(Collection<OptionCount> results) {
        this.results = results;
    }
    public void settotalVotes(int totalVotes) {
    }
}
