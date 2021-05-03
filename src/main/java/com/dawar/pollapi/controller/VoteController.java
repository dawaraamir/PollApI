package com.dawar.pollapi.controller;

import com.dawar.pollapi.domain.Vote;
import com.dawar.pollapi.repository.VoteRepo;
import com.dawar.pollapi.service.PollService;
import com.dawar.pollapi.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class VoteController {
    @Autowired
    private VoteService voteService;
    @Autowired
    private VoteRepo voteRepo;
    @Autowired
    private PollService pollService;

    @RequestMapping(value = "/polls/{pollId}/votes", method = RequestMethod.POST)
    public ResponseEntity<?> createVote (@PathVariable Long pollId, @RequestBody Vote vote) {
        pollService.verifyPoll(pollId);
        voteService.createVote(pollId, vote);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vote.getId()).toUri());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/polls/votes/{voteId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteVote(@PathVariable Long voteId, @RequestBody Vote vote){
        voteService.deleteVote(voteId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/polls/{pollId}/votes", method=RequestMethod.GET)
    public Iterable<Vote> getAllVotes(@PathVariable Long pollId) {
        pollService.verifyPoll(pollId);
        return voteService.getAllVotes(pollId);
    }

}
