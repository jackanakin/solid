import java.time.LocalDateTime;

abstract class FileSystemElement {
    private String name;
    private LocalDateTime dateModified;

    public FileSystemElement(String name, LocalDateTime dateModified) {
        this.name = name;
        this.dateModified = dateModified;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateModified() {
        return dateModified;
    }

    public abstract void accept(FileSystemVisitor visitor);
}