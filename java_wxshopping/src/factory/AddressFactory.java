package factory;

import modleDaoImpl.AddressImpl;

public class AddressFactory {
	public static AddressImpl getInstance() {
		return new AddressImpl();
	}
}
