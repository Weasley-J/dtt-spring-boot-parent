#!/bin/bash

IMG='mcr.microsoft.com/mssql/server:latest'
WORK_DIR='/usr/local/sqlserver'
CONTAINER='sqlserver'

mkdir -pv $WORK_DIR/{mssql,}
chmod 777 $WORK_DIR

docker rmi -f $IMG && docker pull $IMG

docker network rm mynet
docker network create --driver bridge --subnet 172.18.0.0/16 --gateway 172.18.0.1 mynet

docker stop $CONTAINER && docker rm -f $CONTAINER
docker run --name $CONTAINER --hostname $CONTAINER \
  -p 1433:1433 \
  --net mynet \
  -e "ACCEPT_EULA=Y" \
  -e "SA_PASSWORD=YourStrong@Passw0rd" \
  -v $WORK_DIR/mssql:/var/opt/mssql \
  -v /etc/timezone:/etc/timezone \
  -v /etc/localtime:/etc/localtime \
  -d $IMG

docker logs -f sqlserver
