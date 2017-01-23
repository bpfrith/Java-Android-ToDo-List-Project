package example.com.codeclan.example.todo_list;

import java.util.ArrayList;

/**
 * Created by user on 21/01/2017.
 */

public class List{

    ArrayList<Listable> tasks;

    public List(){
        tasks = new ArrayList<>();
    }

    public int numberOfTasks() {
        return tasks.size();
    }

    public void addTask(Listable task) {
        tasks.add(task);
    }

    public void removeTask(Listable task) {
        tasks.remove(task);
    }

    public ArrayList<Listable> getTasks(){
        return tasks;
    }

    public void removeByDescription(String description) {
        ArrayList<Listable>toRemove = new ArrayList<>();
        for(Listable task : tasks){
            if(task.getDescription() == description){
                toRemove.add(task);
            }
        }
        tasks.removeAll(toRemove);
    }

    public void setup(){
        tasks.add(new Task("Hide Chocolate before Bethany gets home from work."));
        tasks.add(new Task("Fix bugs."));
        tasks.add(new Task("Learn Simpsons made up words."));
        tasks.add(new Task("Teach Cohort 9 the Goblin song."));
    }
}
