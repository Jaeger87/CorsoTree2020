import 'dart:convert';

import 'package:dio/dio.dart';
import 'package:sprintf/sprintf.dart';
import 'package:tree_booking/entity/EventEntity.dart';
import 'package:tree_booking/utils/Utils.dart';
import 'package:tree_booking/utils/Configuration.dart';

class EventsHandler {

  Future<List<EventEntity>> getActiveEvents() async {
    /*return [
      EventEntity(name: "prova", capacity: 20, date: DateTime.now(), eventid: "123", place: "via roma", owned: false),
      EventEntity(name: "prova2", capacity: 20, date: DateTime.now(), eventid: "123", place: "via roma", owned: true),
      
    ];*/
    Dio dio = Utils.buildDio();
    try {
      Response r = (await dio.get(Configuration.GET_ACTIVE_EVENTS));
      if (r.statusCode != 200)
        return [];
      List<EventEntity> events = [];
      for(var event in r.data)
        events.add(eventEntityFromJson(json.encode(event)));

      return events;
    } on DioError catch (e) {
      return null;
    }
  }

  Future<List<EventEntity>> getUserEvents() async {
    /*return [
      EventEntity(name: "prova", capacity: 20, date: DateTime.now(), eventid: "123", place: "via roma", owned: false),
      EventEntity(name: "prova2", capacity: 20, date: DateTime.now(), eventid: "123", place: "via roma", owned: true),
      EventEntity(name: "prova", capacity: 20, date: DateTime.now(), eventid: "123", place: "via roma", owned: false),
      EventEntity(name: "prova2", capacity: 20, date: DateTime.now(), eventid: "123", place: "via roma", owned: true),
      EventEntity(name: "prova", capacity: 20, date: DateTime.now(), eventid: "123", place: "via roma", owned: false),
      EventEntity(name: "prova2", capacity: 20, date: DateTime.now(), eventid: "123", place: "via roma", owned: true),
    ];*/
    Dio dio = Utils.buildDio();
    try {
      Response r = (await dio.get(Configuration.GET_USER_EVENTS));
      if (r.statusCode != 200)
        return [];
      List<EventEntity> events = [];
      for(var event in r.data)
        events.add(eventEntityFromJson(json.encode(event)));

      return events;
    } on DioError catch (e) {
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
      return null;
    }
  }

  Future<bool> cancelEvent(String eventId) async {
    Dio dio = Utils.buildDio();
    try {
      Response r = (await dio.delete(sprintf(Configuration.CANCEL_EVENT, [eventId])));
      return (r.statusCode == 200);
    } on DioError catch (e) {
      return false;
    }
  }

  Future<bool> signToEvent(String eventId) async {
    Dio dio = Utils.buildDio();
    try {
      Response r = (await dio.post(sprintf(Configuration.SIGN_TO_EVENT, [eventId])));
      return (r.statusCode == 201);
    } on DioError catch (e) {
      return false;
    }
  }

  Future<bool> createEvent(EventEntity eventEntity) async {
    Dio dio = Utils.buildDio();
    try {
      Response r = (await dio.post(Configuration.CREATE_EVENT, data: json.encode(eventEntity.toJson())));
      return (r.statusCode == 201);
    } on DioError catch (e) {
      return false;
    }
  }

  Future<bool> unjoinEvent(String eventId) async {
    Dio dio = Utils.buildDio();
    try {
      Response r = (await dio.post(sprintf(Configuration.UNJOIN_EVENT, [eventId])));
      return (r.statusCode == 201);
    } on DioError catch (e) {
      return false;
    }
  }

}