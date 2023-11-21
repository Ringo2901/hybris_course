package concerttours.controller;

import de.hybris.platform.catalog.CatalogService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @Autowired
    CatalogService catalogService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String handleRequest(final ModelMap model, @RequestParam String code) throws Exception {
        ProductModel product = null;
        catalogService.setSessionCatalogVersion("concertToursProductCatalog", "Online");
        if (code != null)
        {
            product = productService.getProductForCode(code);
        }
        model.put("product", product);
        return "product";
    }
}
