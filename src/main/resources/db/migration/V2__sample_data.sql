INSERT INTO users (id, firebase_uid, email, display_name) VALUES
    ('usr-001', 'firebase-uid-victor', 'victor@example.com', 'Víctor'),
    ('usr-002', 'firebase-uid-ana',    'ana@example.com',    'Ana'),
    ('usr-003', 'firebase-uid-marcos', 'marcos@example.com', 'Marcos'),
    ('usr-004', 'firebase-uid-lucia',  'lucia@example.com',  'Lucía');

INSERT INTO wish_lists (id, user_id, share_code, target_size) VALUES
    (1, 'usr-001', 'VICTOR24', 10),
    (2, 'usr-002', 'ANA-BDAY', 10),
    (3, 'usr-003', 'MARCOS-X', 10);

INSERT INTO user_interests (list_id, keyword) VALUES
    (1, 'ciencia ficción'),
    (1, 'teclados mecánicos'),
    (1, 'café de especialidad'),
    (1, 'programación'),
    (2, 'yoga'),
    (2, 'cocina japonesa'),
    (2, 'novela negra'),
    (3, 'fotografía'),
    (3, 'senderismo'),
    (3, 'videojuegos retro');

INSERT INTO gift_items (list_id, name, product_url, image_url, price, status, reserved_by_user_id, reserved_at, purchased_at) VALUES
    (1, 'Dune - Frank Herbert',
        'https://www.amazon.es/dp/8466338489',
        'https://m.media-amazon.com/images/I/91IM4W6LEML.jpg',
        12.99, 'AVAILABLE', NULL, NULL, NULL),

    (1, 'Keychron K2 Pro',
        'https://www.amazon.es/dp/B09GKPG31C',
        'https://m.media-amazon.com/images/I/71fS1HPNGFL.jpg',
        109.00, 'AVAILABLE', NULL, NULL, NULL),

    (1, 'Aeropress Coffee Maker',
        'https://www.amazon.es/dp/B0047BIWSK',
        'https://m.media-amazon.com/images/I/71gVXlG2SXL.jpg',
        39.99, 'RESERVED', 'usr-002', '2026-03-10 11:00:00', NULL),

    (1, 'Clean Code - Robert C. Martin',
        'https://www.amazon.es/dp/0132350882',
        'https://m.media-amazon.com/images/I/51E2055ZGUL.jpg',
        35.50, 'RESERVED', 'usr-003', '2026-03-12 09:30:00', NULL),

    (1, 'Fundación - Isaac Asimov',
        'https://www.amazon.es/dp/8497599538',
        'https://m.media-amazon.com/images/I/91OeXD8IXAL.jpg',
        11.50, 'AVAILABLE', NULL, NULL, NULL),

    (1, 'Timemore C2 Molinillo Manual',
        'https://www.amazon.es/dp/B07VPYMQMB',
        'https://m.media-amazon.com/images/I/71nRHqTYCNL.jpg',
        49.99, 'AVAILABLE', NULL, NULL, NULL),

    (1, 'The Pragmatic Programmer',
        'https://www.amazon.es/dp/0135957052',
        'https://m.media-amazon.com/images/I/71f743sOPoL.jpg',
        42.00, 'AVAILABLE', NULL, NULL, NULL),

    (1, 'Gateron Yellow Switch Pack',
        'https://www.amazon.es/dp/B07K87FMXK',
        NULL,
        18.00, 'AVAILABLE', NULL, NULL, NULL),

    (1, 'El problema de los tres cuerpos',
        'https://www.amazon.es/dp/8496173496',
        'https://m.media-amazon.com/images/I/813wlGxOLtL.jpg',
        13.99, 'AVAILABLE', NULL, NULL, NULL),

    (1, 'Chemex 6 tazas',
        'https://www.amazon.es/dp/B000I1WP7W',
        'https://m.media-amazon.com/images/I/81RsCMsWbUL.jpg',
        44.90, 'PURCHASED', 'usr-004', '2026-03-01 18:00:00', '2026-03-05 10:00:00'),

    (2, 'Esterilla de yoga Manduka PRO',
        'https://www.amazon.es/dp/B001R6YBKG',
        NULL,
        120.00, 'AVAILABLE', NULL, NULL, NULL),

    (2, 'Sartén para wok Joyce Chen',
        'https://www.amazon.es/dp/B00022WSH8',
        NULL,
        45.00, 'AVAILABLE', NULL, NULL, NULL);

INSERT INTO list_access (list_id, accessor_user_id) VALUES
    (1, 'usr-002'),
    (1, 'usr-003'),
    (1, 'usr-004'),
    (2, 'usr-001'),
    (2, 'usr-003');
