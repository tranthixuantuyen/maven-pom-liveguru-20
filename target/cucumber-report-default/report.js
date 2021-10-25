$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("dataTable.feature");
formatter.feature({
  "line": 2,
  "name": "Datatable Feature",
  "description": "",
  "id": "datatable-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@datatable"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Create new Customer with email \u003cUsername\u003e",
  "description": "",
  "id": "datatable-feature;create-new-customer-with-email-\u003cusername\u003e",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@datatable_step"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Input to Username and Password",
  "rows": [
    {
      "cells": [
        "Name",
        "Pass"
      ],
      "line": 8
    },
    {
      "cells": [
        "\u003cUsername\u003e",
        "\u003cPassword\u003e"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Click to Submit button",
  "keyword": "And "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "datatable-feature;create-new-customer-with-email-\u003cusername\u003e;",
  "rows": [
    {
      "cells": [
        "Username",
        "Password"
      ],
      "line": 13,
      "id": "datatable-feature;create-new-customer-with-email-\u003cusername\u003e;;1"
    },
    {
      "cells": [
        "0977108233",
        "123456"
      ],
      "line": 14,
      "id": "datatable-feature;create-new-customer-with-email-\u003cusername\u003e;;2"
    },
    {
      "cells": [
        "0977108234",
        "123456"
      ],
      "line": 15,
      "id": "datatable-feature;create-new-customer-with-email-\u003cusername\u003e;;3"
    },
    {
      "cells": [
        "0977108235",
        "123456"
      ],
      "line": 16,
      "id": "datatable-feature;create-new-customer-with-email-\u003cusername\u003e;;4"
    },
    {
      "cells": [
        "0977108236",
        "123456"
      ],
      "line": 17,
      "id": "datatable-feature;create-new-customer-with-email-\u003cusername\u003e;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5496094300,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Create new Customer with email 0977108233",
  "description": "",
  "id": "datatable-feature;create-new-customer-with-email-\u003cusername\u003e;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@datatable"
    },
    {
      "line": 4,
      "name": "@datatable_step"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Input to Username and Password",
  "matchedColumns": [
    0,
    1
  ],
  "rows": [
    {
      "cells": [
        "Name",
        "Pass"
      ],
      "line": 8
    },
    {
      "cells": [
        "0977108233",
        "123456"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Click to Submit button",
  "keyword": "And "
});
formatter.match({
  "location": "FacebookSteps.inputToUsernameAndPassword(DataTable)"
});
formatter.result({
  "duration": 307451100,
  "status": "passed"
});
formatter.match({
  "location": "FacebookSteps.clickToSubmitButton()"
});
formatter.result({
  "duration": 62240900,
  "status": "passed"
});
formatter.after({
  "duration": 643761400,
  "status": "passed"
});
formatter.before({
  "duration": 2298972000,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Create new Customer with email 0977108234",
  "description": "",
  "id": "datatable-feature;create-new-customer-with-email-\u003cusername\u003e;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@datatable"
    },
    {
      "line": 4,
      "name": "@datatable_step"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Input to Username and Password",
  "matchedColumns": [
    0,
    1
  ],
  "rows": [
    {
      "cells": [
        "Name",
        "Pass"
      ],
      "line": 8
    },
    {
      "cells": [
        "0977108234",
        "123456"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Click to Submit button",
  "keyword": "And "
});
formatter.match({
  "location": "FacebookSteps.inputToUsernameAndPassword(DataTable)"
});
formatter.result({
  "duration": 201704900,
  "status": "passed"
});
formatter.match({
  "location": "FacebookSteps.clickToSubmitButton()"
});
formatter.result({
  "duration": 68209000,
  "status": "passed"
});
formatter.after({
  "duration": 618022900,
  "status": "passed"
});
formatter.before({
  "duration": 2008607300,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Create new Customer with email 0977108235",
  "description": "",
  "id": "datatable-feature;create-new-customer-with-email-\u003cusername\u003e;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@datatable"
    },
    {
      "line": 4,
      "name": "@datatable_step"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Input to Username and Password",
  "matchedColumns": [
    0,
    1
  ],
  "rows": [
    {
      "cells": [
        "Name",
        "Pass"
      ],
      "line": 8
    },
    {
      "cells": [
        "0977108235",
        "123456"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Click to Submit button",
  "keyword": "And "
});
formatter.match({
  "location": "FacebookSteps.inputToUsernameAndPassword(DataTable)"
});
formatter.result({
  "duration": 207468700,
  "status": "passed"
});
formatter.match({
  "location": "FacebookSteps.clickToSubmitButton()"
});
formatter.result({
  "duration": 69889700,
  "status": "passed"
});
formatter.after({
  "duration": 631130400,
  "status": "passed"
});
formatter.before({
  "duration": 3265884500,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Create new Customer with email 0977108236",
  "description": "",
  "id": "datatable-feature;create-new-customer-with-email-\u003cusername\u003e;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@datatable"
    },
    {
      "line": 4,
      "name": "@datatable_step"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Input to Username and Password",
  "matchedColumns": [
    0,
    1
  ],
  "rows": [
    {
      "cells": [
        "Name",
        "Pass"
      ],
      "line": 8
    },
    {
      "cells": [
        "0977108236",
        "123456"
      ],
      "line": 9
    }
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "Click to Submit button",
  "keyword": "And "
});
formatter.match({
  "location": "FacebookSteps.inputToUsernameAndPassword(DataTable)"
});
formatter.result({
  "duration": 240952500,
  "status": "passed"
});
formatter.match({
  "location": "FacebookSteps.clickToSubmitButton()"
});
formatter.result({
  "duration": 64696100,
  "status": "passed"
});
formatter.after({
  "duration": 614486400,
  "status": "passed"
});
});