docker network create pg-network

export CURRENT_DIR=C:\Users\user\IdeaProjects\test\replication-spring-boot-example\ops

# MASTER DATABASENI ISHGA TUSHURAMIZ
docker run --name postgres-master -p 5432:5432 -v $CURRENT_DIR/data/master:/var/lib/postgresql/data -e POSTGRES_PASSWORD=postgres --network pg-network -d postgres:16

sleep 5

# MASTER DATABASEDA REPLICATION UCHUN USER YARATAMIZ
docker exec -e PGPASSWORD=postgres postgres-master psql -U postgres -d postgres -c "CREATE ROLE repluser WITH LOGIN REPLICATION PASSWORD 'replpass';"

docker stop postgres-master

# MASTERNING MALUMOTLARINI SLAVEGA O'TKAZAMIZ, RUCHNOY BACKUP
cp -R $CURRENT_DIR/data/master $CURRENT_DIR/data/slave

# MASTERNING CONFIGLARINI REPLICATIONGA TO'GRILAYMIZ
cp $CURRENT_DIR/config/master/pg_hba.conf $CURRENT_DIR/data/master/pg_hba.conf
cp $CURRENT_DIR/config/master/postgresql.conf $CURRENT_DIR/data/master/postgresql.conf

# SLAVENING CONFIGLARINI REPLICATIONGA TO'GRILAYMIZ
cp $CURRENT_DIR/config/slave/pg_hba.conf $CURRENT_DIR/data/slave/pg_hba.conf
cp $CURRENT_DIR/config/slave/postgresql.conf $CURRENT_DIR/data/slave/postgresql.conf
touch $CURRENT_DIR/data/slave/standby.signal

# MASTER VA SLAVENI QAYTA ISHGA TUSHURAMIZ
docker start postgres-master
docker run --name postgres-slave1 -p 5433:5432 -v $CURRENT_DIR/data/slave:/var/lib/postgresql/data -e POSTGRES_PASSWORD=postgres --network pg-network -d postgres:16
