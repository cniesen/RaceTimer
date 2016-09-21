package com.niesen.racetimer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;

@RestController
public class TimerController {

    Timers timers = new Timers();

    @Autowired
    private RaceTimeRepository raceTimeRepository;

    @RequestMapping(value = "/api/timer/{racerId}/start", method = RequestMethod.GET)
    public ResponseEntity timerStart(@PathVariable int racerId, @RequestParam("token") String token) {
        RestSecurity.checkToken(token);

        timers.startTimer(racerId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/api/timer/{racerId}/cancel", method = RequestMethod.GET)
    public ResponseEntity timerCancel(@PathVariable int racerId, @RequestParam("token") String token) {
        RestSecurity.checkToken(token);

        timers.cancelTimer(racerId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Transactional
    @RequestMapping(value = "/api/timer/{racerId}/stop", method = RequestMethod.GET)
    public Long timerStop(@PathVariable int racerId, @RequestParam("token") String token) {
        RestSecurity.checkToken(token);

        Long time = timers.stopTimer(racerId);
        if (time != null) {
            RaceTime raceTime = new RaceTime(racerId, new Timestamp(new Date().getTime()), time);
            raceTimeRepository.save(raceTime);
        }
        return time;
    }

    @RequestMapping(value = "/api/timer", method = RequestMethod.GET)
    public ResponseEntity racesInProgress(@RequestParam("token") String token) {
        RestSecurity.checkToken(token);

        return new ResponseEntity(HttpStatus.OK);
    }

}
