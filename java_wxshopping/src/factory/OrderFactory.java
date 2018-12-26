package factory;

import modleDaoImpl.OrderImpl;

public class OrderFactory {
	public static OrderImpl getInstance() {
		return new OrderImpl();
	}
}
