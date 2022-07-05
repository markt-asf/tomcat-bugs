<html>
  <head>
    <script type="text/javascript">
        "use strict";
        
        var ws = null;
        
        function connect() {
        	ws = new WebSocket('ws://localhost:8080/tomcat-bugs/Bug65755Endpoint');
        	ws.onopen = function () {
        	}
        }
        

        function disconnect() {
        	ws.close();
        }
    </script>
  </head>
  <body>
    <p>
      <button onclick="connect();">Connect WebSocket</button>
      <button onclick="disconnect();">Disconnect WebSocket</button>
    </p>
    <p>
      <a href="bug65755b.jsp">Stage 2</a>
    </p>
  </body>
</html>