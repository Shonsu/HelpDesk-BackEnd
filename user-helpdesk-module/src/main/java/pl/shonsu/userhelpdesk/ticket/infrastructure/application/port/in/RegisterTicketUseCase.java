package pl.shonsu.userhelpdesk.ticket.infrastructure.application.port.in;

public interface RegisterTicketUseCase {
    boolean registerTicket(RegisterTicketCommand command);
}
