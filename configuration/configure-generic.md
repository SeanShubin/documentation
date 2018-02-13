## On Server

    useradd -m -d /home/webmaster webmaster
    passwd webmaster
    apt-get update
    apt-get -y autoremove
    apt-get -y upgrade
    apt-get -y install nginx supervisor git
    vim /etc/nginx/nginx.conf
    nginx -s reload
    
    su webmaster
    cd ~
    mkdir .ssh
    chmod 700 .ssh
    touch .ssh/authorized_keys
    chmod 600 .ssh/authorized_keys
    vim /home/webmaster/.ssh/authorized_keys

    mkdir -p git/repo
    cd git/repo
    git init --bare
    cd hooks
    mv post-update.sample post-update
    vim /home/webmaster/git/repo/hooks/post-update
    cd ~/git
    git clone repo local

## On Client
    git clone webmaster@__HOST__:/home/webmaster/git/repo

## /home/webmaster/git/repo/hooks/post-update

    #!/bin/sh
    GIT_WORK_TREE=/home/webmaster/git/local git checkout -f 
    
## /etc/nginx/nginx.conf

    server {
        listen       80;
        server_name  localhost;
        root /home/webmaster/git/local/site;
        error_page 404 /index.html;
        location / {}
    }   
