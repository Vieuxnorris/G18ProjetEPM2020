CREATE TABLE Employee (
    id bigint ,
    name VARCHAR(50),
    address VARCHAR(150)
);
/*
CREATE TABLE DirectDepositAccount (
    empId INTEGER NOT NULL,
    bank VARCHAR(50) NOT NULL,
    account VARCHAR(50) NOT NULL
);

CREATE TABLE MailMethod (
    empId INTEGER NOT NULL,
    mail VARCHAR(50) NOT NULL
);

CREATE TABLE PaymentMethod (
    empId INTEGER NOT NULL,
    payMethod VARCHAR(50) NOT NULL
);

CREATE TABLE PaymentClassification (
    empId INTEGER NOT NULL,
    salary VARCHAR(50) NOT NULL
);

CREATE TABLE Commission (
    empId INTEGER NOT NULL,
    salary VARCHAR(50) NOT NULL
);

CREATE TABLE Hourly (
    empId INTEGER NOT NULL,
    hoursRate VARCHAR(50) NOT NULL
);

CREATE TABLE SalesReceipt (
    empId INTEGER NOT NULL,
    date DATE NOT NULL,
    saleRate DOUBLE PRECISION NOT NULL
);

CREATE TABLE TimeCard (
    empId INTEGER NOT NULL,
    date DATE NOT NULL,
    hours DOUBLE PRECISION NOT NULL
);

/*