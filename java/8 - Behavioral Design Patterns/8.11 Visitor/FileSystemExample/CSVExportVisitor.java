public class CSVExportVisitor implements FileSystemVisitor {
    private StringBuilder csv = new StringBuilder();

    @Override
    public void visit(File file) {
        csv.append("File,")
                .append(file.getName()).append(",")
                .append(file.getSize()).append(",")
                .append(file.getDateModified()).append("\n");
    }

    @Override
    public void visit(Directory directory) {
        csv.append("Directory,")
                .append(directory.getName()).append(",")
                .append(directory.getDateModified()).append("\n");
    }

    public String getCSV() {
        return csv.toString();
    }
}