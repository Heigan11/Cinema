<html lang="en">
<head>
    <head>
        <title>Chat WebSocket</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.6.0/sockjs.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
        <script type="text/javascript">
            var stompClient = null;

            function setConnected(connected) {
                document.getElementById('connect').disabled = connected;
                document.getElementById('disconnect').disabled = !connected;
                document.getElementById('conversationDiv').style.visibility
                    = connected ? 'visible' : 'hidden';
                document.getElementById('response').innerHTML = '';
            }

            function connect() {
                var socket = new SockJS('/ws');
                stompClient = Stomp.over(socket);
                stompClient.connect({}, function(frame) {
                    setConnected(true);
                    console.log('Connected: ' + frame);
                    stompClient.subscribe('/topic/public', function(message) {
                        showMessageOutput(JSON.parse(message.body));
                    });
                });
            }

            function disconnect() {
                if(stompClient != null) {
                    stompClient.disconnect();
                }
                setConnected(false);
                console.log("Disconnected");
            }

            function sendMessage() {
                // var from = document.getElementById('from').value;
                // var text = document.getElementById('text').value;
                // stompClient.send("/app/chat.sendMessage", {},
                //     JSON.stringify({'from':from, 'text':text}));

                var message = {
                    from: document.getElementById('from').value,
                    text: document.getElementById('text').value
                };
                stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(message));
            }

            function showMessageOutput(messageOutput) {
                var response = document.getElementById('response');
                var p = document.createElement('p');
                p.style.wordWrap = 'break-word';
                p.appendChild(document.createTextNode(messageOutput.from + ": "
                    + messageOutput.text + " (" + messageOutput.time + ")"));
                response.appendChild(p);
            }
        </script>
</head>
<body onload="disconnect()">
<div>
    <div>
        <input type="text" id="from" placeholder="Choose a nickname"/>
    </div>
    <br />
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">
            Disconnect
        </button>
    </div>
    <br />
    <div id="conversationDiv">
        <input type="text" id="text" placeholder="Write a message..."/>
        <button id="sendMessage" onclick="sendMessage();">Send</button>
        <p id="response"></p>
    </div>
</div>
</body>


<#--<body>-->
<#--<br>-->
<#--<br>-->
<#--<br>-->
<#--<a href="/admin/panel/halls">HALLS</a>-->
<#--<a href="/admin/panel/films">MOVIES</a>-->
<#--<a href="/admin/panel/sessions">SESSIONS</a>-->
<#--</body>-->
</html>
