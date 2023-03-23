-- BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS course CASCADE;
DROP TABLE IF EXISTS course_student CASCADE;
DROP TABLE IF EXISTS grades CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	first_name varchar (25) NOT NULL,
	last_name varchar (25) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE course (
  course_id SERIAL PRIMARY KEY,
  teacher_id int,
  course_title varchar(50),
  course_description varchar (500),
  difficulty_level varchar(2),
  cost decimal(10,2),
  isArchived boolean
);

CREATE TABLE course_student (
  student_id int,
  course_id int,
  PRIMARY KEY (student_id, course_id)
);


CREATE TABLE grades (
  grade_id SERIAL PRIMARY KEY,
  student_id int,
  course_id int,
  total_points int,
  earned_points int,
  status varchar(12) DEFAULT 'Incomplete',
  submission_content varchar (10000),
  feedback varchar (5000)	
);


ALTER TABLE course ADD FOREIGN KEY (teacher_id) REFERENCES users (user_id);

ALTER TABLE course_student ADD FOREIGN KEY (student_id) REFERENCES users (user_id);

ALTER TABLE course_student ADD FOREIGN KEY (course_id) REFERENCES course (course_id);




--
ALTER TABLE grades ADD FOREIGN KEY (student_id) REFERENCES users (user_id);
--
ALTER TABLE grades ADD FOREIGN KEY (student_id) REFERENCES student (student_id);

ALTER TABLE grades ADD FOREIGN KEY (course_id) REFERENCES course (course_id);

COMMIT TRANSACTION;