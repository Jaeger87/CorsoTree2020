import 'dart:convert';

import 'package:dio/dio.dart';
import 'package:sprintf/sprintf.dart';
import 'package:tree_booking/entity/EventEntity.dart';
import 'package:tree_booking/utils/Utils.dart';
import 'package:tree_booking/utils/Configuration.dart';

class EventsHandler {

  Future<List<EventEntity>> getActiveEvents() async {
    Dio dio = Utils.buildDio();
    try {
      Response r = (await dio.get(Configuration.GET_ACTIVE_EVENTS));
      if (r.statusCode != 200)
        return [];
      List<EventEntity> events = [];
      for(String s in r.data)
        events.add(eventEntityFromJson(s));

      return events;
    } on DioError catch (e) {
      //print("ERROR GETTING TIME" + e.toString());
      //print(e.response?.data);
      //print(e.message);
      return null;
    }
  }

  Future<List<EventEntity>> getUserEvents() async {
    Dio dio = Utils.buildDio();
    try {
      Response r = (await dio.get(Configuration.GET_USER_EVENTS));
      if (r.statusCode != 200)
        return [];
      List<EventEntity> events = [];
      for(String s in r.data)
        events.add(eventEntityFromJson(s));

      return events;
    } on DioError catch (e) {
      //print("ERROR GETTING TIME" + e.toString());
      //print(e.response?.data);
      //print(e.message);
      return null;
    }
  }

  Future<EventEntity> getEventDetails(String eventId) async {
    Dio dio = Utils.buildDio();
    try {
      Response r = (await dio.get(sprintf(Configuration.GET_EVENT_DETAILS, [eventId])));
      if (r.statusCode != 200)
        return null;
      return EventEntity.fromJson(r.data);
    } on DioError catch (e) {
      //print("ERROR GETTING TIME" + e.toString());
      //print(e.response?.data);
      //print(e.message);
      return null;
    }
  }

  Future<bool> cancelEvent(String eventId) async {
    Dio dio = Utils.buildDio();
    try {
      Response r = (await dio.delete(sprintf(Configuration.CANCEL_EVENT, [eventId])));
      return (r.statusCode == 200);
    } on DioError catch (e) {
      //print("ERROR GETTING TIME" + e.toString());
      //print(e.response?.data);
      //print(e.message);
      return false;
    }
  }

  Future<bool> signToEvent(String eventId) async {
    Dio dio = Utils.buildDio();
    try {
      Response r = (await dio.post(sprintf(Configuration.SIGN_TO_EVENT, [eventId])));
      return (r.statusCode == 202);
    } on DioError catch (e) {
      //print("ERROR GETTING TIME" + e.toString());
      //print(e.response?.data);
      //print(e.message);
      return false;
    }
  }

  Future<bool> createEvent(EventEntity eventEntity) async {
    Dio dio = Utils.buildDio();
    try {
      Response r = (await dio.post(Configuration.CREATE_EVENT, data: json.encode(eventEntity.toJson())));
      return (r.statusCode == 201);
    } on DioError catch (e) {
      //print("ERROR GETTING TIME" + e.toString());
      //print(e.response?.data);
      //print(e.message);
      return false;
    }
  }

}