package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import de.htw_berlin.ai_bachelor.kbe.checklist.validator.MyInterval;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by timol on 21.01.2016.
 */
@ManagedBean(name = "properties", eager = true)
@ApplicationScoped
public class PropertiesMB {

    private int maxPrio = 10;

    public int getMaxPrio() {
        return maxPrio;
    }

    public void setMaxPrio(int maxPrio) {
        this.maxPrio = maxPrio;
    }

    public String update(){
        //MAX_PRIORITY = newMaxPriority;
        return "updated";
    }
}
