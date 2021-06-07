create table "crossroad"(
    id SERIAL PRIMARY KEY,
    city VARCHAR(200)
);

create table "traffic_light"(
    id SERIAL PRIMARY KEY,
    crossroad_id INTEGER REFERENCES crossroad
);

create table "road"(
    id SERIAL PRIMARY KEY,
    crossroad_id INTEGER REFERENCES crossroad
);

create table "car" (
    id SERIAL PRIMARY KEY ,
    speed INTEGER,
    road_id INTEGER REFERENCES road
);
