package com.startspring.workspace.controllerAndClass;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatV2Controller {

    private List<ChatMessage> messages = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET, value = "/v2/chat")
    @ResponseBody
    public List<ChatMessage> showAllMessages() {
        return messages;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/v2/chat")
    @ResponseBody
    public List<ChatMessage> theAuthorMessage(@RequestParam String author) {
        List<ChatMessage> authorMessages = new ArrayList<>();
        if (author == null) {
            return authorMessages;
        } else {
            for (ChatMessage message : messages) {
                if (message.getAuthor().equals(author)) {
                    authorMessages.add(message);
                }
            }
            return authorMessages;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/v2/chat")
    public String addNewMessage(String author, String text) {
        ChatMessage message = new ChatMessage();
        message.setDate(OffsetDateTime.now());
        message.setAuthor(author);
        message.setText(text);
        return "you added new message";
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "v2/chat/{id}")
    public String deleteMessage(@PathVariable int id) {
        messages.remove(id);
        return "you deleted message";
    }

}
