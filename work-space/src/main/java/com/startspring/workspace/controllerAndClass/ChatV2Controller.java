package com.startspring.workspace.controllerAndClass;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v2/chat")
public class ChatV2Controller {

    private List<ChatMessage> messages = new ArrayList<>();

    @PostConstruct
    public void init() {
        messages.add(new ChatMessage(OffsetDateTime.now(), "Joanna", "tekst"));
        messages.add(new ChatMessage(OffsetDateTime.now(), "Mariusz", "text2"));
    }

//    @GetMapping("")
//    public List<ChatMessage> showAllMessages() {
//        return messages;
//    }

    @GetMapping("")
    public List<ChatMessage> theAuthorMessage(@RequestParam(required = false) String author,
                                              @RequestParam(required = false)
                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) OffsetDateTime dateFrom,
                                              @RequestParam(required = false)
                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) OffsetDateTime dateTo) {
        List<ChatMessage> authorMessages = new ArrayList<>();
        if (author == null || author.isEmpty()) {
            return messages;
        } else {
            for (ChatMessage message : messages) {
                if (message.getAuthor().equals(author)) {
                    authorMessages.add(message);
                }
            }
            return authorMessages;
        }
    }

    @PostMapping("")
    public ChatMessage addNewMessage(@RequestBody ChatMessage message) {
        message.setDate(OffsetDateTime.now());
        messages.add(message);
        return message;
    }

    @DeleteMapping("/{id}")
    public ChatMessage deleteMessage(@PathVariable int id) {
        return messages.remove(id);
    }
}