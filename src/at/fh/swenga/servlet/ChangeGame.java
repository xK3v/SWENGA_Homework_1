package at.fh.swenga.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class ChangeGame
 */
@WebServlet("/changeGame")
public class ChangeGame extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeGame() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);

		GameService gameService = (GameService) session.getAttribute("gameService");

		String idString = request.getParameter("id");
		String name = request.getParameter("name");
		String developer = request.getParameter("developer");
		String releaseDateString = request.getParameter("releaseDate");

		String errorMessage = "";
		boolean errorOccurred = false;

		int id = 0;

		try {
			id = Integer.parseInt(idString);
		} catch (Exception e) {
			errorMessage += "ID invalid<br>";
			errorOccurred = true;
		}

		Date releaseDate = new Date();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			releaseDate = sdf.parse(releaseDateString);
		} catch (Exception e) {
			errorMessage += "Release Date invalid<br>";
			errorOccurred = true;
		}

		if (!errorOccurred) {
			GameModel game = gameService.getGameByID(id);

			if (game == null) {
				errorMessage += "Game doesn´t exist!<br>";
				errorOccurred = true;
			} else {
				game.setName(name);
				game.setDeveloper(developer);
				game.setReleaseDate(releaseDate);
			}
		}

		if (!errorOccurred) {
			request.setAttribute("message", "Game " + id + " changed.");
		} else {
			request.setAttribute("errorMessage", errorMessage);
		}

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
