package example.com.codeclan.example.todo_list;

/**
 * Created by user on 21/01/2017.
 */

public class Task implements Listable{

    String description;
    String details;
    boolean complete;

    public Task(String description, String details, boolean arg){
        this.description = description;
        this.details = details;
        complete = arg;
    }


    public String getDescription() {
        return description;
    }

    public String getDetails() {
        return details;
    }

    public boolean getComplete() {
        return complete;
    }

    public void cycleComplete(){
        complete = !complete;
    }
}
