package concerttours.daos.impl;

import concerttours.daos.ContactRequestDao;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.training.model.ContactRequestModel;

import java.util.List;

@Component
public class DefaultContactRequestDao extends AbstractItemDao implements ContactRequestDao {
    @Autowired
    private FlexibleSearchService flexibleSearchService;
    public List<ContactRequestModel> findBySender(final String sender) {
        final String queryString = "SELECT {PK} FROM {ContactRequest} WHERE {SENDER} = ?sender";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("sender", sender);
        final SearchResult<ContactRequestModel> result = this.flexibleSearchService.search(query);
        return result.getResult();
    }

}
