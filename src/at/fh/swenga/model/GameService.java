package at.fh.swenga.model;

import java.util.ArrayList;
import java.util.List;

public class GameService {

	private List<GameModel> games = new ArrayList<GameModel>();

	public void addGame(GameModel game) {
		games.add(game);
	}

	public boolean contains(GameModel game) {
		return games.contains(game);
	}

	public boolean isEmpty() {
		return games.isEmpty();
	}

	public GameModel getGameByID(int id) {
		for (GameModel gameModel : games) {
			if (gameModel.getId() == id) {
				return gameModel;
			}
		}
		return null;
	}

	public int getSize() {
		return games.size();
	}

	public List<GameModel> getAllGames() {
		return games;
	}

	public List<GameModel> getFilteredGames(String searchString) {

		if (searchString == null || searchString.equals("")) {
			return games;
		}

		List<GameModel> filteredList = new ArrayList<GameModel>();

		for (GameModel gameModel : games) {

			if ((gameModel.getName() != null && gameModel.getName().contains(searchString))
					|| gameModel.getDeveloper() != null && gameModel.getDeveloper().contains(searchString)) {
				filteredList.add(gameModel);
			}
		}
		return filteredList;
	}

	public boolean remove(int id) {
		return games.remove(new GameModel(id, null, null, null));
	}

}
