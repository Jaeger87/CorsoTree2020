// To parse this JSON data, do
//
//     final userEntity = userEntityFromJson(jsonString);

import 'dart:convert';
import 'package:intl/intl.dart';
import 'package:tree_booking/entity/UserGender.dart';

UserEntity userEntityFromJson(String str) => UserEntity.fromJson(json.decode(str));

String userEntityToJson(UserEntity data) => json.encode(data.toJson());

class UserEntity {
  UserEntity({
    this.id,
    this.name,
    this.username,
    this.surname,
    this.birthDate,
    this.gender,
    this.password,
  });

  String id;
  String name;
  String username;
  String surname;
  DateTime birthDate;
  UserGender gender;
  String password;

  factory UserEntity.fromJson(Map<String, dynamic> json) => UserEntity(
    id: json["id"],
    name: json["name"],
    username: json["username"],
    surname: json["surname"],
    birthDate: json["birthDate"] != null ? DateTime.parse(json["birthDate"]) : null,
    gender: json["gender"] != null ? userGenderFromString(json["gender"]) : null,
    password: json["password"],
  );

  Map<String, dynamic> toJson() => {
    "id": id,
    "name": name,
    "username": username,
    "surname": surname,
    "birthDate": DateFormat('yyyy-MM-dd').format(birthDate),
    "gender": userGenderToString(gender),
    "password": password,
  };
}

/*
{

    "id": "",
    "name": "",
    "username": "",
    "surname": "",
    "birthDate": "",
    "gender": "",
    "password": ""

}
 */