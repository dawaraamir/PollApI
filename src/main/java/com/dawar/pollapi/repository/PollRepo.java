package com.dawar.pollapi.repository;

import com.dawar.pollapi.domain.Poll;
import org.springframework.data.repository.CrudRepository;

public interface PollRepo extends CrudRepository <Poll, Long> {
}
