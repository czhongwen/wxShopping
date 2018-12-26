package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IndexTypeDao;
import factory.IndexTypeFactory;
import modle.IndexDetail;
import modle.IndexType;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetType
 */
@WebServlet(description = "获得商品分类详情", urlPatterns = { "/GetTypeServlet" })
public class GetTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetTypeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		IndexTypeDao itd = IndexTypeFactory.getInstance();
		List<IndexType> indexList = itd.getAll();
		JSONObject result=new JSONObject();
		JSONArray arrType = new JSONArray();
		JSONArray arrTypeList = new JSONArray();
		for (IndexType indexType : indexList) {
			
			JSONObject objType = new JSONObject();
			objType.accumulate("name", indexType.getItName());
			objType.accumulate("style", "");
			arrType.add(objType);
			JSONArray arr=new JSONArray();
			JSONObject objTypeList = new JSONObject();
			for (IndexDetail indexDetail : indexType.getListId()) {

				JSONObject objTypeList1 = new JSONObject();
				objTypeList1.accumulate("id", indexDetail.getIdId());
				objTypeList1.accumulate("name", indexDetail.getIdName());
				objTypeList1.accumulate("image", indexDetail.getIdImage());
				arr.add(objTypeList1);
			}
			objTypeList.accumulate("topPic", indexType.getItImage());
			objTypeList.accumulate("title", indexType.getItName());
			objTypeList.accumulate("arr", arr);
			arrTypeList.add(objTypeList);
		}
		result.accumulate("type", arrType);
		result.accumulate("typeList", arrTypeList);
		out.print(result);
	}

}
