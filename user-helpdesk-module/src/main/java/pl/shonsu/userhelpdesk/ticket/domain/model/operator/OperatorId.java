package pl.shonsu.userhelpdesk.ticket.domain.model.operator;

public record OperatorId(Long id){
    public static OperatorId of(Long id){
        return new OperatorId(id);
    }
}