-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th5 23, 2024 lúc 02:09 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlysanpham_btl`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `ID` int(11) NOT NULL,
  `MaPhieuNhap` varchar(50) NOT NULL,
  `Masp` varchar(15) NOT NULL,
  `SoLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`ID`, `MaPhieuNhap`, `Masp`, `SoLuong`) VALUES
(16, 'PN01', 'SP11', 3),
(17, 'PN01', 'SP15', 4),
(18, 'PN01', 'SP12', 7),
(19, 'PN01', 'SP02', 2);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietphieuxuat`
--

CREATE TABLE `chitietphieuxuat` (
  `ID` int(11) NOT NULL,
  `MaPhieuXuat` varchar(50) NOT NULL,
  `Masp` varchar(15) NOT NULL,
  `SoLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietphieuxuat`
--

INSERT INTO `chitietphieuxuat` (`ID`, `MaPhieuXuat`, `Masp`, `SoLuong`) VALUES
(12, 'PX02', 'SP10', 5),
(13, 'PX02', 'SP15', 12),
(14, 'PX02', 'SP14', 3),
(15, 'PX02', 'SP17', 13),
(21, 'PX03', 'SP05', 5),
(22, 'PX03', 'SP17', 2),
(23, 'PX03', 'SP02', 2),
(24, 'PX03', 'SP21', 2),
(25, 'PX03', 'SP24', 13),
(26, 'PX03', 'SP17', 2),
(34, 'PX04', 'SP17', 7),
(35, 'PX04', 'SP15', 5),
(36, 'PX04', 'SP19', 4),
(37, 'PX04', 'SP24', 10),
(38, 'PX04', 'SP20', 2),
(39, 'PX10', 'SP08', 5),
(40, 'PX10', 'SP17', 10),
(41, 'PX10', 'SP03', 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisp`
--

CREATE TABLE `loaisp` (
  `Maloai` varchar(10) NOT NULL,
  `Tenloai` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loaisp`
--

INSERT INTO `loaisp` (`Maloai`, `Tenloai`) VALUES
('CT', 'Cơ thể'),
('DM', 'Da mặt'),
('MP', 'Mỹ phẩm'),
('PK', 'Phụ kiện'),
('TD', 'Trang điểm');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `maNCC` varchar(20) NOT NULL,
  `tenNCC` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`maNCC`, `tenNCC`) VALUES
('NCC001', 'Công Ty TNHH Quốc Tế Unilever Việt Nam'),
('NCC002', 'Công Ty TNHH xuất nhập khẩu mỹ phẩm Mint'),
('NCC003', 'Công Ty TNHH mỹ phẩm Ohui'),
('NCC004', 'Công Ty TNHH mỹ phẩm Sakira');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `maNV` varchar(15) NOT NULL,
  `tenNV` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `capBac` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`maNV`, `tenNV`, `username`, `password`, `capBac`) VALUES
('NV001', 'admin', 'admin', '123', 'Quản lý'),
('NV002', 'Lê Thị Hoài Anh', 'hoaianh123', '123', 'Nhân viên'),
('NV003', 'Nguyễn Thị Hoài', 'hoai123', '123', 'Nhân viên'),
('NV004', 'Kiều Thị Bích Hồng', 'hong123', '123', 'Nhân viên'),
('NV005', 'Phạm Trâm Anh', 'tramanh123', '123', 'Nhân viên'),
('NV006', 'Nguyễn Trọng Hiếu', 'hieu123', '123', 'Nhân viên'),
('NV007', 'Nguyễn Thị Hiền', 'hien123', '123', 'Nhân viên'),
('NV008', 'Bùi Quý Hiếu', 'bqh123', '123', 'Nhân viên'),
('NV009', 'Hoàng Thị Hương', 'huong123', '123', 'Nhân viên'),
('NV010', 'Nguyễn Đình Khánh', 'khanh123', '123', 'Nhân viên');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhap`
--

CREATE TABLE `phieunhap` (
  `MaPhieuNhap` varchar(50) NOT NULL,
  `NgayTaoPhieu` date NOT NULL,
  `NguoiTaoPhieu` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieunhap`
--

INSERT INTO `phieunhap` (`MaPhieuNhap`, `NgayTaoPhieu`, `NguoiTaoPhieu`) VALUES
('PN01', '2023-12-04', 'hong123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `MaPhieuXuat` varchar(50) NOT NULL,
  `NgayTaoPhieu` date NOT NULL,
  `NguoiTaoPhieu` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `phieuxuat`
--

INSERT INTO `phieuxuat` (`MaPhieuXuat`, `NgayTaoPhieu`, `NguoiTaoPhieu`) VALUES
('PX02', '2023-12-03', 'hong123'),
('PX03', '2023-12-03', 'hong123'),
('PX04', '2023-12-04', 'hong123'),
('PX10', '2023-12-04', 'hong123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `Masp` varchar(15) NOT NULL,
  `Tensp` varchar(255) NOT NULL,
  `Maloai` varchar(10) NOT NULL,
  `MoTa` text DEFAULT NULL,
  `Gia` float NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `XuatXu` varchar(255) NOT NULL,
  `maNCC` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`Masp`, `Tensp`, `Maloai`, `MoTa`, `Gia`, `SoLuong`, `XuatXu`, `maNCC`) VALUES
('SP01', 'Sữa rửa mặt dưỡng ẩm SVR', 'MP', 'Rửa mặt hàng ngày giúp loại bỏ bã nhờn và bụi bẩn, làm sáng da', 285000, 100, 'Pháp', 'NCC001'),
('SP02', 'Kem nền Maybelline', 'TD', 'Kem nền trang điểm giúp che phủ các khuyết điểm và tạo lớp nền mịn màng', 245000, 120, 'Pháp', 'NCC002'),
('SP03', 'Son Bbia', 'TD', 'Son môi màu đỏ tươi sáng, tạo nên đôi môi quyến rũ', 189000, 76, 'Hàn Quốc', 'NCC002'),
('SP04', 'Serum trị mụn', 'MP', 'Serum chứa các thành phần chống vi khuẩn và giảm đốm mụn, giúp kiểm soát tình trạng da mụn và làm dịu nhẹ làn da.', 195000, 70, 'Hàn Quốc', 'NCC001'),
('SP05', 'Phấn má hồng JUDYDOLL', 'TD', 'Phấn má hồng làm tôn lên đường nét khuôn mặt và tạo cảm giác tươi tắn', 125000, 95, 'Trung Quốc', 'NCC001'),
('SP06', 'Kem dưỡng da ban đêm Olay', 'MP', 'Kem dưỡng da ban đêm giúp tái tạo và phục hồi làn da sau một ngày làm việc, chứa các thành phần dưỡng da chuyên sâu.', 365000, 90, 'Anh', 'NCC002'),
('SP07', 'Mascara siêu cong Clio', 'TD', 'Mascara siêu cong giúp làm cong và dài mi một cách tự nhiên', 145000, 90, 'Hàn Quốc', 'NCC001'),
('SP08', 'Tẩy tế bào chết Enzymatic', 'MP', 'Tẩy tế bào chết enzymatic giúp loại bỏ tế bào da chết một cách nhẹ nhàng, để lại làn da sáng mịn và tươi tắn.', 250000, 105, 'Ý', 'NCC001'),
('SP09', 'Dầu tẩy trang dưỡng ẩm', 'MP', 'Dầu tẩy trang dưỡng ẩm giúp loại bỏ lớp trang điểm và tạp chất trên da, đồng thời cung cấp dưỡng ẩm cho da.', 235000, 60, 'Pháp', 'NCC002'),
('SP10', 'Bút kẻ mắt nước Kiss Me', 'TD', 'Bút kẻ mắt nước giúp tạo đường viền mắt sắc nét và bền màu', 130000, 105, 'Mỹ', 'NCC001'),
('SP11', 'Cọ Tán Son Môi, Che Khuyết Điểm Môi', 'PK', 'Cọ Tán Son Môi, Che Khuyết Điểm Môi được thiết kế với đầu tròn đa năng mềm mại giúp tán son đều mịn trên môi, hỗ trợ cho việc lên màu son mà không bị lem, mang đến hiệu ứng ombre cho đôi môi thêm dày dặn.\r\n', 35000, 26, 'Hàn Quốc', 'NCC001'),
('SP12', 'Giấy Thấm Dầu 70 Miếng Dr.G Red R.E.D Blemish Oil Control Paper', 'PK', 'Giấy Thấm Dầu Dr.G Red Blemish Oil Control Paper 70 Miếng với chiết xuất từ trà xanh không những giúp kháng khuẩn kháng viêm cho làn da mà còn giúp hút đi các bã nhờn được tiết ra trên da, trả lại một làn da khô sạch, trong trẻo - được xem là bảo bối trong túi xách của mọi cô gái.', 85000, 62, 'Trung Quốc', 'NCC002'),
('SP13', 'Kem Tắm Trắng Da Toàn Thân Secret Key Snow White Milky Pack', 'CT', 'Kem tắm trắng da Secret Key Snow White Milky Pack không chứa các chất độc hại, chất tạo mùi mà đem lại cho các chị em phụ nữ làn da trắng sáng cùng với những trải nghiệm thú vị ngay từ lần thử đầu tiên. Sản phẩm còn chứa các thành phần giúp chống tia UV, thẩm thấu nhanh trên da mà không gây bí bách lỗ chân lông.', 320000, 12, 'Hàn Quốc', 'NCC003'),
('SP14', 'Nước Hoa Dior Miss Dior Absolutely Blooming Eau De Parfum', 'CT', 'Nước Hoa Dior Miss Dior Absolutely Blooming Eau De Parfum thuộc nhóm hương hoa cỏ trái cây nên cực kỳ tươi trẻ, hiện đại và mang phong thái ngọt ngào. Mở đầu ra là một khu vườn trái cây đầy ngọt ngào, là quả mâm xôi chua ngọt là quả dâu đỏ, dâu đen. Tiếp đến là hương mẫu đơn thanh tao kết hợp với hồng hoa đầy nồng nàn. Và chốt lại các hương chính là xạ hương làm cho lòng người xao xuyến.', 3250000, 13, 'Pháp', 'NCC001'),
('SP15', 'Nước Tẩy Trang Phục Hồi Cho Da Nhạy Cảm Pretty Skin B5 Cleansing Water', 'DM', 'Nước Tẩy Trang Phục Hồi Cho Da Nhạy Cảm Pretty Skin B5 Cleansing Water chứa các thành phần dịu nhẹ và lành tính, không chứa hương liệu hay cồn, giúp làm sạch da một cách dịu nhẹ mà không gây kích ứng cho làn da nhạy cảm.', 299000, 110, 'Hàn Quốc', 'NCC002'),
('SP16', 'Kem Dưỡng Chăm Sóc Làm Se Khít Lỗ Chân Lông Bioderma Sebium Pore Refiner', 'DM', 'Kem Dưỡng Chăm Sóc Làm Se Khít Lỗ Chân Lông Bioderma Sebium Pore Refiner là sản phẩm kem dưỡng ẩm chăm sóc cho da mụn được điều chế với công thức chứa Hydrophilic sugar giúp làn da được dưỡng ẩm liên tục trong suốt 48 giờ, đem lại hiệu quả mềm mịn và tươi trẻ.', 325000, 55, 'Trung Quốc', 'NCC004'),
('SP17', 'Bông Phấn Khô Lớn Vacosi Large Round Puff', 'PK', 'Bông phấn khô tròn lớn màu kem VACOSI có thiết kế hình tròn, dễ cầm và dặm phấn theo cách chuyên nghiệp nhất. Với đường kính 9cm, bông phấn rất thích hợp dùng để phủ phấn sau khi đánh kem nền.', 25000, 100, 'Trung Quốc', 'NCC002'),
('SP18', 'Bông Đắp Dưỡng Miếng Đôi 40 Miếng Silcot ', 'PK', 'Bông Đắp Dưỡng Miếng Đôi 40 Miếng Silcot  - Nhật Bản là sản phẩm bán chạy số 1 tại Nhật Bản hơn 10 năm liền, bông trang điểm Unicharm Silcot hứa hẹn mang đến cho người dùng một làn da khỏe đẹp tự nhiên. ', 45000, 23, 'Nhật Bản', 'NCC003'),
('SP19', 'Nhíp Đầu Xéo Vacosi Slanted Tweezers', 'PK', 'Nhíp đầu xéo VACOSI được sản xuất theo công nghệ Hàn Quốc, sử dụng chất liệu inox không rỉ, phủ sơn đen cao cấp. Thiết kế đơn giản dễ sử dụng, bạn có thể gắp các chi tiết nhỏ nhất một cách dễ dàng.', 75000, 39, 'Trung Quốc', 'NCC001'),
('SP20', 'Tẩy Tế Bào Chết Làm Trắng Da White Conc Body Gommage', 'CT', 'Tẩy Tế Bào Chết Làm Trắng Da White Conc Body Gommage là một dòng sản phẩm tẩy da chết hóa học thuộc thương hiệu nổi tiếng Da White, với thành phần là các dưỡng chất cần thiết, vừa hỗ trợ tẩy tế bào chết cho da, vừa có khả năng dưỡng ẩm và làm trắng da.', 335000, 30, 'Nhật bản', 'NCC004'),
('SP21', 'Dầu Gội Dưỡng Tóc Suôn Mượt Tóc Loreal Paris Extraordinary Oil Smooth Silicone-Free Shampoo', 'CT', 'Dầu Gội Dưỡng Tóc Suôn Mượt Tóc Loreal Paris Extraordinary Oil Smooth Silicone-Free Shampoo có chứa các thành phần tự nhiên như 100% chiết xuất gỗ tuyết tùng; hỗ trợ cải thiện tình trạng tóc gãy rụng, khô xơ, mang đến một mái tóc suôn mượt và chắc khỏe hiệu quả.', 199000, 110, 'Pháp', 'NCC001'),
('SP22', 'Kem Dưỡng Da Tay Hatomugi Moisturizing & Conditioning The Hand Cream', 'CT', 'Với thành phần chiết xuất từ hạt ý dĩ giúp cung cấp dưỡng chất và độ ẩm cho da tay, giúp da tay mềm mịn và tươi sáng hơn - Kem Dưỡng Tay Hatomugi The Hand Cream nhất định là một sản phẩm không thể thiếu trong quá trình làm đẹp của chị em phụ nữ.', 86000, 98, 'Nhật Bản', 'NCC002'),
('SP23', 'Nước Hoa Hồng Klairs Supple Preparation Facial Toner', 'DM', 'Nước Hoa Hồng Klairs Supple Preparation Facial Toner là toner \"thần thánh\" nhận được rất nhiều review tốt, có chiết xuất từ thực vật, giúp cân bằng độ pH, tăng cường hiệu quả chăm sóc da. Giúp \"hồi sức\" và \"bừng tỉnh\" làn da mềm mại, ẩm mịn, sáng ngời.', 289000, 43, 'Ý', 'NCC003'),
('SP24', 'Mặt Nạ Giảm Thâm Mụn, Giúp Đều Màu Da Foodaholic With Vitamin C - Brightening', 'DM', 'Mặt Nạ Giảm Thâm Mụn, Giúp Đều Màu Da Foodaholic With Vitamin C - Brightening với chiết xuất vitamin C dưỡng trắng, dưỡng sáng và làm đều màu da, đồng thời giúp cho da không bị khô, nhăn do ảnh hưởng lão hóa. Xoá mờ những nốt đen trên da, ức chế việc tạo thành melanin, làm mờ sắc tố melanin, làm mờ vết thâm, nám, tàn nhang.', 18000, 190, 'Pháp', 'NCC004'),
('SP25', 'Kem Chống Nắng Kiềm Dầu La Roche-Posay Anthelios UVmune 400 Oil Control Gel-Cream SPF 50+ PA++++ ', 'DM', 'Kem Chống Nắng Kiềm Dầu La Roche-Posay Anthelios UVmune 400 Oil Control Gel-Cream SPF 50+ PA++++ cung cấp cho làn da sự bảo vệ tối ưu chống lại tia UVA & UVB của mặt trời đồng thời chống lại tác hại của tia hồng ngoại và ô nhiễm, chống thấm nước và kiểm soát dầu hiệu quả.', 459000, 24, 'Pháp', 'NCC003');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `loaisp`
--
ALTER TABLE `loaisp`
  ADD PRIMARY KEY (`Maloai`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`maNCC`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`maNV`);

--
-- Chỉ mục cho bảng `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`MaPhieuNhap`);

--
-- Chỉ mục cho bảng `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`MaPhieuXuat`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`Masp`),
  ADD KEY `maloai` (`Maloai`),
  ADD KEY `NCC` (`maNCC`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietphieunhap`
--
ALTER TABLE `chitietphieunhap`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT cho bảng `chitietphieuxuat`
--
ALTER TABLE `chitietphieuxuat`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD CONSTRAINT `fk_ma_ncc` FOREIGN KEY (`maNCC`) REFERENCES `sanpham` (`maNCC`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Các ràng buộc cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `fk_ma_loai` FOREIGN KEY (`Maloai`) REFERENCES `loaisp` (`Maloai`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
