// To parse this JSON data, do
//
//     final eventEntity = eventEntityFromJson(jsonString);

import 'dart:convert';

EventEntity eventEntityFromJson(String str) => EventEntity.fromJson(json.decode(str));

String eventEntityToJson(EventEntity data) => json.encode(data.toJson());

class EventEntity {
  EventEntity({
    this.eventid,
    this.name,
    this.date,
    this.place,
    this.capacity,
  });

  String eventid;
  String name;
  String date;
  String place;
  int capacity;

  factory EventEntity.fromJson(Map<String, dynamic> json) => EventEntity(
    eventid: json["eventid"],
    name: json["name"],
    date: json["date"],
    place: json["place"],
    capacity: json["capacity"],
  );

  Map<String, dynamic> toJson() => {
    "eventid": eventid,
    "name": name,
    "date": date,
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