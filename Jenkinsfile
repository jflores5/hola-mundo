pipeline {
	agent none 
	stages {
		stage('SeleniumHub') {
			agent {
				docker {
					image 'selenium/hub'
					args '-d -p 4444:4444 --name selenium-hub'
				}
				steps {}
			}
		}
		stage('SeleniumNode') {
			agent {
				docker {
					image 'selenium/node-chrome'
					args '-d --link selenium-hub:hub'
				}
				steps {}
			}
		}
		stage('Test') {
			steps {
				sh 'mvn -f EDAF clean test'
			}
		}
	}
}
