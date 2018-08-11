package de.martinplatschek.snikochatapi.message;

import de.martinplatschek.snikochatapi.message.objects.MessageDao;
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

    @PostMapping("/set")
    public ResponseEntity<HttpStatus> setMessage(@RequestBody MessageDao message) {
        return new ResponseEntity<>(this.messageWorker.saveMessage(message) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/get")
    public ResponseEntity<List<MessageDao>> getMessages(@RequestParam(value="message", defaultValue = "") String msg) {
        return new ResponseEntity<>(!msg.equals("") ? this.messageWorker.getMessagesByText(msg) : this.messageWorker.getAllMessages(), HttpStatus.OK);
    }

    @GetMapping("/delete")
    public ResponseEntity<HttpStatus> deleteMessages(@RequestParam(value = "message", defaultValue = "") String msg) {
        this.messageWorker.deleteAllMessages();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
