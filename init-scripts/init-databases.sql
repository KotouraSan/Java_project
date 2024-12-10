CREATE DATABASE project_auth;
CREATE DATABASE project_customer;
CREATE DATABASE project_delivery;
CREATE DATABASE project_order;
CREATE DATABASE project_shop;
CREATE DATABASE zipkin;

GRANT ALL PRIVILEGES ON DATABASE project_auth TO postgres;
GRANT ALL PRIVILEGES ON DATABASE project_customer TO postgres;
GRANT ALL PRIVILEGES ON DATABASE project_delivery TO postgres;
GRANT ALL PRIVILEGES ON DATABASE project_order TO postgres;
GRANT ALL PRIVILEGES ON DATABASE project_shop TO postgres;
GRANT ALL PRIVILEGES ON DATABASE zipkin TO postgres;
