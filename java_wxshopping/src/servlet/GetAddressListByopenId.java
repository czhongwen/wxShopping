package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressDao;
import factory.AddressFactory;
import modle.Address;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import until.SortAddress;

/**
 * Servlet implementation class GetAddressListByopenId
 */
@WebServlet(description = "通过openId获取收货地址", urlPatterns = { "/GetAddressListByopenId" })
public class GetAddressListByopenId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAddressListByopenId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		AddressDao ad=AddressFactory.getInstance();
		List<Address> listAddress=ad.getAddress(openId);
		listAddress=SortAddress.sortAddres(listAddress);
		JSONArray jsonArr=new JSONArray();
		for (Address a : listAddress) {
			JSONObject jsonObj=new JSONObject();
			jsonObj.accumulate("aId", a.getAId());
			jsonObj.accumulate("name", a.getName());
			jsonObj.accumulate("phone", a.getTelephone());
			jsonObj.accumulate("province", a.getProvice());
			jsonObj.accumulate("city", a.getCity());
			jsonObj.accumulate("county", a.getCounty());
			jsonObj.accumulate("detail", a.getDetail());
			jsonObj.accumulate("defalut", a.getDefaultAdress());
			jsonArr.add(jsonObj);
		}
		PrintWriter out=response.getWriter();
		out.print(jsonArr);
		out.flush();
	}

}
