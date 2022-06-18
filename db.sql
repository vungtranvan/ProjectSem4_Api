Create database ExamTest
go
use ExamTest
go

Create table Account
(
Id int primary key identity,
UserName varchar(25) not null,
[Password] varchar(Max) not null,
[Name] nvarchar(50) not null,
Email varchar(50) not null,
[Image] text,
Birthday date,
[Address] text,
Sex bit not null,
IsAdmin bit not null,
CreatedDate datetime not null,
UpdatedDate datetime
)
go

Create table [CategoryExam]
(
Id int primary key identity,
Name nvarchar(50) not null,
CreatedDate datetime not null,
UpdatedDate datetime
)
go

Create table [Question]
(
Id int primary key identity,
[Name] text not null,
CategoryExamId int FOREIGN KEY REFERENCES CategoryExam(Id),
Answer_a text not null,
Answer_b text not null,
Answer_c text not null,
Answer_d text not null,
AnswerCorrect varchar(5) not null,
[Image] text,
CreatedDate datetime not null,
UpdatedDate datetime
)
go

Create table [HistoryTest]
(
Id int primary key identity,
UserId int FOREIGN KEY REFERENCES Account(Id),
CategoryExamId int FOREIGN KEY REFERENCES CategoryExam(Id),
CorectMark int,
TotalMark int,
[Status] bit not null,
CreatedDate datetime not null,
UpdatedDate datetime
)
go

Create table [HistoryTestDetail]
(
HistoryTestId int FOREIGN KEY REFERENCES HistoryTest(Id),
QuestionId int FOREIGN KEY REFERENCES Question(Id),
AnswerChoice varchar(5),
PRIMARY KEY (HistoryTestId,QuestionId)
)
go

insert into CategoryExam(Name,CreatedDate) values
(N'Toán','2022-06-15'),
(N'Văn','2022-06-15'),
(N'Anh','2022-06-15')
go

insert into Account(UserName,[Password],[Name],Email,[Image],Birthday,[Address],Sex,IsAdmin,CreatedDate)
values ('Admin','Admin@123',N'Admin Manager','admin@gmail.com','image_default','2001-01-15',N'Ba Vì',1,1,'2022-06-15')
go

select * from CategoryExam
go
select * from Account
go
