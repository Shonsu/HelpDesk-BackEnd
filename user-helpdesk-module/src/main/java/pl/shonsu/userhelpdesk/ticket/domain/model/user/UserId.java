package pl.shonsu.userhelpdesk.ticket.domain.model.user;

public record UserId(Long id) {
    public static UserId of(Long id){
        return new UserId(id);
    }
}
