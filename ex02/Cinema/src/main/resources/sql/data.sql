insert into halls (seats) VALUES
    (
        '100'
    );
insert into movies (title, year, restriction, description) VALUES
    (
        'The Terminator',
        '1984',
        '16',
        'The Terminator is a 1984 American science fiction action film directed by James Cameron.'
    );

INSERT INTO chat_user (avatar_id, name, password)
values ('1', 'nasya',
        '$2a$10$BEsEiXoQwpqVQmseTtprWORMl.j.XZWqT6N69Sj0qC6eA2KcSmLFS');

INSERT INTO avatars (id, filepath, mimetype, originalname, imagesize, uniquename, user_id)
values (1,
        '/home/anastasia/Desktop/FWA-my/ex02/Cinema/target/cargo/configurations/tomcat9x/webapps/images/1/0_cat.png',
        'image/png',
        'cat.png',
        53621,
        '0_cat.png',
        1
        );
