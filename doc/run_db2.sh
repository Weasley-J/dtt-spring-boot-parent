#!/bin/bash

IMG='ibmcom/db2:latest'
WORK_DIR='/usr/local/db2'
CONTAINER='db2'

rm -rfv "$WORK_DIR"
mkdir -pv $WORK_DIR/{database,}
chmod 777 -vR $WORK_DIR

docker rmi -f $IMG && docker pull $IMG

docker network rm mynet
docker network create --driver bridge --subnet 172.18.0.0/16 --gateway 172.18.0.1 mynet

docker stop $CONTAINER && docker rm -f $CONTAINER
docker run --name $CONTAINER --privileged=true \
  --net mynet \
  -p 50000:50000 \
  -e LICENSE=accept \
  -e DBNAME=testdb \
  -e DB2INSTANCE=weasley \
  -e DB2INST1_PASSWORD=123456 \
  -v $WORK_DIR/database:/database \
  -v /etc/timezone:/etc/timezone \
  -v /etc/localtime:/etc/localtime \
  -d $IMG

docker logs -f db2

docker exec -it db2 /bin/bash
