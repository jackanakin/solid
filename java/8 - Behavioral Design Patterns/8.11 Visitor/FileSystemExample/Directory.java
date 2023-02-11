import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Directory extends FileSystemElement {
    private List<FileSystemElement> elements = new ArrayList<>();

    public Directory(String name, LocalDateTime dateModified) {
        super(name, dateModified);
    }

    public void addElement(FileSystemElement element) {
        elements.add(element);
    }

    public List<FileSystemElement> getElements() {
        return elements;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }
}