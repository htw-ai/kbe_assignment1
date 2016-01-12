package de.htw_berlin.ai_bachelor.kbe.checklist.validator;

import de.htw_berlin.ai_bachelor.kbe.checklist.MessageUtil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by chris on 11.01.2016.
 */
@FacesValidator(value = "expirationDateValidator")
public class ExpirationDateValidator implements Validator {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        Date sendDate = (Date) value;
        LocalDate now = LocalDate.now();
        //long timestamp = (now.getYear() * 10000) + (now.getMonthValue() * 100) + (now.getDayOfMonth());
        GregorianCalendar today = new GregorianCalendar(now.getYear(), now.getMonthValue() -1, now.getDayOfMonth());

        if (sendDate.getTime() < today.getTimeInMillis())
            throw new ValidatorException(new FacesMessage(MessageUtil.getMessage(facesContext, "de.htw_berlin.ai_bachelor.kbe.checklist.toDo.expirationDate.INVALID")));
    }
}
