package webtest.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("WEB-INF/LoginPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		dbService databaseService = new dbService();
		
		User loggedIn = databaseService.logIn(userName, password);
		if(loggedIn == null || loggedIn.getRole() == null) {
			request.setAttribute("loggedIn",-1 );
			request.getRequestDispatcher("WEB-INF/LoginPage.jsp").forward(request, response);
		}
		else {
			request.getSession().setAttribute("user", loggedIn);
			if(loggedIn.getRole().equals("author")) {
				response.sendRedirect("AuthorHome");
				return;
			}
			else {
				response.sendRedirect("ListArticle");
			}
			
		}
		
	}

}
