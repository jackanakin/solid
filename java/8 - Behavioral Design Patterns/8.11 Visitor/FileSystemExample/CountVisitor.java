
class CountVisitor implements FileSystemVisitor {
    private int fileCount = 0;
    private int directoryCount = 0;

    @Override
    public void visit(File file) {
        fileCount++;
    }

    @Override
    public void visit(Directory directory) {
        directoryCount++;
    }

    public int getFileCount() {
        return fileCount;
    }

    public int getDirectoryCount() {
        return directoryCount;
    }
}