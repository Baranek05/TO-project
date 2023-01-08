package com.example.server.service;

import java.util.LinkedList;
import java.util.Queue;

public abstract class RenameMe<T> {
    protected final Queue<T> messageQueue;

    public RenameMe() {
        messageQueue = new LinkedList<>();
    }

    public T getMessage() {
        if(messageQueue.isEmpty()) {
            return null;
        }

        return messageQueue.poll();
    }
}
