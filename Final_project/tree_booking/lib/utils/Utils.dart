import 'dart:io';

import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';
import 'package:get/get.dart';
import 'package:tree_booking/utils/Configuration.dart';
import 'package:tree_booking/utils/CookiesManager.dart';
import 'package:tree_booking/utils/XsProgressHudCustom.dart';

class Utils {

  static void showCustomHud(BuildContext context) {
    XsProgressHudCustom.show(context);
  }

  static void hideCustomHud(BuildContext context) {
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

  static void showWarningSnackBar(String message, {String title, int durationSeconds}) {
    if(message == null)
      return;

    Get.snackbar(
        title,
        message,
        backgroundColor: Colors.amber,
        colorText: Colors.white,
        snackPosition: SnackPosition.BOTTOM,
        margin: EdgeInsets.only(bottom: 20, left: 20, right: 20),
        barBlur: 10
    );
    return;
  }

  static void showOkSnackBar(String message,
      {String title,
        int durationSeconds,
        SnackPosition position,
        Function onTap,
        bool isDismissible}) {
    if (message == null) return;

    Get.snackbar(title, message,
        backgroundColor: Colors.green,
        colorText: Colors.white,
        snackPosition: position ?? SnackPosition.BOTTOM,
        margin: EdgeInsets.only(bottom: 20, left: 20, right: 20),
        barBlur: 10,
        onTap: onTap ?? (GetBar snack) {
          /*if(isDismissible)
            snack?.dismiss();*/
        },
        animationDuration: Duration(milliseconds: 400),
        duration: Duration(seconds: durationSeconds ?? 5),
        isDismissible: isDismissible);
    return;
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