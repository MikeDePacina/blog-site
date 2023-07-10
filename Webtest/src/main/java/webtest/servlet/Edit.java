package webtest.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

//  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		dbService databaseService = new dbService();
	
		request.setAttribute("categories", databaseService.getCategories());
		request.setAttribute("articleToEdit",databaseService.getArticle(id));
		
		databaseService.close();
		request.getRequestDispatcher("WEB-INF/Edit.jsp").forward(request, response);

	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		dbService databaseService = new dbService();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String excerpt = request.getParameter("excerpt");
		String category = request.getParameter("category");
		User user = (User) request.getSession().getAttribute("user");
		databaseService.editArticle(id, title, content, category, excerpt);
		databaseService.close();
		if(user.getRole() == "author") {
			response.sendRedirect("AuthorHome");
			return;
		}
		else response.sendRedirect("ListArticle");
		
		
	}

}
