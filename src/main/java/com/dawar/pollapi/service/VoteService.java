package com.dawar.pollapi.service;

import com.dawar.pollapi.domain.Vote;
import com.dawar.pollapi.repository.VoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    @Autowired
    VoteRepo voteRepository;

    public void createVote (Long pollId, Vote vote) {
        voteRepository.save(vote);
    }

    public Iterable<Vote> getAllVotes(Long pollId) {
        return voteRepository.findByPoll(pollId);
    }
}
