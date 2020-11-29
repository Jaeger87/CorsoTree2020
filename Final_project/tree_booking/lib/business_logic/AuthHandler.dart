import 'dart:convert';

import 'package:dio/dio.dart';
import 'package:sprintf/sprintf.dart';
import 'package:tree_booking/entity/UserEntity.dart';
import 'package:tree_booking/utils/Configuration.dart';
import 'package:tree_booking/utils/CookiesManager.dart';
import 'package:tree_booking/utils/Utils.dart';

class AuthHandler {

  Future<UserEntity> login(String username, String password) async {
    Dio dio = Utils.buildDio();
    try {
      Response r = (await dio.get(sprintf(
          Configuration.LOGIN, [username, password]
      )));
      if(r.statusCode != 200)
        return null;

      // set cookies
      CookiesManager.clear();
      if(!r.headers.map.containsKey("set-cookie"))
        return null;
      for (String cookieString in r.headers["set-cookie"])
        CookiesManager.addCookie(cookieString);

      return UserEntity.fromJson(r.data);
    } on DioError catch (e) {
      //print("ERROR GETTING TIME" + e.toString());
      //print(e.response?.data);
      //print(e.message);
      return null;
    }
  }

  Future<bool> signup(UserEntity userEntity) async {
    Dio dio = Utils.buildDio();
    try {
      Response r = await dio.post(Configuration.SIGNUP_USER, data: json.encode(userEntity.toJson()));
      if(r.statusCode != 201)
        return false;

      // set cookies
      CookiesManager.clear();
      if(!r.headers.map.containsKey("set-cookie"))
        return false;
      for (String cookieString in r.headers["set-cookie"])
        CookiesManager.addCookie(cookieString);

      return true;

    } on DioError catch (e) {
      //print("ERROR GETTING TIME" + e.toString());
      //print(e.response?.data);
      //print(e.message);
      return false;
    }
  }

}