#  创建Exam1
mvn archetype:generate -DgroupId=com.hand -DartifactId=Exam2 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false -DarchetypeCatalog=internal

#执行项目
cd Exam1
先执行
mvn exec:java -Dexec.mainClass="com.jikexueyuan.testmysetversocket1.main.MyServerSocker"
再执行
mvn exec:java -Dexec.mainClass="com.jikexueyuan.myjavachatclient.main.StartClient"

