/**
 * The mrJar Plugin Supports Multi-module Grouping, Compilation and Packaging with --module-source-path. Also Supports Running JavaFX Applications.
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
package javamodularity.providers.main;

import java.util.List;
import javamodularity.easytext.analysis.api.Analyzer;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        Iterable<Analyzer> analyzers = ServiceLoader.load(Analyzer.class);

        for (Analyzer analyzer : analyzers) {
            System.out.println(analyzer.getName());
        }
    }
}
