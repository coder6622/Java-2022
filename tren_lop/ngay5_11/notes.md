- [1. Dac ta truy xuat](#1-dac-ta-truy-xuat)
  - [1.1. private: duoc su dung trong noi bo class](#11-private-duoc-su-dung-trong-noi-bo-class)
  - [1.2. public: cong khai hoan toan](#12-public-cong-khai-hoan-toan)
  - [1.3. {default}](#13-default)
  - [1.4. protected: tuong tu {default} nhung cho phep ke thua du lop cha va con khac goi](#14-protected-tuong-tu-default-nhung-cho-phep-ke-thua-du-lop-cha-va-con-khac-goi)
  - [Muc che giau tang dan theo mui ten](#muc-che-giau-tang-dan-theo-mui-ten)
- [Encapsulation](#encapsulation)
- [Quy tac dat ten trong java](#quy-tac-dat-ten-trong-java)
  - [Ten package: toan bo ky tu thuong va dau cham: `java.util, com.poly`](#ten-package-toan-bo-ky-tu-thuong-va-dau-cham-javautil-compoly)
  - [Ten class, interface: viet hoa ky tu dau](#ten-class-interface-viet-hoa-ky-tu-dau)
  - [Ten field, method, varriable: cac tu phai viet hoa ki tu dau ngoai tru tu dau tien phai viet thuong](#ten-field-method-varriable-cac-tu-phai-viet-hoa-ki-tu-dau-ngoai-tru-tu-dau-tien-phai-viet-thuong)
- [Su phan cap ke thua](#su-phan-cap-ke-thua)
- [Lop truu tuong: la lop co `hanh vi chua duoc xac dinh ro`](#lop-truu-tuong-la-lop-co-hanh-vi-chua-duoc-xac-dinh-ro)
- [Interface: chi chua cac method abstract va cac bien final](#interface-chi-chua-cac-method-abstract-va-cac-bien-final)
  - [Interface la public hoac default](#interface-la-public-hoac-default)
  - [Interface co the duoc ke thua](#interface-co-the-duoc-ke-thua)
- [Lop noi](#lop-noi)
- [Truyen tham so cho phuong thuc](#truyen-tham-so-cho-phuong-thuc)
  - [Khi phuong thuc lam thay doi gia tri cua tham so this:](#khi-phuong-thuc-lam-thay-doi-gia-tri-cua-tham-so-this)
- [Final - dinh nghia hang](#final---dinh-nghia-hang)
  - [Su dung tu khoa `final` de dinh nghia hang](#su-dung-tu-khoa-final-de-dinh-nghia-hang)

# 1. Dac ta truy xuat

## 1.1. private: duoc su dung trong noi bo class

## 1.2. public: cong khai hoan toan

## 1.3. {default}

- `public` doi voi cac lop truy xuat `cung goi`
- `private` vs cac lop truy xuat `khac goi`

## 1.4. protected: tuong tu {default} nhung cho phep ke thua du lop cha va con khac goi

## Muc che giau tang dan theo mui ten

> `public -> protected -> {default} -> private`

# Encapsulation

- `Bao ve thong tin du lieu`
- `Tang cuong do mo rong`
- De che giau thong tin, su dung `private` cho cac truong du lieu
- Bo sung cac `getter va setter` de doc va ghi du lieu

# Quy tac dat ten trong java

## Ten package: toan bo ky tu thuong va dau cham: `java.util, com.poly`

## Ten class, interface: viet hoa ky tu dau

## Ten field, method, varriable: cac tu phai viet hoa ki tu dau ngoai tru tu dau tien phai viet thuong

- hoTen, diem, fullName, mark
- setHoTen(), input(), setDiem()

> `Ten class, field va varriable su dung danh tu`

> `Ten phuong thuc su dung dong tu`

# Su phan cap ke thua

- Trong java `1 lop` chi co `mot lop cha duy nhat` `(don ke thua)`

- Muc dich: `tai su dung`
- Lop con duoc phep so huu cac tai san:

  - cac tai san `public hoac protected` cua lop cha

- Dac ta truy xuat cua phuong thuc lop con phai co do `cong khai bang hoac hon dac ta` truy xuat cua phuong thuc lop cha

# Lop truu tuong: la lop co `hanh vi chua duoc xac dinh ro`

- Khong su dung `new` de tao doi tuong tu lop truu truong

# Interface: chi chua cac method abstract va cac bien final

## Interface la public hoac default

## Interface co the duoc ke thua

# Lop noi

- La lop duoc khai bao ben trong mot lop khac
- Co hai loai: lop noi tinh va lop noi thong thuong

# Truyen tham so cho phuong thuc

## Khi phuong thuc lam thay doi gia tri cua tham so this:

- Neu la tham tri: gia tri cua tham so se khong bi thay doi
- Neu la tham bien: gia tri cua tham so bi thay doi theo

# Final - dinh nghia hang

- Lop hang khong cho phep ke thua
- Phuong thuc hang khong the ghi de
- Bien hang khong cho phep thay doi gia tri

## Su dung tu khoa `final` de dinh nghia hang
