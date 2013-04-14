package kvizmester.beans;


public class Room {
	private String roomName;
	private String playerName;
	
	public Room(String roomName, String playerName){
		this.roomName=roomName;
		this.playerName=playerName;
	}
	
	
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

}
