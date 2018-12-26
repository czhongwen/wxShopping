package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartsDao;
import factory.CartFactory;
import modle.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetCartsList
 */
@WebServlet(description = "获得购物车列表", urlPatterns = { "/GetCartsList" })
public class GetCartsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCartsList() {
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
		PrintWriter out=response.getWriter();
        String oppenId=request.getParameter("openId");
        CartsDao cd=CartFactory.getInstance();
        List<Product> cartsList=cd.findCarets(oppenId);
        JSONArray res=new JSONArray();
        for (Product product : cartsList) {
			JSONObject obj=new JSONObject();
			obj.accumulate("pId", product.getPId());
			obj.accumulate("pName", product.getPName());
			obj.accumulate("pDetail", product.getPInfo());
			obj.accumulate("pPrice", product.getPPrice());
			obj.accumulate("pImage", product.getpPic1());
			obj.accumulate("flag", false);
			obj.accumulate("pNum", product.getPNum());
			obj.accumulate("pStyle", "");
			res.add(obj);
		}
        out.print(res);
	}

}
