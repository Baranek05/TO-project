package com.example.server.service;

import com.example.server.model.WorkOrder;
import com.example.server.storage.WorkDataBase;
import org.springframework.stereotype.Service;

@Service
public class WorkService {

    private final WorkDataBase workDataBase;

    public WorkService() {
        this.workDataBase = new WorkDataBase();
    }

    public void addWork(WorkOrder work) {
        workDataBase.save(work);
    }
}
