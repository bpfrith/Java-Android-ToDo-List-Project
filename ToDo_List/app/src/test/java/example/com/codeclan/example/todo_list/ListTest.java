package example.com.codeclan.example.todo_list;

import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.*;

/**
 * Created by user on 21/01/2017.
 */

public class ListTest {

    List list;
    Listable task;

    @Before
    public void before(){
        list = new List();
        task = new Task("Hide chocolate before sister gets home.");
    }

    @Test
    public void listStartsEmpty(){
        assertEquals(0, list.numberOfTasks());
    }

    @Test
    public void canAddTask(){
        list.addTask(task);
        assertEquals(1, list.numberOfTasks());
    }

    @Test
    public void canRemoveTask(){
        list.addTask(task);
        list.removeTask(task);
        assertEquals(0, list.numberOfTasks());
    }
}
