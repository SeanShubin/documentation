
in maven project to deploy

https://github.com/SeanShubin/deploytest


mvn deploy -Dgpg.passphrase=*** -Dgpg.keyname=seanshubin.com --settings=/Users/seanshubin/.m2/deploy-to-maven-central-settings.xml

https://oss.sonatype.org/#stagingRepositories

gpg2 --keyserver hkp://pool.sks-keyservers.net --send-keys 8822B9A8
gpg2 --keyserver hkp://keyserver.ubuntu.com --send-keys 8822B9A8
gpg2 --keyserver hkp://pgp.mit.edu --send-keys 8822B9A8

find . | grep "\.asc$"
gpg2 --verify ./analysis/target/detangler-analysis-0.9-javadoc.jar.asc
gpg2 --verify ./analysis/target/detangler-analysis-0.9-sources.jar.asc
