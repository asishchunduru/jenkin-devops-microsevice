pipeline {
	agent any
	stages {
		stage('Build') {
			steps{
				echo "Build"
			}
		}
		stage('Test') {
			steps{
				echo "Test"
			}
		}
		stage('Intergration Test') {
			steps{
				echo "Intergration Test"
			}

		
		}
	} post {
		always{
			echo "i am good always"
		}
		success{
			echo "i work for success"
		}
		failure{
			echo "keep trying"
		}
	}
}
	