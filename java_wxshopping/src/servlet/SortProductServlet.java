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
import until.SortProduct;

/**
 * Servlet implementation class SortProduct
 */
@WebServlet(description = "对浏览的商品进行排序", urlPatterns = { "/SortProduct" })
public class SortProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/json; charset=utf-8"); 
		boolean flag=Boolean.valueOf(request.getParameter("flag"));
		int arrs=Integer.valueOf(request.getParameter("arrs"));
		int typeNum=Integer.valueOf(request.getParameter("typeNum"));
		ProductsDao pd=ProductFactory.getInstance();
		PrintWriter out=response.getWriter();
		List<Product> listProducts=pd.findProducts(arrs, typeNum);
		List<Product> list=null;
		if(!flag) {
			list=SortProduct.ascSort(listProducts);
		}else {
			list=SortProduct.descSort(listProducts);
		}
		JSONArray arr=new JSONArray();
		for (Product product : list) {
			JSONObject obj=new JSONObject();
			obj.accumulate("pId", product.getPId());
			obj.accumulate("pName", product.getPName());
			obj.accumulate("pPic1", product.getpPic1());
			obj.accumulate("pPrice", product.getPPrice());
			arr.add(obj);
		}
		JSONObject result=new JSONObject();
		result.accumulate("result", arr);
		out.println(result);
		
		//String str="";
		//JSONObject o=JSONObject.toBean(str, User.class)
	}

}
