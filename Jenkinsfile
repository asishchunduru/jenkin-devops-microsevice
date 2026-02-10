pipeline {
    agent {
        docker {
            image 'maven:3.9.12-eclipse-temurin-17'
        }
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn --version'
                echo "Build"
            }
        }

        stage('Test') {
            steps {
                echo "Test"
            }
        }

        stage('Integration Test') {
            steps {
                echo "Integration Test"
            }
        }
    }

    post {
        always {
            echo "i am good always"
        }
        success {
            echo "i work for success"
        }
        failure {
            echo "keep trying"
        }
    }
}
