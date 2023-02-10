import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.setContent("Content 1");
        editor.setContent("Content 2");

        History history = new History();
        history.push(editor.createMemento());

        editor.setContent("Content 3");
        history.push(editor.createMemento());

        editor.setContent("Content 4");
        System.out.println("Current content: " + editor.getContent());

        editor.restore(history.pop());
        System.out.println("Restored content: " + editor.getContent());

        editor.restore(history.pop());
        System.out.println("Restored content: " + editor.getContent());
    }
}

class EditorMemento {
    private final String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class Editor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public EditorMemento createMemento() {
        return new EditorMemento(content);
    }

    public void restore(EditorMemento memento) {
        content = memento.getContent();
    }
}

class History {
    private final List<EditorMemento> states = new ArrayList<>();

    public void push(EditorMemento state) {
        states.add(state);
    }

    public EditorMemento pop() {
        if (states.isEmpty()) {
            return null;
        }
        return states.remove(states.size() - 1);
    }
}