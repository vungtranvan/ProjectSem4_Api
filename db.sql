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
CorrectMark int,
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

INSERT INTO Account(UserName,[Password],[Name],Email,[Address],Sex,IsAdmin) VALUES 
('Admin','Admin@123',N'Admin Manager','admin@gmail.com',N'Hà Nội',1,1),
('VungTran','Demo@123',N'Vững Trần Văn','vungtran@gmail.com',N'Ba Vì',1,0),
('Demo01','Demo@123',N'Cô Đơn Dành Cho Ai','demo01@gmail.com',N'Cà Mau',0,0)
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
(N'1 + 9 = ?',1,'10', '20', '30', '40', 'A',null),
(N'6 : 3 = ?',1,'3', '6', '1', '2', 'B',null),
(N'9 : 9 = ?',1,'1', '10', '2', '6', 'A',null),
(N'10 + 9 = ?',1,'19', '29', '39', '49', 'A',null),
(N'10 - 9 = ?',1,'1', '29', '39', '49', 'A',null),
(N'1 - 1 = ?',1,'1', '0', '2', '3', 'A',null),
(N'6 - 4 = ?',1,'1', '2', '3', '4', 'B',null),
(N'7 x 9 = ?',1,'86', '63', '39', '49', 'B',null),

(N'Tên khai sinh của Tô Hoài là:',2,N'Nguyễn Sen', N'Nguyễn Mạnh Khải', N'Đinh Trọng Đoàn', N'Phạm Minh Tài', 'A',null),
(N'Địa danh nào dưới đây là quê nội của Tô Hoài?',2,N'Làng Mọc, nay thuộc phường Nhân Chính, quận Thanh Xuân, Hà Nội.', N'Làng Vị Xuyên, huyện Mĩ Lộc, Nam Định', N'Làng Hảo, huyện Mĩ Hào, Hưng Yên', N'Thôn Cát Động, Thị trấn Kim Bài, huyện Thanh Oai, tỉnh Hà Đông', 'D',null),
(N'Tô Hoài xuất thân trong gia đình như thế nào?',2,N'Gia đình công chức', N'Gia đình có truyền thống yêu nước', N'Gia đình thợ thủ công', N'Gia đình nha nho khi Hán học đã suy tàn', 'C',null),
(N'Tô Hoài đã từng làm công việc nào sau đây?',2,N'Dạy trẻ', N'Bán hàng', N'Kế toán hiệu buôn', N'Tất cả các đáp án trên', 'D',null),
(N'Tô Hoài gia nhập Hội Văn hóa cứu quốc năm bao nhiêu?',2,N'1941', N'1942', N'1943', N'1944', 'C',null),
(N'Tác giả Tô Hoài đoạt giải nhất Tiểu thuyết của Hội Văn nghệ Việt Nam năm 1956 với tác phẩm nào?',2,N'Truyện Tây Bắc', N'Tiểu thuyết Quê nhà', N'Tiểu thuyết Miền Tây', N'Ba người khác', 'A',null),
(N'Tác phẩm nào dưới đây không phải là sáng tác của Tô Hoài?',2,N'Dế Mèn phiêu lưu kí', N'O chuột', N'Truyện Tây Bắc', N'Nắng trong vườn', 'D',null),
(N'Vợ chồng A Phủ được in trong tác phẩm nào?',2,N'Truyện Tây Bắc', N'O chuột', N'Nhà nghèo', N'Cát bụi chân ai', 'A',null),
(N'Sống trong nhà thống lí Pá Tra, Mị có thân phận tủi nhục, thấp hèn. Tô Hoài đã so sánh thân phận của Mị với:',2,N'Con trâu', N'Con ngựa', N'Con rùa', N'Cả ba đáp án trên', 'D',null),
(N'Vợ chồng A Phủ được sáng tác năm bao nhiêu?',2,N'1950', N'1951', N'1952', N'1953', 'C',null),
(N'Căn phòng Mị ở được miêu tả qua những chi tiết nào?',2,N'Ở cái buồng Mị nằm, kín mít, có một chiếc của sổ lỗ vuông to bằng bàn tay. Lúc nào trông ra cũng chỉ thấy trăng trắng, không biết là sương hay là nắng.', N'Ở cái buồng Mị nằm, có một khung cửa sổ, trông ra núi rừng Tây Bắc.', N'Cả hai đáp án trên đều đúng', N'Cả hai đáp án trên đều sai', 'A',null),
(N'Ngày xưa, khi chưa trở thành con dâu gạt nợ nhà thống lí Pá Tra, Mị là một cô gái xinh đẹp, tài năng như thế nào?',2,N'Mị thổi lá cũng hay như thổi sáo', N'Mị hát rất hay, bao nhiêu người mê', N'Cả hai đáp án trên đều đúng', N'Cả hai đáp án trên đều sai', 'A',null),
(N'Yếu tố nào tác động đến sự hồi sinh của Mị?',2,N'Cảnh sắc của Hồng Ngài trong những ngày xuân', N'Rượu', N'Tiếng sáo', N'Tất cả các đáp án trên', 'D',null),
(N'Vợ nhặt được in trong tác phẩm nào?',2,N'Con chó xấu xí', N'Nên vợ nên chồng', N'Nhà nghèo', N'O chuột', 'A',null),
(N'Tác phẩm nào dưới đây không phải của tác giả Kim Lân?',2,N'Nên vợ nên chồng', N'Con chó xấu xí', N'O chuột', N'Làng', 'C',null),
(N'Nhan đề “Vợ nhặt” mang ý nghĩa:',2,N'Thân phận con người trở nên rẻ rúng, có thể “nhặt” được như món đồ ngưởi ta đánh rơi hoặc bỏ quên', N'Thể hiện khát khao sống, khát khao hạnh phúc của con người trong hoàn cảnh khốn cùng', N'Cả hai đáp án trên đều đúng', N'Cả hai đáp án trên đều sai', 'C',null),
(N'Tình huống truyện của tác phẩm Vợ nhặt mang ý nghĩa:',2,N'Tố cáo chế độ phong kiến đã đẩy người nông dân vào bước đường cùng', N'Tố cáo chế độ thực dân, phát xít đẩy người nông dân vào nạn đói khủng kiếp, vào cảnh khốn cùng.', N'Mang giá trị nhân bản sâu sa dù hoàn cảnh bi thảm đến đâu con người ta vẫn khao khát hạnh phúc, vẫn hướng về ánh sáng và tin tưởng vào tương lai.', N'Đáp án B và C', 'D',null),
(N'Giá trị hiện thực của truyện ngắn Vợ nhặt là:',2,N'Cho thấy một thảm cảnh thê thảm của những con người nghèo trong nạn đói 1945 do phát xít Nhật và thực dân Pháp gây nên.', N'Tố cáo tội ác của bọn thực dân phát xít.', N'Thể hiện lòng cảm thông sâu sắc đối với số phận con người trong nạn đói.', N'Là bài ca ca ngợi sự sống, tình thương, sự cưu mang, đùm bọc, khát vọng', 'A',null),
(N'Vợ nhặt mang giá trị nhân đạo sau:',2,N'Tố cáo tội ác của bọn thực dân phát xít.', N'Thể hiện lòng cảm thông sâu sắc đối với số phận con người trong nạn đói.', N'Là bài ca ca ngợi sự sống, tình thương, sự cưu mang, đùm bọc, khát vọng hạnh phúc. Tác phẩm chỉ ra con đường giải phóng cho những con người nghèo khổ: chỉ có thể đi theo cách mạng để tự giải phóng, để thoát khỏi đói nghèo .', N'Tất cả các đáp án trên', 'D',null),
(N'Nhan đề “Vợ nhặt” gợi ra điều gì?',2,N'Gợi sự rẻ rúng của thân phận con người và tình cảnh thê thảm của con người trong nạn đói 1945', N'Gợi ra hình ảnh một người đàn ông may mắn khi có vợ', N'Gợi ra cảnh nhặt vợ dễ dàng khi có nhiều phụ nữ', N'Tất cả các đáp án trên', 'A',null),
(N'Tình huống truyện của Vợ nhặt là:',2,N'Tràng – một người dân ngụ cư, xấu xí bỗng dung “nhặt” được vợ', N'Tràng cưới thị về làm vợ', N'Khát vọng sống và hạnh phúc của Tràng trong nạn đói', N'Tất cả các đáp án trên', 'A',null),
(N'Công việc của Tràng là:',2,N'Nông dân', N'Kéo xe bò thuê', N'Xay lúa thuê', N'Cày thuê', 'B',null),
(N'Đáp án nào không đúng khi nói về vẻ đẹp tâm hồn của nhân vật Tràng?',2,N'Thuần hậu, hiền lành, chất phác', N'Tâm hồn lạc quan, yêu đời', N'Sức sống tiềm tàng và sức phản kháng mãnh liệt', N'Tấm lòng nhân hậu', 'C',null),
(N'Tâm trạng của Tràng như thế nào khi đưa thị về nhà?',2,N'Ngượng nghịu', N'Lo sợ, sốt ruột', N'Thở phào nhẹ nhõm khi được mẹ vun đắp', N'Tất cả các đáp án trên', 'D',null),
(N'Tâm trạng bà cụ Tứ thay đổi như thế nào khi biết chuyện Tràng đưa thị về làm vợ?',2,N'Ngỡ ngàng, lo lắng, tức giận', N'Ngỡ ngàng, tức giận, phản đối', N'Ngỡ ngàng, tủi cực, xót xa, vui mừng, vun đắp', N'Sung sướng, vỡ òa hạnh phúc', 'C',null),
(N'Một biểu hiện ở Tràng được Kim Lân nhắc đến nhiều lần khi anh mới "nhặt" được vợ đối lập với biểu hiện tâm trạng thường có của người đang ở trong cảnh đói khát bi thảm là:',2,N'Cười', N'Nói luôn miệng', N'Hát khe khẽ', N'Mắt sáng lên lấp lánh', 'A',null),
(N'Tác phẩm Hồn Trương Ba, da hàng thịt thuộc thể loại:',2,N'Kịch', N'Tiểu thuyết', N'Truyện vừa', N'Truyện ngắn', 'A',null),
(N'Thể thơ của bài thơ “Sóng”:',2,N'Thơ năm chữ', N'Thơ sáu chữ', N'Thơ bảy chữ', N'Thơ tự do', 'A',null),
(N'Qua bài thơ “Sóng”, Xuân Quỳnh đã khám phá sự tương đồng, hòa hợp giữa:',2,N'“Anh” và “em”', N'“Sóng” và “anh”', N'“Sóng” và “em”', N'Tất cả các đáp án trên', 'C',null),
(N'Giá trị nội dung bài thơ “Sóng” của Xuân Quỳnh:',2,N'Diễn tả tình yêu của người phụ nữ thiết tha, nồng nàn, chung thủy, muốn vượt lên thử thách của thời gian và sự hữu hạn của đời người', N'Sự phẫn uất, đau buồn trước tình duyên lận đận, gắng gượng vươn lên để kiếm tìm đích đến của tình yêu', N'Cả hai đáp án trên đều đúng', N'Cả hai đáp án trên đều sai', 'A',null),
(N'Thủ pháp nghệ thuật được sử dụng ở hai câu thơ đầu bài thơ “Sóng” của Xuân Quỳnh?',2,N'Nghệ thuật đối lập', N'So sánh', N'Nhân hóa', N'Hoán dụ', 'A',null),
(N'Khổ thơ cuối bài thơ “Sóng” thể hiện:',2,N'Khát vọng cống hiến', N'Khát vọng hóa thân, bất tử hóa tình yêu', N'Cả hai đáp án trên đều đúng', N'Cả hai đáp án trên đều sai', 'B',null),
(N'Thể loại của “Người lái đò sông Đà” là:',2,N'Bút kí', N'Truyện ngắn', N'Tùy bút', N'Phóng sự', 'C',null),
(N'Sự độc đáo của sông Đà được thể hiện qua lời đề từ như thế nào?',2,N'Sự độc đáo của sông Đà thể hiện qua hướng chảy', N'Sự độc đáo của sông Đà thể hiện qua màu nước bốn mùa', N'Sự độc đáo của sông Đà thể hiện qua khung cảnh hai bên bờ sông', N'Tất cả các đáp án trên', 'A',null),
(N'Sông Đà được miêu tả mang những vẻ đẹp gì?',2,N'Sông Đà hùng vĩ, dữ dội với tính cách hung bạo', N'Sông Đà với vẻ đẹp thơ mộng, tính cách trữ tình', N'Cả hai đáp án trên đều đúng', N'Cả hai đáp án trên đều sai', 'C',null),

(N'Mary is at school now. She is ______ Maths.',3,N'learn', N'learns', N'learning', N'learned', 'C',null),
(N'Where is Tony from ? - He is ______ Australia.',3,N'from', N'wit', N'at', N'of', 'A',null),
(N'How ____ are you, Hieu? - I am nine years old.',3,N'odl', N'old', N'year', N'years', 'B',null),
(N'____ are you today? - I am fine, thank you.',3,N'What', N'When', N'Where', N'How', 'D',null),
(N'I go to school ______ my friends every morning.',3,N'to', N'with', N'for', N'at', 'A',null),
(N'His name is Tuan. He _____ my new classmate.',3,N'is', N'am', N'are', N'be', 'A',null),
(N'Long is a __ pill at Hong Kong Primary School.',3,N'bu', N'bi', N'pu', N'pi', 'C',null),
(N'This is my hometown. It is beau__ful and quiet.',3,N'ti', N'di', N'to', N'do', 'A',null),
(N'Tony is a _____ at Rainbow Primary School.',3,N'pupil', N'farmer', N'doctor', N'teacher', 'A',null),
(N'Minh Thu likes playing ______ and listening to music.',3,N'game', N'chess', N'cat and mouse', N'tennis', 'B',null),
(N'Tony and Minh Thu are _____ years old.',3,N'badminton', N'volleyball', N'nine', N'ten', 'C',null),
(N'Choose the correct sentence.',3,N'This is my new friends. Her name is Huong.', N'This am my new friend. Her name is Huong', N'This are my new friend. Her name is Huong', N'This is my new friend. Her name is Huong', 'D',null),
(N'Choose the correct sentence.',3,N'Hurri up! We are late for school.', N'Hurri up! We are lete for school.', N'Hurry up! We are late for school.', N'Hurry up! We are late for schuul.', 'C',null),
(N'Where are you from? - I am from Viet Nam, I li_ _ in Ho Chi Minh City.',3,N'be', N'de', N've', N'se', 'C',null),
(N'Look at those people. They are from Korea. They are Kore_ _.',3,N'en', N'on', N'in', N'an', 'A',null),
(N'What is her _ _ tionality? - She is English.',3,N'na', N'ma', N'sa', N'da', 'A',null),
(N'______ are you from? - I am from America.',3,N'When', N'Where', N'What', N'Why', 'B',null),
(N'What is that? - It is the flag of my _____',3,N'Countri', N'Country', N'Cuontry', N'Counrty', 'B',null),
(N'What is your name? - ___ name is Linda.',3,N'Me', N'Mine', N'My', N'I', 'B',null),
(N'We are going camping with some ____.',3,N'foreigners', N'foreigner', N'forigners', N'fereigners', 'A',null),
(N'Can you speak _____ ? - Yes, i can.',3,N'England', N'Inglish', N'English', N'Englend', 'C',null),
(N'Choose the correct sentence.',3,N'Jame is an American boy. He is nine year old.', N'Jame is a American boy. He is nine years old.', N'Jame is an American boy. He is nine years old.', N'Jame is an American boy. She is nine year old.', 'B',null),
(N'Choose the correct sentence.',3,N'Where do Mary and Peter come from? - They comes from England.', N'Where does Mary and Peter come from? - They come from England.', N'Where do Mary and Peter come from? - They come from English.', N'Where do Mary and Peter come from? - They come from England.', 'D',null),
(N'Choose the correct sentence.',3,N'I am from Japanese. I am Japan. Where are you from?', N'I am from Japanese. I am Japanese. Where are you from?', N'I am from Japanese. I am Japanese. Where are your from?', N'I am from Japanese. I am Japanese. Where are you from?', 'D',null),
(N'Choose the odd one out.',3,N'December', N'Fifth', N'October', N'May', 'B',null),
(N'Choose the odd one out.',3,N'month', N'date', N'year', N'flower', 'D',null),
(N'Choose the odd one out.',3,N'birthday', N'book', N'ruler', N'pen', 'A',null),
(N'Choose the odd one out.',3,N'Who', N'What', N'Where', N'This', 'D',null),
(N'Choose the odd one out.',3,N'cake', N'museum', N'balloon', N'present', 'B',null),
(N'When is her _ _rthday? - It is on the eighth of June.',3,N'be', N'bi', N'ba', N'bo', 'B',null),
(N'I do not have to go to school on Saturday and S_ _nday.',3,N'un', N'an', N'en', N'on', 'A',null),
(N'What is the date today? - It is on the fifteen of Febr_ _ry',3,N'ua', N'uo', N'ou', N'au', 'A',null),
(N'There _____ two balloons, ten candles and a big cakes.',3,N'am', N'is', N'be', N'are', 'D',null),
(N'______ is the date today? - It is the tenth of January',3,N'When', N'Where', N'What', N'Which', 'C',null),
(N'What pets do you have? - I have ____ cat.',3,N'an', N'a', N'the', N'X', 'B',null),
(N'I need to buy some ____ for the party.',3,N'cendle', N'candler', N'candlers', N'candles', 'D',null),
(N'When do you _____ Maths? - I have it everyday.',3,N'has', N'have', N'has not', N'have not', 'B',null)
go

INSERT INTO HistoryTest(UserId,CategoryExamId,[Status]) VALUES(1,1,0)
GO

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
@keySearch nvarchar(250)
AS 
BEGIN 
Select * from Account where UserName LIKE '%'+@keySearch+'%' or [Name] Like '%'+@keySearch+'%' or Email Like '%'+@keySearch+'%' or [Address] Like '%'+@keySearch+'%'
ORDER BY Id desc
END
GO

CREATE PROC App_Account_GetById
@id int
AS 
BEGIN 
Select * from Account Where Id = @id
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
@keySearch nvarchar(250)
AS 
BEGIN 
Select q.Id, q.Name, c.Name as 'CategoryExamName' from Question as q LEFT JOIN CategoryExam as c ON q.CategoryExamId = c.Id 
where q.Name Like '%'+@keySearch+'%' or c.Name Like '%'+@keySearch+'%'
ORDER BY Id desc
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


-- HistoryTest & HistoryTestDetail
CREATE PROC App_HistoryTest_GetAllByUseIdAndCategoryExamId
@userId int,
@categoryExamId int
AS
BEGIN
SELECT h.Id, h.CorrectMark, h.TotalMark, h.Status FROM HistoryTest as h WHERE h.UserId = @userId AND h.CategoryExamId = @categoryExamId AND Id != 1
ORDER BY Id asc
END
GO

CREATE PROC App_HistoryTest_GetAllByAdmin
@keySearch nvarchar(250)
AS
BEGIN
SELECT h.Id, a.Name as 'AccountName',c.Name as 'CategoryExamName', h.CorrectMark, h.TotalMark, h.Status
FROM HistoryTest as h 
LEFT JOIN Account as a ON h.UserId = a.Id 
LEFT JOIN CategoryExam as c ON h.CategoryExamId = c.Id 
WHERE h.Id != 1 AND (a.Name Like '%'+@keySearch+'%' or c.Name Like '%'+@keySearch+'%' or h.Status = @keySearch)
ORDER BY h.Id desc
END
GO

CREATE PROC App_HistoryTestDetail_GetByHistoryTestId
@id int
AS
BEGIN
SELECT q.*, h.AnswerChoice FROM HistoryTestDetail as h 
LEFT JOIN Question as q on h.QuestionId = q.Id WHERE h.HistoryTestId = @id
ORDER BY Id asc
END 
GO

CREATE PROC App_HistoryTest_Add
@UserId int,
@CategoryExamId int
AS
BEGIN TRY
    BEGIN TRANSACTION

INSERT INTO HistoryTest(UserId,CategoryExamId,[Status]) VALUES(@UserId,@CategoryExamId,0)

INSERT INTO HistoryTestDetail(HistoryTestId, QuestionId)
SELECT TOP 10 (select max(Id) from HistoryTest) as 'HistoryTestId', Id as 'QuestionId' FROM Question where CategoryExamId = @CategoryExamId
ORDER BY NEWID()

COMMIT TRANSACTION
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION
END CATCH
GO

CREATE PROC App_HistoryTest_Update
@id int,
@correctMark int,
@totalMark int
AS 
BEGIN
UPDATE HistoryTest SET CorrectMark=@correctMark, TotalMark = @totalMark, [Status] = 1 WHERE id = @id
END
GO

CREATE PROC App_HistoryTestDetail_Update
@historyTestId int,
@questionId int,
@answerChoice varchar(5)
AS 
BEGIN
UPDATE HistoryTestDetail SET AnswerChoice = @answerChoice WHERE HistoryTestId = @historyTestId AND QuestionId = @questionId
END
GO

/*
SELECT COUNT(*) FROM Question
SELECT * FROM Question
SELECT * FROM Account ORDER BY Id OFFSET 1 ROWS FETCH NEXT 10 ROWS ONLY

EXEC App_Account_CountDataOfGetAll @keySearch = 'Admin'
EXEC App_HistoryTest_Add @UserId = 2, @CategoryExamId = 1
EXEC App_HistoryTest_GetAllByAdmin @keySearch = false
DROP PROCEDURE App_HistoryTest_GetAllByAdmin

UPDATE Account SET [Image] = null

select * from CategoryExam
select * from HistoryTest
select * from HistoryTestDetail
delete from HistoryTestDetail
delete from HistoryTest where id != 1
*/
