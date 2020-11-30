import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:tree_booking/business_logic/EventsHandler.dart';
import 'package:tree_booking/entity/EventEntity.dart';
import 'package:tree_booking/ui/events/EventDetails.dart';
import 'package:tree_booking/utils/MyLocalizations.dart';
import 'package:tree_booking/utils/Utils.dart';
import 'package:intl/intl.dart';

class UserEvents extends StatefulWidget {
  @override
  _UserEventsState createState() => _UserEventsState();
}

class _UserEventsState extends State<UserEvents> {
  List<EventEntity> userEvents;

  @override
  void initState() {
    super.initState();
    EventsHandler().getUserEvents().then((value) {
      if(this.mounted && value != null)
        setState(() {
          userEvents = value;
        });
    });
  }

  @override
  Widget build(BuildContext context) {
    return
      userEvents == null ? Utils.getProgressIndicator() :
      Container(
        child: RefreshIndicator(
            onRefresh: () {
              EventsHandler().getUserEvents().then((value) {
                if (this.mounted && value != null)
                  setState(() {
                    userEvents = value;
                  });
              });
              return Future.delayed(Duration(seconds: 0), () => true);
            },
          child: SingleChildScrollView(
            physics: AlwaysScrollableScrollPhysics(),
            child: Padding(
              padding: EdgeInsets.only(left: 20, right: 20, bottom: 70),
              child: Column(
                children: _buildEvents(),
              ),
            ),
          ),
        ),
      );
  }

  List<Widget> _buildEvents() {
    return userEvents.map((e) => _buildEvent(e)).toList();
  }

  Widget _buildEvent(EventEntity e) {
    double width = MediaQuery.of(context).size.width;
    return Padding(
      padding: EdgeInsets.only(bottom: 10),
      child: InkWell(
        onTap: () {
          Get.to(EventDetails(e)).whenComplete(() {
            EventsHandler().getUserEvents().then((value) {
              if(this.mounted && value != null)
                setState(() {
                  userEvents = value;
                });
            });
          });
        },
        child: Card(
          elevation: 5,
          shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.circular(20)
          ),
          child: Padding(
            padding: EdgeInsets.symmetric(vertical: 20, horizontal: 20),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Container(
                  width: width * 0.8,
                  child: Text(
                    e.name,
                    textAlign: TextAlign.left,
                    style: TextStyle(
                      color: Colors.black,
                      fontWeight: FontWeight.bold,
                      fontSize: 18.0,
                    ),
                  ),
                ),
                SizedBox(height: 10),
                Row(
                  children: [
                    Text(
                      DateFormat('dd/MM/yyyy').format(e.date),
                      textAlign: TextAlign.left,
                      style: TextStyle(
                        color: Colors.black,
                        fontWeight: FontWeight.normal,
                        fontSize: 16.0,
                      ),
                    ),
                    SizedBox(width: 10),
                    Text(
                      DateFormat('HH:mm').format(e.date),
                      textAlign: TextAlign.left,
                      style: TextStyle(
                        color: Colors.black,
                        fontWeight: FontWeight.normal,
                        fontSize: 16.0,
                      ),
                    ),
                  ],
                ),
                SizedBox(height: 10),
                Container(
                  width: width * 0.8,
                  child: Text(
                    e.place,
                    textAlign: TextAlign.left,
                    style: TextStyle(
                      color: Colors.black,
                      fontWeight: FontWeight.normal,
                      fontSize: 18.0,
                    ),
                  ),
                ),
                SizedBox(height: 10),
                Text(
                  e.capacity.toString() + " " + MyLocalizations.of(context, "places"),
                  textAlign: TextAlign.left,
                  style: TextStyle(
                    color: Colors.black,
                    fontWeight: FontWeight.normal,
                    fontSize: 18.0,
                  ),
                ),
                SizedBox(height: 20),
                Center(
                  child: Text(
                    MyLocalizations.of(context, "tap_details"),
                    textAlign: TextAlign.center,
                    style: TextStyle(
                      color: Colors.black,
                      fontWeight: FontWeight.normal,
                      fontSize: 16.0,
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
