package com.example.server.controller;

import com.example.server.service.RenameMe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public abstract class MessageController<TMessage, TService extends RenameMe<TMessage>> {

    protected final TService service;

    @Autowired
    protected MessageController(TService service) {
        this.service = service;
    }

    @GetMapping("/getmessage")
    public TMessage getMessage() {
        return service.getMessage();
    }


}
