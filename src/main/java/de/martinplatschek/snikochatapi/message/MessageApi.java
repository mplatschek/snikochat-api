package de.martinplatschek.snikochatapi.message;

import de.martinplatschek.snikochatapi.message.objects.MessageDao;
import de.martinplatschek.snikochatapi.message.objects.MessageDto;
import de.martinplatschek.snikochatapi.message.worker.MessageWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageApi {

    private final MessageWorker messageWorker;

    @Autowired
    public MessageApi(MessageWorker messageWorker) {
        this.messageWorker = messageWorker;
    }

    @PostMapping("")
    public ResponseEntity<HttpStatus> setMessage(@RequestBody MessageDto message) {
        this.messageWorker.saveMessage(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<MessageDto>> getMessages(@RequestParam(value="filter", defaultValue = "") String filter) {
        return new ResponseEntity<>(this.messageWorker.getAllMessages(filter), HttpStatus.OK);
    }

    @DeleteMapping("")
    public ResponseEntity<HttpStatus> deleteMessages(@RequestParam(value = "text", defaultValue = "") String msg) {
        this.messageWorker.deleteAllMessages();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
