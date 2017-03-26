
public class Feelings {
private String emotion;
private String solution;
private String quote;
public Feelings (String _emotion, String  _solution, String _quote){
	emotion = _emotion;
	solution= _solution;
	quote = _quote;
}
public String getEmotion(){
	return emotion;
}

public boolean equals(String _emotion) {
	if(_emotion.toUpperCase().equals(getEmotion())){
	return true;
	}
	return false;
}// equals method

public String toString() {
	return "Advice: " +solution + "\n" + "Practical things for you to do: " + quote;
}// to string
}//class Feelings
