Instruction:
1. Have docker running
2. In terminal run
    * mkdir -p $HOME/docker/volumes/postgres
    * docker run --rm --name pg-docker -e POSTGRES_PASSWORD=docker -d -p 5432:5432 -v $HOME/docker/volumes/postgres:/var/lib/postgresql/data  postgres:11
    * docker exec -it pg-docker bash 
    * psql -h localhost -U postgres -d postgres 
    * Can now run postgres commands to check everythign is working
3. When running flyway migration, make sure the project build (need to see the schema in target folder)



https://www.postgresqltutorial.com/postgresql-create-function/