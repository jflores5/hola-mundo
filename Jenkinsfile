pipeline {
	agent any 
	stages {
		stage('test') {
			steps {
				sh 'docker run -d -p 4444:4444 --name selenium-hub selenium/hub'
				sh 'docker run -d --link selenium-hub:hub selenium/node-chrome'
				sh 'mvn -f EDAF clean test'
			}
		}
	}
}
