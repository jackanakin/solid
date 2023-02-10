package src.command;

public interface WorkflowCommand {

    void execute();

    void undo();
}
