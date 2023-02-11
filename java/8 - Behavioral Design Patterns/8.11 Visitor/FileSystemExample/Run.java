import java.time.LocalDateTime;

public class Run {
    public static void main(String[] args) {
        Directory root = new Directory("root", LocalDateTime.now());

        Directory dir1 = new Directory("dir1", LocalDateTime.now());
        File file1 = new File("file1", LocalDateTime.now(), 100);
        File file2 = new File("file2", LocalDateTime.now(), 200);
        dir1.addElement(file1);
        dir1.addElement(file2);

        Directory dir2 = new Directory("dir2", LocalDateTime.now());
        File file3 = new File("file3", LocalDateTime.now(), 300);
        File file4 = new File("file4", LocalDateTime.now(), 400);
        dir2.addElement(file3);
        dir2.addElement(file4);

        root.addElement(dir1);
        root.addElement(dir2);

        SizeVisitor sizeVisitor = new SizeVisitor();
        root.accept(sizeVisitor);

        CountVisitor countVisitor = new CountVisitor();
        root.accept(countVisitor);

        CSVExportVisitor csvVisitor = new CSVExportVisitor();
        root.accept(csvVisitor);

        System.out.println("File count: " + countVisitor.getFileCount());
        System.out.println("Directory count: " + countVisitor.getDirectoryCount());
        System.out.println("Total size: " + sizeVisitor.getSize());

        System.out.println(csvVisitor.getCSV());
    }
}