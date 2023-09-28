package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in;

public interface OpenTicketUseCase {
    boolean openTicket(OpenTicketCommand command);
}