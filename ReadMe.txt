Після завантаження Linux Ubuntu Server переходимо в режим суперкористувача (рут)
sudo -i

Заходимо суперкористувачем в СУБД:
mysql

Створюємо БД
CREATE DATABASE university;

Переходимо в створену базу даних
USE university;

Створюємо таблицю:
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

Додаємо новий запис в створену таблицю:
INSERT INTO user (username, password) VALUES ('admin', 'password');

Налаштуємо користувача для підключення до СУБД:
CREATE USER 'user'@'%' IDENTIFIED BY 'UserPassword123!';

Надаємо усі привілеї цьому користувачу:
GRANT ALL PRIVILEGES ON *.* TO 'user'@'%' WITH GRANT OPTION;

Активуємо зміни:
FLUSH PRIVILEGES;

Виходимо з MySQL:
quit

