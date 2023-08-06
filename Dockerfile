# PostgreSQL 이미지를 기반으로 합니다.
FROM postgres:latest

# # 데이터베이스 설정 파일을 복사합니다.
# COPY ./pgdata/postgresql.conf /etc/postgresql/postgresql.conf
# COPY ./pgdata/pg_hba.conf /etc/postgresql/pg_hba.conf 

# # 필요한 경우 초기 SQL 스크립트를 실행할 수 있습니다.
# # 예를 들어, 데이터베이스와 사용자를 생성하는 스크립트를 실행할 수 있습니다.
# COPY ./init.sql /docker-entrypoint-initdb.d/
