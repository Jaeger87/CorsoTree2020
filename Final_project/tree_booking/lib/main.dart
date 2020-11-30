import 'package:flutter/material.dart';
import 'package:flutter_localizations/flutter_localizations.dart';
import 'package:get/get.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:tree_booking/ui/auth/ChooseServer.dart';
import 'package:tree_booking/ui/events/HomePage.dart';
import 'package:tree_booking/utils/MyLocalizationDelegate.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.

  static var routes = <String, WidgetBuilder>{
    '/choose_server': (BuildContext context) => new ChooseServer(),
    /*'/splash_screen': (BuildContext context) => new SplashScreen(),
    '/login': (BuildContext context) => new LoginPage(),
    '/home': (BuildContext context) => new Home(),
    '/change_password': (BuildContext context) => new ChangePasswordPage(),*/
  };

  @override
  Widget build(BuildContext context) {
    return GetMaterialApp(
      title: 'TreeBooking',
      enableLog: false,
      defaultTransition: Transition.fade,
      opaqueRoute: Get.isOpaqueRouteDefault,
      popGesture: Get.isPopGestureEnable,
/*      transitionDuration: Get.defaultDurationTransition,
      defaultGlobalState: Get.defaultGlobalState,*/
      debugShowCheckedModeBanner: false,
      theme: new ThemeData(
        primarySwatch: Colors.lightBlue,
        accentColor: Colors.cyan[600],
        //,
        brightness: Brightness.light,
        /*textTheme: GoogleFonts.robotoTextTheme(
          Theme.of(context).textTheme,
        ),*/
        textTheme: GoogleFonts.montserratTextTheme(
          Theme.of(context).textTheme,
        ),
      ),
      routes: routes,
      localizationsDelegates: [
        MyLocalizationDelegate(),
        GlobalMaterialLocalizations.delegate,
        GlobalWidgetsLocalizations.delegate,
        FallbackCupertinoLocalisationsDelegate()
      ],
      supportedLocales: [
        const Locale('it', 'IT'), // Italian
        //const Locale('en', 'US'), // English
        // ... other locales the app supports
      ],
      home: ChooseServer(),
    );
  }
}