package com.rohan.Journal.Repo;

import com.rohan.Journal.Entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository<JournalEntry, ObjectId> {

}
