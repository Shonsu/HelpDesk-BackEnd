package pl.shonsu.helpdesk.management.handlinggroup.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.shonsu.helpdesk.management.handlinggroup.controller.dto.HandlingGroupDto;
import pl.shonsu.helpdesk.management.handlinggroup.model.HandlingGroup;
import pl.shonsu.helpdesk.management.handlinggroup.service.HandlingGroupService;

import java.util.List;

@RestController
@RequestMapping("/admin/handlinggroup")
class HandlingGroupController {
    public static final Long EMPTY_ID = null;
    private final HandlingGroupService handlingGroupService;

    HandlingGroupController(HandlingGroupService handlingGroupService) {
        this.handlingGroupService = handlingGroupService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HandlingGroupDto createHandlingGroup(@RequestBody HandlingGroupDto handlingGroupDto) {
        HandlingGroup handlingGroup = handlingGroupService.createHandlingGroup(new HandlingGroup(EMPTY_ID, handlingGroupDto.name()));
        return new HandlingGroupDto(null, handlingGroup.getName());
    }

    @GetMapping
    public List<HandlingGroupDto> getHandlingGroups() {
        return handlingGroupService.getHandlingGroups().stream()
                .map(handlingGroup -> new HandlingGroupDto(handlingGroup.getId(), handlingGroup.getName()))
                .toList();
    }

    @GetMapping("/{handlingGroupId}")
    public HandlingGroupDto getHandlingGroup(@PathVariable Long handlingGroupId) {
        HandlingGroup handlingGroup = handlingGroupService.getHandlingGroup(handlingGroupId);
        return new HandlingGroupDto(handlingGroup.getId(), handlingGroup.getName());
    }

    @PutMapping("/{handlingGroupId}")
    public HandlingGroupDto updateHandlingGroup(@RequestBody HandlingGroupDto handlingGroupDto, @PathVariable Long handlingGroupId) {
        HandlingGroup handlingGroup = handlingGroupService.updateHandlingGroup(new HandlingGroup(handlingGroupId, handlingGroupDto.name()));
        return new HandlingGroupDto(handlingGroup.getId(), handlingGroup.getName());
    }

    @DeleteMapping("/{handlingGroupId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHandlingGroup(@PathVariable Long handlingGroupId) {
        handlingGroupService.deleteHandlingGroup(handlingGroupId);
    }
}
