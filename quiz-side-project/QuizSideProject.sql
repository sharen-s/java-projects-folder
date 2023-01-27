BEGIN TRANSACTION;
DROP TABLE if EXISTS quiz, questions, answers, quiz_content CASCADE;

CREATE TABLE quiz
( quiz_id serial,
  theme varchar(50) NOT NULL,

  constraint pk_quiz_id primary key(quiz_id)
);

CREATE TABLE questions
( 
  questions_id serial,
  question_text varchar(200) NOT NULL,
  quiz_id int NOT NULL,
  theme varchar(50) NOT NULL,
 
  constraint pk_questions_id primary key(questions_id),
  constraint fk_quiz_id FOREIGN KEY (quiz_id) REFERENCES quiz (quiz_id)
);

CREATE TABLE answers
( answers_id serial,
  questions_id int NOT NULL,
  answer_1 varchar(200) NOT NULL,
  answer_2 varchar(200) NOT NULL,
  answer_3 varchar(200) NOT NULL,
  correct_answer varchar(50) NOT NULL,
 
 
 constraint pk_answers_id primary key(answers_id),
 constraint fk_question_id FOREIGN KEY (questions_id) REFERENCES questions (questions_id)
);

CREATE TABLE quiz_content
( quiz_content_id serial,
  quiz_id int NOT NULL,
  questions_id int NOT NULL,
  answers_id int NOT NULL,
 
 constraint pk_quiz_content_id primary key(quiz_content_id),
 constraint fk_questions foreign key (questions_id) references questions (questions_id),
 constraint fk_answers foreign key (answers_id) references answers (answers_id),
 constraint fk_quiz foreign key (quiz_id) references quiz (quiz_id)

);

INSERT INTO quiz (quiz_id, theme)
VALUES (1, 'history');

INSERT INTO quiz (quiz_id, theme)
VALUES (2, 'pop culture');

INSERT INTO quiz (quiz_id, theme)
VALUES (3, 'java');

--history:

INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (1, 'What did Paul Revere ride?', 1, 'history');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (2, 'What were the names of Columbus’s ships?', 1, 'history');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (13, 'Who was the first person to orbit the Earth?', 1, 'history');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (14, 'How many wives did Henry VIII have?', 1, 'history');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (15, 'How many colonies were there in the United States?', 1, 'history');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (16, 'What was Michelangelo’s last name?', 1, 'history');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (17, 'The Louisiana Purchase took place in what year?', 1, 'history');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (18, 'Who was in power the longest?', 1, 'history');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (19, 'Which conflict was the shortest?', 1, 'history');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (20, 'Which of the following was NOT Greek?', 1, 'history');


INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (1, 1, 'A horse', 'A bicycle', 'A cow', 'A horse');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (2, 2, 'Ashley, Marie, Lucy', 'Nina, Pinta, Santa Maria', 'Mayflower, Speedwell, Discovery', 'Nina, Pinta, Santa Maria');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (13, 13,'Yuri Gagarin', 'Neil Armstrong', 'John Glenn', 'Yuri Gagarin');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (14, 14,'2', '6', '4', '6');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (15, 15,'13', '12', '14', '13');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (16, 16,'Brunelleschi', 'Buonarroti', 'Botticelli', 'Buonarroti');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (17, 17,'1813', '1823', '1803', '1803');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (18, 18,'Margaret Thatcher', 'Winston Churchill', 'Franklin D. Roosevelt', 'Franklin D. Roosevelt');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (19, 19,'WWII', 'American War of Independence', 'American Civil War', 'WWII');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (20, 20,'Virgil', 'Homer', 'Herodotus', 'Virgil');

INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (1, 1, 1);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (1, 2, 2);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (1, 13, 13);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (1, 14, 14);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (1, 15, 15);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (1, 16, 16);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (1, 17, 17);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (1, 18, 18);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (1, 19, 19);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (1, 20, 20);


--pop culture:

INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (3, 'When did Britney Spears shave her head?', 2, 'pop culture');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (4, 'Who used to clean Paris Hilton’s closet?', 2, 'pop culture');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (5, 'Which Friends character was Courteney Cox originally asked to play?', 2,'pop culture' );
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (6, 'Which high school subject did Walter White teach in Breaking Bad?', 2,'pop culture');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (7, 'Finish this quote from The Office: “I’m not superstitious, but I am a ___ ___.”', 2,'pop culture');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (8, 'Who hosts “Hell’s Kitchen”?', 2,'pop culture');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (9, 'What is the #1 streamed song on Spotify?', 2,'pop culture');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (10, 'What do fans of Lady Gaga affectionately call themselves?', 2,'pop culture');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (11, 'Whitney Houston famously covered “I Will Always Love You”—who sang the original?', 2,'pop culture');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (12, 'What word is missing from this quote from Emily Brontë’s Wuthering Heights? “Whatever our ___ are made of, his and mine are the same.”', 2,'pop culture');


INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (3, 3, '2009', '2018', '2007', '2007');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (4, 4, 'Kim Kardashian', 'Lindsay Kohan', 'Nicole Richie', 'Kim Kardashian');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (5, 5, 'Monica', 'Rachel', 'Phoebe', 'Rachel');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (6, 6, 'History', 'Science', 'Chemistry', 'Chemistry');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (7, 7, '“little stitious”', '“bit scared”', '"running away"”', '“little stitious”');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (8, 8, 'Alex Michel', 'Gordon Ramsay', 'Pauly D', 'Gordon Ramsay');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (9, 9, '“I Love Rock ‘n’ Roll” by Joan Jett and the Blackhearts', '"Oops!… I Did It Again" by Britney Spears’', '“Shape of You” by Ed Sheeran', '“Shape of You” by Ed Sheeran');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (10, 10, 'Little Monsters', 'Gagas', 'Lady-Gs', 'Little Monsters');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (11, 11, 'Sammy Hagar', 'Dolly Parton', 'Lady Gaga', 'Dolly Parton');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (12, 12, 'Hands', 'Lives', 'Souls', 'Souls');


INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (2, 3, 3);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (2, 4, 4);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (2, 5, 5);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (2, 6, 6);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (2, 7, 7);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (2, 8, 8);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (2, 9, 9);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (2, 10, 10);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (2, 11, 11);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (2, 12, 12);


--java:


INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (21, 'Which is not part of OOP principles? ', 3, 'java');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (22, 'Which of the following is a Java keyword? ', 3, 'java');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (23, 'Which  method can be used to find the length of a string?', 3, 'java');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (24, 'Primitive variables are stored where?', 3,'java');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (25, 'What is the JRE?', 1, 'java');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (26, 'What is NOT part of a for statement?', 3, 'java');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (27, 'Which type of loop is best known for using an index or counter? ', 3, 'java');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (28, 'What is the output of the following code snippet?
int i = 0;
for(i = 0 ; i < 5; i++){			
}		
System.out.println(i);', 3, 'java');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (29, 'Which of those doesn’t have an index based structure?', 3, 'java');
INSERT INTO questions (questions_id, question_text, quiz_id, theme)
VALUES (30, 'Which allows the storage of a null key and null values?', 3, 'java');


INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (21, 21,'Encapsulation', 'Inheritance', 'Fluctuation', 'Fluctuation');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (22, 22, 'Final', 'Select', 'Repeat', 'Final');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (23, 23,'getLength()', 'length()', 'len()', 'length()');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (24, 24, 'touppercase()', 'toUpperCase()', 'toupca()', 'toUpperCase()');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (25, 25, 'Joe Rogan Experience', 'Java Rudimentary Encapsulation', 'Java Runtime Environment', 'Java Runtime environment');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (26, 26, 'Condition', 'Terminator', 'Iterator', 'Terminator');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (27, 27, 'for-each', 'do-while loop', 'for (traditional)', 'for (traditional)');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (28, 28, '5', '4', 'Compilation Error', ' 5');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (29, 29, 'List', 'Set', 'Map', 'Set');
INSERT INTO answers (answers_id, questions_id, answer_1, answer_2, answer_3, correct_answer)
VALUES (30, 30, 'Hashtable', 'HashMap', 'Iterator', 'HashMap');

INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (3, 21, 21);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (3, 22, 22);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (3, 23, 23);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (3, 24, 24);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (3, 25, 25);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (3, 26, 26);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (3, 27, 27);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (3, 28, 28);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (3, 29, 29);
INSERT INTO quiz_content (quiz_id, questions_id, answers_id)
VALUES (3, 30, 30);

COMMIT TRANSACTION;


