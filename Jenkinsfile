pipeline {
    agent {
        docker {
            image 'node:latest'
        }
    }

    stages {
        stage('Build') {
            steps {
                sh 'node --version'
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
