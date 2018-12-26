package factory;

import modleDaoImpl.CartsImpl;

public class CartFactory {

	public static CartsImpl getInstance() {
		return new CartsImpl();
	}

}
