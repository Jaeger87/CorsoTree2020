import 'dart:io';

class CookiesManager {
  static List<Cookie> cookies = [];
  static List<String> cookiesheader = [];
  static List<String> headers = [];

  static final CookiesManager _singleton = new CookiesManager._internal();

  factory CookiesManager() {
    return _singleton;
  }

  CookiesManager._internal();

  static bool cookiesPresent() {
    return cookies.any((cookie)=>cookie.name == "userid" || cookie.name == "firebasecookie");
  }

  static String getCookiesAsString() {
    String a = "";
    for (var value in cookiesheader) {
      a += value + ";";
    }
    return a;
  }

  static void clear(){
    cookies.clear();
    cookiesheader.clear();
  }

  /*static void addHeader(String headerString) {
    if(headers.contains(headerString))
      return;
    headers.add(headerString);
  }*/

  static void addCookie(String cookieString) {
    if(cookies.contains(Cookie.fromSetCookieValue(cookieString)))
      return;
    cookies.add(Cookie.fromSetCookieValue(cookieString));
    cookiesheader.add(cookieString);
  }

  static Map<String,String> getHeaderAsMap() {
    Map<String, String> h = Map();
    /*for(String cookie in CookiesManager.headers){
      var parts = cookie.split("=");
      String val = "";
      for(int i=1; i<parts.length;i++)
        val += parts[i];
      headers.putIfAbsent(parts[0], () => val);
    }*/
    h.putIfAbsent("Cookie", () => getCookiesAsString());
    //headers.forEach((header) => h.putIfAbsent(header.split("=")[0], ()=>header.split("=")[1]));
    return h;
  }
}
