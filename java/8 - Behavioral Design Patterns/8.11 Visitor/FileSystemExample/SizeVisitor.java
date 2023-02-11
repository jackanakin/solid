class SizeVisitor implements FileSystemVisitor {
    private int size = 0;
    private int directorySize = 0;

    @Override
    public void visit(File file) {
        size += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        directorySize += size;
        size = 0;
    }

    public int getSize() {
        return size + directorySize;
    }
}