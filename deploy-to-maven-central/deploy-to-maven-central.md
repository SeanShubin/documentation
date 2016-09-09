
in maven project to deploy
    <distributionManagement>
        <repository>
            <id>maven staging</id>
            <url>https://oss.sonatype.org/service/local/staging/deploy/maven2</url>
        </repository>
    </distributionManagement>


mvn clean verify gpg:sign deploy -Dgpg.passphrase=*** --settings=/Users/seanshubin/.m2/deploy-to-maven-central-settings.xml

https://oss.sonatype.org/#stagingRepositories

gpg2 --keyserver hkp://pool.sks-keyservers.net --send-keys 8822B9A8
gpg2 --keyserver hkp://keyserver.ubuntu.com --send-keys 8822B9A8
gpg2 --keyserver hkp://pgp.mit.edu --send-keys 8822B9A8
