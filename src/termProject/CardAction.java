package termProject;

public enum CardAction {
	DRAW,
	DRAW2,
	DISCARD,
	PICK("Empty"),
	TELEPORT, 
	NONE;
	
	private String excluded;
	private String result;
	
	CardAction(String s){
		excluded = s;
	}
	
	CardAction(){
		excluded = null;
		result = null;
	}
	
	public String getExcluded(){
		return excluded;
	}
	
	public void setExcluded(String s){
		excluded = s;
	}
	
	public String getResult(){
		return result;
	}
	
	public void setResult(String s){
		result = s;
	}
	
}
