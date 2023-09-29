package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in;

public interface CloseTicketUseCase {
    boolean closeTicket(CloseTicketCommand command);
}
