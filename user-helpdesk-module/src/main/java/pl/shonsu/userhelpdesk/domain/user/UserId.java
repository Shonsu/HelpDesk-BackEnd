package pl.shonsu.userhelpdesk.domain.user;

public record UserId(Long id) {
    public static UserId of(Long id){
        return new UserId(id);
    }
}
