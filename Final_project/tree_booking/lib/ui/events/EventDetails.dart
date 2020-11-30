import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:tree_booking/business_logic/EventsHandler.dart';
import 'package:tree_booking/entity/EventEntity.dart';
import 'package:tree_booking/ui/common/RoundedButton.dart';
import 'package:tree_booking/ui/style/AppTheme.dart';
import 'package:tree_booking/utils/MyLocalizations.dart';
import 'package:tree_booking/utils/Utils.dart';
import 'package:intl/intl.dart';

class EventDetails extends StatefulWidget {
  final EventEntity eventEntity;

  EventDetails(this.eventEntity);

  @override
  _EventDetailsState createState() => _EventDetailsState();
}

class _EventDetailsState extends State<EventDetails> {

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    double width = MediaQuery.of(context).size.width;
    return
      widget.eventEntity == null ? Utils.getProgressIndicator() :
      Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        centerTitle: true,
        title: Text(
          widget.eventEntity.name,
          textAlign: TextAlign.center,
          style: TextStyle(
            color: AppTheme.baseTheme,
            fontStyle:  FontStyle.normal,
            fontWeight: FontWeight.normal,
            fontSize: 22.0,
          ),
        ),
      ),
      body: Padding(
        padding: EdgeInsets.only(top: 20, left: 20, right: 20),
        child: SingleChildScrollView(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            mainAxisAlignment: MainAxisAlignment.start,
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
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
              Text(
                widget.eventEntity.name,
                textAlign: TextAlign.left,
                style: TextStyle(
                  color: AppTheme.baseTheme,
                  fontWeight: FontWeight.normal,
                  fontSize: 18.0,
                ),
              ),
              SizedBox(height: 20),
              Text(
                MyLocalizations.of(context, "address"),
                textAlign: TextAlign.left,
                style: TextStyle(
                  color: Colors.black,
                  fontWeight: FontWeight.bold,
                  fontSize: 18.0,
                ),
              ),
              SizedBox(height: 10),
              Text(
                widget.eventEntity.place,
                textAlign: TextAlign.left,
                style: TextStyle(
                  color: AppTheme.baseTheme,
                  fontWeight: FontWeight.normal,
                  fontSize: 18.0,
                ),
              ),
              SizedBox(height: 20),
              Text(
                MyLocalizations.of(context, "places"),
                textAlign: TextAlign.left,
                style: TextStyle(
                  color: Colors.black,
                  fontWeight: FontWeight.bold,
                  fontSize: 18.0,
                ),
              ),
              SizedBox(height: 10),
              Text(
                widget.eventEntity.capacity.toString(),
                textAlign: TextAlign.left,
                style: TextStyle(
                  color: AppTheme.baseTheme,
                  fontWeight: FontWeight.normal,
                  fontSize: 18.0,
                ),
              ),
              SizedBox(height: 20),
              Text(
                MyLocalizations.of(context, "date"),
                textAlign: TextAlign.left,
                style: TextStyle(
                  color: Colors.black,
                  fontWeight: FontWeight.bold,
                  fontSize: 18.0,
                ),
              ),
              SizedBox(height: 20),
              Text(
                DateFormat('dd/MM/yyyy').format(widget.eventEntity.date),
                textAlign: TextAlign.left,
                style: TextStyle(
                  color: AppTheme.baseTheme,
                  fontWeight: FontWeight.normal,
                  fontSize: 18.0,
                ),
              ),
              SizedBox(height: 20),
              Text(
                MyLocalizations.of(context, "time"),
                textAlign: TextAlign.left,
                style: TextStyle(
                  color: Colors.black,
                  fontWeight: FontWeight.bold,
                  fontSize: 18.0,
                ),
              ),
              SizedBox(height: 20),
              Text(
                DateFormat('HH:mm').format(widget.eventEntity.date),
                textAlign: TextAlign.left,
                style: TextStyle(
                  color: AppTheme.baseTheme,
                  fontWeight: FontWeight.normal,
                  fontSize: 18.0,
                ),
              ),
              SizedBox(height: 20),
              SizedBox(height: 50),
              Center(
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                   /* RoundedButton(MyLocalizations.of(context, "back"), Colors.white, Colors.red,
                            () {
                          Get.back();
                        }),
                    SizedBox(width: width * 0.1),*/
                    widget.eventEntity.owned ?
                    RoundedButton(MyLocalizations.of(context, "delete"), Colors.white, Colors.red,
                            () {
                          deleteEvent();
                        }) : SizedBox(),
                    SizedBox(width: widget.eventEntity.owned ? width * 0.1 : 0),
                    widget.eventEntity.joined ?
                    RoundedButton(MyLocalizations.of(context, "unjoin"), Colors.white, AppTheme.baseTheme,
                            () {
                          unjoinEvent();
                        })
                      :
                    RoundedButton(MyLocalizations.of(context, "join"), Colors.white, AppTheme.baseTheme,
                            () {
                          joinEvent();
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

  void deleteEvent() async {
    Utils.showCustomHud(context);
    bool success = await EventsHandler().cancelEvent(widget.eventEntity.eventid);
    Utils.hideCustomHud(context);
    if(!success) {
      Utils.showErrorSnackBar(MyLocalizations.of(context, "cannot_delete_event"));
      return;
    }
    Utils.showOkSnackBar(MyLocalizations.of(context, "delete_event_ok"));
    Get.back();
  }

  void joinEvent() async {
    Utils.showCustomHud(context);
    bool success = await EventsHandler().signToEvent(widget.eventEntity.eventid);
    Utils.hideCustomHud(context);
    if(!success) {
      Utils.showErrorSnackBar(MyLocalizations.of(context, "cannot_join_event"));
      return;
    }
     if(this.mounted)
       setState(() {
         widget.eventEntity.joined = true;
       });
    Utils.showOkSnackBar(MyLocalizations.of(context, "join_event_ok"));
  }

  void unjoinEvent() async {
    Utils.showCustomHud(context);
    bool success = await EventsHandler().unjoinEvent(widget.eventEntity.eventid);
    Utils.hideCustomHud(context);
    if(!success) {
      Utils.showErrorSnackBar(MyLocalizations.of(context, "cannot_unjoin_event"));
      return;
    }
    Get.back();
    Utils.showOkSnackBar(MyLocalizations.of(context, "unjoin_event_ok"));
  }

}
