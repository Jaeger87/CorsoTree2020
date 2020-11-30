import 'package:flutter/material.dart';
import 'package:flutter_cupertino_date_picker_fork/flutter_cupertino_date_picker_fork.dart';
import 'package:get/get.dart';
import 'package:time_machine/time_machine.dart';
import 'package:tree_booking/business_logic/AuthHandler.dart';
import 'package:tree_booking/entity/UserEntity.dart';
import 'package:tree_booking/entity/UserGender.dart';
import 'package:tree_booking/ui/common/RoundedButton.dart';
import 'package:tree_booking/ui/events/HomePage.dart';
import 'package:tree_booking/ui/style/AppTheme.dart';
import 'package:tree_booking/utils/MyLocalizations.dart';
import 'package:tree_booking/utils/Utils.dart';
import 'package:intl/intl.dart';

class SignupPage extends StatefulWidget {
  @override
  _SignupPageState createState() => _SignupPageState();
}

class _SignupPageState extends State<SignupPage> {
  TextEditingController usernameController = new TextEditingController();
  TextEditingController passwordController = new TextEditingController();
  TextEditingController nameController = new TextEditingController();
  TextEditingController surnameController = new TextEditingController();
  UserGender gender;
  DateTime birthDate;
  var formatter = new DateFormat('yyyy-MM-dd');

  @override
  Widget build(BuildContext context) {
    double width = MediaQuery.of(context).size.width;
    double height = MediaQuery.of(context).size.height;
    return Scaffold(
      backgroundColor: Colors.white,
      body: Padding(
        padding: EdgeInsets.only(top: AppBar().preferredSize.height, left: 20, right: 20),
        child: SingleChildScrollView(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            mainAxisAlignment: MainAxisAlignment.start,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Center(child: Image.asset("assets/treelogo.png", width: width * 0.5, fit: BoxFit.cover,)),
              SizedBox(height: 50),
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
                  textInputAction: TextInputAction.next,
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
                    FocusScope.of(context).requestFocus(FocusNode());
                  },
                ),
              ),
              SizedBox(height: 10),
              Text(
                MyLocalizations.of(context, "name"),
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
                  keyboardType: TextInputType.name,
                  textInputAction: TextInputAction.next,
                  controller: nameController,
                  maxLines: 1,
                  textAlign: TextAlign.left,
                  style: TextStyle(
                      color: AppTheme.baseTheme,
                      fontWeight: FontWeight.normal,
                      fontSize: 16.0),
                  decoration: InputDecoration(
                    border: UnderlineInputBorder(),
                    //border: InputBorder.none,
                    hintText: MyLocalizations.of(context, "insert_name"),
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
                MyLocalizations.of(context, "surname"),
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
                  textInputAction: TextInputAction.next,
                  controller: surnameController,
                  maxLines: 1,
                  textAlign: TextAlign.left,
                  style: TextStyle(
                      color: AppTheme.baseTheme,
                      fontWeight: FontWeight.normal,
                      fontSize: 16.0),
                  decoration: InputDecoration(
                    border: UnderlineInputBorder(),
                    hintText: MyLocalizations.of(context, "insert_surname"),
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
                MyLocalizations.of(context, "surname"),
                textAlign: TextAlign.left,
                style: TextStyle(
                  color: Colors.black,
                  fontWeight: FontWeight.bold,
                  fontSize: 18.0,
                ),
              ),
              SizedBox(height: 10),
              Center(
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    new Text(
                      MyLocalizations.of(context, "male"),
                      style: new TextStyle(fontSize: 16.0),
                    ),
                    new Radio<UserGender>(
                      value: UserGender.MALE,
                      groupValue: gender,
                      onChanged: (userGender) {
                        if(this.mounted)
                          setState(() {
                            gender = userGender;
                          });
                      },
                    ),
                    new Text(
                      MyLocalizations.of(context, "female"),
                      style: new TextStyle(
                        fontSize: 16.0,
                      ),
                    ),
                    new Radio<UserGender>(
                      value: UserGender.FEMALE,
                      groupValue: gender,
                      onChanged: (userGender) {
                        if(this.mounted)
                          setState(() {
                            gender = userGender;
                          });
                      },
                    ),
                    new Text(
                      MyLocalizations.of(context, "other"),
                      style: new TextStyle(fontSize: 16.0),
                    ),
                    new Radio<UserGender>(
                      value: UserGender.OTHER,
                      groupValue: gender,
                      onChanged: (userGender) {
                        if(this.mounted)
                          setState(() {
                            gender = userGender;
                          });
                      },
                    ),
                  ],
                )
              ),
              SizedBox(height: 10),
              Text(
                MyLocalizations.of(context, "birthdate"),
                textAlign: TextAlign.left,
                style: TextStyle(
                  color: Colors.black,
                  fontWeight: FontWeight.bold,
                  fontSize: 18.0,
                ),
              ),
              SizedBox(height: 20),
              Container(
                child: InkWell(
                  onTap: () {
                    _showDatePicker(context);
                  },
                  child: Text(
                    birthDate != null ?
                    formatter.format(birthDate) : MyLocalizations.of(context, "birthdate"),
                    textAlign: TextAlign.start,
                    style: TextStyle(
                      color: AppTheme.baseTheme,
                      fontSize: 15.0,
                      fontWeight: FontWeight.normal,
                    ),
                  ),
                ),
              ),
              SizedBox(height: 30),
              Center(
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    RoundedButton(MyLocalizations.of(context, "back"), Colors.white, Colors.red,
                            () {
                          Get.back();
                        }),
                    SizedBox(width: width * 0.1),
                    RoundedButton(MyLocalizations.of(context, "signup"), Colors.white, AppTheme.baseTheme,
                            () {
                          signup();
                        }),
                  ],
                ),
              ),
              SizedBox(height: 50),
            ],
          ),
        ),
      ),
    );
  }

  void _showDatePicker(BuildContext context) {
    DatePicker.showDatePicker(
      context,
      locale: Localizations.localeOf(context).languageCode == "it" ? DateTimePickerLocale.it : DateTimePickerLocale.en_us,
      pickerTheme: DateTimePickerTheme(
        cancel: Text(
          MyLocalizations.of(context, "cancel"),
          textAlign: TextAlign.center,
          style: TextStyle(
            color: Colors.red,
            fontStyle:  FontStyle.normal,
            fontWeight: FontWeight.normal,
            fontSize: 16.0,
          ),
        ),
        confirm: Text(
          MyLocalizations.of(context, "confirm"),
          textAlign: TextAlign.center,
          style: TextStyle(
            color: AppTheme.baseTheme,
            fontStyle:  FontStyle.normal,
            fontWeight: FontWeight.normal,
            fontSize: 16.0,
          ),
        ),
      ),
      minDateTime: DateTime(1900, 1, 1),
      maxDateTime: ZonedDateTime(Instant.now(), DateTimeZone.local).localDateTime.subtractYears(18).toDateTimeLocal(),
      dateFormat: 'dd-MMMM-yyyy',
      onConfirm: (date, selIndex) {
        setState(() {
          birthDate = date;
        });
      },

    );
  }

  void signup() async {
    if(usernameController.text.isEmpty || passwordController.text.isEmpty || surnameController.text.isEmpty
      || nameController.text.isEmpty || gender == null || birthDate == null) {
      Utils.showErrorSnackBar(MyLocalizations.of(context, "fill_fields"));
      return;
    }
    Utils.showCustomHud(context);
    UserEntity userEntity = new UserEntity(
      name: nameController.text,
      username: usernameController.text,
      surname: surnameController.text,
      password: passwordController.text,
      gender: gender,
      birthDate: birthDate
    );
    bool success = await AuthHandler().signup(userEntity);
    Utils.hideCustomHud(context);
    if(!success) {
      Utils.showErrorSnackBar(MyLocalizations.of(context, "cannot_signup"));
      return;
    }
    Utils.showOkSnackBar(MyLocalizations.of(context, "signup_ok"));
    Get.offAll(HomePage());
  }
}
