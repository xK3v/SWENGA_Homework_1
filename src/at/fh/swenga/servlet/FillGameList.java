package at.fh.swenga.servlet;

import java.io.IOException;
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
 * Servlet implementation class FillGameList
 */
@WebServlet("/fillGameList")
public class FillGameList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FillGameList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		GameService gameService = (GameService) session.getAttribute("gameService");
		if (gameService == null) {
			gameService = new GameService();
			session.setAttribute("gameService", gameService);
		}
		
		Date now = new Date();
		
		gameService.addGame(new GameModel(gameService.getSize()+1, "CSGO", "Valve", now));
		gameService.addGame(new GameModel(gameService.getSize()+1, "League of Legends", "Riot Games", now));
		gameService.addGame(new GameModel(gameService.getSize()+1, "PUBG", "Bluehole", now));
		gameService.addGame(new GameModel(gameService.getSize()+1, "Apex: Legends", "Respawn Entertainment", now));
		
		RequestDispatcher rd = request.getRequestDispatcher("./listGames");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
