// https://leetcode.com/problems/unique-morse-code-words

class Solution {
  public int uniqueMorseRepresentations(String[] words) {
    // Create a Morse code map
    String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", 
                           ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", 
                           ".--", "-..-", "-.--", "--.."};
    

    Set<String> seen = new HashSet<>();
    

    for (String word : words) {
      StringBuilder morseRepresentation = new StringBuilder();
      // Convert word to Morse code representation
      for (char letter : word.toCharArray()) {
        morseRepresentation.append(morseCode[letter - 'a']);
      }

      seen.add(morseRepresentation.toString());
    }
    
    return seen.size();
  }
}
