CREATE TABLE users (
    id           VARCHAR(36)  NOT NULL,
    firebase_uid VARCHAR(128) NOT NULL,
    email        VARCHAR(255) NOT NULL,
    display_name VARCHAR(100) NOT NULL,
    created_at   TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_users             PRIMARY KEY (id),
    CONSTRAINT uq_users_firebase    UNIQUE (firebase_uid),
    CONSTRAINT uq_users_email       UNIQUE (email)
);

CREATE TABLE wish_lists (
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    user_id     VARCHAR(36) NOT NULL,
    share_code  VARCHAR(12) NOT NULL,
    target_size INT         NOT NULL DEFAULT 10,
    created_at  TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_wish_lists            PRIMARY KEY (id),
    CONSTRAINT uq_wish_lists_user       UNIQUE (user_id),
    CONSTRAINT uq_wish_lists_share_code UNIQUE (share_code),
    CONSTRAINT fk_wish_lists_user       FOREIGN KEY (user_id)
        REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE user_interests (
    id      BIGINT       NOT NULL AUTO_INCREMENT,
    list_id BIGINT       NOT NULL,
    keyword VARCHAR(100) NOT NULL,

    CONSTRAINT pk_user_interests      PRIMARY KEY (id),
    CONSTRAINT uq_user_interests_pair UNIQUE (list_id, keyword),
    CONSTRAINT fk_user_interests_list FOREIGN KEY (list_id)
        REFERENCES wish_lists(id) ON DELETE CASCADE
);

CREATE TABLE gift_items (
    id                  BIGINT         NOT NULL AUTO_INCREMENT,
    list_id             BIGINT         NOT NULL,
    name                VARCHAR(255)   NOT NULL,
    product_url         VARCHAR(1000)  NULL,
    image_url           VARCHAR(1000)  NULL,
    price               DECIMAL(10, 2) NULL,
    status              ENUM('AVAILABLE', 'RESERVED', 'PURCHASED') NOT NULL DEFAULT 'AVAILABLE',
    reserved_by_user_id VARCHAR(36)    NULL,
    reserved_at         TIMESTAMP      NULL,
    purchased_at        TIMESTAMP      NULL,
    created_at          TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_gift_items         PRIMARY KEY (id),
    CONSTRAINT fk_gift_items_list    FOREIGN KEY (list_id)
        REFERENCES wish_lists(id) ON DELETE CASCADE,
    CONSTRAINT fk_gift_items_reserver FOREIGN KEY (reserved_by_user_id)
        REFERENCES users(id) ON DELETE SET NULL
);

CREATE TABLE list_access (
    id               BIGINT      NOT NULL AUTO_INCREMENT,
    list_id          BIGINT      NOT NULL,
    accessor_user_id VARCHAR(36) NOT NULL,
    accessed_at      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT pk_list_access      PRIMARY KEY (id),
    CONSTRAINT uq_list_access_pair UNIQUE (list_id, accessor_user_id),
    CONSTRAINT fk_list_access_list FOREIGN KEY (list_id)
        REFERENCES wish_lists(id) ON DELETE CASCADE,
    CONSTRAINT fk_list_access_user FOREIGN KEY (accessor_user_id)
        REFERENCES users(id) ON DELETE CASCADE
);

CREATE INDEX idx_gift_items_list_id  ON gift_items(list_id);
CREATE INDEX idx_gift_items_status   ON gift_items(list_id, status);
CREATE INDEX idx_user_interests_list ON user_interests(list_id);
CREATE INDEX idx_list_access_list    ON list_access(list_id);
