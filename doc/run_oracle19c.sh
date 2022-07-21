#!/bin/bash

IMG='registry.cn-hangzhou.aliyuncs.com/zhuyijun/oracle:19c'
WORK_DIR='/usr/local/oracle/oradata'
CONTAINER='oracle19c'

# pull image
# pull ${IMG}

# mkdir
rm -rfv "$WORK_DIR"
mkdir -p ${WORK_DIR}
chmod 777 ${WORK_DIR}

# account parameter
ORACLE_SID="lwj"
ORACLE_PDB="lwjpdb"
ORACLE_PWD="123456"

# run container
docker stop ${CONTAINER}
docker rm -f ${CONTAINER}
docker run --name ${CONTAINER} \
  --net mynet \
  -p 1521:1521 -p 5500:5500 \
  -e ORACLE_SID=${ORACLE_SID} \
  -e ORACLE_PDB=${ORACLE_PDB} \
  -e ORACLE_PWD=${ORACLE_PWD} \
  -e ORACLE_EDITION=standard \
  -v /etc/timezone:/etc/timezone \
  -v /etc/localtime:/etc/localtime \
  -v ${WORK_DIR}:/opt/oracle/oradata \
  -d ${IMG}

#logs
docker logs -ft ${CONTAINER}

docker exec -it ${CONTAINER} /bin/bash

sqlplus / as sysdba

show pdbs;

# Setting SYS SYSTEM password
docker exec ${CONTAINER} ./setPassword.sh $ORACLE_PWD

docker exec -it --user root ${CONTAINER} /bin/bash

cp -rv /etc/skel/.bash_profile /root/

cp -rv /etc/skel/.bashrc /root/

yum install vi

vi ~/.bash_profile

source ~/.bash_profile

docker exec -it ${CONTAINER} /bin/bash

sqlplus system/123456@lwj

# select name,open_mode from v$pdbs;


# alter session set container=lwjpdb;

