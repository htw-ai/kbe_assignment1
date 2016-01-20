package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import java.util.HashMap;
import java.util.Iterator;
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
            System.out.println("\t Count of Elements in View: " + (countChildren(phaseEvent.getFacesContext().getViewRoot()) +1) );
        }
        if(phaseEvent.getPhaseId().getName().equals("RENDER_RESPONSE")){
            System.out.println("\t ID of Component Tree:" + phaseEvent.getFacesContext().getViewRoot().getViewId());
            System.out.println("\t Count of Elements in View: " + (countChildren(phaseEvent.getFacesContext().getViewRoot()) +1 ));
            System.out.println("\t Component Families in Tree: " + countFam(phaseEvent.getFacesContext().getViewRoot()).toString());
        }

    }

    public void beforePhase(PhaseEvent phaseEvent) {
        System.out.println("Before Phase: "  + phaseEvent.getPhaseId().getName());

    }

    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

    private Map countFam(UIComponent com){
        Map<String, Integer> countingMap = new HashMap<String, Integer>(0);

        addChildrenFamilyCount(countingMap, com);
        
        return countingMap;
    }
    
    private void addChildrenFamilyCount(Map<String, Integer> countingMap, UIComponent parent){
    	String familyName = parent.getFamily();
    	countingMap.put(familyName, countingMap.getOrDefault(familyName, 0) + 1);
    	
    	if (parent.getChildCount() == 0)
    		return;

		for (UIComponent child : parent.getChildren()) 
			addChildrenFamilyCount(countingMap, child);	
    }
    
    private int countChildren(UIComponent parent){
    	if(parent.getChildCount()==0)
    		return 0;
    	
    	int count = parent.getChildCount();
    	for(UIComponent child : parent.getChildren()) 
    		count += countChildren(child);
    	
    	return count;    	
    }
}
