var http = require('http');
var requests=0;
var startTime;
var host;
var handleRequest = function(request, response) {
  console.log("Received request, host:", request.headers.host, " | URL:", request.url);
  response.setHeader('Content-Type', 'text/plain');
  response.writeHead(200);
  response.write("Kubernetes App running on: " + host + "\n");
  response.write("Always be yourself unless you can be a jedi, then be a jedi!");
  response.end(" | version=1 \n");
  console.log("[",new Date(),"] INFO: ");
  console.log("Host:", host, "| Total requests:", ++requests, "| Uptime:", (new Date() - startTime)/1000, "s");
}
var www = http.createServer(handleRequest);
www.listen(8080,function () {
    startTime = new Date();
	host = process.env.HOSTNAME;
    console.log ("Kubernetes App started:", startTime, "| Running on:" , host, "\n");
});
