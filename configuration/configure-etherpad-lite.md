# Configuring Etherpad Lite


## Summary
- create digital ocean [droplet](https://www.digitalocean.com/), these instructions used Ubuntu 16.04.3 x64
- install dependencies
- in the nginx.conf file, delete the entirety of the http {} section and replace it with the content detailed later in this document 
- create user
- clone etherpad-lite
- launch etherpad-lite

## Commands

    ssh -o StrictHostKeyChecking=no root@HOSTNAME
    apt-get update
    apt-get -y upgrade
    curl -sL https://deb.nodesource.com/setup_8.x | sudo -E bash -
    apt-get -y install gzip git curl python libssl-dev pkg-config build-essential nginx nodejs
    vim /etc/nginx/nginx.conf
    nginx -s reload
    useradd -m -d /home/sean sean
    passwd sean
    su sean
    cd ~
    git clone git://github.com/ether/etherpad-lite.git
    cd etherpad-lite
    bin/run.sh

## Contents of http {} section within nginx configuration

    server {
        listen       80;
        location /pad/ {
            proxy_pass http://127.0.0.1:9001/;
        }
    }
