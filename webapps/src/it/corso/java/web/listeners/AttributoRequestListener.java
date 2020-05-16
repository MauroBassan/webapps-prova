package it.corso.java.web.listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AttributoRequestListener
 *
 */
@WebListener
public class AttributoRequestListener implements ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public AttributoRequestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent arg0)  { 
         System.out.println("Oggetto rimosso dalla request! " +arg0.getName());
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent arg0)  { 
    	 
    	System.out.println("Oggetto aggiunto alla request! "+arg0.getName());
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent arg0)  { 
    	System.out.println("Oggetto modificato dalla request! "+arg0.getName());
    }
	
}
