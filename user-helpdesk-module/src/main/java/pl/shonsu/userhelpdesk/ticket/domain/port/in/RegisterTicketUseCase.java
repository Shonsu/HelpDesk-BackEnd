package pl.shonsu.userhelpdesk.ticket.domain.port.in;

public interface RegisterTicketUseCase {
    boolean registerTicket(RegisterTicketCommand registerTicketCommand);
}
