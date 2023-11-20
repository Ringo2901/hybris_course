package concerttours.controller;

import concerttours.service.TrainingProductService;
import de.hybris.platform.catalog.CatalogService;
import de.hybris.platform.core.model.product.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TrainingProductController {
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private TrainingProductService trainingProductService;

    @RequestMapping(value = "/trainingProduct", method = RequestMethod.GET)
    public String handleRequest(final ModelMap model, @RequestParam String code) throws Exception
    {
        catalogService.setSessionCatalogVersion("concertToursProductCatalog", "Online");

        ProductModel product = null;
        if (code != null)
        {
            product = trainingProductService.getProductForCode(code);
        }
        model.put("product", product);
        return "trainingProduct.jsp";
    }
}
