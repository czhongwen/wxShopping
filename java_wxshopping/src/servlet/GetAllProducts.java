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
 * Servlet implementation class GetAllProducts
 */
@WebServlet(description = "获得所有商品", urlPatterns = { "/GetAllProducts" })
public class GetAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllProducts() {
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
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		//request.setCharacterEncoding("utf-8"); 
		PrintWriter out=response.getWriter();
		ProductsDao pd=ProductFactory.getInstance();
		List<Product> listProducts=pd.findProducts();
		JSONArray jsonArr=new JSONArray();
//		int i=0;
		for (Product product : listProducts) {
//			if(i>6) {
//				break;
//			}
			JSONObject jsonObj=new JSONObject();
			jsonObj.accumulate("pId", product.getPId());
			jsonObj.accumulate("pName", product.getPName());
			jsonObj.accumulate("pInfo", product.getPInfo());
			jsonObj.accumulate("rDate", product.getRDate());
//			jsonObj.accumulate("pDetail", product.getPDetail());
			jsonObj.accumulate("pIc1", product.getpPic1());
//			jsonObj.accumulate("pIc2", product.getpPic2());
//			jsonObj.accumulate("pIc3", product.getpPic3());
//			jsonObj.accumulate("pIc4", product.getpPic4());
//			jsonObj.accumulate("pIc5", product.getpPic5());
			jsonObj.accumulate("pPrice", product.getPPrice());
			jsonObj.accumulate("pNum", product.getPNum());
			jsonObj.accumulate("discount", product.getPDiscunt());
			jsonArr.add(jsonObj);
//			i++;
		}
		out.print(jsonArr);
		request.setAttribute("products", listProducts);
	}

}
