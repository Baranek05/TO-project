package com.example.server.storage;

import com.example.server.model.WorkOrder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class WorkDataBase {

    private final List<WorkOrder> workOrders;

    public WorkDataBase() {
        this.workOrders = new ArrayList<>();
    }

    public void save(WorkOrder work) {
        workOrders.add(work);
    }
}
