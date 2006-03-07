/*
 * SIP Communicator, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */

package net.java.sip.communicator.impl.gui.main;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import net.java.sip.communicator.impl.gui.main.contactlist.ContactListPanel;
import net.java.sip.communicator.impl.gui.main.i18n.Messages;
import net.java.sip.communicator.impl.gui.main.utils.AntialiasingManager;

/**
 * @author Yana Stamcheva
 *
 * The main tabbed pane containing the contact list panel, the 
 * call list panel and the dial panel. 
 */
public class MainTabbedPane extends JTabbedPane {
	
	private DialPanel dialPanel = new DialPanel();
	
	private ContactListPanel contactListPanel;
	
	public MainTabbedPane(MainFrame parent){		
	
		contactListPanel = new ContactListPanel(parent);
		
		dialPanel.setPhoneNumberCombo(parent.getCallPanel().getPhoneNumberCombo());
		
		this.addTab(Messages.getString("contacts"), contactListPanel);
		this.addTab(Messages.getString("callList"), new JPanel());
		//this.addTab(Messages.getString("dial"), dialPanel);
	}
	
	public void paint(Graphics g){
		
		AntialiasingManager.activateAntialiasing(g);
	
		super.paint(g);
	}

    public ContactListPanel getContactListPanel() {
        return contactListPanel;
    }

}
