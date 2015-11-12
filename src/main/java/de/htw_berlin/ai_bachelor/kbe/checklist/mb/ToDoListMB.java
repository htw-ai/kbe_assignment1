package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDoList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "toDoList", eager = true)
@SessionScoped
public class ToDoListMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private ToDoList toDoList;

    public ToDoListMB() {
        super();
        toDoList = new ToDoList();
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
    }

    //Should be called if the Button "Speichern" is pushed.
    //Needs configuration in the faces-config.xml.
    public String save() {
        return "save";
    }
}
