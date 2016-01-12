package de.htw_berlin.ai_bachelor.kbe.checklist;

import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by chris on 11.01.2016.
 */
public class MessageUtil {

    /**
     * retrieving the message of a given key in the default language
     *
     * @param messageKey
     * @return
     */
    public static String getMessage(String messageKey) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String messageBundleName = facesContext.getApplication().getMessageBundle();
        Locale locale = facesContext.getViewRoot().getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName, locale);

        return bundle.getString(messageKey);
    }

    /**
     * retrieving the message of a given key in tha language configured within a certain faces context
     *
     * @param context
     * @param messageKey
     * @return
     */
    public static String getMessage(FacesContext context, String messageKey) {
        String messageBundleName = context.getApplication().getMessageBundle();
        Locale locale = context.getViewRoot().getLocale();
        ResourceBundle bundle = ResourceBundle.getBundle(messageBundleName, locale);

        return bundle.getString(messageKey);
    }

}
