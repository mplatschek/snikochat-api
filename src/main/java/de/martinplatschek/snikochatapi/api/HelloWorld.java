package de.martinplatschek.snikochatapi.api;

import de.martinplatschek.snikochatapi.dataobjects.MessageDao;
import de.martinplatschek.snikochatapi.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HelloWorld {

    private MessagesRepository repository;

    @Autowired
    public HelloWorld(MessagesRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/set")
    public MessageDao setMessage(@RequestParam(value = "message", defaultValue = "empty") String message) {
        MessageDao msg = new MessageDao("anon", new Date(), message);
        this.repository.save(msg);
        return msg;
    }

    @RequestMapping("/get")
    public List<MessageDao> getMessages(@RequestParam(value="message", defaultValue = "") String msg) {
        return !msg.equals("") ? this.repository.findByMessage(msg) : this.repository.findAll();
    }

    @RequestMapping("/delete")
    public String deleteMessages(@RequestParam(value = "message", defaultValue = "") String msg) {
        this.repository.deleteAll();
        return "OK";
    }
}
