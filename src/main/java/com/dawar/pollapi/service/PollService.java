package com.dawar.pollapi.service;

import com.dawar.pollapi.domain.Poll;
import com.dawar.pollapi.exception.ResourceNotFoundException;
import com.dawar.pollapi.repository.PollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PollService {

    @Autowired
    PollRepo pollRepository;

    public void verifyPoll(Long pollId) throws ResourceNotFoundException {
        Optional<Poll> poll = pollRepository.findById(pollId);
        if (pollRepository.existsById(pollId) == false) {
            throw new ResourceNotFoundException("Poll with id " + pollId + " not found");
        }
    }

    public void getAllPolls() {
        Iterable<Poll> allPolls = pollRepository.findAll();
    }

    public void createPoll( Poll poll) {
        pollRepository.save(poll);
    }

    public void getPoll(Long pollId) {
        pollRepository.findById(pollId);
        verifyPoll(pollId);
    }

    public void updatePoll(Poll poll, Long pollId) {
        // Save the entity
        verifyPoll(pollId);
        pollRepository.save(poll);
    }

    public void deletePoll(Long pollId) {
        verifyPoll(pollId);
        pollRepository.deleteById(pollId);
    }
}
