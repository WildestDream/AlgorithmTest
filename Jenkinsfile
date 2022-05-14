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
        input {
            message "continue to exec performance?"
            ok "yes, just do it"
            submitter: "admin"
        }
        stage('Deploy') {
            steps {
                bat 'mvn clean install'
            }
        }
    }
}