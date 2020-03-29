-- *************** SqlDBM: PostgreSQL ****************;
-- ***************************************************;

-- ************************************** "enums"
CREATE TYPE user_type as ENUM
(
 'borrower', 'guarantor', 'both'
);

CREATE TYPE periodicity as ENUM
(
 'daily', 'weekly', 'monthly'
);

CREATE TYPE finance_type as ENUM
(
 'loan', 'easy_instalment'
);

-- ************************************** "users"

CREATE TABLE "users"
(
 "user_id" bytea NOT NULL,
 "name"    varchar(50) NOT NULL,
 "photo"   bytea NULL,
 "mobile"  varchar(20) NULL,
 "mobile2" varchar(50) NULL,
 "mail"    varchar(50) NULL,
 "city"    varchar(50) NOT NULL,
 "address" varchar(512) NULL,
 "type"    user_type NOT NULL,
 CONSTRAINT "PK_users" PRIMARY KEY ( "user_id" )
);








-- ************************************** "user_finances"

CREATE TABLE "user_finances"
(
 "finance_id"           bytea NOT NULL,
 "user_id"              bytea NOT NULL,
 "principal"            numeric NOT NULL,
 "interest_rate"        numeric NOT NULL,
 "term"                 numeric NOT NULL,
 "instalment_type"      periodicity NOT NULL,
 "date_of_commencement" date NOT NULL,
 "date_of_disbursement" date NOT NULL,
 "finance_type"         finance_type NOT NULL,
 "instalment_amount"    numeric NOT NULL,
 "remaining_principal"  numeric NOT NULL,
 "date_of_closure"      date NULL,
 CONSTRAINT "PK_user_finances" PRIMARY KEY ( "finance_id" ),
 CONSTRAINT "FK_16" FOREIGN KEY ( "user_id" ) REFERENCES "users" ( "user_id" )
);

CREATE INDEX "fkIdx_16" ON "user_finances"
(
 "user_id"
);









-- ************************************** "user_finances_extras"

CREATE TABLE "user_finances_extras"
(
 "finance_id"       bytea NOT NULL,
 "guarantor"        bytea NULL,
 "support_document" bytea NULL,
 CONSTRAINT "PK_user_finances_extras" PRIMARY KEY ( "finance_id" ),
 CONSTRAINT "FK_28" FOREIGN KEY ( "finance_id" ) REFERENCES "user_finances" ( "finance_id" ),
 CONSTRAINT "FK_40" FOREIGN KEY ( "guarantor" ) REFERENCES "users" ( "user_id" )
);

CREATE INDEX "fkIdx_28" ON "user_finances_extras"
(
 "finance_id"
);

CREATE INDEX "fkIdx_40" ON "user_finances_extras"
(
 "guarantor"
);








-- ************************************** "payments"

CREATE TABLE "payments"
(
 "payment_id"      bytea NOT NULL,
 "finance_id"      bytea NOT NULL,
 "date_of_payment" date NOT NULL,
 "amount"          numeric NOT NULL,
 CONSTRAINT "PK_payments" PRIMARY KEY ( "payment_id" ),
 CONSTRAINT "FK_45" FOREIGN KEY ( "finance_id" ) REFERENCES "user_finances" ( "finance_id" )
);

CREATE INDEX "fkIdx_45" ON "payments"
(
 "finance_id"
);







