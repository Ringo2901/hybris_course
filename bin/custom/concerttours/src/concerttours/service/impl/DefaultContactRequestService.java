package concerttours.service.impl;

import concerttours.daos.ContactRequestDao;
import concerttours.service.ContactRequestService;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.training.model.ContactRequestModel;

import java.util.List;

@Component
public class DefaultContactRequestService implements ContactRequestService {
    @Autowired
    private ContactRequestDao contactRequestDao;

    public ContactRequestModel getContactRequest(final String sender) {
        final List<ContactRequestModel> result = contactRequestDao.findBySender(sender);
        final int resultCount = result.size();
        if (resultCount == 0) {
            throw new UnknownIdentifierException(
                    "ContactRequest with sender '" + sender + "' not found!"
            );
        } else if (resultCount > 1) {
            throw new AmbiguousIdentifierException(
                    "ContactRequest with sender '" + sender + "' is not unique, "
                            + resultCount + " requests found!"
            );
        }
        return result.iterator().next();
    }
}
