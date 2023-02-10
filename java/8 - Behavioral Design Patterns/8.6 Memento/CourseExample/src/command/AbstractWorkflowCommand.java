package src.command;

import src.WorkflowDesigner;
import src.WorkflowDesigner.Memento;

public abstract class AbstractWorkflowCommand implements WorkflowCommand {

    protected Memento memento;

    protected WorkflowDesigner receiver;

    public AbstractWorkflowCommand(WorkflowDesigner designer) {
        this.receiver = designer;
    }

    @Override
    public void undo() {
        receiver.setMemento(memento);
    }
}
