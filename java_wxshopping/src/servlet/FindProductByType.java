package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class FindProductByType
 */
@WebServlet(description = "通过商品分类查找商品", urlPatterns = { "/FindProductByType" })
public class FindProductByType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindProductByType() {
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
		int no=Integer.valueOf(request.getParameter("no"));
		int typeNum=Integer.valueOf(request.getParameter("typeNum"));
		//System.out.println("no:"+no+" typeNum:"+typeNum);
		List<Product> listProducts=pd.findProductsByType(no, typeNum);
		JSONObject result=new JSONObject();
		if(listProducts.size()!=0) {
			JSONArray arr=new JSONArray();
			for (Product product : listProducts) {
				JSONObject obj=new JSONObject();
				obj.accumulate("pId", product.getPId());
				obj.accumulate("pName", product.getPName());
				obj.accumulate("pPic1", product.getpPic1());
				obj.accumulate("pPrice", product.getPPrice());
				arr.add(obj);
			}
			result.accumulate("result", arr);
		}else {
			result.accumulate("result", "empty");
		}
		out.println(result);
	}

}
