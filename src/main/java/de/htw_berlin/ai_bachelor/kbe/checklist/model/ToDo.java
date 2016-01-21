package de.htw_berlin.ai_bachelor.kbe.checklist.model;

import de.htw_berlin.ai_bachelor.kbe.checklist.validator.MyInterval;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDo implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final SimpleDateFormat formatter = new SimpleDateFormat("d.M.yyyy");

    private String name;
    private boolean done = false;
    private Date expirationDate = new Date();
    @MyInterval
    private int priority = 1;

    private ToDo(String name, boolean done) {
        super();
        this.name = name;
        this.done = done;
    }

    public ToDo(String name) {
        this(name, false);
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * see https://dzone.com/articles/bean-validation-made-simple
     *
     * @Min(value = 18, message = "Age must be greater than or equal to 18")
     */

    public Date getExpirationDate() {
        return expirationDate;
    }

    public String getFormattedDate() {
        return formatter.format(expirationDate);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
