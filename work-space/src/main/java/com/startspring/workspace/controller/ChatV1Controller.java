package com.startspring.workspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatV1Controller {

    private List<String> messages = new ArrayList<>();

//    @PostConstruct
//    public void init() {g
//        messages.add("Hej");
//        messages.add("Czesc!");
//        messages.add("Ala");
//        messages.add("ma");
//        messages.add("kota");
//        messages.add("o");
//        messages.add("imieniu");
//        messages.add("Mruczek.");
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/v1/chat")
    @ResponseBody
    public String showAllMessages() {
        if (messages.isEmpty()) {
            return "no messages";
        } else {
            return messages.toString();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/v1/add-message")
    @ResponseBody
    public String addNewMessage(@RequestParam String message) {
        messages.add(message);
        return messages.get(messages.size() - 1);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/v1/chat-newest")
    @ResponseBody
    public String fiveLastMessages() {
        List<String> fiveMessages = new ArrayList<>();
        if (messages.isEmpty()) {
            return "no new messages";
        } else if (messages.size() < 6) {
            return messages.toString();
        } else {
            for (int i = 0; i < 6; i++) {
                fiveMessages.add(messages.get(messages.size() - 1 - i));
            }
            return fiveMessages.toString();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "v1/chat/{index}")
    @ResponseBody
    public String selectedMessage(@PathVariable int index) {
        if (index > messages.size() - 1) {
            return "no message for this number";
        } else {
            return messages.get(index);
        }
    }
}
