drop table project_subject;
drop table project;
drop table recruiter;
drop table subject;


create table subject(id int primary key,first_name varchar2(20), last_name varchar2(20), ph_no varchar2(10), 
					email varchar2(50),
					date_of_birth date, 
					ethnicity varchar2(20),
					height int, 
					username varchar2(16),
					password varchar2(20));
					
create table recruiter(id int primary key, 
						name varchar2(20), 
						ph_no varchar2(10), 
						email varchar2(50), 
						address varchar2(200),
						username varchar2(16),
						password varchar2(20));					
					
					
					
create table project(id int primary key, 
					project_name varchar2(20), 
					recruiter_id int,  foreign key (recruiter_id) references recruiter(id), 
					ethnicity varchar2(20), 
					min_height int, 
					max_height int, 
					min_age int,
					max_age int 
					);
					
create table project_subject(id int primary key, 
								project_id int,foreign key (project_id) references project(id),
								subject_id int,foreign key (subject_id) references subject(id),
								status varchar2(20),
								subject_comments varchar2(200), 
								requireter_comments varchar2(200));					
					