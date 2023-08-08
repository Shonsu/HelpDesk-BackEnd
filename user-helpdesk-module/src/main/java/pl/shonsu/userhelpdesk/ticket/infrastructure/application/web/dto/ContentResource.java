package pl.shonsu.userhelpdesk.ticket.infrastructure.application.web.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record ContentResource(@NotNull Long ticketFormId,  @NotEmpty Map<@NotNull String, @NotNull String> content) {
}
