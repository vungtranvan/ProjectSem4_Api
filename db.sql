Create database ExamTest
go
use ExamTest
go

Create table Account
(
Id int primary key identity,
UserName varchar(25) unique not null,
[Password] varchar(Max) not null,
[Name] nvarchar(50) not null,
Email varchar(50) unique not null,
[Image] text,
[Address] ntext,
Sex bit not null,
IsAdmin bit not null
)
go

Create table [CategoryExam]
(
Id int primary key identity,
Name nvarchar(50) unique not null
)
go

Create table [Question]
(
Id int primary key identity,
[Name] ntext not null,
CategoryExamId int FOREIGN KEY REFERENCES CategoryExam(Id),
Answer_a ntext not null,
Answer_b ntext not null,
Answer_c ntext not null,
Answer_d ntext not null,
AnswerCorrect varchar(5) not null,
[Image] text
)
go

Create table [HistoryTest]
(
Id int primary key identity,
UserId int FOREIGN KEY REFERENCES Account(Id),
CategoryExamId int FOREIGN KEY REFERENCES CategoryExam(Id),
CorectMark int,
TotalMark int,
[Status] bit not null
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

-- Insert data into table
INSERT INTO CategoryExam([Name]) VALUES (N'Toán'),(N'Văn'),(N'Anh')
go

INSERT INTO Account(UserName,[Password],[Name],Email,[Image],[Address],Sex,IsAdmin) VALUES 
('Admin','Admin@123',N'Admin Manager','admin@gmail.com','image_default',N'Ba Vì',1,1),
('KenvinNguyen','Demo@123',N'Kenvin Nguyễn','kenvinnguyen@gmail.com','image_default',N'Hà Nội',1,0),
('VungTran','Demo@123',N'Vững Trần Văn','VungTran@gmail.com','image_default',N'Hà Nội',1,0),
('NguyenVan','Demo@123',N'Nguyễn Văn','NguyenVan@gmail.com','image_default',N'Hà Nội',1,0),
('TranDat','Demo@123',N'Trần Dạt','TranDat@gmail.com','image_default',N'Hà Nội',1,0),
('HoaNguyen','Demo@123',N'Hoa Nguyễn','HoaNguyen@gmail.com','image_default',N'Hà Nội',1,0),
('BaTu','Demo@123',N'Bá Tú','BaTu@gmail.com','image_default',N'Hà Nội',1,0),
('Demo01','Demo@123',N'Demo 01','Demo01@gmail.com','image_default',N'Hà Nội',1,0),
('Demo02','Demo@123',N'Demo 02','Demo02@gmail.com','image_default',N'Hà Nội',1,0),
('BaPhong','Demo@123',N'Bá Phong','BaPhong@gmail.com','image_default',N'Hà Nội',1,0),
('BaPhong01','Demo@123',N'Bá Phong 01','BaPhong01@gmail.com','image_default',N'Hà Nội',1,0),
('VinhNguyen','Demo@123',N'Vinh Nguyễn','VinhNguyen@gmail.com','image_default',N'Hà Nội',1,0),
('KhanhHuyen','Demo@123',N'Khánh Huyền','KhanhHuyen@gmail.com','image_default',N'Hà Nội',1,0),
('TamMao','Demo@123',N'Tam Mao','TamMao@gmail.com','image_default',N'Hà Nội',1,0),
('HuyNguyen','Demo@123',N'Huy Nguyễn','HuyNguyen@gmail.com','image_default',N'Hà Nội',1,0),
('HuyTran','Demo@123',N'Huy Trần','HuyTran@gmail.com','image_default',N'Hà Nội',1,0),
('HuyTran01','Demo@123',N'Huy Trần 01','HuyTran01@gmail.com','image_default',N'Hà Nội',1,0),
('LienNguyen','Demo@123',N'Liên Nguyễn','LienNguyen@gmail.com','image_default',N'Hà Nội',1,0),
('LyNguyen','Demo@123',N'Ly Nguyễn','LyNguyen@gmail.com','image_default',N'Hà Nội',1,0),
('ThuyDo','Demo@123',N'Thúy Đỗ Thị','ThuyDo@gmail.com','image_default',N'Hà Nội',1,0),
('ThuyDo01','Demo@123',N'Thúy Trang Đỗ Thị','ThuyDo01@gmail.com','image_default',N'Hà Nội',1,0),
('SonNguyen','Demo@123',N'Sơn Nguyễn','SonNguyen@gmail.com','image_default',N'Hà Nội',1,0)
go

INSERT INTO Question([Name],CategoryExamId,Answer_a,Answer_b,Answer_c,Answer_d,AnswerCorrect,[Image]) VALUES
(N'1 + 1 = ?',1,'1', '2', '3', '4', 'B',null),
(N'1 + 2 = ?',1,'1', '2', '3', '4', 'C',null),
(N'2 + 2 = ?',1,'1', '4', '5', '2', 'B',null),
(N'1 x 1 = ?',1,'1', '2', '0', '3', 'A',null),
(N'1 + 3 = ?',1,'0', '1', '2', '4', 'D',null),
(N'5 + 1 = ?',1,'3', '4', '6', '5', 'C',null),
(N'6 - 1 = ?',1,'2', '3', '4', '5', 'D',null),
(N'1 + 5 = ?',1,'3', '4', '5', '6', 'D',null),
(N'1 + 7 = ?',1,'8', '2', '3', '3', 'A',null),
(N'1 + 4 = ?',1,'1', '2', '5', '3', 'C',null),
(N'2 x 3 = ?',1,'6', '7', '8', '9', 'A',null),
(N'10 + 1 = ?',1,'12', '14', '11', '12', 'C',null),
(N'10 + 10 = ?',1,'20', '10', '40', '30', 'A',null),
(N'0 x 10 = ?',1,'1', '2', '3', '0', 'D',null),
(N'1 + 9 = ?',1,'10', '20', '30', '40', 'A',null)
go

-- PROC
-- CategoryExam
CREATE PROC App_CategoryExam_GetAll
AS
BEGIN 
Select * from CategoryExam
END
GO

CREATE PROC App_CategoryExam_GetById
@id int
AS 
BEGIN 
Select * from CategoryExam Where Id = id
END
GO

-- Account
CREATE PROC App_Account_GetAll
@skip int,
@take int,
@keySearch nvarchar(250)
AS 
BEGIN 
Select * from Account where UserName LIKE '%'+@keySearch+'%' or [Name] Like '%'+@keySearch+'%' or Email Like '%'+@keySearch+'%' or [Address] Like '%'+@keySearch+'%'
ORDER BY Id OFFSET @skip ROWS FETCH NEXT @take ROWS ONLY
END
GO

CREATE PROC App_Account_CountDataOfGetAll
@keySearch nvarchar(250)
AS 
BEGIN 
Select COUNT(*) as 'Total' from Account where UserName LIKE '%'+@keySearch+'%' or [Name] Like '%'+@keySearch+'%' or Email Like '%'+@keySearch+'%' or [Address] Like '%'+@keySearch+'%'
END
GO

CREATE PROC App_Account_GetById
@id int
AS 
BEGIN 
Select * from Account Where Id = id
END
GO

CREATE PROC App_Account_GetByUserName
@userName varchar(25)
AS 
BEGIN 
Select * from Account Where UserName = @userName
END
GO

CREATE PROC App_Account_GetByEmail
@email varchar(50)
AS 
BEGIN 
Select * from Account Where Email = @email
END
GO

CREATE PROC App_Account_Insert
@userName varchar(25),
@password varchar(Max),
@name nvarchar(50),
@email varchar(50),
@image text,
@address ntext,
@sex bit,
@isAdmin bit
AS
BEGIN
INSERT INTO Account(UserName,[Password],[Name],Email,[Image],[Address],Sex,IsAdmin) VALUES (@userName,@password,@name,@email,@image,@address,@sex,@isAdmin)
END
GO


CREATE PROC App_Account_Update
@id int,
@userName varchar(25),
@password varchar(Max),
@name nvarchar(50),
@email varchar(50),
@image text,
@address ntext,
@sex bit,
@isAdmin bit
AS 
BEGIN
UPDATE Account SET UserName = @userName, [Password]=@password, [Name]=@name, Email=@email, [Image]=@image, [Address]=@address, Sex=@sex, IsAdmin=@isAdmin WHERE id = @id
END
GO

CREATE PROC App_Account_UpdatePassword
@userName varchar(25),
@password varchar(Max)
AS 
BEGIN
UPDATE Account SET [Password]=@password WHERE UserName = @userName
END
GO

CREATE PROC App_Account_Delete
@id int
AS
BEGIN
DELETE Account WHERE Id = @id
END 
GO

-- Question
CREATE PROC App_Question_GetAll
@skip int,
@take int,
@keySearch nvarchar(250)
AS 
BEGIN 
Select q.*, c.Name as 'CategoryExamName' from Question as q LEFT JOIN CategoryExam as c ON q.CategoryExamId = c.Id 
where q.Name Like '%'+@keySearch+'%' or c.Name = @keySearch
ORDER BY Id OFFSET @skip ROWS FETCH NEXT @take ROWS ONLY
END
GO

CREATE PROC App_Question_CountDataOfGetAll
@keySearch nvarchar(250)
AS 
BEGIN 
Select COUNT(*) as 'Total' from Question as q LEFT JOIN CategoryExam as c ON q.CategoryExamId = c.Id 
where q.Name Like '%'+@keySearch+'%' or c.Name = @keySearch
END
GO

CREATE PROC App_Question_GetById
@id int
AS 
BEGIN 
Select q.*, c.Name as 'CategoryExamName' from Question as q LEFT JOIN CategoryExam as c ON q.CategoryExamId = c.Id Where q.Id = @id
END
GO

CREATE PROC App_Question_Insert
@name ntext,
@categoryExamId int,
@answer_a ntext,
@answer_b ntext,
@answer_c ntext,
@answer_d ntext,
@answerCorrect varchar(5),
@image text
AS
BEGIN
INSERT INTO Question([Name],CategoryExamId,Answer_a,Answer_b,Answer_c,Answer_d,AnswerCorrect,[Image]) 
VALUES (@name,@categoryExamId,@answer_a,@answer_b,@answer_c,@answer_d,@answerCorrect,@image)
END
GO


CREATE PROC App_Question_Update
@id int,
@name ntext,
@categoryExamId int,
@answer_a ntext,
@answer_b ntext,
@answer_c ntext,
@answer_d ntext,
@answerCorrect varchar(5),
@image text
AS 
BEGIN
UPDATE Question SET [Name]=@name, CategoryExamId=@categoryExamId, Answer_a=@answer_a, Answer_b=@answer_b, Answer_c=@answer_c, Answer_d=@answer_d, AnswerCorrect=@answerCorrect, [Image] =@image WHERE id = @id
END
GO

CREATE PROC App_Question_Delete
@id int
AS
BEGIN
DELETE Question WHERE Id = @id
END 
GO

select * from CategoryExam
go
select * from Account where UserName Like '%1%' or [Name] Like '%1%' or Email Like '%1%' or [Address] Like '%1%'
go

SELECT COUNT(*) FROM Account

SELECT * FROM Account ORDER BY Id OFFSET 1 ROWS FETCH NEXT 10 ROWS ONLY
GO

--EXEC App_Account_CountDataOfGetAll @keySearch = 'Admin'
--DROP PROCEDURE App_Question_GetById
