package pl.shonsu.helpdesk.management.handlinggroup.controller;

import org.springframework.web.bind.annotation.*;
import pl.shonsu.helpdesk.management.handlinggroup.controller.dto.HandlingGroupDto;
import pl.shonsu.helpdesk.management.handlinggroup.model.HandlingGroup;
import pl.shonsu.helpdesk.management.handlinggroup.service.HandlingGroupService;

import java.util.List;

@RestController
@RequestMapping("/handlinggroup")
class HandilngGroupController {
    private final HandlingGroupService handlingGroupService;

    HandilngGroupController(HandlingGroupService handlingGroupService) {
        this.handlingGroupService = handlingGroupService;
    }

    @PostMapping
    public HandlingGroup createHandlingGroup(@RequestBody HandlingGroupDto handlingGroup){
        return handlingGroupService.createHandlingGroup(new HandlingGroup(handlingGroup.getName()));
    }

    @GetMapping
    public List<HandlingGroup> getHandlingGroups(){
        return handlingGroupService.getHandlingGroups();
    }

    @GetMapping("/{id}")
    public HandlingGroup getHandlingGroup(@PathVariable Long id){
        return handlingGroupService.getHandlingGroup(id);
    }

    @DeleteMapping("/id")
    public void deleteHandlingGroup(@PathVariable Long id){
        handlingGroupService.deleteHandlingGroup(id);
    }
}
