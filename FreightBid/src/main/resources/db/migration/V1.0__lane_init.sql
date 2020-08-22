create table lanes (
lane_id BIGINT auto_increment,
shipping_city VARCHAR(250),
shipping_state VARCHAR(250),
receiving_city VARCHAR(250),
receiving_state VARCHAR(250),
commodity VARCHAR(250),
volume BIGINT,
bid_id BIGINT,
PRIMARY KEY(lane_id)

);