package until;

import java.util.List;

import modle.Address;

public class SortAddress {
	public static List<Address> sortAddres(List<Address> listAddress) {
		
		for (int i = 0; i < listAddress.size(); i++) {
			Address a=listAddress.get(i);
			if(a.getDefaultAdress()==1) {
				listAddress.set(i, listAddress.get(0));
				listAddress.set(0, a);
				break;
			}
		}
		
		return listAddress;
	}
}
