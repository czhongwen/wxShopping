package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductsDao;
import factory.ProductFactory;
import modle.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet(description = "添加商品", urlPatterns = { "/AddProductServlet" })
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		Product product=new Product();
		ProductsDao pd=ProductFactory.getInstance();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
		String pName=request.getParameter("pName");
		String pInfo=request.getParameter("pInfo");
		String pType=request.getParameter("pType");
		String pic1=request.getParameter("pic1");
		String pic2=request.getParameter("pic2");
		String pic3=request.getParameter("pic3");
		String pic4=request.getParameter("pic4");
		String pic5=request.getParameter("pic5");
		String pPrice=request.getParameter("pPrice");
		String num=request.getParameter("pNum");
		String intro=request.getParameter("intro");
		product.setPName(pName);
		product.setPInfo(pInfo);
		product.setpType(Integer.valueOf(pType));
		product.setpPic1(pic1);
		product.setpPic2(pic2);
		product.setpPic3(pic3);
		product.setpPic4(pic4);
		product.setpPic5(pic5);
		product.setPPrice(Integer.valueOf(pPrice));
		product.setPNum(Integer.valueOf(num));
		product.setPDetail(intro);
		HttpSession session=request.getSession();
		session.setAttribute("pType", Integer.valueOf(pType));
		boolean flag=pd.addProduct(product);
		if(flag) {
			out.print("<script type='text/javascript'>alert('商品添加成功')</script>");
		}else {
			out.print("<script type='text/javascript'>alert('商品添加失败')</script>");
		}
		response.setHeader("refresh", "0.5;URL=addProduct.jsp");
	}

}
