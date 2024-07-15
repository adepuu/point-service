-- Create the users table
CREATE TABLE IF NOT EXISTS users
(
    id           BIGSERIAL PRIMARY KEY,
    email        VARCHAR(50) UNIQUE,
    display_name VARCHAR(100),
    points       DECIMAL(10, 2)           DEFAULT 0.0,
    created_at   TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Create the roles table
CREATE TABLE IF NOT EXISTS points
(
    id          BIGSERIAL PRIMARY KEY,
    user_id     BIGINT REFERENCES users (id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    points      DECIMAL(10, 2)           DEFAULT 0.0,
    remaining   DECIMAL(10, 2)           DEFAULT 0.0,
    is_deducted BOOLEAN                  DEFAULT FALSE,
    expired_at  TIMESTAMP WITH TIME ZONE DEFAULT NULL,
    created_at  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

