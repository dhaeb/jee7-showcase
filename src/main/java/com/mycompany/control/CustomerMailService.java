package com.mycompany.control;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mycompany.entity.Customer;
import com.mycompany.entity.Product;

@Stateless
@Local
public class CustomerMailService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3295652330260349593L;
	
	@Resource(mappedName = "java:jboss/mail/Default")
    private Session mySession;

	// TODO: Consume JBoss Mail Service Resource
	public void sendProductInfoMailToCustomers(Customer customer, List<Product> products) throws MessagingException {
		Message message = new MimeMessage(mySession);
        message.setFrom(new InternetAddress(""));
        Address toAddress = new InternetAddress("");
        message.addRecipient(Message.RecipientType.TO, toAddress);
        message.setSubject("");
        message.setContent("", "text/plain");
        Transport.send(message);
	}
}
