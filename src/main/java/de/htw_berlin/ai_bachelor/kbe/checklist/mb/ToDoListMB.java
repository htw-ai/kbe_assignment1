package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDoList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

@ManagedBean(name = "toDoList", eager = true)
@ApplicationScoped
public class ToDoListMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private ToDoList toDoList;
    private ToDoList _toDoList;

    public ToDoListMB() {
        super();
        _toDoList = new ToDoList();
        toDoList = _toDoList;

//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        String messageBundleName = facesContext.getApplication().getMessageBundle();
//        Locale locale = facesContext.getViewRoot().getLocale();
//        ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName, locale);
//
//        String message = bundle.getString(UIInput.REQUIRED_MESSAGE_ID);
//        System.out.println(message);
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

    public void movetoTime(){
    //    return "showTime";
    }

}
