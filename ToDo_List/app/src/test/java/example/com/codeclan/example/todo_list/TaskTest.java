package example.com.codeclan.example.todo_list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by user on 21/01/2017.
 */

public class TaskTest{

    Listable task;

    @Before
    public void before(){
        task = new Task("Learn Simpsons made up words.");
    }

    @Test
    public void canGetDescription(){
        assertEquals("Learn Simpsons made up words.", task.getDescription());
    }

    @Test
    public void canGetDetails(){
        assertEquals("", task.getDetails());
    }

    @Test
    public void startsIncomplete(){
        assertFalse(task.getComplete());
    }

    @Test
    public void canCycleComplete(){
        task.cycleComplete();
        task.cycleComplete();
        assertTrue(task.getComplete());
    }
}
