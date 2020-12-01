import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:tree_booking/business_logic/AuthHandler.dart';
import 'package:tree_booking/entity/UserEntity.dart';
import 'package:tree_booking/ui/auth/SignupPage.dart';
import 'package:tree_booking/ui/common/RoundedButton.dart';
import 'package:tree_booking/ui/events/HomePage.dart';
import 'package:tree_booking/ui/style/AppTheme.dart';
import 'package:tree_booking/utils/MyLocalizations.dart';
import 'package:tree_booking/utils/Utils.dart';

class LoginPage extends StatefulWidget {
  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  TextEditingController usernameController = new TextEditingController();
  TextEditingController passwordController = new TextEditingController();

  @override
  Widget build(BuildContext context) {
    double width = MediaQuery.of(context).size.width;
    double height = MediaQuery.of(context).size.height;
    return Scaffold(
      backgroundColor: Colors.white,
      resizeToAvoidBottomInset: true,
      body: Padding(
        padding: EdgeInsets.symmetric(horizontal: 20),
        child: SingleChildScrollView(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Center(child: Image.asset("assets/treelogo.png", width: width * 0.7, fit: BoxFit.cover,)),
              SizedBox(height: height * 0.1),
              Text(
                MyLocalizations.of(context, "username"),
                textAlign: TextAlign.left,
                style: TextStyle(
                  color: Colors.black,
                  fontWeight: FontWeight.bold,
                  fontSize: 18.0,
                ),
              ),
              SizedBox(height: 10),
              Center(
                child: TextField(
                  keyboardType: TextInputType.text,
                  textInputAction: TextInputAction.next,
                  controller: usernameController,
                  maxLines: 1,
                  textAlign: TextAlign.left,
                  style: TextStyle(
                      color: AppTheme.baseTheme,
                      fontWeight: FontWeight.normal,
                      fontSize: 16.0),
                  decoration: InputDecoration(
                    border: UnderlineInputBorder(),
                    //border: InputBorder.none,
                    hintText: MyLocalizations.of(context, "insert_username"),
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
              SizedBox(height: 10),
              Text(
                MyLocalizations.of(context, "password"),
                textAlign: TextAlign.left,
                style: TextStyle(
                  color: Colors.black,
                  fontWeight: FontWeight.bold,
                  fontSize: 18.0,
                ),
              ),
              SizedBox(height: 10),
              Center(
                child: TextField(
                  keyboardType: TextInputType.visiblePassword,
                  textInputAction: TextInputAction.done,
                  controller: passwordController,
                  maxLines: 1,
                  textAlign: TextAlign.left,
                  style: TextStyle(
                      color: AppTheme.baseTheme,
                      fontWeight: FontWeight.normal,
                      fontSize: 16.0),
                  decoration: InputDecoration(
                    border: UnderlineInputBorder(),
                    //border: InputBorder.none,
                    hintText: MyLocalizations.of(context, "insert_password"),
                    hintStyle: TextStyle(
                        color: AppTheme.baseTheme,
                        fontWeight: FontWeight.normal,
                        fontSize: 16.0),
                  ),
                  onEditingComplete: () {
                    login();
                  },
                ),
              ),
              SizedBox(height: 50),
              Center(
                child: RoundedButton(MyLocalizations.of(context, "login"), Colors.white, AppTheme.baseTheme,
                        () {
                      login();
                    }),
              ),
              SizedBox(height: 50),
              Center(
                child: RoundedButton(MyLocalizations.of(context, "signup"), Colors.white, Colors.red,
                        () {
                      signup();
                    }),
              )
            ],
          ),
        ),
      ),
    );
  }

  void login() async {
      if(usernameController.text.isEmpty) {
        Utils.showErrorSnackBar(MyLocalizations.of(context, "insert_username"));
        return;
      }
      if(passwordController.text.isEmpty) {
        Utils.showErrorSnackBar(MyLocalizations.of(context, "insert_password"));
        return;
      }

      Utils.showCustomHud(context);
      UserEntity userEntity = await AuthHandler().login(usernameController.text, passwordController.text);
      Utils.hideCustomHud(context);
      if(userEntity == null) {
        Utils.showErrorSnackBar(MyLocalizations.of(context, "cannot_login"));
        return;
      }
      Utils.showOkSnackBar(MyLocalizations.of(context, "login_done"));
      Get.offAll(HomePage());
  }

  void signup() {
    Get.to(SignupPage());
  }
}
