package servlet;

import java.io.IOException;

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

/**
 * Servlet implementation class LoadAddressServlet
 */
@WebServlet(description = "保存修改的地址", urlPatterns = { "/LoadAddressServlet" })
public class LoadAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadAddressServlet() {
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
		AddressDao ad=AddressFactory.getInstance();
		String openId=request.getParameter("openId");
		boolean arrInsFlag=Boolean.valueOf(request.getParameter("arrInsFlag"));
		boolean arrUptFlag=Boolean.valueOf(request.getParameter("arrUptFlag"));
		boolean arrDelFlag=Boolean.valueOf(request.getParameter("arrDelFlag"));

		if(arrDelFlag) {
			String arrDel=request.getParameter("arrDel");
			JSONArray jsonArr=JSONArray.fromObject(arrDel);
			for (int i = 0; i < jsonArr.size(); i++) {
				JSONObject obj=JSONObject.fromObject(jsonArr.getJSONObject(i));
				boolean flag=ad.deleteAddress((int)obj.get("aId"));
				if(!flag) {
					i--;
				}
			}
		}
		
		if(arrInsFlag) {
			String arrIns=request.getParameter("arrIns");
			JSONArray jsonArr=JSONArray.fromObject(arrIns);
			for (int i = 0; i < jsonArr.size(); i++) {
				JSONObject obj=JSONObject.fromObject(jsonArr.getJSONObject(i));
				Address add=new Address();
				add.setName(obj.getString("name"));
				add.setTelephone(obj.getString("phone"));
				add.setProvice(obj.getString("province"));
				add.setCity(obj.getString("city"));
				add.setCounty(obj.getString("county"));
				add.setDetail(obj.getString("detail"));
				add.setDefaultAdress(obj.getInt("defalut"));
				add.setOppenid(openId);
				boolean flag=ad.addAddress(add);
				if(!flag) {
					i--;
				}
			}
		}
		
		if(arrUptFlag) {
			String arrUpt=request.getParameter("arrUpt");
			JSONArray jsonArr=JSONArray.fromObject(arrUpt);
			for (int i = 0; i < jsonArr.size(); i++) {
				JSONObject obj=JSONObject.fromObject(jsonArr.getJSONObject(i));
				Address add=new Address();
				add.setAId(obj.getInt("aId"));
				add.setName(obj.getString("name"));
				add.setTelephone(obj.getString("phone"));
				add.setProvice(obj.getString("province"));
				add.setCity(obj.getString("city"));
				add.setCounty(obj.getString("county"));
				add.setDetail(obj.getString("detail"));
				add.setDefaultAdress(obj.getInt("defalut"));
				add.setOppenid(openId);
				boolean flag=ad.updateAddress(add);
				if(!flag) {
					i--;
				}
				
			}
		}
	}

}
