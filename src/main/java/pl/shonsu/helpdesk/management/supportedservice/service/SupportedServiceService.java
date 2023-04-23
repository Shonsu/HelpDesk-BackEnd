package pl.shonsu.helpdesk.management.supportedservice.service;

import org.springframework.stereotype.Service;
import pl.shonsu.helpdesk.management.supportedservice.model.SupportedService;
import pl.shonsu.helpdesk.management.supportedservice.repository.SupportedServiceRepository;

import java.util.List;

@Service
public class SupportedServiceService {
    private final SupportedServiceRepository supportedServiceRepository;

    public SupportedServiceService(SupportedServiceRepository supportedServiceRepository) {
        this.supportedServiceRepository = supportedServiceRepository;
    }

    public SupportedService createSupportedService(SupportedService supportedService) {
        validateIsSupportedServiceExists(supportedService);
        return supportedServiceRepository.save(supportedService);
    }

    public List<SupportedService> getSupportedServices() {
        return supportedServiceRepository.findAll();
    }

    public SupportedService getSupportedService(Long id) {
        return supportedServiceRepository.findById(id).orElseThrow();
    }

    public SupportedService updateSupportedService(SupportedService supportedService) {
        validateIsSupportedServiceExists(supportedService);
        return supportedServiceRepository.save(supportedService);
    }

    public void deleteSupportedService(Long supportedServiceId) {
        supportedServiceRepository.deleteById(supportedServiceId);
    }

    private void validateIsSupportedServiceExists(SupportedService supportedService) {
        if (supportedServiceRepository.existsByCode(supportedService.getCode())) {
            throw new IllegalArgumentException("Supported Service exists");
        }
    }
}
