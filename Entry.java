package org.example.tpo7;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;

public class Entry implements Serializable {
    private String id;
    private String original;
    private String formatted;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;

    public Entry(String id, String original, String formatted, Duration duration){
        this.id = id;
        this.original = original;
        this.formatted = formatted;
        this.creationDate = LocalDateTime.now();
        this.expirationDate = this.creationDate.plus(duration);
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

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }
}
