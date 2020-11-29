import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:tree_booking/ui/events/AvailableEvents.dart';
import 'package:tree_booking/ui/events/MyEvents.dart';
import 'package:tree_booking/ui/style/AppTheme.dart';
import 'package:tree_booking/utils/MyLocalizations.dart';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  List<Widget> pages = [AvailableEvents(), MyEvents()];
  int _currentPage = 0;
  PageController _pageController;

  @override
  void initState() {
    super.initState();
    _pageController = PageController(initialPage: 0);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.white,
        bottomNavigationBar: _buildBottomNavBar(),
        appBar: AppBar(
          elevation: 0,
          backgroundColor: Colors.white,
          title: Text(
            "Tree Booking",
            style: GoogleFonts.montserrat(
              color: AppTheme.baseTheme,
              fontWeight: FontWeight.normal,
              fontSize: 24.0,
            ),
          ),
          centerTitle: true,

        ),
        body: PageView(
            physics: NeverScrollableScrollPhysics(),
            controller: _pageController,
            children: pages
        )
    );
  }

  Widget _buildBottomNavBar() {
    return BottomAppBar(
      elevation: 5,
      child: SizedBox(
        height: 70.0,
        child: Row(
            mainAxisSize: MainAxisSize.max,
            crossAxisAlignment: CrossAxisAlignment.center,
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: _buildChildren()
        ),
      ),
      shape: CircularNotchedRectangle(),
      notchMargin: 4.0,
      color: Colors.white,
    );
  }

  _buildChildren() {
    var builder = [
      _buildTab(Icons.home, MyLocalizations.of(context, "available_events"), 0)
    ];
    builder.add(_buildTab(_currentPage == 1 ? Icons.favorite : Icons.favorite_outline_rounded, MyLocalizations.of(context, "my_events"), 1));
    return builder;
  }

  Widget _buildTab(IconData iconData, String text, int index) {
    return InkWell(
      child: Column(
        mainAxisSize: MainAxisSize.min,
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          IconButton(
            padding: EdgeInsets.only(top: 0),
            icon: Icon(iconData, color: _currentPage == index ? AppTheme.baseTheme : Colors.grey),
            //highlightColor: TheTableTheme.darkGrey.withOpacity(0.3),
            onPressed: () {
              setCurrentTab(index);
            },
          ),
          Text(
            text,
            style: TextStyle(
                color: _currentPage == index ? AppTheme.baseTheme : Colors.grey,
                fontWeight: _currentPage == index ? FontWeight.bold : FontWeight.normal,
                fontSize: 12
            ),
          )
        ],
      ),
      onTap: () {
        setCurrentTab(index);
      },
    );
  }

  void setCurrentTab(int index) {
    HapticFeedback.mediumImpact();
    _currentPage = index;
    _pageController.jumpToPage(
      index,
      /*duration: Duration(milliseconds: 400),
        curve: Curves.decelerate*/
    );
    setState(() {});

  }
}
