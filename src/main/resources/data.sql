-- Insert users
INSERT INTO users (email, display_name, points)
VALUES ('user1@example.com', 'User One', 100000.00),
       ('user2@example.com', 'User Two', 200000.00),
       ('user3@example.com', 'User Three', 150000.00);

-- Insert points for User One
INSERT INTO points (user_id, points, remaining, expired_at)
VALUES (1, 50000.00, 50000.00, '2024-07-14 00:00:00+00:00'), -- Expired yesterday
       (1, 30000.00, 30000.00, '2024-07-16 00:00:00+00:00'), -- Expires tomorrow
       (1, 20000.00, 20000.00, '2024-08-15 00:00:00+00:00');
-- Expires in a month

-- Insert points for User Two
INSERT INTO points (user_id, points, remaining, expired_at)
VALUES (2, 100000.00, 100000.00, '2024-07-13 00:00:00+00:00'), -- Expired two days ago
       (2, 50000.00, 50000.00, '2024-07-15 23:59:59+00:00'),   -- Expires today
       (2, 50000.00, 50000.00, '2024-09-15 00:00:00+00:00');
-- Expires in two months

-- Insert points for User Three
INSERT INTO points (user_id, points, remaining, expired_at)
VALUES (3, 75000.00, 75000.00, '2024-07-14 12:00:00+00:00'), -- Expired yesterday
       (3, 50000.00, 50000.00, '2024-07-15 02:00:00+00:00'), -- Expired a few minutes ago
       (3, 25000.00, 25000.00, '2024-07-17 00:00:00+00:00'); -- Expires in two days