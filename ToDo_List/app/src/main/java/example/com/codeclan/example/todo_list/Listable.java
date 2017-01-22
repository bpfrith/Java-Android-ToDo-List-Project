package example.com.codeclan.example.todo_list;

/**
 * Created by user on 21/01/2017.
 */

public interface Listable{

    String getDescription();

    String getDetails();

    boolean getComplete();

    void cycleComplete();

}
