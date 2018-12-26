package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressDao;
import dao.OrderDao;
import factory.AddressFactory;
import factory.OrderFactory;
import modle.Address;
import modle.Order;
import modle.OrderDetail;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import until.GetDate;

/**
 * Servlet implementation class LoadOrders
 */
@WebServlet(description = "用户下单", urlPatterns = { "/LoadOrders" })
public class LoadOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json; charset=utf-8");
		request.setCharacterEncoding("utf-8"); 
		String openId=request.getParameter("openId");
		String type=request.getParameter("type");
		String arr=request.getParameter("orders");
		String address=request.getParameter("address");
		JSONObject addObj=JSONObject.fromObject(address);
		AddressDao ad=AddressFactory.getInstance();
		Address add=new Address();
		boolean flag=true;
		int aId=0;
		switch (type) {
		case "null":
			aId=addObj.getInt("aId");
			break;
		case "uptAddress":
			aId=addObj.getInt("aId");
			add.setAId(addObj.getInt("aId"));
			add.setName(addObj.getString("name"));
			add.setTelephone(addObj.getString("phone"));
			add.setProvice(addObj.getString("province"));
			add.setCity(addObj.getString("city"));
			add.setCounty(addObj.getString("county"));
			add.setDetail(addObj.getString("detail"));
			add.setDefaultAdress(addObj.getInt("defalut"));
			add.setOppenid(openId);
			while(flag) {
				flag=ad.updateAddress(add);
				flag=flag?false:true;
			}
			ad.updateAddress(add);
			break;
		case "insAddress":
			add.setAId(addObj.getInt("aId"));
			add.setName(addObj.getString("name"));
			add.setTelephone(addObj.getString("phone"));
			add.setProvice(addObj.getString("province"));
			add.setCity(addObj.getString("city"));
			add.setCounty(addObj.getString("county"));
			add.setDetail(addObj.getString("detail"));
			add.setDefaultAdress(addObj.getInt("defalut"));
			add.setOppenid(openId);
			while(flag) {
				flag=ad.addAddress(add);
				if(flag) {
					flag=false;
				}else {
					flag=true;
				}
			}
			List<Address> addArr=ad.getAddress(openId);
			aId=addArr.get((addArr.size()-1)).getAId();
			break;
		default:
			break;
		}
		JSONArray jsonArr=JSONArray.fromObject(arr);
		Order order=new Order();
		List<OrderDetail> orderDetailLst=new ArrayList<OrderDetail>();
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject obj=JSONObject.fromObject(jsonArr.get(i));
			OrderDetail od=new OrderDetail();
			od.setPId(obj.getInt("pId"));
			od.setPNum(obj.getInt("num"));
			orderDetailLst.add(od);
		}
		order.setAId(aId);
		order.setDate(GetDate.getDate());
		order.setStatus("待发货");
		order.setOppenId(openId);
		order.setListDetal(orderDetailLst);
		OrderDao od=OrderFactory.getInstance();
		od.addOrder(order, openId);
	}

}
