package concerttours.facades.impl;

import concerttours.data.ContactRequestData;
import concerttours.facades.ContactRequestFacade;
import concerttours.service.ContactRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.training.model.ContactRequestModel;

@Component
public class DefaultContactRequestFacade implements ContactRequestFacade {
    @Autowired
    private ContactRequestService contactRequestService;

    @Override
    public ContactRequestData getContactRequest(String sender) {
        if (sender == null) {
            throw new IllegalArgumentException("Sender cannot be null");
        }
        ContactRequestData contactRequestData = new ContactRequestData();
        ContactRequestModel contactRequestModel = contactRequestService.getContactRequest(sender);

        if (contactRequestModel == null) {
            return null;
        }

        contactRequestData.setMessage(contactRequestModel.getMessage());
        contactRequestData.setSender(contactRequestModel.getSender());

        return contactRequestData;
    }
}
