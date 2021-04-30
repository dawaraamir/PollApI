package com.dawar.pollapi.repository;

import com.dawar.pollapi.domain.Option;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepo extends CrudRepository<Option, Long> {
}
