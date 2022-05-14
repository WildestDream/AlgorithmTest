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
                message "continue to performance test?"
            }
            steps {
                bat 'mvn clean install'
            }
        }

        stage('message') {
            steps {
                bat 'echo hello world'
            }
        }
    }
}