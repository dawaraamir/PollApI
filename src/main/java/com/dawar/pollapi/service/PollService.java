package com.dawar.pollapi.service;

import com.dawar.pollapi.domain.Poll;
import com.dawar.pollapi.repository.PollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PollService {

    @Autowired
    PollRepo pollRepository;


    public void getAllPolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();
    }

    public void createPoll( Poll poll) {
        pollRepository.save(poll);
    }

    public Optional<Poll> getPoll(Long pollId) {
        return pollRepository.findById(pollId);
    }

    public void updatePoll(Poll poll, Long pollId) {
        // Save the entity
        pollRepository.save(poll);
    }

    public void deletePoll(Long pollId) {
        pollRepository.deleteById(pollId);
    }
}
