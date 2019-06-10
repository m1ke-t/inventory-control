INSERT INTO dict_role (id, description) VALUES
  (1, 'ADMIN'),
  (2, 'USER'),
  (3, 'GUEST');
  
  INSERT INTO users (id, login, password, description, disabled) VALUES
  (0, 'admin', '$2a$10$Rj3NMGE88KJnyiutHJbNaup/spC5XV.WChz8bI4YBB4OvdYTknzGG', 'Admin', FALSE), -- hashed pass 123
  (1, 'user', '$2a$10$Rj3NMGE88KJnyiutHJbNaup/spC5XV.WChz8bI4YBB4OvdYTknzGG', 'User', FALSE),
  (2, 'guest', '$2a$10$Rj3NMGE88KJnyiutHJbNaup/spC5XV.WChz8bI4YBB4OvdYTknzGG', 'Guest', FALSE);
  
  
  INSERT INTO user_role (user_id, role_id) VALUES
  (0, 1),
  (1, 2),
  (2, 3);