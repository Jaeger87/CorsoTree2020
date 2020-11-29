import 'dart:async';
import 'package:flutter/material.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';

import 'Utils.dart';

class XsProgressHudCustom extends PopupRoute {
  static Duration LOADING_TIMEOUT = Duration(seconds: 10);
  static Timer timer;

  /*
  * Show message.
  * */
  static Future<void> showMessage(BuildContext context, String message) async {
    try {
      if (_currentHud != null) {
        _currentHud.navigator.pop();
      }
      XsProgressHudCustom hud = XsProgressHudCustom();
      hud.message = message;
      _currentHud = hud;
      Navigator.push(context, hud);
      Future.delayed(hud.delayed).then((val) {
        _currentHud.navigator.pop();
        _currentHud = null;
      });
    } catch (e) {
      _currentHud = null;
    }
  }

  /*
  * show an hud.
  * when you want to do anything, you can call this show.
  * for example： begin network request
  * */
  static Future<void> show(BuildContext context) async {
    if (_currentHud != null)
      return;
    try {
      /*if (_currentHud != null) {
        _currentHud.navigator.pop();
      }*/
      XsProgressHudCustom hud = XsProgressHudCustom();
      _currentHud = hud;
      Navigator.push(context, hud);
      timer = Timer(LOADING_TIMEOUT, () {
        if(_currentHud != null)
          Utils.showWarningSnackBar("Qualcosa è andato storto");
        hide();
      });
    } catch (e) {
      _currentHud = null;
    }
  }

  /*
  * hide hud
  * when you complete something,you can call this hide to hide hud.
  * */
  static Future<void> hide() async {
    if(_currentHud != null){
      try {
        _currentHud.navigator.pop();
        _currentHud = null;
        timer?.cancel();
      } catch (e) {
        _currentHud = null;
      }
    }
  }

// hud show this message, default null. when you set ,it will show message hud, not progress hud.
  String message;
  Color progressColor = Colors.lightBlue;
  Color progressBackgroundColor = Colors.white;
  Color coverColor = Color.fromRGBO(0, 0, 0, 0.4);
  Duration delayed = Duration(milliseconds: 2000);
  TextStyle loadingTextStyle = TextStyle(
      fontSize: 13.0,
      color: Colors.black,
      fontWeight: FontWeight.normal,
      
      decoration: TextDecoration.none);
  TextStyle messageTextStyle = TextStyle(
      fontSize: 14.0,
      color: Colors.black87,
      fontWeight: FontWeight.w500,
      decoration: TextDecoration.none);

  String loadingMessage = 'Loading ...';

  static XsProgressHudCustom _currentHud;

  @override
  // TODO: implement barrierColor
  Color get barrierColor => null;

  @override
  // TODO: implement barrierLabel
  String get barrierLabel => null;

  @override
  // TODO: implement transitionDuration
  Duration get transitionDuration => kThemeAnimationDuration;

  @override
  // TODO: implement barrierDismissible
  bool get barrierDismissible => true;

  @override
  Widget buildPage(BuildContext context, Animation<double> animation,
      Animation<double> secondaryAnimation) {
    // TODO: implement buildPage
    return Container(
      color: Colors.transparent,
      child: Center(
        child: _getProgress(context),
      ),
    );
  }

  @override
  Widget buildTransitions(BuildContext context, Animation<double> animation,
      Animation<double> secondaryAnimation, Widget child) {
    // TODO: implement buildTransitions
    return super
        .buildTransitions(context, animation, secondaryAnimation, child);
  }

  Widget _getProgress(BuildContext context) {
    double height = MediaQuery.of(context).size.height;
    double width = MediaQuery.of(context).size.width;
    return Stack(
      children: <Widget>[
        Container(
          height: height,
          width: width,
          decoration: BoxDecoration(
            gradient: LinearGradient(
              begin: Alignment.topCenter,
              end: Alignment.bottomCenter,
              colors: [
                Colors.black38,
                Colors.black54,
                Colors.black38,
              ],
            ),
          ),
        ),
        Align(
          alignment: Alignment.center,
          child: Container(
              width: 140.0,
              height: 140.0,
              decoration: new BoxDecoration(
                  color: Colors.transparent,
                  borderRadius: new BorderRadius.all(new Radius.circular(10))),
              child: Stack(
                children: <Widget>[
                  Center(
                    child: SpinKitDoubleBounce(
                      color: Colors.grey,
                    ),
                  ),
                  message != null
                      ? Center(
                    child: Container(
                      margin: EdgeInsets.only(top: 70.0),
                      child: Text(message, style: loadingTextStyle),
                    ),
                  )
                      : SizedBox()
                ],
              )),
        ),
      ],
    );
  }
}
