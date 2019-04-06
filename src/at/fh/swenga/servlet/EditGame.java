package at.fh.swenga.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import at.fh.swenga.model.GameModel;
import at.fh.swenga.model.GameService;

/**
 * Servlet implementation class EditGame
 */
@WebServlet("/editGame")
public class EditGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditGame() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idString = request.getParameter("id");

		int id = Integer.parseInt(idString);

		HttpSession session = request.getSession(true);

		GameService gameService = (GameService) session.getAttribute("gameService");

		if (gameService != null) {
			GameModel gameModel = gameService.getGameByID(id);
			if (gameModel != null) {
				request.setAttribute("game", gameModel);
				RequestDispatcher rd = request.getRequestDispatcher("./editGame.jsp");
				rd.forward(request, response);
				return;
			}
		}

		request.setAttribute("errorMessage", "No Game with id " + id);
		RequestDispatcher rd = request.getRequestDispatcher("./listGames");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
