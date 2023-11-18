package concerttours.controller;

import concerttours.service.ContactRequestService;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.model.ContactRequestModel;

@Controller
public class ContactRequestController {
    @Autowired
    private ContactRequestService contactRequestService;
    @Autowired
    private ModelService modelService;

    @RequestMapping(value = "/contactRequest", method = RequestMethod.GET)
    public String handleRequestGet(final ModelMap model, @RequestParam String sender) throws Exception {
        ContactRequestModel contactRequest = null;
        if (sender != null) {
            try {
                contactRequest = contactRequestService.getContactRequest(sender);
            } catch (final UnknownIdentifierException e) {
                // OK, nothing found
            }
        }
        model.put("contactRequest", contactRequest);
        return "contactRequest";
    }

    @RequestMapping(value = "/contactRequest", method = RequestMethod.POST)
    public String handleRequestGet(final ModelMap model, @RequestParam String sender, @RequestParam String newSender, @RequestParam String newMessage) throws Exception {
        ContactRequestModel contactRequest = null;
        if (sender != null) {
            try {
                contactRequest = contactRequestService.getContactRequest(sender);
            } catch (final UnknownIdentifierException e) {
                // OK, nothing found
            }
        }
        if (contactRequest == null) {
            contactRequest = new ContactRequestModel();
            modelService.attach(contactRequest);
        }
        if (newSender != null) {
            contactRequest.setSender(newSender);
        }
        if (newMessage != null) {
            contactRequest.setMessage(newMessage);
        }
        modelService.save(contactRequest);
        model.put("contactRequest", contactRequest);
        return "contactRequest";
    }
}
