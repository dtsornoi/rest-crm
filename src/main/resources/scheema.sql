create table if not exists employees(
    id bigint identity,
    first_name varchar (50),
    last_name varchar (50),
    email varchar (50)
);

create table if not exists users(
    id bigint identity,
    username varchar (50),
    user_password varchar (50),
    authorities varchar (50)
);
