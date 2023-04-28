package pl.shonsu.helpdesk.management.supportedservice.controller;

import org.springframework.web.bind.annotation.*;
import pl.shonsu.helpdesk.management.supportedservice.controller.dto.SupportedServiceDto;
import pl.shonsu.helpdesk.management.supportedservice.model.SupportedService;
import pl.shonsu.helpdesk.management.supportedservice.service.SupportedServiceService;

import java.util.List;

@RestController
@RequestMapping("/supportedservice")
class SupportedServiceController {
    public static final Long EMPTY_ID = null;
    private final SupportedServiceService supportedServiceService;

    SupportedServiceController(SupportedServiceService supportedServiceService) {
        this.supportedServiceService = supportedServiceService;
    }

    @PostMapping
    SupportedServiceDto createSupportedService(@RequestBody SupportedServiceDto supportedServiceDto) {
        SupportedService supportedService = supportedServiceService.createSupportedService(new SupportedService(EMPTY_ID, supportedServiceDto.code()));
        return new SupportedServiceDto(supportedService.getId(), supportedService.getCode());
    }

    @GetMapping
    List<SupportedServiceDto> getSupportedServices() {
        List<SupportedService> supportedServices = supportedServiceService.getSupportedServices();
        return supportedServices.stream()
                .map(supportedService -> new SupportedServiceDto(supportedService.getId(), supportedService.getCode()))
                .toList();
    }

    @GetMapping("/{id}")
    SupportedServiceDto getSupportedService(@PathVariable Long id) {
        SupportedService supportedService = supportedServiceService.getSupportedService(id);
        return new SupportedServiceDto(supportedService.getId(), supportedService.getCode());
    }

    @PutMapping("/{supportedServiceId}")
    public SupportedServiceDto updateSupportedService(@RequestBody SupportedServiceDto supportedServiceDto, @PathVariable Long supportedServiceId) {
        SupportedService supportedService = supportedServiceService.updateSupportedService(new SupportedService(supportedServiceId, supportedServiceDto.code()));
        return new SupportedServiceDto(supportedService.getId(), supportedService.getCode());
    }

    @DeleteMapping("/{supportedServiceId}")
    public void deleteHandlingGroup(@PathVariable Long supportedServiceId) {
        supportedServiceService.deleteSupportedService(supportedServiceId);
    }
}
