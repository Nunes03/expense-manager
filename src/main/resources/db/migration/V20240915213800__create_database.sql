create table category
(
    id          UUID         not null,
    name        varchar(100) not null,
    description varchar(500),
    constraint pk_category PRIMARY KEY (id)
);

create table expense
(
    id          UUID          not null,
    name        varchar(100)  not null,
    description varchar(500),
    value       decimal(7, 2) not null,
    date        date          not null,
    category_id UUID          not null,
    constraint pk_expense primary key (id)
);

alter table expense
    add constraint fk_expense_on_category
        foreign key (category_id) references category (id);