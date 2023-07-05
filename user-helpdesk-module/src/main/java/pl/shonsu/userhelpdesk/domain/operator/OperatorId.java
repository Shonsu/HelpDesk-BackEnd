package pl.shonsu.userhelpdesk.domain.operator;

public record OperatorId(Long id) {
    public static OperatorId of(Long id){
        return new OperatorId(id);
    }
}