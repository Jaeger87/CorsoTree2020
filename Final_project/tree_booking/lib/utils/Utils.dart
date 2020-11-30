import 'dart:io';

import 'package:dio/dio.dart';
import 'package:flushbar/flushbar.dart';
import 'package:flutter/material.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';
import 'package:get/get.dart';
import 'package:tree_booking/utils/Configuration.dart';
import 'package:tree_booking/utils/CookiesManager.dart';
import 'package:tree_booking/utils/XsProgressHudCustom.dart';

class Utils {

  static void showCustomHud(BuildContext context) {
    return;
    XsProgressHudCustom.show(context);
  }

  static void hideCustomHud(BuildContext context) {
    return;
    XsProgressHudCustom.hide();
  }

  static void showErrorSnackBar(String message, {String title, int durationSeconds}) {
    if(message == null)
      return;

    showWarningSnackBar(message, title: title, durationSeconds: durationSeconds);
    return;
    /*Get.snackbar(
      title ?? MyLocalizations.of(Get.context, "snackbar_error"),
      message,
      backgroundColor: Colors.red,
      colorText: Colors.white,
      snackPosition: SnackPosition.BOTTOM,
      margin: EdgeInsets.only(bottom: 20),
      barBlur: 10
    );
    return;*/

    /*showFlash(
      context: context,
      duration: Duration(seconds: durationSeconds ?? 2),
      builder: (_, controller) {
        return Flash(
          controller: controller,
          barrierColor: Colors.green,
          barrierBlur: 10,
          backgroundColor: TheTableTheme.baseColor,
          boxShadows: [BoxShadow(blurRadius: 4)],
          borderRadius: BorderRadius.circular(8.0),
          borderColor: TheTableTheme.baseColor,
          position: FlashPosition.center,
          alignment:  Alignment(0, 0.95),
          enableDrag: false,
          onTap: () => controller.dismiss(),
          child: Padding(
            padding: const EdgeInsets.all(12.0),
            child: DefaultTextStyle(
              style: TextStyle(color: Colors.white),
              child: Text(message),
            ),
          ),
        );
      },
    );*/
  }

  static void showWarningSnackBar(String message,
      {String title, int durationSeconds}) {
    if (message == null) return;
    Flushbar(
      title: title,
      message: message,
      backgroundColor: Colors.amber,
      margin: EdgeInsets.only(bottom: 20, left: 20, right: 20),
      animationDuration: Duration(milliseconds: 400),
      duration:  Duration(seconds: durationSeconds ?? 3),
      barBlur: 10,
      borderRadius: 10,
      onTap: (Flushbar flushbar) {
        flushbar?.dismiss();
      },
    )..show(Get.context);

    /*Get.snackbar(
        title,
        message,
        backgroundColor: Colors.amber,
        colorText: Colors.white,
        snackPosition: SnackPosition.BOTTOM,
        margin: EdgeInsets.only(bottom: 20, left: 20, right: 20),
        duration: Duration(seconds: durationSeconds ?? 5),
        animationDuration: Duration(milliseconds: 400),
        onTap: (GetBar snack) {
          //snack?.dismiss();
        },
        barBlur: 10);*/
  }

  static void showOkSnackBar(String message,
      {String title,
        int durationSeconds,
        SnackPosition position,
        Function onTap,
        bool isDismissible}) {
    if (message == null) return;
    Flushbar(
      title:  title,
      message: message,
      backgroundColor: Colors.green,
      margin: EdgeInsets.only(bottom: 20, left: 20, right: 20),
      animationDuration: Duration(milliseconds: 400),
      isDismissible: isDismissible ?? false,
      barBlur: 10,
      borderRadius: 10,
      duration:  Duration(seconds: durationSeconds ?? 3),
      onTap: onTap ?? (Flushbar flushbar) {
        flushbar?.dismiss();
      },
    )..show(Get.context);
  }

  static Dio buildDio(){
    Dio dio = new Dio();

    BaseOptions options = new BaseOptions(
        connectTimeout: 12000,
        receiveTimeout: 15000,
        headers: {
          "Content-Type": "application/json",
          "Cookie": CookiesManager.getCookiesAsString(),
          "app_version": Configuration.APP_VERSION,
        },
        contentType: ContentType.json.value,
        responseType: ResponseType.json);
    dio.options = options;
    dio.interceptors.add(
        InterceptorsWrapper(
            onError: (DioError dioError) {

            })
    );
    return dio;
  }

  static getProgressIndicator() {
    return SpinKitDoubleBounce(
      color: Colors.blue,
      size: 35,
    );
  }
}