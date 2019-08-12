DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250),
  password VARCHAR(250),
  code VARCHAR(250)
);

INSERT INTO user (user_name, password, code) VALUES
  ('abc123', 'abc123', 'abc123');
