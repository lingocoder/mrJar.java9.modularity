# mrJar.java9.modularity

#### As of v0.0.9, the [***mrJar*** *Plugin*](https://bit.ly/mrJar) Supports Multi-module Grouping, Compilation and Packaging with *`--module-source-path`*. Also, Running JavaFX Applications.

This project is based on an example from @paulbakker's and @sandermak's [*Java 9 Modularity*](http://bit.ly/j9EgRepo) examples repository. It demonstrates the following:

1. ***mrJar's*** support for *`--module-source-path`*
2. ***mrJar's*** support for JavaFX applications
3. ***mrJar's*** support for running modular applications from the command line
4. How ***mrJar*** makes it easy to migrate [*a modular service-based project originally built and ran with shell scripts*](http://bit.ly/j9dularity), to instead be built more simply and ran more conveniently using a build tool
5. How easily ***mrJar*** makes compiling and packaging projects with dozens of modules

##### How to run the *mrJar.java9.modularity* project?

1. Clone it or download it as a zip <br />
   • *`cd`* to the root folder of the project
2. Type any of the following in a terminal: <br />
   a. *`gradlew runProviders`* <br />
   b. *`gradlew runServices`*<sup><sup>1</sup></sup> <br />
   c. *`gradlew runFactory`* <br />
   d. *`gradlew runServicesFactory`* <br />
   e. *`gradlew runFiltering`* <br />               

<br />
<br />
<br />


__

<sup><sup>1</sup></sup><sup> — *The `easytext-services` gui could take a long time to launch. Please be patient. Give it some time and it should eventually start. Also, after clicking that gui's `Calculate` button, the status bar might say „...: NaN“. That same behavior is present in [the code of the original module](http://bit.ly/j9dularity) from which this one is copied.*</sup>