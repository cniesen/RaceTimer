package com.niesen.racetimer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {

    @Autowired
    private RaceTimeRepository raceTimeRepository;

    @RequestMapping(value = "/api/times", method = RequestMethod.GET)
    public Iterable<RaceTime> raceTimes() {
        return raceTimeRepository.findAll();
    }
}
