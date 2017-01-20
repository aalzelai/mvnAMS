/**
 * 
 */
// Socket Server
var server = require('http').Server(app);
// Socket.IO
var io = require('socket.io')(server);
// PostgreSQL
var massive = require("massive");
var pg = require ("pg");
var startExpress = function() {
    server.listen(config.express.port);
    db = app.get('db');
}
var connectionString = "postgres://nbdqnbfi:zURvguyReFYY520-K0XAywvw5etvj8xQ@horton.elephantsql.com:5432/nbdqnbfi";
var pgClient = new pg.Client(connectionString);
pgClient.connect();
pgClient.query('LISTEN "changes"');
pgClient.on('notification', function(data) {
    io.emit("change");
});
var update = function(request, res, next) {
    var newDoc = request.body.data;
    db.steps.saveDoc({id:1,data:newDoc}, function(err,response){
        if (err) {
            handleError(err)
        };
        res.json({ data: response });
        pgClient.query('NOTIFY "change"');
    });
}