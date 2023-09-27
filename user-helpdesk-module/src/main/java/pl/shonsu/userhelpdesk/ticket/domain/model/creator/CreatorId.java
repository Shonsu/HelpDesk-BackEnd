package pl.shonsu.userhelpdesk.ticket.domain.model.creator;

public record CreatorId(Long id){
    public static CreatorId of(Long id) {
        return new CreatorId(id);
    }
}
