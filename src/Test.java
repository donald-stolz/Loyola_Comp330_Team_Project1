/*
    Be able to report of all notes containing one or more mentions
      - Search Note search by key
      - Use while loop

    Be able to report notes by mention/keywords selectively
      - search mention/keyword map

    Be able to generate a report of all notes, organized by mention
      - Create sorted map key = mention; value = notes
    Be able to generate a report of all keywords
      - Create sorted map key = keyword; value = note; iterate through getKey()
    Be able to generate a report of all notes, organized by keyword
      -  Display key-value pairs

    Report of all notes in topological order
*/
// TODO: Replace Note with TreeMaps
import java.util.regex.*;

public class Test{
  public void SortNotes(String[] files){
    // Create a sorted hash map
    TreeMap mentions = new TreeMap();

    ArrayList<String> mentionKeys = new ArrayList<String>();

    // Check for '@' mentions
    mentionKeys = regexChecker("@[a-zA-Z_][0-9a-zA-Z_]*", /*file*/);
    for(String m:mentionKeys) {
        // keys match to an ArrayList so that multiple values can be stored
          // check if value exists
          if (mentions.containsKey(m)){
            // True: Add to ArrayList
            mentions.get(m).add(/*file*/);
          }
          else {
            // False: Add key value
            mentions.put(m, /*file*/);
          }
        }
    System.out.println(mentions);
  }

  public static ArrayList<String> regexChecker(String theRegex, String str2Check){

    ArrayList<String> matches = new ArrayList<String>();

    Pattern checkRegex = Pattern.compile(theRegex);
    Matcher regexMatcher = checkRegex.matcher(str2Check);

    while(regexMatcher.find()){
      if (regexMatcher.group().length() != 0) {
        matches.add(regexMatcher.group().trim());
      }
    }

    for(String m:matches) {
            System.out.println(m);
        }
    return matches;
    }

  public static void main(String[] args) {
    
  }
}
