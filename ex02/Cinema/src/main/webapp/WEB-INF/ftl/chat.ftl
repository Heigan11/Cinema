<html lang="en">
<head>
    <head>
        <style>
            a {
                padding: 10px 0;
                border-width: 0;
                border-radius: 1em;
                display: block;
                width: 500px;
                height: 30px;
                margin: auto;
                background: #60e6c5;
                color: black;
                font-size: 25px;
                outline: none;
                text-transform: uppercase;
                text-align: center;
            }
        </style>
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
                var message = {
                    sender: document.getElementById('sender').value,
                    text: document.getElementById('text').value,
                    movie: { id: ${movie.id}}
                };
                stompClient.send("/app/chat", {}, JSON.stringify(message));
            }

            function showMessageOutput(message) {
                var response = document.getElementById('response');
                var p = document.createElement('p');
                p.style.wordWrap = 'break-word';
                p.appendChild(document.createTextNode(message.sender + ": "
                    + message.text));
                response.appendChild(p);
            }
        </script>
</head>
<body onload="disconnect()">
<div>
    <a> ${movie.title}'s CHAT </a>
    <div>
        <input type="text" id="sender" placeholder="Choose a nickname"/>
    </div>
    <br />
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">
            Disconnect
        </button>
    </div>
    <br/>
    <div id="conversationDiv">
        <input type="text" id="text" placeholder="Write a message..."/>
        <button id="sendMessage" onclick="sendMessage();">Send</button>
        <br/>
        <#list history as message>
            ${message.sender}: ${message.text}
            <br/>
        </#list>
        <p id="response"></p>
    </div>
</div>
</body>
</html>
