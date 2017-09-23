define({ "api": [
  {
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "optional": false,
            "field": "varname1",
            "description": "<p>No type.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "varname2",
            "description": "<p>With type.</p>"
          }
        ]
      }
    },
    "type": "",
    "url": "",
    "version": "0.0.0",
    "filename": "./doc/main.js",
    "group": "D__AppData_eclipse_workspace_myrestful_src_main_java_spittr_api_doc_main_js",
    "groupTitle": "D__AppData_eclipse_workspace_myrestful_src_main_java_spittr_api_doc_main_js",
    "name": ""
  },
  {
    "type": "POST",
    "url": "/spittles/",
    "title": "create a new spittles",
    "version": "0.0.0",
    "name": "saveSpittle",
    "group": "spittles",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Json",
            "optional": false,
            "field": "spittles",
            "description": "<p>TODO</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "URL",
            "optional": false,
            "field": "spittlesURL",
            "description": "<p>TODO</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "type": "_RESULT_NAME",
            "optional": false,
            "field": "_ERROR_NAME",
            "description": "<p>TODO</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": "HTTP/1.1 404 Not Found\n{\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./SpittleApiController.java",
    "groupTitle": "spittles"
  },
  {
    "type": "get",
    "url": "/spittles/:id",
    "title": "Request spittles information",
    "version": "0.0.0",
    "name": "spittleById",
    "group": "spittles",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "id",
            "description": "<p>spittles Unique ID.</p>"
          }
        ]
      }
    },
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "spittles",
            "description": "<p>get spittles information</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Success-Response:",
          "content": " HTTP/1.1 200 OK\n{\n    \"id\": 1,\n    \"message\": \"Sarah\",\n    \"time\": \"2017-08-31\",\n    \"latitude\": 31.12,\n    \"longitude\": 30.12\n}",
          "type": "json"
        }
      ]
    },
    "error": {
      "fields": {
        "Error 4xx": [
          {
            "group": "Error 4xx",
            "type": "NotFound",
            "optional": false,
            "field": "Error",
            "description": "<p>Spittle [ID] not found</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Error-Response:",
          "content": " HTTP/1.1 404 Not Found\n{\n    \"code\": 4,\n    \"message\": \"Spittle [2] not found\"\n}",
          "type": "json"
        }
      ]
    },
    "filename": "./SpittleApiController.java",
    "groupTitle": "spittles"
  }
] });
