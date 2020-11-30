import 'package:flutter/material.dart';
import 'package:flutter_cupertino_date_picker_fork/flutter_cupertino_date_picker_fork.dart';
import 'package:get/get.dart';
import 'package:time_machine/time_machine.dart';
import 'package:tree_booking/business_logic/EventsHandler.dart';
import 'package:tree_booking/entity/EventEntity.dart';
import 'package:tree_booking/ui/common/RoundedButton.dart';
import 'package:tree_booking/ui/events/EventDetails.dart';
import 'package:tree_booking/ui/style/AppTheme.dart';
import 'package:tree_booking/utils/MyLocalizations.dart';
import 'package:intl/intl.dart';
import 'package:tree_booking/utils/Utils.dart';

class CreateEvent extends StatefulWidget {
  @override
  _CreateEventState createState() => _CreateEventState();
}

class _CreateEventState extends State<CreateEvent> {
  TextEditingController nameController = new TextEditingController();
  TextEditingController addressController = new TextEditingController();
  TextEditingController capacityController = new TextEditingController();
  DateTime date;
  TimeOfDay time;

  @override
  Widget build(BuildContext context) {
    double width = MediaQuery.of(context).size.width;
    double height = MediaQuery.of(context).size.height;
    return Scaffold(
      backgroundColor: Colors.white,
      appBar: AppBar(
        backgroundColor: Colors.white,
        elevation: 0,
        centerTitle: true,
        title: Text(
          MyLocalizations.of(context, "create_event"),
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
              Center(
                child: TextField(
                  keyboardType: TextInputType.text,
                  textInputAction: TextInputAction.next,
                  controller: nameController,
                  maxLines: 1,
                  textAlign: TextAlign.left,
                  style: TextStyle(
                      color: AppTheme.baseTheme,
                      fontWeight: FontWeight.normal,
                      fontSize: 16.0),
                  decoration: InputDecoration(
                    border: UnderlineInputBorder(),
                    //border: InputBorder.none,
                    hintText: MyLocalizations.of(context, "insert_name"),
                    hintStyle: TextStyle(
                        color: AppTheme.baseTheme,
                        fontWeight: FontWeight.normal,
                        fontSize: 16.0),
                  ),
                  onEditingComplete: () {
                    FocusScope.of(context).requestFocus(FocusNode());
                  },
                ),
              ),
              SizedBox(height: 10),
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
              Center(
                child: TextField(
                  keyboardType: TextInputType.streetAddress,
                  textInputAction: TextInputAction.next,
                  controller: addressController,
                  maxLines: 1,
                  textAlign: TextAlign.left,
                  style: TextStyle(
                      color: AppTheme.baseTheme,
                      fontWeight: FontWeight.normal,
                      fontSize: 16.0),
                  decoration: InputDecoration(
                    border: UnderlineInputBorder(),
                    //border: InputBorder.none,
                    hintText: MyLocalizations.of(context, "insert_address"),
                    hintStyle: TextStyle(
                        color: AppTheme.baseTheme,
                        fontWeight: FontWeight.normal,
                        fontSize: 16.0),
                  ),
                  onEditingComplete: () {
                    FocusScope.of(context).requestFocus(FocusNode());
                  },
                ),
              ),
              SizedBox(height: 10),
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
              Center(
                child: TextField(
                  keyboardType: TextInputType.number,
                  textInputAction: TextInputAction.next,
                  controller: capacityController,
                  maxLines: 1,
                  textAlign: TextAlign.left,
                  style: TextStyle(
                      color: AppTheme.baseTheme,
                      fontWeight: FontWeight.normal,
                      fontSize: 16.0),
                  decoration: InputDecoration(
                    border: UnderlineInputBorder(),
                    //border: InputBorder.none,
                    hintText: MyLocalizations.of(context, "insert_places"),
                    hintStyle: TextStyle(
                        color: AppTheme.baseTheme,
                        fontWeight: FontWeight.normal,
                        fontSize: 16.0),
                  ),
                  onEditingComplete: () {
                    FocusScope.of(context).requestFocus(FocusNode());
                  },
                ),
              ),
              //DATE
              SizedBox(height: 10),
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
              Container(
                width: width,
                child: InkWell(
                  onTap: () {
                    _showDatePicker(context);
                  },
                  child: Text(
                    date != null ?
                    DateFormat('dd/MM/yyyy').format(date) : MyLocalizations.of(context, "date"),
                    textAlign: TextAlign.start,
                    style: TextStyle(
                      color: AppTheme.baseTheme,
                      fontSize: 15.0,
                      fontWeight: FontWeight.normal,
                    ),
                  ),
                ),
              ),
              SizedBox(height: 15),
              Divider(height: 3, color: Colors.black,),
              //TIME
              SizedBox(height: 10),
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
              Container(
                width: width,
                child: InkWell(
                  onTap: () {
                    _showTimePicker(context);
                  },
                  child: Text(
                    time != null ?
                    (time.hour == 0 ? "00" : time.hour.toString()) + ":" + (time.minute == 0 ? "00" : time.minute.toString()) : MyLocalizations.of(context, "time"),
                    textAlign: TextAlign.start,
                    style: TextStyle(
                      color: AppTheme.baseTheme,
                      fontSize: 15.0,
                      fontWeight: FontWeight.normal,
                    ),
                  ),
                ),
              ),
              SizedBox(height: 15),
              Divider(height: 3, color: Colors.black,),
              SizedBox(height: 50),
              Center(
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    RoundedButton(MyLocalizations.of(context, "back"), Colors.white, Colors.red,
                            () {
                          Get.back();
                        }),
                    SizedBox(width: width * 0.1),
                    RoundedButton(MyLocalizations.of(context, "create"), Colors.white, AppTheme.baseTheme,
                            () {
                          createEvent();
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

  void _showDatePicker(BuildContext context) {
    DatePicker.showDatePicker(
      context,
      locale: Localizations.localeOf(context).languageCode == "it" ? DateTimePickerLocale.it : DateTimePickerLocale.en_us,
      pickerTheme: DateTimePickerTheme(
        cancel: Text(
          MyLocalizations.of(context, "cancel"),
          textAlign: TextAlign.center,
          style: TextStyle(
            color: Colors.red,
            fontStyle:  FontStyle.normal,
            fontWeight: FontWeight.normal,
            fontSize: 16.0,
          ),
        ),
        confirm: Text(
          MyLocalizations.of(context, "confirm"),
          textAlign: TextAlign.center,
          style: TextStyle(
            color: AppTheme.baseTheme,
            fontStyle:  FontStyle.normal,
            fontWeight: FontWeight.normal,
            fontSize: 16.0,
          ),
        ),
      ),
      minDateTime: ZonedDateTime(Instant.now(), DateTimeZone.local).localDateTime.toDateTimeLocal(),
      maxDateTime: ZonedDateTime(Instant.now(), DateTimeZone.local).localDateTime.addMonths(6).toDateTimeLocal(),
      dateFormat: 'dd-MMMM-yyyy',
      onConfirm: (date, selIndex) {
        setState(() {
          this.date = date;
        });
      },

    );
  }

  Future<TimeOfDay> _showTimePicker(BuildContext context) async {
    TimeOfDay time =  await showTimePicker(
      context: context,
      initialTime: TimeOfDay(hour: 18, minute: 0),
      confirmText: MyLocalizations.of(context, "confirm"),
      cancelText: MyLocalizations.of(context, "cancel"),
    );
    if(time != null && this.mounted)
      setState(() {
        this.time = time;
      });
  }

  void createEvent() async {
    if(nameController.text.isEmpty || addressController.text.isEmpty || capacityController.text.isEmpty
        || nameController.text.isEmpty || date == null || time == null) {
      Utils.showErrorSnackBar(MyLocalizations.of(context, "fill_fields"));
      return;
    }
    Utils.showCustomHud(context);
    EventEntity eventEntity = new EventEntity(
      name: nameController.text,
      place: addressController.text,
      capacity: int.parse(capacityController.text),
      date: DateTime(date.year, date.month, date.minute, time.hour, time.minute)
    );
    bool success = await EventsHandler().createEvent(eventEntity);
    Utils.hideCustomHud(context);
    if(!success) {
      Utils.showErrorSnackBar(MyLocalizations.of(context, "cannot_create_event"));
      return;
    }
    Utils.showOkSnackBar(MyLocalizations.of(context, "create_event_ok"));
    Get.off(EventDetails(eventEntity));
  }

}
