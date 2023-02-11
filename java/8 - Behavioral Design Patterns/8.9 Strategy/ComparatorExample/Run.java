import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        
        users.add( new User("Jardel Kuhn", 28) );
        users.add( new User("Daniel Kuhn", 35) );
        users.add( new User("Daiana Kuhn", 37) );
        users.add( new User("Moacir Kuhn", 67) );
        users.add( new User("Maria Kuhn", 63) );

        users.sort( new SortByAge() );
        users.toString();

        users.sort( new SortByName() );
        users.toString();
    }
}

