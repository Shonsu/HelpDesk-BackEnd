package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in;

public interface CancelTicketUseCase {
    void cancelTicket(CancelTicketCommand command);
}