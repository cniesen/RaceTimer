package com.niesen.racetimer;

import org.springframework.data.repository.CrudRepository;

public interface RaceTimeRepository extends CrudRepository<RaceTime, RaceTime.RaceTimeKey> {
}
