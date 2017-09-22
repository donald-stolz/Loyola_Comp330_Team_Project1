import java.util.*;

public class Notes{
	// Key: @identifier Value: fileName
	TreeMap<String,ArrayList<String>> mentions = new TreeMap<String,ArrayList<String>>();
	// Key: #identifier Value: fileName
	TreeMap<String,ArrayList<String>> topics = new TreeMap<String,ArrayList<String>>();
	// Key: fileName		Value: ^identifiers
	TreeMap<String,ArrayList<String>> refs = new TreeMap<String,ArrayList<String>>();


	// Methods for setting values
	public void setMentions(TreeMap<String,ArrayList<String>> mentions){
		this.mentions = mentions;
	}
	public void setTopics(TreeMap<String,ArrayList<String>> topics){
		this.topics = topics;
	}
	public void setRefs(TreeMap<String,ArrayList<String>> refs){
		this.refs = refs;
	}

	// Methods for retrieving all values
	public TreeMap<String,ArrayList<String>> getAllMentions(){
		return mentions;
	}
	public TreeMap<String,ArrayList<String>> getAllTopics(){
		return topics;
	}
	public TreeMap<String,ArrayList<String>> getAllRefs(){
		return refs;
	}

	// Methods for retrieving select value
	public TreeMap<String,ArrayList<String>> getMentions(ArrayList<String> search){
		search.remove(0);
		TreeMap<String,ArrayList<String>> selection = new TreeMap<String,ArrayList<String>>(String.CASE_INSENSITIVE_ORDER);
		ArrayList<String> selected;

		for(String s:search) {
			selected = new ArrayList<String>(mentions.get("@" + s));
			selection.put("@" + s, selected);
		}

		return selection;
	}
	public TreeMap<String,ArrayList<String>> getTopics(ArrayList<String> search){
		search.remove(0);
		TreeMap<String,ArrayList<String>> selection = new TreeMap<String,ArrayList<String>>(String.CASE_INSENSITIVE_ORDER);
		ArrayList<String> selected;

		for(String s:search) {
			selected = new ArrayList<String>();
			selected = mentions.get("#" + s);
			selection.put("#" + s, selected);
		}

		return selection;
	}
}
