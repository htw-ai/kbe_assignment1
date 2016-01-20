package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDoList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Min;
import java.io.Serializable;

@ManagedBean(name = "toDoList", eager = true)
@SessionScoped
public class ToDoListMB implements Serializable {

    private static final long serialVersionUID = 1L;
    public static int MAX_PRIORITY = 10;

    private ToDoList toDoList;
    private ToDoList _toDoList;

    public ToDoListMB() {
        super();
        _toDoList = new ToDoList();
        toDoList = _toDoList;
    }

    public ToDoList getToDoList() {
        return _toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    //Should be called if the Button "Speichern" is pushed.
    //Needs configuration in the faces-config.xml.
    public String save() {
        _toDoList = toDoList;
        return "save";
    }

    @Min(value = 2)
    public int getMaxPriority(){
        return MAX_PRIORITY;
    }

    @Min(value = 2)
    public void setMaxPriority(int maxPriority) {
        MAX_PRIORITY = maxPriority;
    }

    public String updateMaxPriority(){
        //MAX_PRIORITY = newMaxPriority;
        return "updated";
    }

    public void movetoTime(){
    //    return "showTime";
    }

}
