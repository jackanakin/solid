import java.time.LocalDateTime;

class File extends FileSystemElement {
    private int size;

    public File(String name, LocalDateTime dateModified, int size) {
        super(name, dateModified);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}