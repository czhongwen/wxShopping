package until;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println(getDate());
//	}
	public static String getDate() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
		String date=sdf.format(new Date());
		return date;
	}
}
