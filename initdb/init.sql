CREATE TABLE parking (
    id varchar(255) PRIMARY KEY NOT NULL,
    name varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    city varchar(255) NOT NULL
);

CREATE TABLE bookings (
    booking_id varchar(255) PRIMARY KEY NOT NULL,
    name varchar(255) NOT NULL,
    plate varchar(255) NOT NULL,
    parking_id varchar(255) NOT NULL
);