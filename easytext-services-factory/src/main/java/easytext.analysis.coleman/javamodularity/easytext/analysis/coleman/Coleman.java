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
package javamodularity.easytext.analysis.coleman;

import javamodularity.easytext.analysis.api.Analyzer;

import java.util.ArrayList;
import java.util.List;

public class Coleman implements Analyzer {

   public static final String NAME = "Coleman-Liau";

   @Override
   public String getName() {
     return NAME;
   }

   @Override
   public double analyze(List<List<String>> sentences) {
      float totalsentences = sentences.size();
      float words = sentences.stream().mapToInt(sentence -> sentence.size()).sum();
      float letters = sentences.stream().flatMapToInt(sentence -> sentence.stream().mapToInt(word -> word.length())).sum();

      return 0.0588 * (letters / (words / 100)) - 0.296 * (totalsentences / (words / 100)) - 15.8;

   }

}
