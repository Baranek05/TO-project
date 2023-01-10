package com.example.server.controller;

import com.example.server.model.Employee;
import com.example.server.model.MessageAssignTimeFromStandManager;
import com.example.server.model.MessageToStandManagerService;
import com.example.server.service.StandManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("standmanager")
public class StandManagerController extends MessageController<MessageToStandManagerService, StandManagerService> {

    protected StandManagerController(StandManagerService standManagerService) {
        super(standManagerService);
    }

    @PostMapping("/sendmessage")
    public void postMessage(@RequestBody MessageAssignTimeFromStandManager messageAssignTimeFromStandManager) {
        service.sendMessage(messageAssignTimeFromStandManager);
    }

    @PostMapping("/sendfinished")
    public void postMessage() {
        service.finished();
    }

    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }


}
