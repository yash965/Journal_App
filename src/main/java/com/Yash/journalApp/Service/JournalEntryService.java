package com.Yash.journalApp.Service;

import java.time.LocalDateTime;
import java.util.*;
import com.Yash.journalApp.Entity.JournalEntry;
import com.Yash.journalApp.Entity.User;
import com.Yash.journalApp.Repository.JournalEntryRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalEntryRepository;
    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName)
    {
        try {
            User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry savedEntry = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(savedEntry);
            userService.SaveUser(user);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An exception has occured while saving entry");
        }
    }

    public void saveEntry(JournalEntry journalEntry)
    {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> FindAll()
    {
        return journalEntryRepository.findAll();
    }

    // returns Optional which means, it can be null also
    public Optional<JournalEntry> FindEntryById(ObjectId id)
    {
        return journalEntryRepository.findById(id);
    }

    public boolean DeleteById(ObjectId id, String userName)
    {
        boolean removed = false;
        try {
            User user = userService.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));

            if(removed)
            {
                userService.SaveUser(user);
                journalEntryRepository.deleteById(id);
            }
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("An error occured while deleting the entry", e);
        }

        return removed;
    }

}
