INSERT INTO Address (id_address, kindOfStreet, streetName, postalCode, city) VALUES (
    NEXTVAL('hibernate_sequence'),
    'Calle', 'Nuestra Señora de Lourdes, 38', '41510', 'Mairena del Alcor');

INSERT INTO User (id_user, userName, password, firstName, lastName, address_id, phoneNumber, email) VALUES (
    NEXTVAL('hibernate_sequence'),
    'isagonrod',
    'usuario',
    'Isa',
    'González',
    1,
    '+34 680701552',
    'isabelmaria.gonzalezrodriguez@iesvalleinclan.es');

INSERT INTO UserAdmin (id_admin, salary, user_id) VALUES (NEXTVAL('hibernate_sequence'), 60000, 1);