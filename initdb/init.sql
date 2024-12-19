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

INSERT INTO parking (id, name, address, city)
VALUES ('cd5bf97d-83b0-4ae6-9797-41be41f4fe12', 'Underground', 'Red Square', 'Moscow');

INSERT INTO bookings (booking_id, name, plate, parking_id)
VALUES ('4583d2b9-ab55-4858-9b15-d50a27c3961e', 'Toyota Camry', 'P284MA196', 'cd5bf97d-83b0-4ae6-9797-41be41f4fe12');