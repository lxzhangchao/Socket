#  创建Exam1
mvn archetype:generate -DgroupId=com.hand -DartifactId=Exam1 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false -DarchetypeCatalog=internal

#执行项目
cd Exam1

mvn exec:java -Dexec.mainClass="com.hand.Get"

