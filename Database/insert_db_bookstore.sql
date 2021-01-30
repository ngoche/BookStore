Use master
go
use BookStore
go
--insert customer type
insert into dbo.CustomerType(Type)
values(N'vip')
insert into dbo.CustomerType(Type)
values(N'normal')
go
--reset lai id identity
--DBCC Checkident('Customer',RESEED,0)
--insert customer
insert into dbo.Customer(CustomerTypeId,FullName,Gender,Birthday,Phone,Address,Email)
values(1,N'Nguyễn Văn Dương',1,'07/17/1996',N'0975736924',N'120 Nguyễn Trãi Hà Đông',N'duong147nguyen@gmail.com')
insert into dbo.Customer(CustomerTypeId,FullName,Gender,Birthday,Phone,Address,Email)
values(1,N'Đặng Quang Thế An',1,'01/20/1996',N'0978804970',N'65 Thài Hà',N'andq@gmail.com')
insert into dbo.Customer(CustomerTypeId,FullName,Gender,Birthday,Phone,Address,Email)
values(1,N'Ngọc Văn Hệ',1,'09/01/1996',N'0918273645',N'06 Nguyễn Tất Thành',N'hedepzai@gmail.com')
insert into dbo.Customer(CustomerTypeId,FullName,Gender,Birthday,Phone,Address,Email)
values(1,N'Nguyễn Thị Thùy Linh',0,'12/12/1996',N'067724801',N'68 Triều Khúc',N'linhnt@gmail.com')
go
--insert account
insert into dbo.Account(Username,Password,CustomerId)
values(N'duong',N'duong',1)
insert into dbo.Account(Username,Password,CustomerId)
values(N'an',N'an',2)
insert into dbo.Account(Username,Password,CustomerId)
values(N'he',N'he',3)
insert into dbo.Account(Username,Password,CustomerId)
values(N'linh',N'linh',4)
go
--insert employee
insert into dbo.Employee(Salary,FullName,Gender,Birthday,Phone,Address,Email,Username,Password)
values(1000000,N'Trần Đại Nghĩa',1,'02/28/1985',N'0123456789',N'67 Tây Sơn Hà Nội',N'nghiadt@yahoo.com',N'dainghia',N'12345678')
insert into dbo.Employee(Salary,FullName,Gender,Birthday,Phone,Address,Email,Username,Password)
values(1200000,N'Nguyễn Hồng Ngân',0,'05/15/1995',N'0945542664',N'67 Tây Sơn Hà Nội',N'nganhh@yahoo.com',N'ngan',N'12345@ngan')
go
--insert BookCategory
insert into BookCategory(Name) values(N'Truyện tranh')
insert into BookCategory(Name) values(N'Tài liệu lịch sử')
insert into BookCategory(Name) values(N'Nghiêm cứu khoa học')
insert into BookCategory(Name) values(N'Truyện trinh thám')
insert into BookCategory(Name) values(N'Truyện kinh dị')
insert into BookCategory(Name) values(N'Sử thi')
insert into BookCategory(Name) values(N'Ngôn tình')
insert into BookCategory(Name) values(N'Văn học')
go
--insert author
insert into dbo.Author(Name,Birthday)
values(N'Nguyễn Trãi','08/30/1965')
insert into dbo.Author(Name,Birthday)
values(N'Nguyễn Du','09/26/1966')
insert into dbo.Author(Name,Birthday)
values(N'Hồ Chí Minh','10/12/1967')
insert into dbo.Author(Name,Birthday)
values(N'Thu Giang','01/11/1968')
insert into dbo.Author(Name,Birthday)
values(N'Nguyễn Hiến Lê','02/03/1969')
insert into dbo.Author(Name,Birthday)
values(N'Nguyễn Đăng Khoa','04/30/1970')
insert into dbo.Author(Name,Birthday)
values(N'Nguyễn Ngọc Tư','04/30/1971')
insert into dbo.Author(Name,Birthday)
values(N'Bảo Ninh','05/30/1972')
insert into dbo.Author(Name,Birthday,Email,Phone)
values(N'Phan Công Đức','01/20/1874',N'ductt@yahoo.com',N'0245675823')
insert into dbo.Author(Name,Birthday)
values(N'Nguyễn Chính','06/01/1064')
insert into dbo.Author(Name,Birthday,Email,Phone)
values(N'Từ Minh Phương','11/12/1900',N'phuongpt@dg.edu.vn',N'0987765284')
go
--insert publisher
insert into dbo.Publisher(Name,Email,Phone,Address)
values(N'Kim Đồng',N'kimdong@nxbkd.com',N'0245123123',N'123 Phan Châu Trinh Hải Châu')
insert into dbo.Publisher(Name,Email,Phone,Address)
values(N'Tuổi Trẻ',N'tuoitre@nxbtt.com',N'0245555555',N'85 Trần Hương Đạo')
insert into dbo.Publisher(Name,Email,Phone,Address)
values(N'Tự Do',N'td@gmail.com',N'0245166822',N'25 Lý Chính Thắng')
go
--insert book
--status
--0 cũ
--1 mới
--2 hot
--3 bán chạy


insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(1,1,1,N'Tạng thư sống chết',N'./image/an1.jpg',2134000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(2,2,2,N'Bản sắc ẩm thực',N'./image/an2.jpg',456000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(3,3,3,N'Phẫu thuật',N'./image/an3.jpg',654000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(4,4,1,N'Cuộc sống tươi đẹp',N'./image/an4.jpg',876000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(5,5,1,N'Sống',N'./image/an5.jpg',123000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(6,6,1,N'Tư duy kinh tế Việt Nam',N'./image/an6.jpg',342000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(7,1,2,N'Sức mạnh của hiện tại',N'./image/an7.jpg',765000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(8,2,2,N'Marketing du kích trong 30 ngày',N'./image/an8.jpg',1235000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(9,3,2,N'Vượt lên số phận',N'./image/an9.jpg',356000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(10,4,3,N'Học làm lãnh đạo',N'./image/an10.jpg',356000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(11,5,3,N'Khác biệt hay là chết',N'./image/an11.jpg',356000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(1,6,3,N'Cơ cấu trí khôn',N'./image/an12.jpg',356000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(3,1,1,N'Nỗi buồn chiến tranh',N'./image/an13.jpg',356000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(4,2,1,N'Nhà đầu tư thông minh',N'./image/an14.jpg',356000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(5,3,2,N'Cánh đống bất tận',N'./image/an15.jpg',356000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(6,4,2,N'Tôi tài giỏi, bạn cũng thế',N'./image/an16.jpg',356000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(7,5,3,N'Chuyện của Ana',N'./image/an17.jpg',356000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(8,6,3,N'Truyện Kiều',N'./image/an18.jpg',356000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(9,1,1,N'Các tôn giáo trên thế giới',N'./image/an19.jpg',356000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)
insert into dbo.Book(AuthorId,BookCategoryId,PublisherId,BookName,PictureThumb,Price,TotalPage,Language,PublishYear,Discount,Description,Status)
values(2,2,2,N'Bạn có thể đàm phán bất kì điều gì',N'./image/an20.jpg',356000,597,N'Việt Nam',1799,1.1,N'Không có gì',0)


go

--insert order_detail
insert into dbo.OrderDetail(BookIsbn,OrderId,Quantity,TransactionDate,Note)
values(5,1,5,'03/01/2018',N'đã nhận')
insert into dbo.OrderDetail(BookIsbn,OrderId,Quantity,TransactionDate,Note)
values(6,1,4,'03/01/2018',N'đã nhận')
insert into dbo.OrderDetail(BookIsbn,OrderId,Quantity,TransactionDate,Note)
values(7,2,5,'05/01/2018',N'đã nhận')
go

-- ORDER INFO 
insert into dbo.OrderInfo(CustomerId,EmployeeId,OrderDate)
values(1,2,'02/25/2018')
insert into dbo.OrderInfo(CustomerId,EmployeeId,OrderDate)
values(2,1,'12/25/2018')
go


select * from CustomerType
select * from Customer
select * from Account
select * from Employee
select * from BookCategory
select * from Author
select * from Publisher
select * from Book
select * from OrderINFO;
select * from OrderDetail




--delete  from OrderDetail
--delete  from CustomerType
--delete  from Customer
--delete  from Account
--delete  from Employee
--delete  from BookCategory
--delete  from Author
--delete from Publisher
--delete  from Book
--delete  from OrderINFO;
