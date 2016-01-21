package de.htw_berlin.ai_bachelor.kbe.checklist.validator;

import de.htw_berlin.ai_bachelor.kbe.checklist.MessageUtil;
import de.htw_berlin.ai_bachelor.kbe.checklist.mb.PropertiesMB;
import de.htw_berlin.ai_bachelor.kbe.checklist.mb.ToDoListMB;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.validator.ValidatorException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

/**
 * Created by timol on 20.01.2016.
 */
public class PriorityConstraintValidator implements ConstraintValidator<MyInterval, Integer> {

    @Override
    public void initialize(MyInterval myInterval) {
        System.out.println("init priority validator.");
    }

    @Override
    public boolean isValid(Integer priority, ConstraintValidatorContext constraintValidatorContext) {
        FacesContext context = FacesContext.getCurrentInstance();
        PropertiesMB propertiesBean = (PropertiesMB) context.getELContext().getELResolver().getValue(context.getELContext(), null, "properties");

        Integer currenLimit = context.getApplication().evaluateExpressionGet(
                context, String.format("#{properties.maxPrio}"), Integer.class);

        return !(currenLimit < priority || 1 > priority);

    }
}
