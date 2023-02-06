package webtest.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ArticleView
 */
@WebServlet("/ArticleView")
public class ArticleView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleView() {
        super();
        // TODO Auto-generated constructor stub
    }
    
//    public Article getArticleByID(int id) {
//    	Article articleToPub = null;
//    	List<Article>articles = (List<Article>) getServletContext().getAttribute("listOfArticles");
//		for(Article article: articles) {
//			if(article.getId() == id) {
//				articleToPub = article;
//				break;
//			}
//		}
//		return articleToPub;
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		dbService databaseService = new dbService();
		request.setAttribute("article", databaseService.getArticle(id));
		
		databaseService.close();
		request.getRequestDispatcher("WEB-INF/ArticleView.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
