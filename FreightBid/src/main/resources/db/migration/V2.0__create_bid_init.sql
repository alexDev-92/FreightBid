create table bids (
bid_id BIGINT auto_increment,
rate BIGINT,
carrier_id BIGINT,
lane_id BIGINT, 
primary key (bid_id),
CONSTRAINT lane_bid_fk FOREIGN KEY (lane_id) REFERENCES lanes (lane_id),
CONSTRAINT carrier_bid_fk FOREIGN KEY (carrier_id) REFERENCES bids (carrier_id)
);