package pl.shonsu.helpdesk.management.handlinggroup.service;

import org.springframework.stereotype.Service;
import pl.shonsu.helpdesk.management.handlinggroup.model.HandlingGroup;
import pl.shonsu.helpdesk.management.handlinggroup.repository.HandlingGroupRepository;

import java.util.List;

@Service
public class HandlingGroupService {
    private final HandlingGroupRepository handlingGroupRepository;

    public HandlingGroupService(HandlingGroupRepository handlingGroupRepository) {
        this.handlingGroupRepository = handlingGroupRepository;
    }

    public HandlingGroup createHandlingGroup(HandlingGroup handlingGroup) {
        validateIsHandlingGroupExists(handlingGroup);
        return handlingGroupRepository.save(handlingGroup);
    }

    public List<HandlingGroup> getHandlingGroups() {
        return handlingGroupRepository.findAll();
    }

    public HandlingGroup getHandlingGroup(Long id) {
        return handlingGroupRepository.findById(id).orElseThrow();
    }

    public void deleteHandlingGroup(Long id) {
        handlingGroupRepository.deleteById(id);
    }

    public HandlingGroup updateHandlingGroup(HandlingGroup handlingGroup) {
        validateIsHandlingGroupExists(handlingGroup);
        return handlingGroupRepository.save(handlingGroup);
    }

    private void validateIsHandlingGroupExists(HandlingGroup handlingGroup) {
        if (handlingGroupRepository.existsByName(handlingGroup.getName())) {
            throw new IllegalArgumentException("Handling Group exists");
        }
    }
}
