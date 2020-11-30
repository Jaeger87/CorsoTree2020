// To parse this JSON data, do
//
//     final eventEntity = eventEntityFromJson(jsonString);

import 'dart:convert';
import 'package:intl/intl.dart';

EventEntity eventEntityFromJson(String str) => EventEntity.fromJson(json.decode(str));

String eventEntityToJson(EventEntity data) => json.encode(data.toJson());

class EventEntity {
  EventEntity({
    this.eventid,
    this.owned,
    this.name,
    this.date,
    this.place,
    this.capacity,
  });

  String eventid;
  bool owned;
  String name;
  DateTime date;
  String place;
  int capacity;

  factory EventEntity.fromJson(Map<String, dynamic> json) => EventEntity(
    eventid: json["eventid"],
    owned: json["owned"] ?? false,
    name: json["name"],
    date: DateTime.parse(json["date"]),
    place: json["place"],
    capacity: json["capacity"],
  );

  Map<String, dynamic> toJson() => {
    "eventid": eventid,
    "owned": owned,
    "name": name,
    "date": DateFormat('yyyy-MM-ddThh:mm:ss').format(date),
    "place": place,
    "capacity": capacity,
  };
}

/*
{
    "eventid": "",
    "name": "",
    "date": "",
    "place": "",
    "capacity": 11
}
 */