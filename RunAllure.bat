set ProjectPath=%~dp0
cd %ProjectPath%
echo %ProjectPath% 
set p=%PATH%
java -javaagent:"%ProjectPath%libAllure\aspectjweaver-1.8.10.jar" -classpath "%ProjectPath%bin;%ProjectPath%libAllure\*;%ProjectPath%libLog\*;%ProjectPath%libraries\*" org.testng.TestNG "%ProjectPath%bin\runUserTestcases.xml"
pause