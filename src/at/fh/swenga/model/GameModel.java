package at.fh.swenga.model;

import java.util.Date;

public class GameModel {

	private int id;

	private String name;
	private String developer;
	private Date releaseDate;

	public GameModel() {
	}

	public GameModel(int id, String name, String developer, Date releaseDate) {
		super();
		this.id = id;
		this.name = name;
		this.developer = developer;
		this.releaseDate = releaseDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GameModel other = (GameModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GameModel [id=" + id + ", name=" + name + ", developer=" + developer + ", releaseDate=" + releaseDate
				+ "]";
	}

}
