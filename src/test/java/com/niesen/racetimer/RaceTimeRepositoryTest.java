package com.niesen.racetimer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RaceTimeRepositoryTest {

    @Autowired
    private RaceTimeRepository raceTimeRepository;

    @Test
    public void testSave() {
        int racerId = 1;
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Long time = Long.valueOf(40);

        RaceTime raceTime = new RaceTime(racerId, timestamp, time);
        raceTimeRepository.save(raceTime);

        assertEquals(raceTime, raceTimeRepository.findOne(new RaceTime.RaceTimeKey(racerId, timestamp)));
    }
}
