import 'dart:convert';
import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class MyLocalizations {

  final Locale locale;
  static Map<String, Map<String, dynamic>> _localizedValues = {};

  MyLocalizations(this.locale);

  Future<bool> load() async {
    String data = await rootBundle.loadString("assets/lang/${this.locale.languageCode}.json");
    if(data == null)
      data = await rootBundle.loadString("assets/lang/en.json");
    final jjson = json.decode(data);
    _localizedValues.putIfAbsent("${this.locale.languageCode}", () => jjson);
    return true;
  }


  String translate(key) {
    String val = _localizedValues[locale.languageCode][key];
    return val != null ? val : "";
  }

  static String of(BuildContext context, String key) {
    return Localizations.of<MyLocalizations>(context, MyLocalizations).translate(key);
  }
}
