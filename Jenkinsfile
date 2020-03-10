pipeline {
	agent any 
	stages {
		stage('test') {
			steps {
				sh 'docker-compose -p docker up -d'
				sh 'mvn -f EDAF clean test'
			}
		}
	}
}
