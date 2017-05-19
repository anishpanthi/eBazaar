package presentation.control;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import business.exceptions.BackendException;
import presentation.data.BrowseSelectData;
import presentation.data.CartItemPres;
import presentation.data.CatalogPres;
import presentation.data.ManageProductsData;
import presentation.data.ProductPres;

@Controller
public class BrowseSelectUIControl {
	
	@Autowired
	BrowseSelectData browseSelectData;
	
	@Autowired
	ManageProductsData manageProductsData;

	@RequestMapping("/")
	public String viewCatalogsHandler(ModelMap modelMap) {
		System.out.println("*******************");
		List<CatalogPres> catalogs = null;
		try {
			catalogs = browseSelectData.getCatalogList();
		} catch (BackendException e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("catalogs", catalogs);
		return "catalog";
	}

	@RequestMapping(value = "/viewProductList/catalogId/{id}/catalogName/{name}", method = RequestMethod.GET)
	public String viewProductListHandler(@PathVariable int id, @PathVariable String name, ModelMap modelMap) {
		System.out.println("id: " + id + ", name: " + name);
		List<ProductPres> products = null;
		try {
			products = browseSelectData
					.getProductList(manageProductsData.createCatalogPres(id, name));
		} catch (BackendException e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("products", products);
		modelMap.addAttribute("catalogName", name);
		return "product";
	}

	@RequestMapping("/viewProductDetail")
	public String viewProductDetailHandler(@RequestParam("id") int id, ModelMap modelMap) {
		System.out.println("viewProductsHandler2 - id: " + id);
		ProductPres prodPres = null;
		try {
			prodPres = manageProductsData.createProductPresByName(id);
		} catch (BackendException e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("product", prodPres);
		return "productdetail";
	}

	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public String addToCartHandler(@RequestParam Map<String, String> allRequestParams, ModelMap modelMap) {
		System.out.println("addToCartHandler.....");
		String name = allRequestParams.get("prodName");
		double unitPrice = Double.valueOf(allRequestParams.get("unitPrice"));
		CartItemPres cartPres = browseSelectData.cartItemPresFromData(name, unitPrice, 1);
		browseSelectData.addToCart2(cartPres);
		List<CartItemPres> cartItems = browseSelectData.getCartData2();
		modelMap.addAttribute("cartItems", cartItems);
		return "cart";
	}
	
	@RequestMapping(value = "/deleteItem/{cartItemPres}", method = RequestMethod.GET)
	public String deleteCartItem(@PathVariable String cartItemPres, ModelMap modelMap) {
		System.out.println("cartItem pres = " + cartItemPres);
		List<CartItemPres> cartItems = browseSelectData.deleteAndUpdateCart(cartItemPres);
		modelMap.addAttribute("cartItems", cartItems);
		return "redirect:/cart";
	}
	
	@RequestMapping(value = "/cart")
	public String getCart(ModelMap modelMap) throws BackendException {
		System.out.println("Retrieving cart.....");
		List<CartItemPres> cartItems = browseSelectData.getCartData2();
		modelMap.addAttribute("cartItems", cartItems);
		double totalPrice = 0.0;
		if (cartItems != null) {
			for (CartItemPres cartItemPres : cartItems) {
				totalPrice += cartItemPres.getTotalPrice();
			}
		}
		modelMap.addAttribute("cartItems", cartItems);
		modelMap.addAttribute("totalPrice", totalPrice);
		return "cart";
	}

}
