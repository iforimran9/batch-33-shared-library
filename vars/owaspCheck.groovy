def call(String nvdApiKey) {
    dependencyCheck(
        additionalArguments: "--scan ./ --nvdApiKey ${nvdApiKey}",
        odcInstallation: 'DC'
    )

    dependencyCheckPublisher pattern: '**/dependency-check-report.xml'
}
