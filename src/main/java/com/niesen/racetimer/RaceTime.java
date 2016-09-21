package com.niesen.racetimer;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "race_time")
public class RaceTime implements Serializable {

    private static final long serialVersionUID = -2160824349426154465L;

    @EmbeddedId
    private RaceTimeKey key;

    @Column
    private Long time;

    public RaceTime() {
    }

    public RaceTime(Integer racerId, Timestamp timestamp, Long time) {
        this.key = new RaceTimeKey(racerId, timestamp);
        this.time = time;
    }

    public Integer getRacerId() {
        if (key == null) {
            return null;
        } else {
            return key.getRacerId();
        }
    }

    public void setRacerId(Integer racerId) {
        if (key == null) {
            key = new RaceTimeKey();
        }
        key.setRacerId(racerId);
    }

    public Timestamp getTimestamp() {
        if (key == null) {
            return null;
        } else {
            return key.getTimestamp();
        }
    }

    public void setTimestamp(Timestamp timestamp) {
        if (key == null) {
            key = new RaceTimeKey();
        }
        key.setTimestamp(timestamp);
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RaceTime raceTime = (RaceTime) o;
        return Objects.equals(key, raceTime.key) &&
                Objects.equals(time, raceTime.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, time);
    }

    @Override
    public String toString() {
        return "RaceTime{" +
                "key=" + key +
                ", time=" + time +
                '}';
    }

    @Embeddable
    public static class RaceTimeKey implements Serializable {

        private static final long serialVersionUID = -1352313055081821264L;

        @Column
        private Integer racerId;

        @Column
        private Timestamp timestamp;

        public RaceTimeKey() {
            this(null, null);
        }

        public RaceTimeKey(Integer racerId, Timestamp timestamp) {
            this.racerId = racerId;
            this.timestamp = timestamp;
        }

        public Integer getRacerId() {
            return racerId;
        }

        public void setRacerId(Integer racerId) {
            this.racerId = racerId;
        }

        public Timestamp getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RaceTimeKey that = (RaceTimeKey) o;
            return Objects.equals(racerId, that.racerId) &&
                    Objects.equals(timestamp, that.timestamp);
        }

        @Override
        public int hashCode() {
            return Objects.hash(racerId, timestamp);
        }

        @Override
        public String toString() {
            return "RaceTimeKey{" +
                    "racerId=" + racerId +
                    ", timestamp=" + timestamp +
                    '}';
        }
    }
}

