package com.example.server.controller;

import com.example.server.model.MessageAssignTimeFromStandManager;
import com.example.server.model.MessageFromGeneralManagerService;
import com.example.server.model.MessageToStandManagerService;
import com.example.server.service.AirportService;
import com.example.server.service.Services;
import com.example.server.service.StandManagerService;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("standmanager")
public class StandManagerController extends MessageController<MessageToStandManagerService, StandManagerService> {

    protected StandManagerController(AirportService airportService) {
        super(airportService, Services::standManagerService);
    }

    @PostMapping("/sendmessage")
    public void postMessage(@RequestBody MessageAssignTimeFromStandManager messageAssignTimeFromStandManager) {
        airportService.getMessage(messageAssignTimeFromStandManager.flightNumber()).standManagerService().sendMessage(messageAssignTimeFromStandManager);
    }

    @PostMapping("/finished")
    public void postMessage(@RequestBody int flightNumber) {
        airportService.getMessage(flightNumber).standManagerService().finished();
    }

    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }


}
