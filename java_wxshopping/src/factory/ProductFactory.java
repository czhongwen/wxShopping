package factory;

import modleDaoImpl.ProductImpl;;

public class ProductFactory {
	public static ProductImpl getInstance() {
		return new ProductImpl();
	}
}
