package until;

import java.util.List;

import modle.Product;

public class SortProduct {
	public static List<Product> descSort( List<Product> Listproducts) {
		SortProduct sp=new SortProduct();
		sp.dsort(Listproducts);
		return Listproducts;
	}
	public static List<Product> ascSort( List<Product> Listproducts) {
		SortProduct sp=new SortProduct();
		sp.asort(Listproducts);
		return Listproducts;
	}
	public void dsort(List<Product> Listproducts) {
		for(int d=Listproducts.size()/2;d>0;d=d/2) {
			for(int i=d;i<Listproducts.size();i=i+1) {
				for(int j=i;j-d>=0&&Listproducts.get(j).getPPrice()>Listproducts.get(j-d).getPPrice();j=j-d) {
					Product p=Listproducts.get(j);
					Listproducts.set(j, Listproducts.get(j-d));
					Listproducts.set(j-d, p);
				}
			}
		}
	}
	public void asort(List<Product> Listproducts) {
		for(int d=Listproducts.size()/2;d>0;d=d/2) {
			for(int i=d;i<Listproducts.size();i=i+1) {
				for(int j=i;j-d>=0&&Listproducts.get(j).getPPrice()<Listproducts.get(j-d).getPPrice();j=j-d) {
					Product p=Listproducts.get(j);
					Listproducts.set(j, Listproducts.get(j-d));
					Listproducts.set(j-d, p);
				}
			}
		}
	}
}

