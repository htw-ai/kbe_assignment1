package de.htw_berlin.ai_bachelor.kbe.checklist.validator;

import de.htw_berlin.ai_bachelor.kbe.checklist.MessageUtil;
import de.htw_berlin.ai_bachelor.kbe.checklist.mb.ToDoListMB;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by chris on 12.01.2016.
 */
@FacesValidator(value = "toDoPriorityValidator")
public class ToDoPriorityValidator implements Validator {


    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        int priority = (int) value;

        FacesContext context = FacesContext.getCurrentInstance();
        Integer currenLimit = context.getApplication().evaluateExpressionGet(
                context, String.format("#{properties.maxPrio}"), Integer.class);

        if (currenLimit < priority)
            throw new ValidatorException(new FacesMessage(MessageUtil.getMessage(facesContext, "javax.faces.validator.LongRangeValidator.MAXIMUM")));
        else if (1 > priority)
            throw new ValidatorException(new FacesMessage(MessageUtil.getMessage(facesContext, "javax.faces.validator.LongRangeValidator.MINIMUM")));
    }
}
