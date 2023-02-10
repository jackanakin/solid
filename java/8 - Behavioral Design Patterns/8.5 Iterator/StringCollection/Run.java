import java.util.ArrayList;
import java.util.Iterator;

public class Run {
    public static void main(String[] args) {
        // Create a collection of strings
        StringCollection collection = new StringCollection();
        collection.add("Item 1");
        collection.add("Item 2");
        collection.add("Item 3");
        collection.add("Item 4");
        collection.add("Item 5");

        // Create an iterator for the collection
        Iterator<String> iterator = collection.iterator();
        Iterator<String> reverseIterator = collection.reverseIterator();

        // Traverse the collection in the forward direction
        System.out.println("Forward Iteration:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Traverse the collection in the reverse direction
        System.out.println("\nReverse Iteration:");
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }
    }
}

interface Collection<T> {
    Iterator<T> iterator();
    Iterator<T> reverseIterator();
    void add(T item);
}

class StringCollection implements Collection<String> {
    private ArrayList<String> items = new ArrayList<>();

    @Override
    public Iterator<String> iterator() {
        return new StringIterator(this);
    }

    @Override
    public Iterator<String> reverseIterator() {
        return new ReverseStringIterator(this);
    }

    @Override
    public void add(String item) {
        items.add(item);
    }

    ArrayList<String> getItems() {
        return items;
    }
}

class StringIterator implements Iterator<String> {
    private StringCollection collection;
    private int position = 0;

    StringIterator(StringCollection collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return position < collection.getItems().size();
    }

    @Override
    public String next() {
        return collection.getItems().get(position++);
    }
}

class ReverseStringIterator implements Iterator<String> {
    private StringCollection collection;
    private int position;

    ReverseStringIterator(StringCollection collection) {
        this.collection = collection;
        this.position = collection.getItems().size() - 1;
    }

    @Override
    public boolean hasNext() {
        return position >= 0;
    }

    @Override
    public String next() {
        return collection.getItems().get(position--);
    }
}