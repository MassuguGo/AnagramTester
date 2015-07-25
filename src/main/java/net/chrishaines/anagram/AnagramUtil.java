package net.chrishaines.anagram;

import java.util.HashMap;

@SuppressWarnings("javadoc")
public class AnagramUtil {
  
  @SuppressWarnings("boxing")
  public static boolean isAnagram(String str1, String str2) {
    if(str1 == null || str2 == null) {
      return false;
    }
    HashMap<Character,Integer> charCount = new HashMap<Character,Integer>();
    for(char ch1 : str1.toLowerCase().toCharArray()) {
      if(!Character.isWhitespace(ch1)) {
        if(charCount.containsKey(ch1)) {
          charCount.put(ch1, charCount.get(ch1)+1);
        } else {
          charCount.put(ch1, 1);
        }
      }
    }
    for(char ch2 : str2.toLowerCase().toCharArray()) {
      if(!Character.isWhitespace(ch2)) {
        if(!charCount.containsKey(ch2)) {
          return false;
        }
        int curCount = charCount.get(ch2)-1;
        if(curCount == 0) {
          charCount.remove(ch2);
        } else {
          charCount.put(ch2, curCount);
        }
      }
    }
    return charCount.isEmpty();
  }

}
