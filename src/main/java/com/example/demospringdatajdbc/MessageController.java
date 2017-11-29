package com.example.demospringdatajdbc;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MessageController {
    private final MessageRepository messageRepository;

    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("messages")
    public Iterable<Message> getMessages() {
        return this.messageRepository.findAll();
    }

    @GetMapping("messages/{id}")
    public Optional<Message> getMessage(@PathVariable Integer id) {
        return this.messageRepository.findById(id);
    }

    @PostMapping("messages")
    public Message postMessages(@RequestBody Message message) {
        return this.messageRepository.save(message);
    }


    @DeleteMapping("messages/{id}")
    public void deleteMessage(@PathVariable Integer id) {
        this.messageRepository.deleteById(id);
    }
}
