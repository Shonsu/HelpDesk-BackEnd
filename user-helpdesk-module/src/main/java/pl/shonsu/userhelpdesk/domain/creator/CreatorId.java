package pl.shonsu.userhelpdesk.domain.creator;

public record CreatorId(Long id) {
    public static CreatorId of(Long id) {
        return new CreatorId(id);
    }
}
