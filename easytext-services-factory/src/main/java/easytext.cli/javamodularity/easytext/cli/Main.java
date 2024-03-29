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
package javamodularity.easytext.cli;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javamodularity.easytext.analysis.api.Analyzer;

public class Main {

   public static void main(String... args) throws IOException {
      if (args.length == 0) {
         System.out.println("Welcome to EasyText. Please provide a filename as input argument");
         return;
      }

      Path path = Paths.get(args[0]);
      System.out.println("Reading " + path);
      String text = new String(Files.readAllBytes(path), Charset.forName("UTF-8"));

      List<List<String>> sentences = toSentences(text);


      Iterable<Analyzer> analyzers = Analyzer.getAnalyzers();

      for (Analyzer analyzer: analyzers) {
        System.out.println(analyzer.getName() + ": " + analyzer.analyze(sentences));
      }
   }

   public static List<List<String>> toSentences(String text) {
      String removedBreaks = text.replaceAll("\\r?\\n", " ");
      ArrayList<List<String>> sentences = new ArrayList<>();
      for(String rawSentence: removedBreaks.split("[\\.\\?\\!]")) {
         List<String> words = toWords(rawSentence);
         if(words.size() > 0) {
            sentences.add(words);
         }
      }

      return sentences;
   }

   public static List<String> toWords(String sentence) {
      String[] rawWords = sentence.split("\\s+");
      List<String> words = new ArrayList<>();
      for(String rawWord: rawWords) {
         String word = rawWord.replaceAll("\\W", "");
         if(word.length() > 0) {
            words.add(word);
         }
      }

      return words;
   }

}
