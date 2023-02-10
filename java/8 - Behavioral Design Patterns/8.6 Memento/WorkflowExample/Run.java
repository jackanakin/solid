import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        WorkflowDesigner designer = new WorkflowDesigner();
        designer.addStep("Step 1");
        designer.addStep("Step 2");
        designer.addStep("Step 3");
        System.out.println("Current workflow: " + designer.getWorkflow());

        WorkflowHistory history = new WorkflowHistory();
        history.push(designer.createMemento());

        designer.addStep("Step 4");
        System.out.println("Modified workflow: " + designer.getWorkflow());

        designer.restore(history.pop());
        System.out.println("Restored workflow: " + designer.getWorkflow());
    }
}

class WorkflowMemento {
    private final List<String> steps;

    public WorkflowMemento(List<String> steps) {
        this.steps = new ArrayList<>(steps);
    }

    public List<String> getSteps() {
        return steps;
    }
}

class WorkflowDesigner {
    private final List<String> steps = new ArrayList<>();

    public void addStep(String step) {
        steps.add(step);
    }

    public List<String> getWorkflow() {
        return steps;
    }

    public WorkflowMemento createMemento() {
        return new WorkflowMemento(steps);
    }

    public void restore(WorkflowMemento memento) {
        steps.clear();
        steps.addAll(memento.getSteps());
    }
}

class WorkflowHistory {
    private final List<WorkflowMemento> mementos = new ArrayList<>();

    public void push(WorkflowMemento memento) {
        mementos.add(memento);
    }

    public WorkflowMemento pop() {
        if (mementos.isEmpty()) {
            return null;
        }
        return mementos.remove(mementos.size() - 1);
    }
}