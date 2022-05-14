pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Deploy') {
            input {
                message "continue to exec performance?"
                ok "yes, just do it"
                submitter: "admin"
            }
            steps {
                bat 'mvn clean install'
            }
        }
    }
}