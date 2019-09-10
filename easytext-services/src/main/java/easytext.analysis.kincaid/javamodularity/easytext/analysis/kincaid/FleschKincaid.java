/**
 * The mrJar Plugin Supports Multi-module Grouping, Compilation and Packaging with --module-source-path. Also Supports Running JavaFX Applications..
 *
 * Copyright (C) 2019 lingocoder <plugins@lingocoder.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package javamodularity.easytext.analysis.kincaid;

import javamodularity.easytext.analysis.api.Analyzer;

import java.util.ArrayList;
import java.util.List;

public class FleschKincaid  implements Analyzer {

   public static final String NAME = "Flesch-Kincaid";

   @Override
   public String getName() {
     return NAME;
   }

   @Override
   public double analyze(List<List<String>> sentences) {
      float totalsentences = sentences.size();
      float totalwords = sentences.stream().mapToInt(sentence -> sentence.size()).sum();
      float totalsyllables = sentences.stream()
         .flatMapToInt(sentence ->
            sentence.stream().mapToInt(word -> countSyllables(word)))
         .sum();
      return 206.835 - 1.015 * (totalwords / totalsentences) - 84.6 * (totalsyllables / totalwords);
   }

   private int countSyllables(String word) {
      int syllables = 0;
      boolean prevNonVowel = false;
      for(int i = 0; i < word.length(); i++) {
         boolean isVowel = isVowel(word.toLowerCase().charAt(i));
         if(prevNonVowel && isVowel && i != word.length() - 1) {
            syllables++;
         }
         prevNonVowel = !isVowel;
      }
      syllables = syllables == 0 ? 1 : syllables;
      return syllables;
   }

   private boolean isVowel(char letter) {
      return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
   }

}
