INSERT INTO Address (idAddress, kindOfStreet, streetName, postalCode, city) VALUES (
    NEXTVAL('hibernate_sequence'),
    'Calle', 'Nuestra Señora de Lourdes, 38', '41510', 'Mairena del Alcor');

INSERT INTO User (idUser, userName, password, firstName, lastName, addressId, phoneNumber, email) VALUES (
    NEXTVAL('hibernate_sequence'),
    'isagonrod',
    'usuario',
    'Isa',
    'González',
    1,
    '+34 680701552',
    'isabelmaria.gonzalezrodriguez@iesvalleinclan.es');

INSERT INTO UserAdmin (salary, userId) VALUES (NEXTVAL('hibernate_sequence'), 60000, 1);