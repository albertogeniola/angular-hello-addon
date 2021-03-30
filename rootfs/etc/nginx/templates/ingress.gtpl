server {
    listen {{ .interface }}:{{ .port }} default_server;

    include /etc/nginx/includes/server_params.conf;
    include /etc/nginx/includes/proxy_params.conf;

    root /var/www/html;

    location / {
        allow   172.30.32.2;
        deny    all;

        try_files $uri $uri/ /index.html;

    }
}