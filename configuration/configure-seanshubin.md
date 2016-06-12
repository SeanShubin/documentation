Steps to configure cloud server for seanshubin.com
===

Connecting
===
I use digital ocean "droplets", created with ssh keys.
Choose Ubuntu 14.10 x64.
When a droplet is recreated, the host key changes, so to connect you will also remove it from known hosts.

    ssh-keygen -R 123.456.789.012

when using ssh, use this format: root@123.456.789.012

Add a user
===
    useradd -m -d /home/sean sean
    passwd sean

Configure git
=============


Update tools
===

    apt-get update
    apt-get autoremove
    apt-get -y upgrade
    apt-get -y install nginx supervisor git

Configure nginx
===
Add the listed server section.
Don't forget to comment out the listed includes.

    vim /etc/nginx/nginx.conf

    http {
    server {
        listen       80;
        server_name  localhost;
        root /home/sean/git/www;
        error_page 404 /index.html;
        location /foo/ {
            proxy_pass http://127.0.0.1:4000;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        }
        location /bar/ {
            proxy_pass http://127.0.0.1:5000;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        }
        location / {}
    }
    #include /etc/nginx/conf.d/*.conf;
    #include /etc/nginx/sites-enabled/*;
    }

    nginx -s reload

Install Java 8
===

    wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u91-b14/jdk-8u91-linux-x64.tar.gz
    mkdir -p /opt/jdk
    tar -zxvf jdk-8u91-linux-x64.tar.gz -C /opt/jdk
    rm jdk-8u91-linux-x64.tar.gz
    update-alternatives --install /usr/bin/java java /opt/jdk/jdk1.8.0_91/bin/java 100
    java -version

Supervise Applications
===

    vim /etc/supervisor/conf.d/apps.conf

    [program:foo]
    command=java -jar /home/sean/Copy/apps/foo.jar 4000
    user=sean
    autostart=true
    autorestart=true
    stderr_logfile=/var/log/foo.err.log
    stdout_logfile=/var/log/foo.out.log

    [program:bar]
    command=java -jar /home/sean/Copy/apps/bar.jar 5000
    user=sean
    autostart=true
    autorestart=true
    stderr_logfile=/var/log/bar.err.log
    stdout_logfile=/var/log/bar.out.log

Launch supervisor
===

    supervisorctl reread
    supervisorctl update
