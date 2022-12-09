Welcome to our project repo!
To get started with building and testing our game, here's a basic breakdown of the commands you'll use.

BUILDING:

1. (Optional) Run 'mvn clean' at the start to made sure there are no target files from previous builds
2. Use 'mvn package' to build all the files under src/main/java and src/test/java

RUNNING:

1. Once the build was successful from the previous section, type in 'java -cp target/project-1.0-SNAPSHOT.jar Game' to run the game.
2. If you would like to view the Javadocs, navigate to '${basedir}/target/apidocs' and open index.html to view the list of classes. NOTE: Cat, GameTimer, Score, and UserInput could not have their HTML pages generated so you will have to go inside the corresponding .java files to view the methods.
3. Enjoy!

TESTING:
1. Run 'mvn test' to just run the test files.
NOTE: while building all the test files, the build may temporarily halt on MapTest as the window and graphics are rendering. Please do not exit the build as the normal progress will resume shortly.
2. If you wish to see the full code coverage report, navigate to the target/site/jacoco folder and open up the index.html file.
NOTE: If you do not see the target/site folder, you may need to build the project from scratch. In that case, run 'mvn clean' followed by 'mvn package' and try to navigate to the target/site folder again.
