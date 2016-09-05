
in maven project to deploy
    <distributionManagement>
        <repository>
            <id>maven staging</id>
            <url>https://oss.sonatype.org/service/local/staging/deploy/maven2</url>
        </repository>
    </distributionManagement>

in settings.xml
    <server>
        <id>maven-staging</id>
        <username>SeanShubin</username>
        <password>***</password>
    </server>


mvn deploy -Dgpg.passphrase=***
https://oss.sonatype.org/#stagingRepositories
find . | grep "\-javadoc\.jar"
