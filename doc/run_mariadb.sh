#!/bin/bash

WORK_DIR='/usr/local/mariadb'
IMG='mariadb:latest'
CONTAINER='mariadb'

mkdir -pv $WORK_DIR/{conf,conf/conf.d}
touch $WORK_DIR/conf/my.cnf $WORK_DIR/conf/conf.d/config-file.cn
chmod 777 $WORK_DIR

docker rmi -f $IMG && docker pull $IMG

docker network rm mynet
docker network create --driver bridge --subnet 172.18.0.0/16 --gateway 172.18.0.1 mynet

docker stop $CONTAINER && docker rm -f $CONTAINER
docker run --name $CONTAINER \
  -p 3308:3306 \
  --net mynet \
  -v $WORK_DIR:/var/lib/mysql \
  -e MARIADB_ROOT_PASSWORD=123456 \
  -v /etc/timezone:/etc/timezone \
  -v /etc/localtime:/etc/localtime \
  -d $IMG

clear && docker logs -f mariadb

# enter container
docker exec -it mariadb bash

mysql -u root -p123456

use mysql;
