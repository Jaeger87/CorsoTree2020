import 'package:flutter/material.dart';

class RoundedButton extends StatelessWidget {
  String buttonLabel;
  Color buttonLabelColor;
  Color buttonColor;
  Function onTap;
  double fontSize;
  double verticalPadding;

  RoundedButton(this.buttonLabel, this.buttonLabelColor, this.buttonColor, this.onTap, {this.fontSize, this.verticalPadding});

  @override
  Widget build(BuildContext context) {
    return RaisedButton(
        elevation: 0,
        color: buttonColor,
        highlightColor: buttonColor,
        splashColor: buttonColor,
        shape: RoundedRectangleBorder(borderRadius: BorderRadius.circular(10)),
        child: Padding(
          padding: EdgeInsets.symmetric(vertical: verticalPadding ?? 15),
          child: Text(
            buttonLabel,
            style: TextStyle(
              color: buttonLabelColor,
              fontWeight: FontWeight.normal,
              fontSize: fontSize ?? 16.0,
            ),
          ),
        ),
        onPressed: onTap
    );
  }
}
