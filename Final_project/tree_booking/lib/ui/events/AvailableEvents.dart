import 'package:flutter/material.dart';
import 'package:tree_booking/business_logic/EventsHandler.dart';
import 'package:tree_booking/entity/EventEntity.dart';

class AvailableEvents extends StatefulWidget {
  @override
  _AvailableEventsState createState() => _AvailableEventsState();
}

class _AvailableEventsState extends State<AvailableEvents> {
  List<EventEntity> availableEvents;

  @override
  void initState() {
    super.initState();
    EventsHandler().getActiveEvents().then((value) {
      if(this.mounted && value != null)
        setState(() {
          availableEvents = value;
        });
    });
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.green,
    );
  }

}
