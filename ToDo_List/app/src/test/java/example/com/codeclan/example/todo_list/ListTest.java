package example.com.codeclan.example.todo_list;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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

    @Test
    public void canRemoveByDescirption(){
        list.addTask(task);
        list.removeByDescription("Hide chocolate before sister gets home.");
        assertEquals(0, list.numberOfTasks());
    }

    @Test
    public void canGetTasks(){
        ArrayList<Listable> getTasks = new ArrayList<>();
        Task getTask;
        String taskDescription;

        list.addTask(task);
        getTasks = list.getTasks();
        getTask = (Task) getTasks.get(0);
        taskDescription = getTask.getDescription();

        assertEquals("Hide chocolate before sister gets home.", taskDescription);
    }
}
