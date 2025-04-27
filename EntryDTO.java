package org.example.tpo7;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

public class EntryDTO {
    private String id;
    private String original;
    private long duration;

    public EntryDTO(String id, String original, long duration){
        this.id = id;
        this.original = original;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
