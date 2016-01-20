package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cschulze on 17.12.2015.
 */
@ManagedBean(name = "Timer", eager = true)
@ApplicationScoped
public class TimerMB {

    private static SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");

    public String getCurrentTime(){
        return sdf.format(new Date());
    }
}
