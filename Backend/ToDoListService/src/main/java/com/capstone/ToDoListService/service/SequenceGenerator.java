package com.capstone.ToDoListService.service;

import com.capstone.ToDoListService.model.DbSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
@Service
public class SequenceGenerator {
    @Autowired
    private MongoOperations mongoOperations;
    public int getSequence(String seq){
        //get the sequence no
        Query q=new Query(Criteria.where("id").is(seq));
        //update the sequence no
        Update update=new Update().inc("sequence",1);
        //modify in document
        DbSequence counter=mongoOperations.findAndModify(q,update,options().returnNew(true).upsert(true),DbSequence.class);
        return !Objects.isNull(counter) ? counter.getSequence() : 1;
    }
    //MongoTemplate provides a simple way for you to save, update, and delete your domain objects
    // and map those objects to documents stored in MongoDB. You can save, update and delete the object
    //  MongoOperations is the interface that MongoTemplate implements.

    //difference between template and normal forms
    //Template-driven forms make use of the "FormsModule", while reactive forms are based on "ReactiveFormsModule".
    //Template-driven forms are asynchronous in nature, whereas Reactive forms are mostly synchronous.
    //In a template-driven approach, most of the logic is driven from the template, whereas in reactive-driven approach, the logic resides mainly in the component or typescript code.

}
