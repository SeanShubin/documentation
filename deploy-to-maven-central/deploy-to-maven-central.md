
in maven project to deploy
    <distributionManagement>
        <repository>
            <id>maven staging</id>
            <url>https://oss.sonatype.org/service/local/staging/deploy/maven2</url>
        </repository>
    </distributionManagement>


mvn verify gpg:sign deploy -Dgpg.passphrase=*** --settings=/Users/sshubin/.m2/deploy-to-maven-central-settings.xml

https://oss.sonatype.org/#stagingRepositories

