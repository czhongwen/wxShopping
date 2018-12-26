package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductsDao;
import factory.ProductFactory;
import modle.Product;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetProductDetailById
 */
@WebServlet(description = "获取商品详情", urlPatterns = { "/GetProductDetailById" })
public class GetProductDetailById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProductDetailById() {
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
		ProductsDao pd=ProductFactory.getInstance();
		PrintWriter out=response.getWriter();
		int pId=Integer.valueOf(request.getParameter("pId"));
		Product product=pd.findProductsById(pId);
		JSONObject result=new JSONObject();
		result.accumulate("pId", product.getPId());
		result.accumulate("pName", product.getPName());
		result.accumulate("pInfo", product.getPInfo());
		String detail=product.getPDetail().replaceAll("/wxshopping/userfiles", "https://www.czhongwen.xyz/wxshopping/userfiles");
		result.accumulate("pDetail", detail);
		JSONArray arr=new JSONArray();
		String pic1=product.getpPic1();
		String pic2=product.getpPic2();
		String pic3=product.getpPic3();
		String pic4=product.getpPic4();
		String pic5=product.getpPic5();
		arr.add(pic1);
		arr.add(pic2);
		arr.add(pic3);
		arr.add(pic4);
		arr.add(pic5);
		result.accumulate("pic", arr);
		result.accumulate("pPrice", product.getPPrice());
		result.accumulate("pDiscount", product.getPDiscunt());
		out.print(result);
	}

}
