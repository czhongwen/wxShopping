package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import until.GetWXOppenId;

/**
 * Servlet implementation class GetWXOppenIdServlet
 */
@WebServlet(description = "获取微信登录唯一标识", urlPatterns = { "/GetWXOppenIdServlet" })
public class GetWXOpenIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetWXOpenIdServlet() {
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
	    String type="";
		PrintWriter out = response.getWriter();
		type=request.getParameter("type");
		if(type.equals("803")) {
			String key=request.getParameter("key");
			//System.out.println(key);
			try {
				String[] res=GetWXOppenId.load(key);
				JSONObject obj=new JSONObject();
				obj.accumulate("session", res[0]);
				obj.accumulate("openId", res[1]);
				out.println(obj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
