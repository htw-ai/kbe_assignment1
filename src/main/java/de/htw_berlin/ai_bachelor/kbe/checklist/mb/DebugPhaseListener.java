package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import javax.faces.component.UIComponent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by timol on 24.12.2015.
 */
public class DebugPhaseListener implements PhaseListener {
    public void afterPhase(PhaseEvent phaseEvent) {
        System.out.println("After Phase: " + phaseEvent.getPhaseId().getName());
        if(phaseEvent.getPhaseId().getName().equals("RESTORE_VIEW")){
            System.out.println("\t Postback Request: " + phaseEvent.getFacesContext().isPostback());
            System.out.println("\t ID of Component Tree:" + phaseEvent.getFacesContext().getViewRoot().getViewId());
            System.out.println("\t Count of Elements in View: " + phaseEvent.getFacesContext().getViewRoot().getChildCount());
        }
        if(phaseEvent.getPhaseId().getName().equals("RENDER_RESPONSE")){
            System.out.println("\t ID of Component Tree:" + phaseEvent.getFacesContext().getViewRoot().getViewId());
            System.out.println("\t Count of Elements in View: " + phaseEvent.getFacesContext().getViewRoot().getChildCount());
            System.out.println("\t Component Families in Tree: "+ countFam(getFamNames(phaseEvent.getFacesContext().getViewRoot().getChildren())).toString());
        }





    }

    public void beforePhase(PhaseEvent phaseEvent) {
        System.out.println("Before Phase: "  + phaseEvent.getPhaseId().getName());

    }

    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }


    private String[] getFamNames(List complist){
        String comfam[] = new String[complist.size()];

        for(int i =0; i<complist.size(); i++){
            UIComponent comp = (UIComponent)complist.get(i);
            comfam[i] = comp.getFamily();
        }

        return comfam;
    }

    private Map countFam(String[] comfam){
        Map<String, Integer> countingMap = new HashMap<String, Integer>(0);
        for(int i = 0; i < comfam.length; i++){
            if(countingMap.containsKey(comfam[i])){
                countingMap.put(comfam[i], countingMap.get(comfam[i])+1);
            }
            else{
                countingMap.put(comfam[i], 1);
            }
        }

        return countingMap;
    }
}
