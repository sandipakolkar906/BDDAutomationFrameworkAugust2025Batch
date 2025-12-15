$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DashboardWidgets.feature");
formatter.feature({
  "line": 1,
  "name": "Dashboard Widgets tests",
  "description": "",
  "id": "dashboard-widgets-tests",
  "keyword": "Feature"
});
formatter.before({
  "duration": 166700,
  "status": "passed"
});
formatter.before({
  "duration": 107600,
  "status": "passed"
});
formatter.before({
  "duration": 91400,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "I am able to view correct information at Time at Work widget",
  "description": "",
  "id": "dashboard-widgets-tests;i-am-able-to-view-correct-information-at-time-at-work-widget",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@DashboardTimeWidget"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I log in with Admin user and I am at Dashboard Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I view the Time at work widget at Dashboard Page",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I check below values from the widget showing correct values",
  "rows": [
    {
      "cells": [
        "WidgetinfoTitle",
        "ExpectedValue"
      ],
      "line": 8
    },
    {
      "cells": [
        "WidgetTitle",
        "Time at Work"
      ],
      "line": 9
    },
    {
      "cells": [
        "lastpunchedinTime",
        "Not Punched In"
      ],
      "line": 10
    },
    {
      "cells": [
        "currentTime",
        "0h 0m Today"
      ],
      "line": 11
    },
    {
      "cells": [
        "CurrentWeekspan",
        "Dec 08 - Dec 14"
      ],
      "line": 12
    },
    {
      "cells": [
        "TotalWeekHoursmins",
        "0h 0m"
      ],
      "line": 13
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DashboardWidgetStepDefs.i_log_in_with_Admin_user_and_I_am_at_Dashboard_Page()"
});
formatter.write("Starting the browser and application");
formatter.embedding("image/png", "embedded0.png");
formatter.write("Logging in to the  application");
formatter.embedding("image/png", "embedded1.png");
formatter.result({
  "duration": 21224468400,
  "status": "passed"
});
formatter.match({
  "location": "DashboardWidgetStepDefs.i_view_the_Time_at_work_widget_at_Dashboard_Page()"
});
formatter.write("This step is covered in below step");
formatter.result({
  "duration": 250800,
  "status": "passed"
});
formatter.match({
  "location": "DashboardWidgetStepDefs.i_check_below_values_from_the_widget_showing_correct_values(DataTable)"
});
formatter.write("Expected Value Map: {currentTime\u003d0h 0m Today, WidgetTitle\u003dTime at Work, lastpunchedinTime\u003dNot Punched In, CurrentWeekspan\u003dDec 08 - Dec 14, TotalWeekHoursmins\u003d0h 0m}");
formatter.write("Actual Value Map: {currentTime\u003d0h 0m Today, WidgetTitle\u003dTime at Work, lastpunchedinTime\u003dNot Punched In, CurrentWeekspan\u003dDec 08 - Dec 14, TotalWeekHoursmins\u003d0h 0m}");
formatter.result({
  "duration": 901687100,
  "status": "passed"
});
formatter.write("Closing the browser and application!");
formatter.after({
  "duration": 1078504700,
  "status": "passed"
});
formatter.write("Closing the browser and application!");
formatter.after({
  "duration": 1957400,
  "status": "passed"
});
formatter.write("Closing the browser and application!");
formatter.after({
  "duration": 11662900,
  "status": "passed"
});
});