pipeline {
	agent none 
	stages {
		steps {
			sh 'docker-compose -p docker up -d'
			sh 'mvn -f EDAF clean test'
		}
	}
}
