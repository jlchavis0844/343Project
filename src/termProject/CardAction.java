package termProject;

public enum CardAction {
	DRAW,
	DISCARD,
	PICK("Empty"),
	TELEPORT, 
	NONE;
	
	private String excluded;
	CardAction(String s){
		excluded = s;
	}
	
	CardAction(){
		excluded = null;
	}
	
	public String getExcluded(){
		return excluded;
	}
	
	public void setExcluded(String s){
		excluded = s;
	}
	
}
