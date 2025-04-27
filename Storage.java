package org.example.tpo7;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class Storage {
    private ConcurrentHashMap<String, Entry> storage = new ConcurrentHashMap<>();
    //decided to use HashMap here - i think it's one of the easiest options to retrieve data from and decided against h2 database for simplicity
    public boolean save(Entry entry){
        if(storage.containsKey(entry.getId()))
            return false;

        storage.put(entry.getId(), entry);
        return true;
    }

    public Collection<Entry> getAllEntries() {
        return storage.values();
    }

    @Scheduled(fixedRate = 60000)
    public void removeExpired() {
        LocalDateTime now = LocalDateTime.now();
        storage.entrySet().removeIf(entry ->
                entry.getValue().getExpirationDate().isBefore(now) ||
                        entry.getValue().getExpirationDate().isEqual(now)
        );
    }

}

