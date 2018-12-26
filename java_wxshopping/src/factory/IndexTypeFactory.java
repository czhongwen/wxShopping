package factory;


import modleDaoImpl.IndexTypeDaoImpl;

public class IndexTypeFactory {
	public static IndexTypeDaoImpl getInstance() {
		return new IndexTypeDaoImpl();
	}
}
