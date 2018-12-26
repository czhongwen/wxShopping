package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartsDao;
import factory.CartFactory;

/**
 * Servlet implementation class AddCart
 */
@WebServlet(description = "Ìí¼Ó¹ºÎï³µ", urlPatterns = { "/AddCart" })
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
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
        String oppenId=request.getParameter("openId");
        String[] arrPid=request.getParameter("arrPid").split(",");
        String[] arrPnum=request.getParameter("arrPnum").split(",");
        int[] pIds=new int[arrPid.length];
        int[] pNums=new int[arrPnum.length];
        for (int i = 0; i < arrPnum.length; i++) {
        	pIds[i]=Integer.valueOf(arrPid[i]);
        	pNums[i]=Integer.valueOf(arrPnum[i]);
		}
		CartsDao cd=CartFactory.getInstance();
		cd.addProducts(oppenId, pIds, pNums);
	}

}
