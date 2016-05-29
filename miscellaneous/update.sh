#pre configuration
export JAVA_HOME=/opt/tools/jdk1.8.0_92/
export PATH=$PATH:/opt/tools/apache-maven-3.3.9/bin/

deployDir=/opt/applications/deployment/portfolio
appDir=/opt/applications/git/portfolio/

echo ---------  configuration --------
echo java home  $JAVA_HOME
echo path $PATH
echo deployment directory $deployDir
echo application directory $appDir
echo ---------------------------------
sleep 1

#stop existing application
cd $deployDir
echo ----- current directory changed to ----- 
pwd

echo ----- stopping existing process if any -----

pid=$(cat run.pid);
echo existing process pid : $pid

kill -9 $pid

echo ----- process stopped -----
sleep 5
#update codebase from git
cd $appDir
echo ----- current working directory changed -----
pwd

sleep 1
echo ----- updating codebase from git master -----

git pull origin master

echo code updated from git
sleep 5

#run application
echo ----- running updated application -----

nohup mvn spring-boot:run  > $deployDir/nohup.txt 2>&1 & echo $! > $deployDir/run.pid

echo -- script executed successfully , check logs in $deployDir
