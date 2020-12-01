import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:tree_booking/ui/auth/LoginPage.dart';
import 'package:tree_booking/ui/common/RoundedButton.dart';
import 'package:tree_booking/ui/style/AppTheme.dart';
import 'package:tree_booking/utils/Configuration.dart';
import 'package:get/get.dart';
import 'package:tree_booking/utils/MyLocalizations.dart';
import 'package:tree_booking/utils/Utils.dart';

class ChooseServer extends StatefulWidget {
  @override
  _ChooseServerState createState() => _ChooseServerState();
}

class _ChooseServerState extends State<ChooseServer> {
  TextEditingController backendController = new TextEditingController();
  TextEditingController backendPortController = new TextEditingController();


  @override
  void initState() {
    super.initState();
    SystemChrome.setPreferredOrientations([
      DeviceOrientation.portraitUp,
    ]);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.white,
      resizeToAvoidBottomInset: false,
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(
            MyLocalizations.of(context, "backend_url"),
            textAlign: TextAlign.left,
            style: TextStyle(
              color: Colors.black,
              fontWeight: FontWeight.bold,
              fontSize: 18.0,
            ),
          ),
          SizedBox(height: 10),
          Center(
            child: Container(
              width: MediaQuery.of(context).size.width * 0.7,
              child: TextField(
                keyboardType: TextInputType.url,
                textInputAction: TextInputAction.next,
                controller: backendController,
                maxLines: 1,
                textAlign: TextAlign.center,
                style: TextStyle(
                    color: AppTheme.baseTheme,
                    fontWeight: FontWeight.normal,
                    fontSize: 16.0),
                decoration: InputDecoration(
                  border: UnderlineInputBorder(),
                  //border: InputBorder.none,
                  hintText: MyLocalizations.of(context, "insert_backend_url"),
                  hintStyle: TextStyle(
                      color: AppTheme.baseTheme,
                      fontWeight: FontWeight.normal,
                      fontSize: 16.0),
                ),
                onEditingComplete: () {
                  FocusScope.of(context).requestFocus(FocusNode());
                },
              ),
            ),
          ),
          SizedBox(height: 10),
          Center(
            child: Container(
              width: 100,
              child: TextField(
                keyboardType: TextInputType.number,
                textInputAction: TextInputAction.done,
                controller: backendPortController,
                maxLines: 1,
                textAlign: TextAlign.center,
                style: TextStyle(
                    color: AppTheme.baseTheme,
                    fontWeight: FontWeight.normal,
                    fontSize: 16.0),
                decoration: InputDecoration(
                  border: UnderlineInputBorder(),
                  //border: InputBorder.none,
                  hintText: MyLocalizations.of(context, "insert_backend_port"),
                  hintStyle: TextStyle(
                      color: AppTheme.baseTheme,
                      fontWeight: FontWeight.normal,
                      fontSize: 16.0),
                ),
                onEditingComplete: () {
                  setBackend();
                },
              ),
            ),
          ),
          SizedBox(height: 50),
          RoundedButton(MyLocalizations.of(context, "use_test_backend"), Colors.white, Colors.amber,
              () {
                setTestBackend();
              }),
          SizedBox(height: 20),
          RoundedButton(MyLocalizations.of(context, "next"), Colors.white, AppTheme.baseTheme,
              () {
                setBackend();
              })
        ],
      )
    );
  }

  void setBackend() {
    if(backendController.text.isEmpty) {
      Utils.showErrorSnackBar(MyLocalizations.of(context, "insert_url"));
      return;
    }
    if(backendPortController.text.isEmpty) {
      Utils.showErrorSnackBar(MyLocalizations.of(context, "insert_port"));
      return;
    }
    Configuration.SERVER_URL = backendController.text + ":" + backendPortController.text + "/";
    if(!Configuration.SERVER_URL.contains("http"))
      Configuration.SERVER_URL = "http://" + Configuration.SERVER_URL;
    Get.to(LoginPage());
    Utils.showOkSnackBar(MyLocalizations.of(context, "url_set"));
  }

  void setTestBackend() {
    Get.to(LoginPage());
    Utils.showOkSnackBar(MyLocalizations.of(context, "url_set"));
  }
}
